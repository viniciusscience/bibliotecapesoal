package br.com.triersistemas.bibliotecapessoal.model;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
@NoArgsConstructor
@Getter
public class LivroObtidoModel {

    private UUID id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private Integer pagLidas;
    private Integer ano;
    private String status;
    private StringBuilder porcentagemLido;

    public LivroObtidoModel(LivroObtido livroObtido) {
        this.id = livroObtido.getId();
        this.titulo = livroObtido.getTitulo();
        this.autor = livroObtido.getAutor();
        this.paginas = livroObtido.getPaginas();
        this.pagLidas = livroObtido.getPagLidas();
        this.ano = livroObtido.getAno();
        this.status = livroObtido.getLeitura().name();
        this.porcentagemLido = livroObtido.getPorcentagemLido();
    }

}
