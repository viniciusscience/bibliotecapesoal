package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.bibliotecapessoal.model.LivroObtidoModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;
import br.com.triersistemas.bibliotecapessoal.repository.LivroDesejoRepository;
import br.com.triersistemas.bibliotecapessoal.repository.LivroObtidoRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroDesejoService;
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
    public List<LivroObtidoModel> consultar() {
        return livroObtidoRepository.findAll().stream().map(LivroObtidoModel::new).toList();
    }

    @Override
    public LivroObtidoModel consultar(UUID id) {
        return new LivroObtidoModel(this.buscarPorId(id));
    }

    @Override
    public List<LivroObtidoModel> findByAutorContains(String nome) {
        return this.livroObtidoRepository.findByAutorContains(nome).stream().map(LivroObtidoModel::new).toList();
    }

    @Override
    public LivroObtidoModel cadastrar(LivroObtidoModel model) {
        LivroObtido livro = new LivroObtido(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getPagLidas(), model.getAno());
        return new LivroObtidoModel(livroObtidoRepository.save(livro));
    }

    @Override
    public void cadastrar(LivroObtido livroObtido) {
        livroObtidoRepository.save(livroObtido);
    }

    @Override
    public LivroObtidoModel editar(LivroObtidoModel model) {
        LivroObtido livro = this.buscarPorId(model.getId());
        livro.editar(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getPagLidas(), model.getAno());
        return new LivroObtidoModel(livroObtidoRepository.save(livro));
    }

    @Override
    public LivroObtidoModel adicionarPagLidas(UUID id, PagLidasModel model) {
        LivroObtido livro = this.buscarPorId(id);
        livro.acrescentaPaginas(model.getPagLidas());
        return new LivroObtidoModel(livroObtidoRepository.save(livro));
    }

    @Override
    public LivroObtidoModel excluir(UUID id) {
        LivroObtido livro = this.buscarPorId(id);
        livroObtidoRepository.delete(livro);
        return new LivroObtidoModel(livro);
    }

    private LivroObtido buscarPorId(UUID id){
        return livroObtidoRepository.findById(id).orElseThrow(LivroNaoEncontradoException::new);
    }
}
