
package dao.interfaces;

import java.io.IOException;
import modelo.Emprestimo;


public interface EmprestimoInterface {

    public Emprestimo buscarEmprestimo(int idEmprestimo) throws IOException;

    public void salvarEmprestimo(Emprestimo emprestimo) throws IOException;

    public void removerEmprestimo(Emprestimo emprestimo) throws IOException;

    public void removerEmprestimo(int idEmprestimo) throws IOException;
}
