package br.com.triersistemas.bibliotecapessoal.repository.impl;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.QLivroDesejo;
import br.com.triersistemas.bibliotecapessoal.repository.LivroDesejoRepositoryCustom;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class LivroDesejoRepositoryImpl implements LivroDesejoRepositoryCustom {

    @PersistenceContext
    private EntityManager em;
    @Override
    public List<LivroDesejo> ListarPorAutor(String nome) {
        final QLivroDesejo livroDesejo = QLivroDesejo.livroDesejo;

        final BooleanBuilder where = new BooleanBuilder();
        where.and(livroDesejo.autor.containsIgnoreCase(nome));

        return new JPAQuery<LivroDesejo>(em)
                .select(livroDesejo)
                .from(livroDesejo)
                .where(where)
                .fetch();
    }
    }

