package modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprestimo implements Serializable {

    private long cdEmprestimo;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dtEmprestimo;
    private LocalDate dtDevolucao;

    public Emprestimo() {
        cdEmprestimo = System.currentTimeMillis();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public LocalDate getDtEmprestimo() {
        return dtEmprestimo;
    }

    public LocalDate getDtDevolucao() {
        return dtDevolucao;
    }

    public Livro getLivro() {
        return livro;
    }

    public long getCdEmprestimo() {
        return cdEmprestimo;
    }

    public void setCdEmprestimo(long cdEmprestimo) {
        this.cdEmprestimo = cdEmprestimo;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) obj;
        return cdEmprestimo == other.cdEmprestimo;
    }
    
}
