package com.esliceu.dwes.boot.controller;

import com.esliceu.dwes.boot.dao.TipusRepository;
import com.esliceu.dwes.boot.model.Tipus;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dcatalans on 03/03/17.
 */
@RestController
public class TipusController {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private TipusRepository tipusRepository;

    @RequestMapping("/tipusFitxatge")
    public List<Tipus> tipus(){return (List<Tipus>) tipusRepository.findAll();}



}
