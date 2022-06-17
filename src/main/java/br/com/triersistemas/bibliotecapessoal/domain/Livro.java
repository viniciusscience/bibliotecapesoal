package br.com.triersistemas.bibliotecapessoal.domain;

import br.com.triersistemas.bibliotecapessoal.enuns.EnumStatusLeitura;
import br.com.triersistemas.bibliotecapessoal.exceptions.PaginasLidasException;
import br.com.triersistemas.bibliotecapessoal.exceptions.PaginasLivroException;
import br.com.triersistemas.bibliotecapessoal.helper.StringUtils;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Livro {

    private UUID id;
    private String titulo;
    private String autor;
    private Integer paginas;
    private Integer pagLidas;
    private Integer ano;
    private EnumStatusLeitura leitura;

    public Livro(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        this.id = UUID.randomUUID();
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = verificaPaginas(paginas, pagLidas);
        this.pagLidas = verificaPagLidas(pagLidas, paginas);
        this.ano = ano;
        this.leitura = statusLeitura();
    }

    public Livro editar(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = verificaPaginas(paginas, pagLidas);
        this.pagLidas = verificaPagLidas(pagLidas, paginas);
        this.ano = ano;
        this.leitura = statusLeitura();
        return this;
    }

    public Integer verificaPaginas(Integer paginas, Integer pagLidas) throws PaginasLivroException {
        if (paginas < 2 || paginas < pagLidas) {
            throw new PaginasLivroException();
        }
        return paginas;
    }

    public Integer verificaPagLidas(Integer pagLidas, Integer paginas) throws PaginasLidasException {
        if (pagLidas < 0 || pagLidas > paginas) {
            throw new PaginasLidasException();
        }
        return pagLidas;
    }

    public Livro acrescentaPaginas(Integer paginas) {
        if (!(paginas < 0)) {
            this.pagLidas = verificaPagLidas(this.pagLidas + paginas, this.paginas);
            this.leitura = statusLeitura();
        }
        return this;
    }

    public StringBuilder getPorcentagemLido() {
        return StringUtils.porcentagemLeitura((this.getPagLidas() * 100) / this.getPaginas(),
                this.titulo);
    }

    public EnumStatusLeitura statusLeitura() {
        return paginas.equals(pagLidas) ? EnumStatusLeitura.LIDO : EnumStatusLeitura.LENDO;
    }
}
