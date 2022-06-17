package br.com.triersistemas.pessoalbiblioteca.exceptions;

public class LivroIndefinivelException extends RuntimeException{

    public LivroIndefinivelException(String s){
        super("O livro não pode ser cadastrado, modificado, ou alterado. " + s);
    }
}
