package com.example.compliantappbackend.controller;

import com.example.compliantappbackend.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CompliantController {


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser", produces = "application/json", consumes = "application/json" )
    public HashMap<String, String> AddUser(@RequestBody User u){

        HashMap <String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }


}
