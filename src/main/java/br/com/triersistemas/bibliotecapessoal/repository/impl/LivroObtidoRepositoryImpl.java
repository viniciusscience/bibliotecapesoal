package br.com.triersistemas.bibliotecapessoal.repository.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.repository.LivroObtidoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LivroObtidoRepositoryImpl implements LivroObtidoRepository {

    private static final List<LivroObtido> LIST = new ArrayList<>();

    @Override
    public List<LivroObtido> consultar() {
        return LIST;
    }

    @Override
    public Optional<LivroObtido> consultar(UUID id) {
        return LIST.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    @Override
    public void cadastrar(LivroObtido livro) {
        LIST.add(livro);;
    }

    @Override
    public void excluir(LivroObtido livro) {
        LIST.remove(livro);
    }
}
