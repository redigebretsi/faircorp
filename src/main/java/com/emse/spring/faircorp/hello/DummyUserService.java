package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class DummyUserService implements UserService{


  @Autowired
  private GreetingService b;

    public void setB(GreetingService b) {
        this.b = b;
    }

    @Override
    public void greetAll() {
            String[] users = {"Elodie!","Charles!"};
        Stream.of(users).forEach(user -> b.greet(user));


    }
}
