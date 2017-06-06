package app;

import dao.binario.AlunoDao;
import dao.binario.LivroDao;
import java.io.IOException;
import testes.TestesAluno;

import testes.TestesLivro;

public class App {

    public static void main(String[] args) {
        LivroDao daoLivro = new LivroDao();
        TestesLivro testesLivro = new TestesLivro(daoLivro);

        try {
            testesLivro.testeCriarSalvarLivro();
            testesLivro.testeBuscarLivro();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        AlunoDao daoAluno = new AlunoDao();
        TestesAluno testesAluno = new TestesAluno(daoAluno);
        
        try {
            testesAluno.testeCriarSalvarAluno();
            testesAluno.testeBuscarAluno();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        

    }
}
