package biblioteca.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo implements Serializable {

    private long cdEmprestimo;
    private Aluno aluno;
    private Livro livro;
    private LocalDate dtEmprestimo;
    private LocalDate dtDevolucao;
    private boolean quitado = false;
    private final long maxDiasEmprestimo = 14;

    public Emprestimo(Aluno aluno, Livro livro, LocalDate dtEmprestimo, long cdEmprestimo) throws Exception {
        if (dtEmprestimo == null) {
            throw new Exception("Data do empréstimo, não pode ser nula.");
        }
        if (aluno == null || livro == null) {
            throw new Exception(aluno == null ? "Aluno" : "Livro" + " deve ser informado para gravar o emprestimo.");
        }

        this.aluno = aluno;
        this.livro = livro;
        this.dtEmprestimo = dtEmprestimo;
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

    public long getDiasAtraso() {
        long atraso = 0;
        if (dtEmprestimo != null) {
            long diasEmprestimo = ChronoUnit.DAYS.between(dtEmprestimo, dtDevolucao != null ? dtDevolucao : LocalDate.now());
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

    public void devolucaoLivro() throws Exception {
        if (dtEmprestimo == null) {
            throw new Exception("Registro de emprestimo ainda não realizado.");
        }
        if (dtDevolucao != null) {
            throw new Exception("Devolução já realizada.");
        }

        dtDevolucao = LocalDate.now();

        // Só quita a devolução se devolver no prazo
        if (ChronoUnit.DAYS.between(dtEmprestimo, dtDevolucao) <= maxDiasEmprestimo) {
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
