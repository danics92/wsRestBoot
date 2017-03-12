package com.esliceu.dwes.boot.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dcatalans on 03/03/17.
 */
@Entity
public class Fitxatge implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private Date diaHora;


    @ManyToOne(fetch = FetchType.EAGER)
    private Tipus tipusFitxatge;

    public int getId() {
        return id;
    }

    public Fitxatge(Date diaHora, Tipus tipusFitxatge) {
        this.diaHora = diaHora;
        this.tipusFitxatge = tipusFitxatge;
    }

    public Fitxatge(){}

    public void setId(int id) {
        this.id = id;
    }

    public Date getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(Date diaHora) {
        this.diaHora = diaHora;
    }

    public Tipus getTipusFitxatge() {
        return tipusFitxatge;
    }

    public void setTipusFitxatge(Tipus tipusFitxatge) {
        this.tipusFitxatge = tipusFitxatge;
    }

}
