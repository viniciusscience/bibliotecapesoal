package br.com.triersistemas.bibliotecapessoal.model;

import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@NoArgsConstructor
@Getter
public class LojaModel {

    private UUID id;
    private BigDecimal preco;
    private String nome;

    public LojaModel(Loja loja) {
        this.id = loja.getId();
        this.nome = loja.getNome();
        this.preco = loja.getPreco();
    }
}
