package dao.binario;

import java.io.IOException;
import java.util.HashMap;

import modelo.Aluno;

public class AlunoDao extends DAOGenerico {
	private String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
	+ "alunos.bin";
	
	@Override
	public HashMap<Long, Aluno> ler() throws IOException {
		return carregarArquivo(endereco);
	}

	@Override
	public <Long, Aluno> void salvar(HashMap<Long, Aluno> map) throws IOException {
		salvarArquivo(map, endereco);
	}
}
