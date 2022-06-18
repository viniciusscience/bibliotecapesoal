package br.com.triersistemas.bibliotecapessoal.domain;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Livro {

    private UUID id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private Integer ano;

    public Livro(String titulo, String autor, Integer paginas, Integer ano) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.ano = ano;
    }

    public Livro editar(String titulo, String autor, Integer paginas, Integer ano){
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.ano = ano;
        return this;
    }

}
