package br.com.edymar.bibliotecapessoal;

public class Livro {

	private String titulo;
	private String autor;
	private Integer paginas;
	private Integer pagLidas;
	private Integer ano;

	@Override
	public String toString() {
		return "titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", pagLidas=" + pagLidas
				+ ", ano=" + ano + "]";
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
