package modelo;

import java.time.LocalDate;

public class Emprestimo {
	private Aluno aluno;
	private Livro livro;
	private LocalDate dtEmprestimo;
	private LocalDate dtDevolucao;

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

}
