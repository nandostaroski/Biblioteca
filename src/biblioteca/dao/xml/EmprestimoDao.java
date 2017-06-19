package biblioteca.dao.xml;

import java.io.IOException;
import java.util.HashMap;

import biblioteca.modelo.Emprestimo;
import biblioteca.dao.interfaces.EmprestimoDAOInterface;

public class EmprestimoDao extends DAOGenerico implements EmprestimoDAOInterface {

    private final String endereco = System.getProperty("user.home") + System.getProperty("file.separator")
            + "emprestimos.xml";

    @Override
    public HashMap<Long, Emprestimo> ler() throws IOException {
        return carregarArquivo(endereco);
    }

    @Override
    public <Long, Emprestimo> void salvar(HashMap<Long, Emprestimo> map) throws IOException {
        salvarArquivo(map, endereco);
    }

    @Override
    public Emprestimo buscarEmprestimo(long cdEmprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        return emprestimos.get(cdEmprestimo);
    }

    @Override
    public void salvarEmprestimo(Emprestimo emprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        emprestimos.put(emprestimo.getCdEmprestimo(), emprestimo);
        salvar(emprestimos);
    }

    @Override
    public void removerEmprestimo(Emprestimo emprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        emprestimos.remove(emprestimo.getCdEmprestimo());
        salvar(emprestimos);
    }

    @Override
    public void removerEmprestimo(long cdEmprestimo) throws IOException {
        HashMap<Long, Emprestimo> emprestimos = ler();
        emprestimos.remove(cdEmprestimo);
        salvar(emprestimos);
    }
}
