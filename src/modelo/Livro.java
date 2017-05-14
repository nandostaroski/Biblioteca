package modelo;

import java.time.LocalDate;
import java.util.HashMap;

public class Livro {

	private int idLivro;
	private LocalDate dataCadastroSistema;
	private String dadosLivro;
	private String classificacao;
	private String areaConhecimento;
	private String autores;
	private String titulo;
	private String ano;
	private String isbn;
	private String editora;
	private int paginas;
	
	HashMap<Integer, Exemplar> exemplares = new HashMap<Integer, Exemplar>();

	public Livro(int idLivro, LocalDate dataCadastroSistema, String dadosLivro, String classificacao,
			String areaConhecimento, String autores, String titulo, String ano, String isbn, String editora,
			int paginas, int cdBarras, int nrExemplar, LocalDate dataAquisicaoExemplar) {
		super();
		this.idLivro = idLivro;
		this.dataCadastroSistema = dataCadastroSistema;
		this.dadosLivro = dadosLivro;
		this.classificacao = classificacao;
		this.areaConhecimento = areaConhecimento;
		this.autores = autores;
		this.titulo = titulo;
		this.ano = ano;
		this.isbn = isbn;
		this.editora = editora;
		this.paginas = paginas;
		Exemplar exemplar = new Exemplar(cdBarras, nrExemplar, dataAquisicaoExemplar);
		exemplares.put(cdBarras, exemplar);
	}

	public Livro(int idLivro, LocalDate dataCadastroSistema, String dadosLivro, String classificacao,
			String areaConhecimento, String autores, String titulo, String ano, String isbn, String editora,
			int paginas) {
		super();
		this.idLivro = idLivro;
		this.dataCadastroSistema = dataCadastroSistema;
		this.dadosLivro = dadosLivro;
		this.classificacao = classificacao;
		this.areaConhecimento = areaConhecimento;
		this.autores = autores;
		this.titulo = titulo;
		this.ano = ano;
		this.isbn = isbn;
		this.editora = editora;
		this.paginas = paginas;
	}
	
	public void AdicionaExemplar(Exemplar exemplar) {
		exemplares.put(exemplar.getCdBarras(), exemplar);
	}
	
	public Exemplar getExemplar(int codBarras){
		return exemplares.get(codBarras);
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

	public String getDadosLivro() {
		return dadosLivro;
	}

	public void setDadosLivro(String dadosLivro) {
		this.dadosLivro = dadosLivro;
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

}
