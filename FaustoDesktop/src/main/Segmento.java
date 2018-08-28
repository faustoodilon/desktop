package main;

public class Segmento {

	private String segmento;
	private String descricao;
	private String sigla;
	
	public Segmento() {
	
	}

	public Segmento(String segmento, String descricao, String sigla) {
		super();
		this.segmento = segmento;
		this.descricao = descricao;
		this.sigla = sigla;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String toString() {
		return segmento;
	}
	
}
