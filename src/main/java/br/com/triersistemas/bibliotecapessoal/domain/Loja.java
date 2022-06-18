package br.com.triersistemas.bibliotecapessoal.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class Loja {

    private UUID id;
    private BigDecimal preco;
    private String nome;

    public Loja(BigDecimal preco, String nome) {
        this.id = UUID.randomUUID();
        this.preco = preco;
        this.nome = nome;
    }

    public Loja editar(BigDecimal preco, String nome){
        this.preco = preco;
        this.nome = nome;
        return this;
    }
}
