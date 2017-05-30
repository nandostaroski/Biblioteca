package app;

import java.io.IOException;

import testes.TestesLivro;

public class App {
	public static void main(String[] args) {
		dao.xml.LivroDao daoXML = new dao.xml.LivroDao();
		dao.binario.LivroDao daoBinario = new dao.binario.LivroDao();

		TestesLivro testesLivro = new TestesLivro();
		
		try {
			testesLivro.testeSalvarLerTodos(daoXML);
		} catch (IOException e) {
			System.out.println("Erro de Entrada ou Saída de dados. " + e.getMessage());
		}
		
		
		try {
			testesLivro.testeSalvarLerTodos(daoBinario);
		} catch (IOException e) {
			System.out.println("Erro de Entrada ou Saída de dados. " + e.getMessage());
		}
		
		try {
			testesLivro.testeCriarSalvarLivro(daoXML);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
