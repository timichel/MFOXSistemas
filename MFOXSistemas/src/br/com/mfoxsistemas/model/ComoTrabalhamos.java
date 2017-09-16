package br.com.mfoxsistemas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity(name="Como_Trabalhamos")
public class ComoTrabalhamos implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name="SEQ_TRABALHAMOS",sequenceName="SEQ_TRABALHAMOS")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SEQ_TRABALHAMOS")
	private Integer Id;
	@OneToMany(cascade = CascadeType.ALL , orphanRemoval = true, mappedBy = "comoTrabalhamos", targetEntity = Destaque.class)
	private List<Destaque> listDestaques = new ArrayList<>();
	
	public ComoTrabalhamos() {
	}
	
	public ComoTrabalhamos(Integer id, List<Destaque> listDestaques) {
		super();
		Id = id;
		this.listDestaques = listDestaques;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public List<Destaque> getListDestaques() {
		return listDestaques;
	}

	public void setListDestaques(List<Destaque> listDestaques) {
		this.listDestaques = listDestaques;
	}
	
	public void addDestaque(Destaque d){
		this.listDestaques.add(d);
	}
	
	
}
