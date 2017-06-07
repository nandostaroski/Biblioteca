package ferramentas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import modelo.Aluno;
import modelo.Emprestimo;

import modelo.Exemplar;
import modelo.Livro;

public class CriarRepositorios {

    public static void main(String[] args) {
        dao.binario.LivroDao daoLivroBin = new dao.binario.LivroDao();
        dao.binario.AlunoDao daoAlunoBin = new dao.binario.AlunoDao();
        dao.binario.EmprestimoDao daoEmprestimoBin = new dao.binario.EmprestimoDao();
        
        dao.xml.LivroDao daoLivroXML = new dao.xml.LivroDao();
        dao.xml.AlunoDao daoAlunoXML = new dao.xml.AlunoDao();
        dao.xml.EmprestimoDao daoEmprestimoXML = new dao.xml.EmprestimoDao();
        try {
            HashMap<Integer, Livro> livros = importarLivros();
            daoLivroBin.salvar(livros);
            daoLivroXML.salvar(livros);
            
            HashMap<Long, Aluno> alunos = new HashMap<>();
            daoAlunoBin.salvar(alunos);
            daoAlunoXML.salvar(alunos);
            
            HashMap<Long, Emprestimo> emprestimos = new HashMap<>();
            daoEmprestimoXML.salvar(emprestimos);
            daoEmprestimoBin.salvar(emprestimos);
                    
        } catch (FileNotFoundException e) {
            System.out.println("ERRO: "+e.getMessage());
        } catch (IOException e) {
            System.out.println("ERRO: "+e.getMessage());
        }
    }

    private static HashMap<Integer, Livro> importarLivros() throws FileNotFoundException {

        HashMap<Integer, Livro> livros = new HashMap<>();
        String pastaDestino = "livros.csv";
        int contadorExemplar = 0;
        int contadorLivro = 0;
        Scanner teclado = null;
        String linha;
        String[] colunas;

        try {

            teclado = new Scanner(new File(pastaDestino));

            while (teclado.hasNext()) {

                linha = (String) teclado.nextLine();

                if (linha.contains("codigoDeBarras")) {
                } else {
                    colunas = linha.split("\\|");
                    if (colunas.length == 13) {
                        if (colunas[1] != null && livros.get(Integer.parseInt(colunas[1])) != null) {
                            ((Livro) livros.get(Integer.parseInt(colunas[1])))
                                    .AdicionaExemplar(new Exemplar(colunas[0], colunas[2], colunas[3]));
                            contadorLivro++;
                        } else {
                            Livro livro = new Livro(colunas[0], colunas[1], colunas[2], colunas[3], colunas[4],
                                    colunas[5], colunas[6], colunas[7], colunas[8], colunas[9], colunas[10],
                                    colunas[11], colunas[12]);
                            livros.put(livro.getIdLivro(), livro);
                        }
                        contadorExemplar++;
                    }
                }

            }

        } finally {
            if (teclado != null) {
                teclado.close();
            }
        }

        System.out.printf("Foram importados %s livros e %s exemplares." + "\r\n", contadorLivro, contadorExemplar);
        return livros;
    }
}
