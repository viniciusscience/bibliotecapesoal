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
    public List<LivroObtido> consultar() {
        return livroObtidoService.consultar();
    }

    @GetMapping("/consultar/{id}")
    public LivroObtido consultar(@PathVariable UUID id) {
        return livroObtidoService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public LivroObtido cadastrar(@PathVariable UUID id, @RequestBody LivroObtidoModel model) {
        return livroObtidoService.cadastrar(model);
    }

    @PutMapping("/editar/{id}")
    public LivroObtido editar(@PathVariable UUID id, @RequestBody LivroObtidoModel model) {
        return livroObtidoService.editar(id, model);
    }

    @PutMapping("/adicionar-paglidas/{id}")
    public LivroObtido adicionarPagLidas(@PathVariable UUID id, @RequestBody PagLidasModel model) {
        return livroObtidoService.adicionarPagLidas(id, model);
    }
    @DeleteMapping("/excluir/{id}")
    public LivroObtido excluir(@PathVariable UUID id) {
        return livroObtidoService.excluir(id);
    }

}
