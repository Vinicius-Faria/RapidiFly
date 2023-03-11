package com.br.rapidifly.exception;

public class InvalidOperationException extends RuntimeException{

    public InvalidOperationException(String messageErro){
        super(messageErro);
    }
}
