package testes;

import dao.interfaces.EmprestimoDAOInterface;
import java.io.IOException;
import java.time.LocalDate;
import modelo.Aluno;
import modelo.Emprestimo;
import modelo.Livro;

public class TestesEmprestimo {

    EmprestimoDAOInterface dao;

    public TestesEmprestimo(EmprestimoDAOInterface dao) {
        this.dao = dao;
    }

    public void testeCriarEmprestimo() throws Exception {
        System.out.println("Teste criarEmprestimo");

        Livro livro = new Livro(0, 0, 0, LocalDate.MAX, LocalDate.MIN, "clas", "area", "autores", "titulo", "1990", "123456", "123", 0);
        System.out.println("Criando Livro: " + livro);
        Aluno aluno = new Aluno("123", "Fernando");
        System.out.println("Criando Aluno: " + aluno);
        Emprestimo emprestimo = new Emprestimo();
        System.out.println("Criando emprestimo: " + emprestimo);

        System.out.println("Gravar Emprestimo");
        emprestimo.gravarEmprestimo(aluno, livro);
        System.out.println("Emprestimo gravado: " + emprestimo);

        dao.salvarEmprestimo(emprestimo);
        System.out.println("Salvo no Repositorio com sucesso.");
        System.out.println("Fim teste criarEmprestimo. \r\n");
    }

    public void testeBuscaEmprestimo() throws IOException {
        System.out.println("Teste buscaEmprestimo");

        dao.removerEmprestimo(12345);
        Emprestimo emprestimo = dao.buscarEmprestimo(12345);
        System.out.println("Buscando emprestimo que não existe:");
        if (emprestimo != null) {
            System.out.println("Encontrou o emprestimo: " + emprestimo);
        } else {
            System.out.println("Não encontrou o emprestimo.");
        }
        
        emprestimo = new Emprestimo(12345);
                
        System.out.println("Criando Emprestimo: " + emprestimo);
        dao.salvarEmprestimo(emprestimo);

        System.out.println("Buscar emprestimo por ID: 12345");
        emprestimo = dao.buscarEmprestimo(12345);
        if (emprestimo != null) {
            System.out.println("Encontrou o emprestimo: " + emprestimo);
        } else {
            System.out.println("Não encontrou o emprestimo.");
        }

        dao.removerEmprestimo(emprestimo);
        System.out.println("Fim teste buscaEmprestimo. \r\n");
    }
}
