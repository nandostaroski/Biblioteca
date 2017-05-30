package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Livro implements Serializable {

	private int idLivro;
	private LocalDate dataCadastroSistema;
	private String classificacao;
	private String areaConhecimento;
	private String autores;
	private String titulo;
	private String ano;
	private String isbn;
	private String editora;
	private int paginas;

	HashMap<Integer, Exemplar> exemplares;

	public Livro() {

	}

	public Livro(int cdBarras, int idLivro, int exemplar, LocalDate dataAquisicaoExemplar,
			LocalDate dataCadastroSistema, String classificacao, String areaConhecimento, String autores, String titulo,
			String ano, String isbn, String editora, int paginas) {
		super();
		this.idLivro = idLivro;
		this.dataCadastroSistema = dataCadastroSistema;
		this.classificacao = classificacao;
		this.areaConhecimento = areaConhecimento;
		this.autores = autores;
		this.titulo = titulo;
		this.ano = ano;
		this.isbn = isbn;
		this.editora = editora;
		this.paginas = paginas;
		exemplares = new HashMap<Integer, Exemplar>();
		AdicionaExemplar(new Exemplar(cdBarras, exemplar, dataAquisicaoExemplar));
	}

	public Livro(String cdBarras, String idLivro, String exemplar, String dataAquisicaoExemplar,
			String dataCadastroSistema, String classificacao, String areaConhecimento, String autores, String titulo,
			String ano, String isbn, String editora, String paginas) {
		this.idLivro = Integer.parseInt(idLivro);
		this.dataCadastroSistema = LocalDate.parse(dataCadastroSistema, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.classificacao = classificacao;
		this.areaConhecimento = areaConhecimento;
		this.autores = autores;
		this.titulo = titulo;
		this.ano = ano;
		this.isbn = isbn;
		this.editora = editora;
		this.paginas = Integer.parseInt(paginas);
		exemplares = new HashMap<Integer, Exemplar>();
		AdicionaExemplar(new Exemplar(Integer.parseInt(cdBarras), Integer.parseInt(exemplar),
				LocalDate.parse(dataAquisicaoExemplar, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
	}

	public void AdicionaExemplar(Exemplar exemplar) {
		exemplares.put(exemplar.getCdBarras(), exemplar);
	}

	public HashMap<Integer, Exemplar> getExemplares() {
		return exemplares;
	}

	public LocalDate getDataCadastroSistema() {
		return dataCadastroSistema;
	}

	public void setDataCadastroSistema(LocalDate dataCadastroSistema) {
		this.dataCadastroSistema = dataCadastroSistema;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Livro))
			return false;
		Livro other = (Livro) obj;
		if (idLivro != other.idLivro)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [idLivro=" + idLivro + ", dataCadastroSistema=" + dataCadastroSistema + "]";
	}



}
