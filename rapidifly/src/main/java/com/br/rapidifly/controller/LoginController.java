package com.br.rapidifly.controller;

import com.br.rapidifly.entity.Credenciais;
import com.br.rapidifly.entity.Login;
import com.br.rapidifly.exception.InvalidOperationException;
import com.br.rapidifly.service.LoginService;
import org.bouncycastle.crypto.generators.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public boolean login(@RequestBody Credenciais credenciais){

        var login = new Login();
        login.setSenha(credenciais.getSenha());
        login.setNome(credenciais.getNome());

        var loginList = loginService.findAll();

        if(loginList.isEmpty()){
            loginService.save(login);
            return true;
        }else{
            return loginService.verificaLogin(loginList, login);
        }
    }

}
