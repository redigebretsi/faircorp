package com.emse.spring.faircorp;

public class CommandLineRunner {
    public void greetingCommandLine(String name) {
        System.out.println(new StringBuilder().append("Hello, ").append(name).toString());
    }
}
