package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.bibliotecapessoal.exceptions.LojaNaoEcontrada;
import br.com.triersistemas.bibliotecapessoal.model.ExcluiLojaModel;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.model.ModificaLojaModel;
import br.com.triersistemas.bibliotecapessoal.repository.LivroDesejoRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroDesejoService;
import br.com.triersistemas.bibliotecapessoal.service.LivroObtidoService;
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

    @Override
    public List<LivroDesejo> consultar() {
        return livroDesejoRepository.consultar();
    }

    @Override
    public LivroDesejo consultar(UUID id) {
        return livroDesejoRepository.consultar(id).orElseThrow(LivroNaoEncontradoException::new);
    }

    @Override
    public LivroDesejo cadastrar(LivroDesejoModel model) {
        LivroDesejo livroDesejo = new LivroDesejo(model.getTitulo(), model.getAutor(), model.getPaginas(), model.getAno());
        livroDesejoRepository.cadastrar(livroDesejo);
        return livroDesejo;
    }

    @Override
    public LivroDesejo editar(UUID id, LivroDesejoModel model) {
        LivroDesejo livroDesejo = this.consultar(id);
        livroDesejo.editar(model.getTitulo(), model.getAutor(), model.getPaginas(), 0, model.getAno());
        return livroDesejo;
    }

    @Override
    public LivroDesejo adicionarLoja(UUID id, LojaModel model) {
        LivroDesejo livroDesejo = this.consultar(id);
        Loja loja = new Loja(model.getPreco(), model.getNome());
        livroDesejo.adicionarLoja(loja);
        return livroDesejo;
    }

    @Override
    public LivroDesejo modificarLoja(UUID id, ModificaLojaModel model) {
        LivroDesejo livroDesejo = this.consultar(id);
        var loja = livroDesejo.getLojas().stream()
                .filter(l -> l.getId().equals(model.getIdLoja()))
                .findFirst()
                .orElseThrow(LojaNaoEcontrada::new);
        loja.editar(model.getPreco(), model.getNome());
        return livroDesejo;
    }

    public LivroDesejo excluirLoja(UUID id, ExcluiLojaModel model) {
        LivroDesejo livroDesejo = this.consultar(id);
        var loja = livroDesejo.getLojas().stream()
                .filter(l -> l.getId().equals(model.getIdLoja()))
                .findFirst()
                .orElseThrow(LojaNaoEcontrada::new);
        livroDesejo.excluirLoja(loja);
        return livroDesejo;
    }

    @Override
    public LivroObtido livroObtido(UUID id) {
        LivroDesejo livroDesejo = this.consultar(id);
        LivroObtido livroObtido = new LivroObtido(livroDesejo.getTitulo(), livroDesejo.getAutor(), livroDesejo.getPaginas(), 0, livroDesejo.getAno());
        livroObtidoService.cadastrar(livroObtido);
        livroDesejoRepository.excluir(livroDesejo);
        return livroObtido;
    }

    @Override
    public LivroDesejo excluir(UUID id) {
        LivroDesejo livroDesejo = consultar(id);
        livroDesejoRepository.excluir(livroDesejo);
        return livroDesejo;
    }
}
