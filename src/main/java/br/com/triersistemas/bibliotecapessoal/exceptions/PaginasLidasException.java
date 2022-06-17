package br.com.triersistemas.pessoalbiblioteca.exceptions;

public class PaginasLidasException extends LivroIndefinivelException{

    public PaginasLidasException(){
        super("As páginas lidas não podem ser negativas e nem maiores que as páginas totais do livro.");
    }
}
