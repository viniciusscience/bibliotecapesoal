package br.com.triersistemas.bibliotecapessoal.service;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;

import java.util.List;
import java.util.UUID;

public interface LivroDesejoService {

    List<LivroDesejoModel> consultar();
    LivroDesejoModel consultar(UUID id);
    LivroDesejoModel cadastrar(LivroDesejoModel model);
    LojaModel buscaLojaMenorPreco(UUID id);
    List<LivroDesejoModel> buscaPorAutor(String nome);
    List<LivroDesejoModel> buscaPelaOrdemAlfabeticaTituloJPQL();
    LivroDesejoModel editar(LivroDesejoModel model);
    LivroDesejoModel adicionarLoja(UUID id, LojaModel model);
    LivroDesejoModel modificarLoja(UUID id, LojaModel model);
    LivroDesejoModel excluirLoja(UUID id, UUID idLoja);
    LivroDesejoModel livroObtido(UUID id);
    LivroDesejoModel excluir(UUID id);


}
