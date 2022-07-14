package br.com.triersistemas.bibliotecapessoal.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
@Entity
@Table(name = "loja")
@NoArgsConstructor
@Getter
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",
            insertable = false, updatable = false, nullable = false, unique = true)
    private UUID id;
    private BigDecimal preco;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "livro_desejo_id", referencedColumnName = "id")
    private LivroDesejo livroDesejo;

    public Loja(BigDecimal preco, String nome, LivroDesejo livroDesejo) {
        this.id = UUID.randomUUID();
        this.preco = preco;
        this.nome = nome;
        this.livroDesejo = livroDesejo;
    }

    public Loja editar(BigDecimal preco, String nome){
        this.preco = preco;
        this.nome = nome;
        return this;
    }
}
