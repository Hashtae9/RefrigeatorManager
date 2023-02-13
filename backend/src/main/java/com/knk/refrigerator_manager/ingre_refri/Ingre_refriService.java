package com.knk.refrigerator_manager.ingre_refri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Ingre_refriService {
    private Ingre_refriRepository ingre_refriRepository;

    @Autowired
    public void setIngre_refriRepository(Ingre_refriRepository ingre_refriRepository){
        this.ingre_refriRepository = ingre_refriRepository;
    }

    //작업
}
