package dao.binario;

import java.io.IOException;
import java.util.HashMap;

import modelo.Emprestimo;

public class EmprestimoDao extends DAOGenerico {
	private String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
			+ "emprestimos.bin";

	@Override
	public HashMap<Long, Emprestimo> ler() throws IOException {
		return carregarArquivo(endereco);
	}

	@Override
	public <Long, Emprestimo> void salvar(HashMap<Long, Emprestimo> map) throws IOException {
		salvarArquivo(map, endereco);
	}
}
