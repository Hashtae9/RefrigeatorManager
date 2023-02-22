package com.knk.refrigerator_manager.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor//기존의 Autowired 후 의존성 주입이 간편해짐
@Slf4j
public class UserService {
    //Constructor(생성자),Setter,Field
    private UserRepository userRepository;
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<User> users = userRepository.findAll();
        if(!users.isEmpty()){
            log.info("user 객체 있음");
            return users;
        }
        else {
            log.info("user 객체 없음");
            throw new IllegalArgumentException("no such data");
        }
    }
}
