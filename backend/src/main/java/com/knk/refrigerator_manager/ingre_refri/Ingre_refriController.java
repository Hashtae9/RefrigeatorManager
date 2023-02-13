package com.knk.refrigerator_manager.ingre_refri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ingre_refriController {
    private Ingre_refriService ingre_refriService;

    @Autowired
    public void setIngre_refriService(Ingre_refriService ingre_refriService){
        this.ingre_refriService = ingre_refriService;
    }
}
