package app;

import dao.binario.AlunoDao;
import dao.xml.EmprestimoDao;
import dao.binario.LivroDao;
import java.io.IOException;
import testes.TestesAluno;
import testes.TestesEmprestimo;

import testes.TestesLivro;

public class App {

    public static void main(String[] args) {
        LivroDao daoLivro = new LivroDao();
        TestesLivro testesLivro = new TestesLivro(daoLivro);

        try {
            testesLivro.testeCriarSalvarLivro();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        try {
            testesLivro.testeBuscarLivro();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
            

        AlunoDao daoAluno = new AlunoDao();
        TestesAluno testesAluno = new TestesAluno(daoAluno);

        try {
            testesAluno.testeCriarSalvarAluno();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        try {
            testesAluno.testeBuscarAluno();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        EmprestimoDao emprestimoDao = new EmprestimoDao();
        TestesEmprestimo testesEmprestimo = new TestesEmprestimo(emprestimoDao);
        
        try {
            testesEmprestimo.testeCriarEmprestimo();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        try {
            testesEmprestimo.testeBuscaEmprestimo();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

    }
}
