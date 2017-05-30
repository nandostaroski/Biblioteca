package dao.binario;

import java.io.IOException;
import java.util.HashMap;

import dao.interfaces.LivroInterfaceDAO;
import modelo.Livro;

public class LivroDao extends DAOBinarioGenerico implements LivroInterfaceDAO {

	private String endereco = System.getProperty("user.home") + System.getProperty("file.separator") + "livros.bin";

	@Override
	public HashMap<Integer, Livro> ler() throws IOException {
		return carregarArquivo(endereco);
	}

	@Override
	public <Integer, Livro> void salvar(HashMap<Integer, Livro> map) throws IOException {
		salvarArquivo(map, endereco);
	}

	public Livro buscarLivro(int idLivro) throws IOException {
		HashMap<java.lang.Integer, modelo.Livro> livros = ler();
		return livros.get(idLivro);
	}

	public void salvarLivro(Livro livro) throws IOException {
		HashMap<java.lang.Integer, modelo.Livro> livros = ler();
		livros.put(livro.getIdLivro(), livro);
		salvar(livros);
	}

	public void removerLivro(Livro livro) throws IOException {
		HashMap<java.lang.Integer, modelo.Livro> livros = ler();
		livros.remove(livro.getIdLivro());
		salvar(livros);
	}

	public void removerLivro(int idLivro) throws IOException {
		HashMap<java.lang.Integer, modelo.Livro> livros = ler();
		livros.remove(idLivro);
		salvar(livros);
	}
}
