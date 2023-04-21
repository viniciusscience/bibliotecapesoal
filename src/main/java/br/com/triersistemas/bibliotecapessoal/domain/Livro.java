package br.com.triersistemas.bibliotecapessoal.domain;

import br.com.triersistemas.bibliotecapessoal.exceptions.PaginasLivroException;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;
@MappedSuperclass
@NoArgsConstructor
@Getter
public class Livro {
    @Id
    private UUID id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private Integer ano;

    public Livro(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = verificaPaginas(paginas, pagLidas);
        this.ano = ano;
    }

    public Livro editar(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano){
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = verificaPaginas(paginas, pagLidas);
        this.ano = ano;
        return this;
    }

    public Integer verificaPaginas(Integer paginas, Integer pagLidas) throws PaginasLivroException {
        if (paginas < 2 || paginas < pagLidas) {
            throw new PaginasLivroException();
        }
        return paginas;
    }


}
