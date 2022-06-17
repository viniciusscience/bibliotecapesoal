package br.com.triersistemas.bibliotecapessoal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class LivroIndefinivelException extends RuntimeException{

    public LivroIndefinivelException(String s){
        super("O livro não pode ser cadastrado, modificado, ou alterado. " + s);
    }
}
