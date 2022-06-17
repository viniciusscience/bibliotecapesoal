package br.com.triersistemas.bibliotecapessoal.exceptions;

public class PaginasLivroException extends LivroIndefinivelException{

    public PaginasLivroException(){
        super("O livro não pode ter menos que duas páginas ou ter menos " +
                "páginas que a quantidade lida.");
    }
}
