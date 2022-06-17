package br.com.triersistemas.pessoalbiblioteca.model;

import lombok.Getter;

@Getter
public class LivroModel {

    private String titulo;
    private String autor;
    private Integer paginas;
    private Integer pagLidas;
    private Integer ano;
}
