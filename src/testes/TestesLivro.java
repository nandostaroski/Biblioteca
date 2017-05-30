package testes;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import dao.interfaces.InterfaceDAO;
import dao.interfaces.LivroInterfaceDAO;
import ferramentas.ImportacaoLivros;
import modelo.Livro;

public class TestesLivro {

	
	public HashMap<Integer, Livro> testeImportacaoCSV() throws IOException {
		ImportacaoLivros importacao = new ImportacaoLivros();

		return importacao.importarLivros();
	}

	public void testeSalvarLerTodos(InterfaceDAO dao) throws IOException {
		HashMap<Integer, Livro> importarLivros = testeImportacaoCSV();
		dao.salvar(importarLivros);

		HashMap<Integer, Livro> ler = dao.ler();
		System.out.println("Livros: " + ler.size());
		ler.entrySet();
	}
	
	/**
	 * Cria um livro e salva
	 * @param dao
	 * @throws IOException
	 */
	public void testeCriarSalvarLivro(LivroInterfaceDAO dao) throws IOException {
		Livro livro = new Livro(1, 1, 1, LocalDate.now(), LocalDate.now(), "minhaClas", "minhaArea", "eu e eu", "Lirvro", "1990", "123456	", "editoraMaster", 35);
		System.out.println(livro);
		dao.salvarLivro(livro);
	}
	
	/**
	 * Remove o livro caso exista, Busca livro, cria um livro, adiciona ao repositorio, busca o mesmo livro novamente
	 * @param dao
	 * @throws IOException
	 */
	public void testeBuscarLivro(LivroInterfaceDAO dao) throws IOException {
		dao.removerLivro(12345);
		Livro livro = dao.buscarLivro(12345);
		if (livro != null) {
			System.out.println("Encontrou o livro: "+livro);
		} else {
			System.out.println("Não encontrou o livro.");
		}
		livro = new Livro(1, 12345, 1, LocalDate.now(), LocalDate.now(), "minhaClas", "minhaArea", "eu e eu", "Lirvro", "1990", "123456	", "editoraMaster", 35);
		dao.salvarLivro(livro);
		
		livro = dao.buscarLivro(12345);
		if (livro != null) {
			System.out.println("Encontrou o livro: "+livro);
		} else {
			System.out.println("Não encontrou o livro.");
		}
		
		dao.removerLivro(livro);
	}
}