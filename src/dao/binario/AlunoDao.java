package dao.binario;

import dao.interfaces.AlunoInterfaceDAO;
import java.io.IOException;
import java.util.HashMap;

import modelo.Aluno;

public class AlunoDao extends DAOGenerico implements AlunoInterfaceDAO {

    private final String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
            + "alunos.bin";

    @Override
    public HashMap<Long, Aluno> ler() throws IOException {
        return carregarArquivo(endereco);
    }

    @Override
    public <Long, Aluno> void salvar(HashMap<Long, Aluno> map) throws IOException {
        salvarArquivo(map, endereco);
    }

    @Override
    public Aluno buscarAluno(int idAluno) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void salvarAluno(Aluno aluno) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removerAluno(Aluno aluno) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removerAluno(int idAluno) throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
