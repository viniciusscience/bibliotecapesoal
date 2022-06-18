package br.com.triersistemas.bibliotecapessoal.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
public class ModificaLojaModel {

    private UUID idLoja;
    private BigDecimal preco;
    private String nome;
}
