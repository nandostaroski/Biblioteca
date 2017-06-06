package testes;

import dao.interfaces.AlunoDAOInterface;
import java.io.IOException;
import modelo.Aluno;


public class TestesAluno {
    AlunoDAOInterface dao;
    
     public TestesAluno(AlunoDAOInterface dao) {
        this.dao = dao;
    }

    /**
     * Cria um aluno e salva
     *
     * @throws IOException
     */
    public void testeCriarSalvarAluno() throws IOException {
        System.out.println("Teste criaAluno:");
        Aluno aluno = new Aluno("06254252856", "Fernando Staroski");
        System.out.println("Criando Aluno: " + aluno);
        System.out.println("Salvando..");
        dao.salvarAluno(aluno);
        System.out.println("Fim teste criaAluno. \r\n");
    }

    /**
     * Remove o aluno caso exista, Busca aluno, cria um aluno, adiciona ao
     * repositorio, busca o mesmo aluno novamente
     *
     * @throws IOException
     */
    public void testeBuscarAluno() throws IOException {
        System.out.println("Teste buscaAluno:");
        dao.removerAluno(12345);
        Aluno aluno = dao.buscarAluno(12345);
        System.out.println("Buscando aluno que não existe:");
        if (aluno != null) {
            System.out.println("Encontrou o aluno: " + aluno);
        } else {
            System.out.println("Não encontrou o aluno.");
        }
        aluno = new Aluno("0000654", "Aluno Teste");
        aluno.setCodAluno(12345);
        System.out.println("Criando Aluno: " + aluno);
        dao.salvarAluno(aluno);

        System.out.println("Buscar aluno por CD: 12345");
        aluno = dao.buscarAluno(12345);
        if (aluno != null) {
            System.out.println("Encontrou o aluno: " + aluno);
        } else {
            System.out.println("Não encontrou o aluno.");
        }

        dao.removerAluno(aluno);
        System.out.println("Fim teste buscaAluno. \r\n");
    }
}
