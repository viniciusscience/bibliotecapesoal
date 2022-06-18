package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.bibliotecapessoal.model.LivroObtidoModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;
import br.com.triersistemas.bibliotecapessoal.repository.LivroObtidoRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroObtidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroObtidoServiceImpl implements LivroObtidoService {

    @Autowired
    private LivroObtidoRepository livroObtidoRepository;
    @Override
    public List<LivroObtido> consultar() {
        return livroObtidoRepository.consultar();
    }

    @Override
    public LivroObtido consultar(UUID id) {
        return livroObtidoRepository.consultar(id).orElseThrow(LivroNaoEncontradoException::new);
    }

    @Override
    public LivroObtido cadastrar(LivroObtidoModel model) {
        LivroObtido livro = new LivroObtido(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getPagLidas(), model.getAno());
        livroObtidoRepository.cadastrar(livro);
        return livro;
    }

    @Override
    public LivroObtido editar(UUID id, LivroObtidoModel model) {
        LivroObtido livro = this.consultar(id);
        livro.editar(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getPagLidas(), model.getAno());
        return livro;
    }

    @Override
    public LivroObtido adicionarPagLidas(UUID id, PagLidasModel model) {
        LivroObtido livro = this.consultar(id);
        livro.acrescentaPaginas(model.getPagLidas());
        return livro;
    }

    @Override
    public LivroObtido excluir(UUID id) {
        LivroObtido livro = this.consultar(id);
        livroObtidoRepository.excluir(livro);
        return livro;
    }
}
