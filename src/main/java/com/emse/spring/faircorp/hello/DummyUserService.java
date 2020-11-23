package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

@Service
public class DummyUserService implements UserService{


    public void greet(String[] name) {
        System.out.println("Hello, " + name[0] +", "+ "Hello, " + name[1]);

    }

    @Override
    public void greetAll() {
            String[] users = {"Elodie","Charles"};
            greet(users);

    }
}
