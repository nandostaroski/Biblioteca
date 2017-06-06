package dao.interfaces;

import java.io.IOException;
import modelo.Emprestimo;

public interface EmprestimoDAOInterface {

    public Emprestimo buscarEmprestimo(long cdEmprestimo) throws IOException;

    public void salvarEmprestimo(Emprestimo emprestimo) throws IOException;

    public void removerEmprestimo(Emprestimo emprestimo) throws IOException;

    public void removerEmprestimo(long cdEmprestimo) throws IOException;
}
