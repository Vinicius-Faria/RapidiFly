package com.br.rapidifly.controller;

import com.br.rapidifly.entity.Login;
import com.br.rapidifly.exception.InvalidOperationException;
import com.br.rapidifly.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public ResponseEntity<Login> login(@RequestBody Login login){

        var log = loginService.findAll();

       if(!log.isEmpty()){
           loginService.verificaLogin(log, login);
           return ResponseEntity.ok(login);
       }else{
           loginService.save(login);
           return ResponseEntity.ok(login);
       }
    }

}
