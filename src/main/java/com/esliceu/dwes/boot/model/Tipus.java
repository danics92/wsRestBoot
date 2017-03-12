package com.esliceu.dwes.boot.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dcatalans on 03/03/17.
 */
@Entity
public class Tipus implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Nom nom;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nom getNom() {
        return nom;
    }

    public void setNom(Nom nom) {
        this.nom = nom;
    }

    public Tipus(){}

    public Tipus(Nom nom){
        this.nom = nom;
    }
}
