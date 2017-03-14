package com.esliceu.dwes.boot.dao;

import com.esliceu.dwes.boot.model.Fitxatge;
import com.esliceu.dwes.boot.model.Usuari;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by xavi on 2/03/17.
 */
public interface UsuariRepository extends CrudRepository<Usuari,String> {
    List<Usuari> findByNomAndCognom(List<String> users, Long from, Long to);
    Usuari findByUsuari(String u);
}
