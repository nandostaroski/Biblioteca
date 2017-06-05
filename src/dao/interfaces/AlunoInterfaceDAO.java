package dao.interfaces;

import java.io.IOException;
import modelo.Aluno;


public interface AlunoInterfaceDAO {
    	public Aluno buscarAluno(long codAluno) throws IOException;

	public void salvarAluno(Aluno aluno) throws IOException;

	public void removerAluno(Aluno aluno) throws IOException;

	public void removerAluno(long codAluno) throws IOException;
}
