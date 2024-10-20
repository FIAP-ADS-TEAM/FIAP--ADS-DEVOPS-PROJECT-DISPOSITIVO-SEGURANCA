package br.com.fiap.timeads.api.seguranca.apiseguranca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CasaException extends RuntimeException{

    public CasaException(String message){
        super(message);
    }
}
