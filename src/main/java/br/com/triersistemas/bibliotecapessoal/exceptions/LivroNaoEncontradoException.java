package br.com.triersistemas.bibliotecapessoal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LivroNaoEncontradoException extends RuntimeException{

    public LivroNaoEncontradoException(){
        super("Livro não encontrado.");
    }
}
