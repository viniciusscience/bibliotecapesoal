package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.bibliotecapessoal.exceptions.LojaNaoEcontrada;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.repository.LivroDesejoRepository;
import br.com.triersistemas.bibliotecapessoal.repository.LojaRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroDesejoService;
import br.com.triersistemas.bibliotecapessoal.service.LivroObtidoService;
import br.com.triersistemas.bibliotecapessoal.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroDesejoServiceImpl implements LivroDesejoService {

    @Autowired
    private LivroDesejoRepository livroDesejoRepository;

    @Autowired
    private LivroObtidoService livroObtidoService;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public List<LivroDesejoModel> consultar() {
        return livroDesejoRepository.findAll().stream().map(LivroDesejoModel::new).toList();
    }

    @Override
    public LivroDesejoModel consultar(UUID id) {
        return new LivroDesejoModel(this.buscaPorId(id));
    }

    @Override
    public LivroDesejoModel cadastrar(LivroDesejoModel model) {
        LivroDesejo livroDesejo = new LivroDesejo(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getAno());
        return new LivroDesejoModel(this.livroDesejoRepository.save(livroDesejo));
    }

    @Override
    public LojaModel buscaLojaMenorPreco(UUID id) {
        return new LojaModel(this.lojaRepository.buscarLojaMenorPreco(id));
    }

    @Override
    public LivroDesejoModel editar(LivroDesejoModel model) {
        LivroDesejo livroDesejo = this.buscaPorId(model.getId());
        livroDesejo.editar(model.getTitulo(), model.getAutor(), model.getPaginas(), 0, model.getAno());
        return new LivroDesejoModel(this.livroDesejoRepository.save(livroDesejo));
    }

    @Override
    public LivroDesejoModel adicionarLoja(UUID id, LojaModel model) {
       var livroDesejo = this.buscaPorId(id);
       var loja = lojaService.adicionarLoja(livroDesejo, model);
       livroDesejo.adicionarLoja(loja);
       return new LivroDesejoModel(livroDesejoRepository.save(livroDesejo));
    }

    @Override
    public LivroDesejoModel modificarLoja(UUID id, LojaModel model) {
        var livroDesejo = this.buscaPorId(id);
        lojaService.modificarLoja(model);
        return new LivroDesejoModel(this.livroDesejoRepository.save(livroDesejo));
    }

    public LivroDesejoModel excluirLoja(UUID id, UUID idLoja) {
        LivroDesejo livroDesejo = this.buscaPorId(id);
        livroDesejo.excluirLoja(this.lojaService.excluirLoja(idLoja));
        return new LivroDesejoModel(livroDesejo);
    }

    @Override
    public LivroDesejoModel livroObtido(UUID id) {
        LivroDesejo livroDesejo = this.buscaPorId(id);
        LivroObtido livroObtido = new LivroObtido(livroDesejo.getTitulo(), livroDesejo.getAutor(), livroDesejo.getPaginas(), 0, livroDesejo.getAno());
        livroObtidoService.cadastrar(livroObtido);
        livroDesejoRepository.delete(livroDesejo);
        return new LivroDesejoModel(livroDesejo);
    }

    @Override
    public LivroDesejoModel excluir(UUID id) {
        LivroDesejo livroDesejo = this.buscaPorId(id);
        livroDesejoRepository.delete(livroDesejo);
        return new LivroDesejoModel(livroDesejo);
    }

    private LivroDesejo buscaPorId(UUID id) {
        return livroDesejoRepository.findById(id).orElseThrow(LivroNaoEncontradoException::new);
    }
}
