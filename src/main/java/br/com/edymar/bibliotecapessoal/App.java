package br.com.edymar.bibliotecapessoal;

import javax.swing.JOptionPane;

public class App {
	
	public static void main(String[] args) {
		menu();
	}

	private static void menu() {		
		escolheOpcao(Integer.parseInt(JOptionPane.showInputDialog(criarMenu())));
	}
	
	private static String criarMenu() {
		String menu = "     MENU     "
				+ "\n1-Cadastrar Livro";
		return menu;
	}

	private static void escolheOpcao(Integer opcao) {
		switch (opcao) {
		case 1: cadastroLivro();
			break;
		case 2: editarLivro();
			break;
		default:
			break;
		}
	}

	private static void editarLivro() {
		String titulo = JOptionPane.showInputDialog(null);
		Integer opcao = Integer.parseInt(JOptionPane.showInputDialog("   EDITOR   "
				+ "\n1 - Modificar título"
				+ "\n2 - Modificar autor"
				+ "\n3 - Modificar páginas do livro"
				+ "\n4 - Acrescentar páginas"
				+ "\n5 - Modificar ano de lançamento"));		
	}

	private static Leitor cadastroLeitor() {
		String nome;
		Integer idade;
		nome = JOptionPane.showInputDialog("Digite seu nome: ");
		idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade: "));
		return new Leitor(nome, idade);
	}

	public static void cadastroLivro() {
		String titulo, autor;
		Integer paginas, pagLidas, ano;

		titulo = JOptionPane.showInputDialog("Título: ");
		autor = JOptionPane.showInputDialog("Autor: ");
		do {
			paginas = Integer.parseInt(JOptionPane.showInputDialog("Paginas: "));
			if (paginas < 2) {
				JOptionPane.showMessageDialog(null, "O livro precisa ter mais que 2 páginas.");
			}
		} while (paginas < 2);		
		do {
			pagLidas = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de paginas lidas: "));
			if (pagLidas > paginas) {
				JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser maior que o de páginas do livro.");
			}else if (pagLidas < 0) {
				JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser menor que 0.");
			}
		} while (pagLidas > paginas || pagLidas < 0);
		ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de publicação: "));
		Livro livro = new Livro(titulo, autor, paginas, pagLidas, ano);
	}
	
	private static void acrescentarPaginas() {
		String titulo;
		Integer paginasSoma;
		
		titulo = JOptionPane.showInputDialog("Qual livro você quer acrescentar páginas?");
		do {
			paginasSoma = Integer.parseInt(JOptionPane.showInputDialog("Quantas páginas você deseja acrescentar"));
			if (paginasSoma < 0) {
				JOptionPane.showMessageDialog(null, "O número de páginas lidas não pode ser menor que 0.");
			}			
		} while (paginasSoma < 0);		
	} 
}
