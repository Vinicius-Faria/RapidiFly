package com.br.rapidifly.service;

import com.br.rapidifly.entity.Login;
import com.br.rapidifly.exception.InvalidOperationException;
import com.br.rapidifly.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements BaseService<Login, Long> {

    @Autowired
    private LoginRepository loginRepository;

    private static final String SALT = "SaltSecretPassWord2.0";

    private final BCryptPasswordEncoder encoder;

    public LoginService() {
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public Login save(Login login) {
        validate(login);
        String saltedPassword = login.getSenha() + SALT;
        login.setSenha(encoder.encode(saltedPassword));
        return loginRepository.save(login);
    }

    @Override
    public Login update(Login login, Long aLong) {
        return null;
    }

    @Override
    public void delete(Long aLong) {}

    @Override
    public Login findById(Long aLong) {
        return null;
    }

    @Override
    public List<Login> findAll() {
       return loginRepository.findAll();
    }

    @Override
    public void validate(Login login) {

        if(login.getNome().isEmpty() && login.getSenha().isEmpty()){
            throw new InvalidOperationException("Login com dados vazios !");
        }

        if(login.getNome().isBlank() && login.getSenha().isBlank()){
            throw new InvalidOperationException("Login com dados vazios !");
        }

    }

    public boolean verificaLogin(List<Login> login, Login loginUser){

        for (Login log : login) {
            if (log.getNome().equalsIgnoreCase(loginUser.getNome())) {
                String saltedPassword = loginUser.getSenha() + SALT;
                return encoder.matches(saltedPassword, log.getSenha());
            }
        }
        throw new InvalidOperationException("Usuário não encontrado.");

    }
}
