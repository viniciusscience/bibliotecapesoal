package br.com.triersistemas.bibliotecapessoal.domain;

import br.com.triersistemas.bibliotecapessoal.enuns.EnumStatusLeitura;
import br.com.triersistemas.bibliotecapessoal.exceptions.PaginasLidasException;
import br.com.triersistemas.bibliotecapessoal.exceptions.PaginasLivroException;
import br.com.triersistemas.bibliotecapessoal.helper.StringUtils;
import lombok.Getter;

@Getter
public class LivroObtido extends Livro{

    private Integer pagLidas;
    private EnumStatusLeitura leitura;

    public LivroObtido(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        super(titulo, autor, paginas, pagLidas, ano);
        this.pagLidas = verificaPagLidas(pagLidas, paginas);
        this.leitura = statusLeitura();
    }

    public LivroObtido editar(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        super.editar(titulo, autor, paginas, pagLidas, ano);
        this.pagLidas = verificaPagLidas(pagLidas, paginas);
        this.leitura = statusLeitura();
        return this;
    }



    public Integer verificaPagLidas(Integer pagLidas, Integer paginas) throws PaginasLidasException {
        if (pagLidas < 0 || pagLidas > paginas) {
            throw new PaginasLidasException();
        }
        return pagLidas;
    }

    public LivroObtido acrescentaPaginas(Integer paginas) {
        if (!(paginas < 0)) {
            this.pagLidas = verificaPagLidas(this.pagLidas + paginas, this.getPaginas());
            this.leitura = statusLeitura();
        }
        return this;
    }

    public StringBuilder getPorcentagemLido() {
        return StringUtils.porcentagemLeitura((this.getPagLidas() * 100) / this.getPaginas(),
                this.getTitulo());
    }

    public EnumStatusLeitura statusLeitura() {
        return this.getPaginas().equals(pagLidas) ? EnumStatusLeitura.LIDO : EnumStatusLeitura.LENDO;
    }
}
