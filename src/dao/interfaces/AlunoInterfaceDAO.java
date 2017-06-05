package dao.interfaces;

import java.io.IOException;
import modelo.Aluno;


public interface AlunoInterfaceDAO {
    	public Aluno buscarAluno(int idAluno) throws IOException;

	public void salvarAluno(Aluno aluno) throws IOException;

	public void removerAluno(Aluno aluno) throws IOException;

	public void removerAluno(int idAluno) throws IOException;
}
