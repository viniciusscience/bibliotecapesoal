package br.com.triersistemas.pessoalbiblioteca.controller;

import br.com.triersistemas.pessoalbiblioteca.domain.Livro;
import br.com.triersistemas.pessoalbiblioteca.exceptions.LivroNaoEncontradoException;
import br.com.triersistemas.pessoalbiblioteca.model.LivroModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private static final List<Livro> LIVROS = new ArrayList<>();

    @PostMapping("/cadastrar")
    public Livro cadastrar(@RequestBody LivroModel model) {
        var livro = new Livro(model.getTitulo(), model.getAutor(),
                model.getPaginas(), model.getPagLidas(), model.getAno());
        LIVROS.add(livro);
        return livro;
    }

    @PutMapping("/editar-titulo/{id}")
    public Livro editarTitulo(@PathVariable UUID id, @RequestBody LivroModel model) {
        var livro = buscaLivro(id);
        livro.alteraTitulo(model.getTitulo());
        return livro;
    }

    @PutMapping("/editar-autor/{id}")
    public Livro editarAutor(@PathVariable UUID id, @RequestBody LivroModel model) {
        var livro = buscaLivro(id);
        livro.alteraAutor(model.getAutor());
        return livro;
    }

    @PutMapping("/editar-paginas/{id}")
    public Livro editarPaginas(@PathVariable UUID id, @RequestBody LivroModel model) {
        var livro = buscaLivro(id);
        livro.alteraPaginas(model.getPaginas());
        return livro;
    }

    @PutMapping("/editar-paglidas/{id}")
    public Livro editarPagLidas(@PathVariable UUID id, @RequestBody LivroModel model) {
        var livro = buscaLivro(id);
        livro.alteraPagLidas(model.getPagLidas());
        return livro;
    }

    @PutMapping("/editar-ano/{id}")
    public Livro editarLivro(@PathVariable UUID id, @RequestBody LivroModel model) {
        var livro = buscaLivro(id);
        livro.alteraAno(model.getAno());
        return livro;
    }

    @PutMapping("/adicionar-paglidas/{id}")
    public Livro adicionarPagLidas(@PathVariable UUID id, @RequestBody LivroModel model) {
        var livro = buscaLivro(id);
        livro.acrescentaPaginas(model.getPagLidas());
        return livro;
    }

    @GetMapping("/consultar")
    public List<Livro> consultar() {
        return LIVROS;
    }

    @GetMapping("/pesquisalivro/{id}")
    public Livro pesquisaLivro(@PathVariable UUID id){
        return buscaLivro(id);
    }

    @DeleteMapping("/deletar/{id}")
    public Livro deletar(@PathVariable UUID id) {
        var livro = buscaLivro(id);
        LIVROS.remove(livro);
        return livro;
    }


    public Livro buscaLivro(UUID id) {
        return LIVROS.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst()
                .orElseThrow(LivroNaoEncontradoException::new);
    }

}
