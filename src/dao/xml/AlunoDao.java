package dao.xml;

import dao.interfaces.AlunoInterfaceDAO;
import java.io.IOException;
import java.util.HashMap;

import modelo.Aluno;

public class AlunoDao extends DAOGenerico implements AlunoInterfaceDAO {

    private final String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
            + "alunos.xml";

    @Override
    public HashMap<String, Aluno> ler() throws IOException {
        return carregarArquivo(endereco);
    }

    @Override
    public <String, Aluno> void salvar(HashMap<String, Aluno> map) throws IOException {
        salvarArquivo(map, endereco);
    }

    @Override
    public Aluno buscarAluno(String idAluno) throws IOException {
        HashMap<String, Aluno> alunos = ler();
        return alunos.get(idAluno);
    }

    @Override
    public void salvarAluno(Aluno aluno) throws IOException {
        HashMap<String, Aluno> alunos = ler();
        alunos.put(aluno.getCpf(), aluno);
        salvar(alunos);
    }

    @Override
    public void removerAluno(Aluno aluno) throws IOException {
        HashMap<String, Aluno> alunos = ler();
        alunos.remove(aluno.getCpf());
        salvar(alunos);
    }

    @Override
    public void removerAluno(String cpf) throws IOException {
        HashMap<String, Aluno> alunos = ler();
        alunos.remove(cpf);
        salvar(alunos);
    }

}
