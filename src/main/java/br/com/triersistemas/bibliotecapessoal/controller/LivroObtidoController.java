package br.com.triersistemas.bibliotecapessoal.controller;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.LivroObtido;
import br.com.triersistemas.bibliotecapessoal.model.LivroObtidoModel;
import br.com.triersistemas.bibliotecapessoal.model.PagLidasModel;
import br.com.triersistemas.bibliotecapessoal.service.LivroObtidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livro-obtido")
public class LivroObtidoController {

    @Autowired
    private LivroObtidoService livroObtidoService;

    @GetMapping("/consultar")
    public List<LivroObtidoModel> consultar() {
        return livroObtidoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public LivroObtidoModel consultar(@PathVariable UUID id) {
        return livroObtidoService.consultar(id);
    }

    @GetMapping("/buscar-por-autor")
    public List<LivroObtidoModel> findByAutorContains(@RequestBody LivroObtidoModel model) {
        return livroObtidoService.findByAutorContains(model.getAutor());
    }

    @PostMapping("/cadastrar")
    public LivroObtidoModel cadastrar(@RequestBody LivroObtidoModel model) {

        return livroObtidoService.cadastrar(model);
    }

    @PutMapping("/editar")
    public LivroObtidoModel editar(@RequestBody LivroObtidoModel model) {
        return livroObtidoService.editar(model);
    }

    @PutMapping("/adicionar-paglidas/{id}")
    public LivroObtidoModel adicionarPagLidas(@PathVariable UUID id, @RequestBody PagLidasModel model) {
        return livroObtidoService.adicionarPagLidas(id, model);
    }
    @DeleteMapping("/excluir/{id}")
    public LivroObtidoModel excluir(@PathVariable UUID id) {
        return livroObtidoService.excluir(id);
    }

}
