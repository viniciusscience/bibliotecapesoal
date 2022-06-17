package br.com.triersistemas.pessoalbiblioteca.repository.impl;

import br.com.triersistemas.pessoalbiblioteca.domain.Livro;
import br.com.triersistemas.pessoalbiblioteca.repository.LivroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LivroRepositoryImpl implements LivroRepository {

    private static final List<Livro> LIST = new ArrayList<>();

    @Override
    public List<Livro> consultar() {
        return null;
    }

    @Override
    public Livro consultar(UUID id) {
        return null;
    }

    @Override
    public Livro cadastrar(Livro livro) {
        return null;
    }

    @Override
    public Livro excluir(Livro livro) {
        return null;
    }
}
