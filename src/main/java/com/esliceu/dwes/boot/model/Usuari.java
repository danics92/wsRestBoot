package com.esliceu.dwes.boot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by xavi on 2/03/17.
 */
@Entity
public class Usuari implements Serializable {

    public Usuari(){}

    public Usuari(String usuari, String nom, String cognom) {
        this.usuari = usuari;
        this.nom = nom;
        this.cognom = cognom;
    }

    @Id
    @GeneratedValue
    private int id;

    private String usuari;
    private String nom;
    private String cognom;
    private String contrasenya;

    @OneToMany
    @OrderBy("diaHora DESC")
    private List<Fitxatge> fitxatges;


    public String getNom() {
        return nom;
    }

    public void setNom(String nombre) {
        this.nom = nombre;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public List<Fitxatge> getFitxatges() {
        return fitxatges;
    }

    public void setFitxatges(List<Fitxatge> fitxatges) {
        this.fitxatges = fitxatges;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }
}
