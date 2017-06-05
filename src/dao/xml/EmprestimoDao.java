package dao.xml;

import dao.interfaces.EmprestimoInterface;
import java.io.IOException;
import java.util.HashMap;

import modelo.Emprestimo;

public class EmprestimoDao extends DAOGenerico implements EmprestimoInterface {

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
    public Emprestimo buscarEmprestimo(int idEmprestimo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvarEmprestimo(Emprestimo emprestimo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerEmprestimo(Emprestimo emprestimo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removerEmprestimo(int idEmprestimo) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
