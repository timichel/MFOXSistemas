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

@Entity(name="Paragrafo")
public class Paragrafo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name="SEQ_PARAGRAFO",sequenceName="SEQ_PARAGRAFO")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SEQ_PARAGRAFO")
	private Integer Id;
	private String tamFonte;
	private String texto;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name="FK_QUEMSOMOS")
	private QuemSomos quemSomos;
	
	public Paragrafo() {
		}
	
	public Paragrafo(String tamFonte, String texto) {
		this.tamFonte = tamFonte;
		this.texto = texto;
	}
	
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTamFonte() {
		return tamFonte;
	}
	public void setTamFonte(String tamFonte) {
		this.tamFonte = tamFonte;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public QuemSomos getQuemSomos() {
		return quemSomos;
	}

	public void setQuemSomos(QuemSomos quemSomos) {
		this.quemSomos = quemSomos;
	}
		
}
