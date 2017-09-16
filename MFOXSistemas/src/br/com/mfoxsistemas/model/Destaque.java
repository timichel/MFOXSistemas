package br.com.mfoxsistemas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="Destaque")
public class Destaque implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name="SEQ_DESTAQUE",sequenceName="SEQ_DESTAQUE")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SEQ_DESTAQUE")
	private Integer Id;
	
	private String urlIcon;
	private String titulo;
	private String descricao;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="FK_COMOTRABALHAMOS")
	private ComoTrabalhamos comoTrabalhamos;
	
	public Destaque() {
	
	}
	
	public Destaque(String urlIcon, String titulo, String descricao, ComoTrabalhamos comoTrabalhamos) {
		super();
		this.urlIcon = urlIcon;
		this.titulo = titulo;
		this.descricao = descricao;
		this.comoTrabalhamos = comoTrabalhamos;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUrlIcon() {
		return urlIcon;
	}

	public void setUrlIcon(String urlIcon) {
		this.urlIcon = urlIcon;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ComoTrabalhamos getComoTrabalhamos() {
		return comoTrabalhamos;
	}

	public void setComoTrabalhamos(ComoTrabalhamos comoTrabalhamos) {
		this.comoTrabalhamos = comoTrabalhamos;
	}
	
}
