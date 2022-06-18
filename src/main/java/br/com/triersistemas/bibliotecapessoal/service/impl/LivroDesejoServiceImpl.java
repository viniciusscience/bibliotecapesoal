package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.bibliotecapessoal.exceptions.LojaNaoEcontrada;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.model.ModificaLojaModel;
import br.com.triersistemas.bibliotecapessoal.repository.LivroDesejoRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroDesejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroDesejoServiceImpl implements LivroDesejoService {

    @Autowired
    private LivroDesejoRepository livroDesejoRepository;

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
    public LivroDesejo alterar(UUID id, LivroDesejoModel model) {
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
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(LojaNaoEcontrada::new);
        loja.editar(model.getPreco(), model.getNome());
        return livroDesejo;
    }

    public LivroDesejo excluirLoja(UUID id, ModificaLojaModel model){
        LivroDesejo livroDesejo = this.consultar(id);
        var loja = livroDesejo.getLojas().stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(LojaNaoEcontrada::new);
        livroDesejo.excluirLoja(loja);
        return livroDesejo;
    }

    @Override
    public LivroDesejo excluir(UUID id) {
        LivroDesejo livroDesejo = consultar(id);
        livroDesejoRepository.excluir(livroDesejo);
        return livroDesejo;
    }
}
