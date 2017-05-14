package modelo;

import java.time.LocalDate;

public class Exemplar {
	private int cdBarras;
	private int exemplar;
	private LocalDate dataAquisicaoExemplar;

	public Exemplar(int cdBarras, int exemplar, LocalDate dataAquisicaoExemplar) {
		super();
		this.cdBarras = cdBarras;
		this.exemplar = exemplar;
		this.dataAquisicaoExemplar = dataAquisicaoExemplar;
	}

	public int getCdBarras() {
		return cdBarras;
	}

	public void setCdBarras(int cdBarras) {
		this.cdBarras = cdBarras;
	}

	public int getExemplar() {
		return exemplar;
	}

	public void setExemplar(int exemplar) {
		this.exemplar = exemplar;
	}

	public LocalDate getDataAquisicaoExemplar() {
		return dataAquisicaoExemplar;
	}

	public void setDataAquisicaoExemplar(LocalDate dataAquisicaoExemplar) {
		this.dataAquisicaoExemplar = dataAquisicaoExemplar;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Exemplar))
			return false;
		Exemplar other = (Exemplar) obj;
		if (cdBarras != other.cdBarras)
			return false;
		return true;
	}

}
