package br.com.triersistemas.bibliotecapessoal.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "livro_desejo")
@NoArgsConstructor
@Getter
public class LivroDesejo extends Livro{

    @OneToMany(mappedBy = "livroDesejo")
    private List<Loja> lojas;

    public LivroDesejo(String titulo, String autor, Integer paginas, Integer ano) {
        super(titulo, autor, paginas, 0, ano);
        this.lojas = new ArrayList<>();
    }


    protected LivroDesejo editar(String titulo, String autor, Integer paginas, Integer ano, BigDecimal preco, String loja) {
        super.editar(titulo, autor, paginas, 0, ano);
        return this;
    }

    public LivroDesejo adicionarLoja(Loja loja){
        this.lojas.add(loja);
        return this;
    }

    public LivroDesejo excluirLoja(Loja loja) {
        this.lojas.remove(loja);
        return this;
    }
}
