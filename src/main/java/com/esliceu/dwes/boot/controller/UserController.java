package com.esliceu.dwes.boot.controller;

import com.esliceu.dwes.boot.dao.UsuariRepository;
import com.esliceu.dwes.boot.model.FiltrarUsuari;
import com.esliceu.dwes.boot.model.Usuari;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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


    @RequestMapping(value = "/usuarisPerNom", method = RequestMethod.GET)
    public List<Usuari> getByNom(@RequestParam List<String> users, @RequestParam(required = false) Long from,@RequestParam(required = false) Long to){
        //return usuariRepository.findByNomAndCognom(users,from,to);

        Session session = factory.openSession();
        //select * from usuari_fitxatges as uf inner join usuari as u on uf.usuari_id = u.id inner join fitxatge as f on uf.fitxatges_id = f.id where usuari = "xcambil";
        String queryS = "select u.usuari from usuari_fitxatges as uf inner join usuari as u on uf.usuari_id = u.id inner join fitxatge as f on uf.fitxatges_id = f.id  ";
        if(users != null){
            SQLQuery q = (SQLQuery) session.createQuery(queryS);
            q.setParameterList("usuaris", ids);

//            queryS+="where ";
//
//            for (int i = 0 ; i < users.size();i++){
//                queryS+="usuari = "+users.get(i);
//                if(i+1 != users.size()){
//                    queryS+=" and";
//                }
//            }
        }
        //org.hibernate.Query query = session.createQuery("FROM TrackedItem item WHERE item.id IN (:ids)");

        return null;
    }

}
