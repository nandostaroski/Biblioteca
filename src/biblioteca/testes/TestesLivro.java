package biblioteca.testes;

import java.io.IOException;
import java.time.LocalDate;

import biblioteca.modelo.Livro;
import biblioteca.dao.interfaces.LivroDAOInterface;
import biblioteca.modelo.Exemplar;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestesLivro {

    LivroDAOInterface dao;

    public TestesLivro(LivroDAOInterface dao) {
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

    
    public void testeMaiorTempoEntreDatas() throws IOException {
        System.out.println("Teste testeMaiorTempoEntreDatas:");
        HashMap<Integer, Livro> livros = dao.buscarLivros();
        Livro livro = null;
        int codExemplar = 0;
        for (Map.Entry<Integer, Livro> entry : livros.entrySet()) {
            Livro livroAtual = entry.getValue();
            if (livro == null) {
                livro = livroAtual;
                codExemplar = buscaCodExemplarMaisAntigo(livro);
            } else {
                int exemplarMaisAntigoDoLivroAtual = buscaCodExemplarMaisAntigo(livroAtual);
                if (periodoEntreAquisicaoCadastro(livro, livro.getExemplares().get(codExemplar)) < periodoEntreAquisicaoCadastro(livroAtual, livroAtual.getExemplares().get(exemplarMaisAntigoDoLivroAtual))) {
                    livro = livroAtual;
                    codExemplar = exemplarMaisAntigoDoLivroAtual;
                }
            }
        }
        System.out.println("Livro com maior diferença entre data de cadastro e data de aquisição do exemplar: ");
        System.out.println(livro);
        System.out.println(livro.getExemplares().get(codExemplar));
        System.out.println("Diferença de " + periodoEntreAquisicaoCadastro(livro, livro.getExemplares().get(codExemplar)) + " dias.");
        System.out.println("Fim teste testeMaiorTempoEntreDatas. \r\n");
    }

    /**
     * @Autor fstaroski
     * @param livro
     * @param exemplar
     * @return a quantidade de dias entre A data de aquisição do Exemplar e data
     * de Cadastro do Sistema do livro
     */
    private long periodoEntreAquisicaoCadastro(Livro livro, Exemplar exemplar) {
        return ChronoUnit.DAYS.between(livro.getDataCadastroSistema(), exemplar.getDataAquisicaoExemplar());
    }

    /**
     *
     * @param livro
     * @return codExemplar do exemplar com a maior diferença entre A data de
     * aquisição do Exemplar e data de Cadastro do Sistema do livro
     */
    private int buscaCodExemplarMaisAntigo(Livro livro) {
        long periodo = Integer.MIN_VALUE;
        int codExemplar = -1;
        Set<Map.Entry<Integer, Exemplar>> exemplares = livro.getExemplares().entrySet();
        for (Map.Entry<Integer, Exemplar> entry1 : exemplares) {
            Integer codExemplarAtual = entry1.getKey();
            Exemplar exemplarAtual = entry1.getValue();
            long periodoAtual = periodoEntreAquisicaoCadastro(livro, exemplarAtual);
            if (periodo < periodoAtual) {
                periodo = periodoAtual;
                codExemplar = codExemplarAtual;
            }
        }
        return codExemplar;
    }
}
