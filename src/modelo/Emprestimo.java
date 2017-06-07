package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Emprestimo implements Serializable {

    private long cdEmprestimo;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dtEmprestimo;
    private LocalDate dtDevolucao;
    private boolean quitado = false;
    private final int maxDiasEmprestimo = 14;

    public Emprestimo() {
        cdEmprestimo = System.currentTimeMillis();
    }

    public Emprestimo(long cdEmprestimo) {
        this.cdEmprestimo = cdEmprestimo;
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

    public boolean isQuitado() {
        return quitado;
    }

    public int getDiasAtraso() {
        int atraso = 0;
        if (dtEmprestimo != null) {
            int diasEmprestimo = Period.between(dtEmprestimo, dtDevolucao != null ? dtDevolucao : LocalDate.now()).getDays();
            if (diasEmprestimo > maxDiasEmprestimo) {
                atraso = diasEmprestimo - maxDiasEmprestimo;
            }
        }
        return atraso;
    }
    
    public void quitarEmprestimo() throws Exception {
        if (dtEmprestimo == null) {
            throw new Exception("Registro de emprestimo ainda não realizado.");
        }
        if (dtDevolucao == null) {
            throw new Exception("Devolução ainda não realizada, favor verificar.");
        }
        if (isQuitado()) {
            throw new Exception("Emprestimo já quitado.");
        }
        quitado = true;
    }

    public void gravarEmprestimo(Aluno aluno, Livro livro) throws Exception {
        if (dtEmprestimo != null) {
            throw new Exception("Registro de emprestimo já realizado. Não é possível modifica-lo.");
        }

        if (aluno == null || livro == null) {
            throw new Exception(aluno == null ? "Aluno" : "Livro" + " deve ser informado para gravar o emprestimo.");
        }

        this.aluno = aluno;
        this.livro = livro;
        this.dtEmprestimo = LocalDate.now();
    }

    public void devolucaoLivro() throws Exception {
        if (dtEmprestimo == null) {
            throw new Exception("Registro de emprestimo ainda não realizado.");
        }
        if (dtDevolucao != null) {
            throw new Exception("Devolução já realizada.");
        }

        dtDevolucao = LocalDate.now();

        if (Period.between(dtEmprestimo, dtDevolucao).getDays() <= maxDiasEmprestimo) {
            quitado = true;
        }
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

    @Override
    public String toString() {
        return "Emprestimo{" + "cdEmprestimo=" + cdEmprestimo + ", aluno=" + aluno + ", livro=" + livro + ", dtEmprestimo=" + dtEmprestimo + ", dtDevolucao=" + dtDevolucao + ", quitado=" + quitado + '}';
    }
    
}
