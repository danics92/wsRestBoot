package com.esliceu.dwes.boot;

import com.esliceu.dwes.boot.model.Fitxatge;
import com.esliceu.dwes.boot.model.Tipus;
import com.esliceu.dwes.boot.model.Usuari;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by xavi on 23/02/17.
 */
@Configuration
public class BeanConfig {

    @Bean
    @Scope(value = "prototype")
    public Usuari user(){
        return new Usuari();
    }

    @Bean
    @Scope(value = "prototype")
    public Tipus tipus(){
        return new Tipus();
    }

    @Bean
    @Scope(value = "prototype")
    public Fitxatge fitx(){
        return new Fitxatge();
    }
}
