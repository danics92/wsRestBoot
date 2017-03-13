package com.esliceu.dwes.boot.controller;

import com.esliceu.dwes.boot.dao.UsuariRepository;
import com.esliceu.dwes.boot.model.Fitxatge;
import com.esliceu.dwes.boot.model.Usuari;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xavi on 23/02/17.
 */
@RestController
public class UserController {
    private static SessionFactory factory;

    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private UsuariRepository usuariRepository;

    @RequestMapping("/usuaris")
    public List<Usuari> usuarios(){
        return (List<Usuari>) usuariRepository.findAll();
    }


    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
    public List<Usuari> getByNom(@RequestParam List<String> users, @RequestParam(required = false) Long from,@RequestParam(required = false) Long to){
        List<Usuari> usersFitxatge = new ArrayList<>();
        Usuari usuarioConsulta;
        Usuari userReturn;
        List<Fitxatge> fitxatges = new ArrayList<>();
        for (int i = 0; i < users.size(); i++){
            usuarioConsulta =  usuariRepository.findByUsuari(users.get(i));
            System.out.println(usuarioConsulta.toString());
            userReturn =  new Usuari(usuarioConsulta.getNom(),usuarioConsulta.getCognom());
            for (int j = 0; j < usuarioConsulta.getFitxatges().size(); j++) {
                if(usuarioConsulta.getFitxatges().get(j).getDiaHora() >= from
                        && usuarioConsulta.getFitxatges().get(j).getDiaHora() <= to){
                    fitxatges.add(usuarioConsulta.getFitxatges().get(j));
                }
            }
            userReturn.setFitxatges(fitxatges);
            fitxatges = new ArrayList<>();
            usersFitxatge.add(userReturn);
        }
        return usersFitxatge;
    }

}
