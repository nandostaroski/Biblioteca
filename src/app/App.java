package app;

//import dao.xml.LivroDao;
import dao.binario.LivroDao;
import java.io.IOException;

import testes.TestesLivro;

public class App {

    public static void main(String[] args) {
        LivroDao dao = new LivroDao();

        TestesLivro testesLivro = new TestesLivro(dao);

        try {
            testesLivro.testeCriarSalvarLivro();
            testesLivro.testeBuscarLivro();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("ERRO: " + e.getMessage());
        }
        
        int a = true ? 0 : 1;
        System.out.println(a);
        
    }
}
