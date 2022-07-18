package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;

import java.util.List;
import java.util.UUID;

public interface LojaService {

    List<Loja> consultarLojas(List<Loja> lojas);
    Loja adicionarLoja(LivroDesejo livroDesejo, LojaModel model);
    Loja modificarLoja(LojaModel model);
    Loja excluirLoja(UUID idLoja);
    Loja buscarLojaMenorPreco(UUID id);

    void excluirLojas(List<Loja> lojas);
}
