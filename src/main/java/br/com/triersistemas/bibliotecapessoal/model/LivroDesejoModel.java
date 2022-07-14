package br.com.triersistemas.bibliotecapessoal.model;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
@NoArgsConstructor
@Getter
public class LivroDesejoModel {

    private UUID id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private Integer ano;
    private List<LojaModel> lojas;

    public LivroDesejoModel(LivroDesejo livroDesejo) {
        this.id = livroDesejo.getId();
        this.titulo = livroDesejo.getTitulo();
        this.autor = livroDesejo.getAutor();
        this.paginas = livroDesejo.getPaginas();
        this.ano = livroDesejo.getAno();
        this.lojas = this.criaListaLoja(livroDesejo.getLojas());
    }

    private List<LojaModel> criaListaLoja(List<Loja> lojas) {
        if (Objects.nonNull(lojas) && !lojas.isEmpty()) {
            return lojas.stream().map(LojaModel::new).toList();
        } else {
            return new ArrayList<>();
        }
    }

}
