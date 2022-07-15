package br.com.triersistemas.bibliotecapessoal.controller;

import br.com.triersistemas.bibliotecapessoal.domain.Loja;
import br.com.triersistemas.bibliotecapessoal.model.LivroDesejoModel;
import br.com.triersistemas.bibliotecapessoal.model.LojaModel;
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
    public List<LivroDesejoModel> consultar(){
        return livroDesejoService.consultar();
    }
    @GetMapping("/consultar/{id}")
    public LivroDesejoModel consultar(@PathVariable UUID id){
        return livroDesejoService.consultar(id);
    }

    @GetMapping("/loja-menor-preco/{id}")
    public LojaModel lojaMenorPreco(@PathVariable UUID id){
        return livroDesejoService.buscaLojaMenorPreco(id);
    }

    @GetMapping("/buscar-por-autor")
    public List<LivroDesejoModel> lojaMenorPreco(@RequestBody String nome){
        return livroDesejoService.buscaPorAutor(nome);
    }

    @GetMapping("/busca-ordem-alfabetica")
    public List<LivroDesejoModel> buscaOrdemAlfabetica(){
        return livroDesejoService.buscaPelaOrdemAlfabeticaTituloJPQL();
    }

    @PostMapping("/cadastrar")
    public LivroDesejoModel cadastrar(@RequestBody LivroDesejoModel model){
        return livroDesejoService.cadastrar(model);
    }
    @PutMapping("/editar")
    public LivroDesejoModel editar(@RequestBody LivroDesejoModel model){
        return livroDesejoService.editar(model);
    }
    @PutMapping("/adicionar-loja/{id}")
    public LivroDesejoModel adicionarLoja(@PathVariable UUID id, @RequestBody LojaModel model){
        return livroDesejoService.adicionarLoja(id, model);
    }
    @PutMapping("/modificar-loja/{id}")
    public LivroDesejoModel modificarLoja(@PathVariable UUID id, @RequestBody LojaModel model){
        return livroDesejoService.modificarLoja(id, model);
    }
    @DeleteMapping("/excluir-loja/{id}/{idLoja}")
    public LivroDesejoModel excluirLoja(@PathVariable UUID id, @PathVariable UUID idLoja){
        return livroDesejoService.excluirLoja(id, idLoja);
    }
    @DeleteMapping("/livro-obtido/{id}")
    public LivroDesejoModel livroObtido(@PathVariable UUID id){
        return livroDesejoService.livroObtido(id);
    }
    @DeleteMapping("/excluir/{id}")
    public LivroDesejoModel excluir(@PathVariable UUID id){
        return livroDesejoService.excluir(id);
    }
}
