package com.knk.refrigerator_manager.refrigerator;

import com.knk.refrigerator_manager.user.User;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RefrigeratorService {
    private RefrigeratorRepository refrigeratorRepository;
    @Autowired
    public void setRefrigeratorRepository(RefrigeratorRepository refrigeratorRepository){
        this.refrigeratorRepository = refrigeratorRepository;
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
