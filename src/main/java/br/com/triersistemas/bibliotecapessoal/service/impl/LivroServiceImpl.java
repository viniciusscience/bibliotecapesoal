package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.Livro;
import br.com.triersistemas.bibliotecapessoal.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.bibliotecapessoal.model.LivroModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;
import br.com.triersistemas.bibliotecapessoal.repository.LivroRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;
    @Override
    public List<Livro> consultar() {
        return livroRepository.consultar();
    }

    @Override
    public Livro consultar(UUID id) {
        return livroRepository.consultar(id).orElseThrow(LivroNaoEncontradoException::new);
    }

    @Override
    public Livro cadastrar(LivroModel model) {
        Livro livro = new Livro(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getPagLidas(), model.getAno());
        livroRepository.cadastrar(livro);
        return livro;
    }

    @Override
    public Livro editar(UUID id, LivroModel model) {
        Livro livro = this.consultar(id);
        livro.editar(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getPagLidas(), model.getAno());
        return livro;
    }

    @Override
    public Livro adicionarPagLidas(UUID id, PagLidasModel model) {
        Livro livro = this.consultar(id);
        livro.acrescentaPaginas(model.getPagLidas());
        return livro;
    }

    @Override
    public Livro excluir(UUID id) {
        Livro livro = this.consultar(id);
        livroRepository.excluir(livro);
        return livro;
    }
}
