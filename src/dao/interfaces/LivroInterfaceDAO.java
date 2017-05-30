package dao.interfaces;

import java.io.IOException;

import modelo.Livro;

public interface LivroInterfaceDAO {
	public Livro buscarLivro(int idLivro) throws IOException;

	public void salvarLivro(Livro livro) throws IOException;

	public void removerLivro(Livro livro) throws IOException;

	public void removerLivro(int idLivro) throws IOException;
}
