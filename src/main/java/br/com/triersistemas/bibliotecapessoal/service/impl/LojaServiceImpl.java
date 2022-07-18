package br.com.triersistemas.bibliotecapessoal.service.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.exceptions.LojaNaoEcontrada;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.repository.LojaRepository;
import br.com.triersistemas.bibliotecapessoal.service.LivroDesejoService;
import br.com.triersistemas.bibliotecapessoal.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LojaServiceImpl implements LojaService {

    @Autowired
    private LojaRepository lojaRepository;

    @Override
    public List<Loja> consultarLojas(List<Loja> lojas) {
        return lojaRepository.findAllById(this.buscaIdsLojas(lojas)).stream().toList();
    }

    @Override
    public Loja adicionarLoja(LivroDesejo livroDesejo,LojaModel model) {
        Loja loja = new Loja(model.getPreco(), model.getNome(), livroDesejo);
        return this.lojaRepository.save(loja);
    }

    @Override
    public Loja modificarLoja(LojaModel model) {
        Loja loja = this.buscarPorId(model.getId());
        loja.editar(model.getPreco(), model.getNome());
        return this.lojaRepository.save(loja);
    }
    @Override
    public Loja excluirLoja(UUID idLoja) {
        var loja = buscarPorId(idLoja);
        this.lojaRepository.delete(loja);
        return loja;
    }

    @Override
    public Loja buscarLojaMenorPreco(UUID id) {
        return this.lojaRepository.buscarLojaMenorPreco(id);
    }

    @Override
    public void excluirLojas(List<Loja> lojas) {
        this.lojaRepository.deleteAll(lojas);
    }

    private List<UUID> buscaIdsLojas(List<Loja> lojas) {
        return lojas.stream().map(Loja::getId).toList();
    }


    private Loja buscarPorId(UUID id) {
        return this.lojaRepository.findById(id).orElseThrow(LojaNaoEcontrada::new);
    }
}
