package br.com.edymar.bibliotecapessoal;

public class Livro {

	private String titulo;
	private String autor;
	private Integer paginas;
	private Integer pagLidas;
	private Integer ano;

	@Override
	public String toString() {
		return "Título - " + titulo + " | Autor - " + autor + " | Paginas - " + paginas + " | Páginas lidas - " + pagLidas + " | Ano de lançamento - " + ano;
	}

	public Livro(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.pagLidas = pagLidas;
		this.ano = ano;
	}

	public void acrescentaPaginas(Integer pag) {
		this.pagLidas += pag;
		
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void modificarAno(Integer ano) {
		this.ano = ano;
	}



	public Integer porcentagemLido() {
		return  (this.getPagLidas() * 100) / this.getPaginas();
	}

	public Integer getPagLidas() {
		return this.pagLidas;
	}

	public Integer getPaginas() {
		return this.paginas;
	}

	public Boolean isLido() {
		return paginas.equals(pagLidas);
	}

	public void modificarTitulo(String titulo) {
		this.titulo = titulo;		
	}

	public void modificarAutor(String autor) {
		this.autor = autor;
		
	}
}
