package com.esliceu.dwes.boot.controller;

import com.esliceu.dwes.boot.dao.FitxatgeRespository;
import com.esliceu.dwes.boot.dao.TipusRepository;
import com.esliceu.dwes.boot.dao.UsuariRepository;
import com.esliceu.dwes.boot.model.Fitxatge;
import com.esliceu.dwes.boot.model.Nom;
import com.esliceu.dwes.boot.model.Tipus;
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

    @Autowired
    private TipusRepository tipusRepository;

    @Autowired
    private FitxatgeRespository fitxatgeRespository;


    @RequestMapping("/usuaris")
    public List<Usuari> usuarios(){
        return (List<Usuari>) usuariRepository.findAll();
    }


    @RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
    public List<Usuari> getByNom(@RequestParam(required = false) List<String> users, @RequestParam(required = true) Long from,@RequestParam(required = true) Long to){
        List<Usuari> usersFitxatge = new ArrayList<>();
        Usuari usuarioConsulta;
        Usuari userReturn;
        List<Fitxatge> fitxatges = new ArrayList<>();
        Usuari usuariActual = new Usuari();

        if(users != null){
            for (int i = 0; i < users.size(); i++){
                usuariActual.setUsuari(users.get(i));
                usuarioConsulta =  usuariRepository.findByUsuari(usuariActual.getUsuari());
                System.out.println(usuarioConsulta.toString());
                userReturn =  new Usuari(usuarioConsulta.getUsuari(),usuarioConsulta.getNom(),usuarioConsulta.getCognom());
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
        }
        else{
            List<Usuari> lu = (List<Usuari>) usuariRepository.findAll();

            for (int i = 0; i < lu.size(); i++){
                usuarioConsulta =  usuariRepository.findByUsuari(lu.get(i).getUsuari());
                userReturn =  new Usuari(usuarioConsulta.getUsuari(),usuarioConsulta.getNom(),usuarioConsulta.getCognom());
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
        }



        return usersFitxatge;
    }

    @RequestMapping(value = "/insertarFitxatge", method = RequestMethod.POST)
    public void doInsert(@RequestParam String nomUsuari, @RequestParam long dataHora){
        System.out.println(nomUsuari +"-----"+dataHora);
        Usuari usuariObtingut = usuariRepository.findByUsuari(nomUsuari);
        Tipus tipus = tipusRepository.findByNom(Nom.ENTRADA);
        System.out.println(tipus);

        if(usuariObtingut.getFitxatges() == null) {
            tipus = tipusRepository.findByNom(Nom.ENTRADA);
        }else if(usuariObtingut.getFitxatges().get(0).getTipusFitxatge().getNom() == Nom.ENTRADA ) {
            tipus = tipusRepository.findByNom(Nom.SORTIDA);
        }else{
            tipus = tipusRepository.findByNom(Nom.ENTRADA);
        }
        Fitxatge fitxatge = new Fitxatge(dataHora, tipus);
        fitxatgeRespository.save(fitxatge);

        usuariObtingut.getFitxatges().add(fitxatge);
        usuariRepository.save(usuariObtingut);
    }

}
