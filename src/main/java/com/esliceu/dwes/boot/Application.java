package com.esliceu.dwes.boot;

import com.esliceu.dwes.boot.dao.FitxatgeRespository;
import com.esliceu.dwes.boot.dao.TipusRepository;
import com.esliceu.dwes.boot.dao.UsuariRepository;
import com.esliceu.dwes.boot.model.Fitxatge;
import com.esliceu.dwes.boot.model.Nom;
import com.esliceu.dwes.boot.model.Tipus;
import com.esliceu.dwes.boot.model.Usuari;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(UsuariRepository repo, FitxatgeRespository frp, TipusRepository tipusRepo){

        return (args) -> {

            Tipus tipus1 = new Tipus(Nom.ENTRADA);
            tipusRepo.save(tipus1);

            Tipus tipus2 = new Tipus(Nom.ENTRADA);
            tipusRepo.save(tipus2);

            Fitxatge f1 = new Fitxatge(1489433626,tipus1);
            f1.setTipusFitxatge(tipus1);
            f1.setTipusFitxatge(tipus2);

            Fitxatge f2 = new Fitxatge(1489433626, tipus2);
            f2.setTipusFitxatge(tipus1);
            f2.setTipusFitxatge(tipus2);

            frp.save(f1);
            frp.save(f2);

            List<Fitxatge> lf = new ArrayList<>();
            lf.add(f1);

            List<Fitxatge> lf2 = new ArrayList<>();
            lf2.add(f2);


            Usuari u1 = (new Usuari("xcambil","Xisco", "cambil","1234"));
            u1.setFitxatges(lf);
            repo.save(u1);

            Usuari u2 = (new Usuari("jbauer","Jack", "Bauer","1234"));
            u2.setFitxatges(lf2);
            repo.save(u2);



//            Usuari u3 = (new Usuari("Chloe", "O'Brian","1234"));
//            u3.setFitxatges(lf);
//            repo.save(u3);
//
//            Usuari u4 = (new Usuari("Kim", "Bauer","1234"));
//            u4.setFitxatges(lf);
//            repo.save(u4);
//
//            Usuari u5 = (new Usuari("David", "Palmer","1234"));
//            u5.setFitxatges(lf);
//            repo.save(u5);
//
//            Usuari u6 = (new Usuari("Michelle", "Dessler","1234"));
//            u6.setFitxatges(lf);
//            repo.save(u6);
        };

    }
}
