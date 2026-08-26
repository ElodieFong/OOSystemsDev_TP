package com.example.louezvotrevoiture.fr.web;

import org.springframework.web.bind.annotation.*;

@RestController
public class Rent {
    @GetMapping("/")
    public String hello() {
    return "hello";
    }
}