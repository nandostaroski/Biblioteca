package biblioteca.dao.interfaces;

import java.io.IOException;

import biblioteca.modelo.Livro;
import java.util.HashMap;

public interface LivroDAOInterface {

    public Livro buscarLivro(int idLivro) throws IOException;

    public void salvarLivro(Livro livro) throws IOException;

    public void removerLivro(Livro livro) throws IOException;

    public void removerLivro(int idLivro) throws IOException;
    
    public HashMap<Integer, Livro>  buscarLivros() throws IOException;
}
