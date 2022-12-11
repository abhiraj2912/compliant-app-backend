package com.example.compliantappbackend.controller;

import com.example.compliantappbackend.dao.CompliantDao;
import com.example.compliantappbackend.dao.UserDao;
import com.example.compliantappbackend.model.Compliant;
import com.example.compliantappbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CompliantController {

    @Autowired
    private UserDao udao;

    @Autowired
    private CompliantDao cdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser", produces = "application/json", consumes = "application/json" )
    public HashMap<String, String> AddUser(@RequestBody User u){
        udao.save(u);
        HashMap <String, String> map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Login(@RequestBody User u){
        HashMap <String, String> map = new HashMap<>();
        List<User> result = udao.LoginCheck(u.getUsername(),u.getPassword());
        if(result.size()==0){
            System.out.println(result);
            map.put("status","failed");
            return map;
        }
        else {
            int id = result.get(0).getId();
            map.put("id",String.valueOf(id));
            map.put("status","success");
            return map;
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userinfo", consumes = "application/json", produces = "application/json")
    List<User> UserInfo(@RequestBody User u){
        return (List<User>) udao.UserInfo(u.getId());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addcompliant", consumes = "application/json", produces = "application/json")
    public  HashMap<String,String> AddCompliant(@RequestBody Compliant c){
        HashMap <String, String> map = new  HashMap<>();
        cdao.save(c);
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/ucompliantview", consumes = "application/json", produces = "application/json")
    public List<Compliant> userCompliant(@RequestBody Compliant c){
        String uid = String.valueOf(c.getUserId());
        System.out.println(uid);
        return (List<Compliant>) cdao.UserView(c.getUserId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/acompliantview")
    public List<Map<String,String>> adminCompliant(){
        return (List<Map<String,String>>) cdao.AdminView();
    }
}
