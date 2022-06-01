package br.com.edymar.bibliotecapessoal;

import java.util.ArrayList;
import java.util.List;

public class Leitor {

	private String nome;
	private Integer idade;
	private List<Livro> livrosLidos;
	private List<Livro> livrosLendo;
	private List<Livro> livrosALer;

	public Leitor(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
		this.livrosLidos = new ArrayList<Livro>();
		this.livrosLendo = new ArrayList<Livro>();
		this.livrosALer = new ArrayList<Livro>();
	}
	
	public void biblioteca(Livro livro) {
		if (livro.getLido()) {
			livrosLidos.add(livro);
		}else if (livro.getPagLidas() == 0) {
			livrosALer.add(livro);
		}else {
			livrosLendo.add(livro);
		}
	}
	
	

}
