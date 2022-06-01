package br.com.edymar.bibliotecapessoal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BD {
	
	private static final List<Livro> livros = new ArrayList<>();
	
	private BD() {}
	
	public static void preload() {
		livros.add(new Livro(null, null, null, null, null));
		livros.add(new Livro(null, null, null, null, null));
		livros.add(new Livro(null, null, null, null, null));
		livros.add(new Livro(null, null, null, null, null));
		livros.add(new Livro(null, null, null, null, null));
	}
	
	public static void salvarLivro(Livro livro) {
		livros.add(livro);
	}
	
	public static List<Livro> getLivros() {
		return Collections.unmodifiableList(livros);
	}
}
