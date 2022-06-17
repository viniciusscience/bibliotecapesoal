package br.com.triersistemas.bibliotecapessoal.controller;

import br.com.triersistemas.bibliotecapessoal.domain.Livro;
import br.com.triersistemas.bibliotecapessoal.model.LivroModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;
import br.com.triersistemas.bibliotecapessoal.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/consultar")
    public List<Livro> consultar() {
        return livroService.consultar();
    }

    @GetMapping("/pesquisalivro/{id}")
    public Livro consultar(@PathVariable UUID id) {
        return livroService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public Livro cadastrar(@PathVariable UUID id, @RequestBody LivroModel model) {
        return livroService.cadastrar(model);
    }

    @PutMapping("/editar/{id}")
    public Livro editar(@PathVariable UUID id, @RequestBody LivroModel model) {
        return livroService.editar(id, model);
    }

    @PutMapping("/adicionar-paglidas/{id}")
    public Livro adicionarPagLidas(@PathVariable UUID id, @RequestBody PagLidasModel model) {
        return livroService.adicionarPagLidas(id, model);
    }

    @DeleteMapping("/excluir/{id}")
    public Livro excluir(@PathVariable UUID id) {
        return livroService.excluir(id);
    }
}
