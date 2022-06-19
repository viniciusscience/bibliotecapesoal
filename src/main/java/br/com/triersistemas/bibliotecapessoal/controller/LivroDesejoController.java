package br.com.triersistemas.bibliotecapessoal.controller;

import br.com.triersistemas.bibliotecapessoal.domain.LivroDesejo;
import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.model.ExcluiLojaModel;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
import br.com.triersistemas.bibliotecapessoal.model.ModificaLojaModel;
import br.com.triersistemas.bibliotecapessoal.service.LivroDesejoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/livro-desejo")
public class LivroDesejoController {

    @Autowired
    private LivroDesejoService livroDesejoService;

    @GetMapping("/consultar")
    public List<LivroDesejo> consultar(){
        return livroDesejoService.consultar();
    }
    @GetMapping("/consultar/{id}")
    public LivroDesejo consultar(@PathVariable UUID id){
        return livroDesejoService.consultar(id);
    }

    @PostMapping("/cadastrar")
    public LivroDesejo cadastrar(@RequestBody LivroDesejoModel model){
        return livroDesejoService.cadastrar(model);
    }
    @PutMapping("/editar/{id}")
    public LivroDesejo editar(@PathVariable UUID id, @RequestBody LivroDesejoModel model){
        return livroDesejoService.editar(id, model);
    }
    @PutMapping("/adicionar-loja/{id}")
    public LivroDesejo adicionarLoja(@PathVariable UUID id, @RequestBody LojaModel model){
        return livroDesejoService.adicionarLoja(id, model);
    }
    @PutMapping("/modificar-loja/{id}")
    public LivroDesejo modificarLoja(@PathVariable UUID id, @RequestBody ModificaLojaModel model){
        return livroDesejoService.modificarLoja(id, model);
    }
    @PutMapping("/excluir-loja/{id}")
    public LivroDesejo excluirLoja(@PathVariable UUID id, @RequestBody ExcluiLojaModel model){
        return livroDesejoService.excluirLoja(id, model);
    }
    @DeleteMapping("/livro-obtido/{id}")
    public LivroDesejo livroObtido(@PathVariable UUID id){
        return livroDesejoService.livroObtido(id);
    }
    @DeleteMapping("/excluir/{id}")
    public LivroDesejo excluir(@PathVariable UUID id){
        return livroDesejoService.excluir(id);
    }
}
