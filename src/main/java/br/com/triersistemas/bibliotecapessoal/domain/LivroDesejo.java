package br.com.triersistemas.bibliotecapessoal.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class LivroDesejo extends Livro{

    private List<Loja> lojas;

    public LivroDesejo(String titulo, String autor, Integer paginas, Integer ano) {
        super(titulo, autor, paginas, ano);
        this.lojas = new ArrayList<>();
    }


    protected LivroDesejo editar(String titulo, String autor, Integer paginas, Integer ano, BigDecimal preco, String loja) {
        super.editar(titulo, autor, paginas, ano);
        return this;
    }

    public LivroDesejo adicionarLoja(Loja loja){
        this.lojas.add(loja);
        return this;
    }

    public void excluirLoja(Loja loja) {
        this.lojas.remove(loja);
    }
}
