package com.knk.refrigerator_manager.refrigerator;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RefrigeratorService {
    private RefrigeratorRepository refrigeratorRepository;
    @Autowired
    public void setRefrigeratorRepository(RefrigeratorRepository refrigeratorRepository){
        this.refrigeratorRepository = refrigeratorRepository;
    }

    @Transactional
    public Long patchUpdate(String refriName){
        Optional<Refrigerator> refrigerator = refrigeratorRepository.findById(2L);
        if(refrigerator.isEmpty()){
            return 0L;
        }
        Refrigerator r = refrigerator.get();
        if(r.getRefri_name() != null){
            r.setRefri_name(refriName);
        }
        return r.getRefriID();
    }

    @Transactional
    public List<Refrigerator> findAll(){
        List<Refrigerator> refrigerators = refrigeratorRepository.findAll();
        if(!refrigerators.isEmpty()){
            log.info("refrigerator 객체 있음");
            return refrigerators;
        }
        else {
            log.info("user 객체 없음");
            throw new IllegalArgumentException("no such data");
        }
    }
}
