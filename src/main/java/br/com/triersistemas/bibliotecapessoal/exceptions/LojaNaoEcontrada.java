package br.com.triersistemas.bibliotecapessoal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class LojaNaoEcontrada extends RuntimeException{

    public LojaNaoEcontrada() {
        super("Loja não encontrada");
    }
}
