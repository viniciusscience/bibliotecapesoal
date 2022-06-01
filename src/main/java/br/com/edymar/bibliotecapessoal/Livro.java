package br.com.edymar.bibliotecapessoal;

public class Livro {

	private String titulo;
	private String autor;
	private Integer paginas;
	private Integer pagLidas;
	private Integer ano;

	@Override
	public String toString() {
		return "Livro [titulo=" + titulo + ", autor=" + autor + ", paginas=" + paginas + ", pagLidas=" + pagLidas
				+ ", ano=" + ano + "]";
	}

	public Livro(String titulo, String autor, Integer paginas, Integer pagLidas, Integer ano) {
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.pagLidas = pagLidas;
		this.ano = ano;
	}

	public static void acrescentaPaginas(String titulo, Integer paginas) {
		
	}

	private Integer porcentagemLido() {
		return (this.getPaginas() / this.getPagLidas()) * 100;
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
}
