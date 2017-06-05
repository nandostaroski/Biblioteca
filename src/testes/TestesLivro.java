package testes;

import java.io.IOException;
import java.time.LocalDate;

import dao.interfaces.LivroInterfaceDAO;
import modelo.Livro;

public class TestesLivro {

    LivroInterfaceDAO dao;

    public TestesLivro(LivroInterfaceDAO dao) {
        this.dao = dao;
    }

    /**
     * Cria um livro e salva
     *
     * @throws IOException
     */
    public void testeCriarSalvarLivro() throws IOException {
        System.out.println("Teste criaLivro:");
        Livro livro = new Livro(1, 1, 1, LocalDate.now(), LocalDate.now(), "minhaClas", "minhaArea", "eu e eu", "Lirvro", "1990", "123456	", "editoraMaster", 35);
        System.out.println("Criando Livro: " + livro);
        System.out.println("Salvando..");
        dao.salvarLivro(livro);
        System.out.println("Fim teste criaLivro. \r\n");
    }

    /**
     * Remove o livro caso exista, Busca livro, cria um livro, adiciona ao
     * repositorio, busca o mesmo livro novamente
     *
     * @throws IOException
     */
    public void testeBuscarLivro() throws IOException {
        System.out.println("Teste buscaLivro:");
        dao.removerLivro(12345);
        Livro livro = dao.buscarLivro(12345);
        System.out.println("Buscando livro que não existe:");
        if (livro != null) {
            System.out.println("Encontrou o livro: " + livro);
        } else {
            System.out.println("Não encontrou o livro.");
        }
        livro = new Livro(1, 12345, 1, LocalDate.now(), LocalDate.now(), "minhaClas", "minhaArea", "eu e eu", "Lirvro", "1990", "123456	", "editoraMaster", 35);
        System.out.println("Criando Livro: " + livro);
        dao.salvarLivro(livro);

        System.out.println("Buscar livro por ID: 12345");
        livro = dao.buscarLivro(12345);
        if (livro != null) {
            System.out.println("Encontrou o livro: " + livro);
        } else {
            System.out.println("Não encontrou o livro.");
        }

        dao.removerLivro(livro);
        System.out.println("Fim teste buscaLivro. \r\n");
    }
}
