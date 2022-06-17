package br.com.triersistemas.bibliotecapessoal.repository.impl;

import br.com.triersistemas.bibliotecapessoal.domain.Livro;
import br.com.triersistemas.bibliotecapessoal.repository.LivroRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LivroRepositoryImpl implements LivroRepository {

    private static final List<Livro> LIST = new ArrayList<>();

    @Override
    public List<Livro> consultar() {
        return LIST;
    }

    @Override
    public Optional<Livro> consultar(UUID id) {
        return LIST.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    @Override
    public void cadastrar(Livro livro) {
        LIST.add(livro);;
    }

    @Override
    public void excluir(Livro livro) {
        LIST.remove(livro);
    }
}
