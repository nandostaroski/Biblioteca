package biblioteca.app;

import biblioteca.dao.binario.AlunoDao;
import biblioteca.dao.xml.EmprestimoDao;
import biblioteca.dao.binario.LivroDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import biblioteca.testes.TestesAluno;
import biblioteca.testes.TestesEmprestimo;
import biblioteca.testes.TestesLivro;

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

        try {
            testesLivro.testeMaiorTempoEntreDatas();
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
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
