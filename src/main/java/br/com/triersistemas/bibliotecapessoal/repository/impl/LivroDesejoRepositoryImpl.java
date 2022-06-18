package br.com.triersistemas.bibliotecapessoal.repository.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.repository.LivroDesejoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LivroDesejoRepositoryImpl implements LivroDesejoRepository {

    private static final List<LivroDesejo> LIST = new ArrayList<>();

    @Override
    public List<LivroDesejo> consultar() {
        return LIST;
    }

    @Override
    public Optional<LivroDesejo> consultar(UUID id) {
        return LIST.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    @Override
    public void cadastrar(LivroDesejo livroDesejo) {
        LIST.add(livroDesejo);
    }

    @Override
    public void excluir(LivroDesejo livroDesejo) {
        LIST.remove(livroDesejo);
    }
}
