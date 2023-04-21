package br.com.triersistemas.bibliotecapessoal.domain;

import br.com.triersistemas.bibliotecapessoal.enuns.EnumStatusLeitura;
import br.com.triersistemas.bibliotecapessoal.exceptions.PaginasLidasException;
import br.com.triersistemas.bibliotecapessoal.helper.StringUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "livro_obtido")
@NoArgsConstructor
@Getter
public class LivroObtido extends Livro{
    @Column(name = "paginas_lidas")
    private Integer pagLidas;
    @Enumerated(EnumType.STRING)
    private EnumStatusLeitura leitura;

    public LivroObtido(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        super(titulo, autor, paginas, pagLidas, ano);
        this.pagLidas = verificaPagLidas(pagLidas, 0, paginas);
        this.leitura = statusLeitura();
    }

    public LivroObtido editar(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
        super.editar(titulo, autor, paginas, pagLidas, ano);
        this.pagLidas = verificaPagLidas(pagLidas, 0, paginas);
        this.leitura = statusLeitura();
        return this;
    }

    public Integer verificaPagLidas(Integer pagLidas, Integer paginas, Integer pagTotais) throws PaginasLidasException {
        if (paginas < 0 || paginas > pagTotais || pagLidas > pagTotais) {
            throw new PaginasLidasException();
        }
        if (paginas > 0) {
            return paginas;
        }
        return pagLidas;
    }

    public LivroObtido acrescentaPaginas(Integer paginas) {
        if (!(paginas < 0)) {
            this.pagLidas = verificaPagLidas(this.getPagLidas(), paginas, this.getPaginas());
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
