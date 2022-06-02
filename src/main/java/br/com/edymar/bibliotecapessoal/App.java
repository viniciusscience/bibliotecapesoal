package br.com.edymar.bibliotecapessoal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
	
	private static List<Livro> livros = new ArrayList<Livro>();
	
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {
		Integer opcao = 5;
		do {
			try {
				opcao = Integer.parseInt(JOptionPane.showInputDialog("MENU"
						+ "\n1-Cadastrar Livro"
						+ "\n2-Editar Livro"
						+ "\n3-Mostrar todos os livros"
						+ "\n4-Porcentagem de leitura dos livros"
						+ "\n5-Sair"));
				escolheOpcao(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Você deve digitar uma opção válida.");
				opcao = 0;
			}
		} while (opcao != 5);
		
	}

	private static void escolheOpcao(Integer opcao) {
		switch (opcao) {
		case 1: cadastroLivro();
			break;
		case 2: editarLivro();
			break;
		case 3: mostrarLivros();;
			break;
		case 4: porcentagemLeitura();
			break;
		case 5: mostrarLivros();
		porcentagemLeitura();
			break;
		}
	}
	
	

	//CADASTRO DE LIVRO
	public static void cadastroLivro() {
		String titulo, autor;
		Integer paginas, pagLidas, ano;

		titulo = JOptionPane.showInputDialog("Título: ");
		autor = JOptionPane.showInputDialog("Autor: ");
		do {
			paginas = Integer.parseInt(JOptionPane.showInputDialog("Paginas: "));
			if (paginas < 2) {
				JOptionPane.showMessageDialog(null, "O livro precisa ter no mínimo 2 páginas.");
			}
		} while (paginas < 2);		
		do {
			pagLidas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de paginas lidas: "));
			if (pagLidas > paginas) {
				JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser maior que o de páginas do livro.");
			}else if (pagLidas < 0) {
				JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser menor que 0.");
			}else {
				break;
			}
		} while (true);
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de publicação: "));
		Livro livro = new Livro(titulo, autor, paginas, pagLidas, ano);
		livros.add(livro);
	}

	//EDIÇÃO DE LIVRO
	private static void editarLivro() {
		Integer opcao = Integer.parseInt(JOptionPane.showInputDialog("EDITOR"
				+ "\n1 - Modificar título"
				+ "\n2 - Modificar autor"
				+ "\n3 - Modificar páginas do livro"
				+ "\n4 - Acrescentar páginas"
				+ "\n5 - Modificar ano de lançamento"));
		switch (opcao) {
		case 1:	alterarTitulo();		
			break;
		case 2:	alterarAutor();		
			break;
		case 3:	alterarPaginas();		
			break;
		case 4:	acrescentarPaginasLidas();		
			break;
		case 5:	alterarAnoLancamento();		
			break;
		default: JOptionPane.showMessageDialog(null, "Opção Inválida.");
			break;
		}
	}	

	private static void alterarTitulo() {
		Livro livro = buscarLivro();
		String titulo;
		if (livro != null) {
			titulo = JOptionPane.showInputDialog("Digite um novo título para " + livro.getTitulo());
			livro.modificarTitulo(titulo);
		}		
	}
	
	private static void alterarAutor() {
		Livro livro = buscarLivro();
		String autor;
		if (livro != null) {
			autor = JOptionPane.showInputDialog("Digite um novo autor para" + livro.getTitulo());
			livro.modificarAutor(autor);
		}
	}
	
	private static void alterarPaginas() {
		Livro livro = buscarLivro();
		Integer pag;
		if (livro != null) {
			do {
				pag = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo número de páginas para " + livro.getTitulo()));
				if (pag < 2) {
					JOptionPane.showMessageDialog(null, "O livro precisa ter no mínimo 2 páginas.");
				}else if (pag < livro.getPagLidas()) {
					JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser maior que o número total de páginas.");
				}else {
					break;
				}			
			} while (true);
			livro.acrescentaPaginas(pag);
		}

	}
	
	private static void acrescentarPaginasLidas() {
		Livro livro = buscarLivro();
		Integer paginasSoma;
		if (livro != null) {
			do {
				paginasSoma = Integer.parseInt(JOptionPane.showInputDialog("Quantas páginas lidas você deseja acrescentar para " + livro.getTitulo()));
				if (paginasSoma < 0) {
					JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser menor que 0.");
				}else if (paginasSoma + livro.getPagLidas() > livro.getPaginas()) {
					JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser maior que o número total de páginas.");
				}else {
					break;
				}
			} while (true);
			livro.acrescentaPaginas(paginasSoma);
		}
	}
	
	private static void alterarAnoLancamento() {
		Livro livro = buscarLivro();
		Integer ano;
		if (livro != null) {
			ano = Integer.parseInt(JOptionPane.showInputDialog("Digite um novo ano de lançamento para " + livro.getTitulo()));
			livro.modificarAno(ano);			
		}		
	}
	
	//MOSTAR INFORMAÇÕES
	private static void mostrarLivros() {
		String mensagem = "";
		for (Livro livro : livros) {
			if (livro != null) {
				mensagem += livro.toString() + "\n";
			}else {
				JOptionPane.showMessageDialog(null, "Você ainda não cadastrou nenhum livro.");
			}	
		}
		if (!mensagem.equals("")) {
			JOptionPane.showMessageDialog(null, mensagem);
		}		
	}
	
	private static void porcentagemLeitura() {
		String percent = "";
		for (Livro livro : livros) {			
			percent += livro.getTitulo() + " ";
			for (int i = 0; i < livro.porcentagemLido(); i += 5) {				
				percent += "*";				
			}
			percent += " " + livro.porcentagemLido() + "%\n"; 
		}
		if (!percent.equals("")) {
			JOptionPane.showMessageDialog(null, percent);
		}		
	}
	
	//BUSCAR ALGUM LIVRO
	private static Livro buscarLivro() {		
		Livro livro = null;
		try {
			if (livros.get(0) != null) {
				String titulo = JOptionPane.showInputDialog("Qual livro?");
				for (Livro l : livros) {
					if (l.getTitulo().replace(" ", "").equalsIgnoreCase(titulo.replace(" ", ""))) {
						livro = l;
					}		
				}
			}if (livro == null) {
				JOptionPane.showMessageDialog(null, "livro não encontrado.");
			}
		}catch (Exception e) {			
				JOptionPane.showMessageDialog(null, "Você ainda não cadastrou nenhum livro.");
		}	
		return livro;
	}
}
