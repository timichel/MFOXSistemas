package br.com.mfoxsistemas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity(name="QuemSomos")
@NamedQueries({
@NamedQuery(name = "QuemSomos.findAll", query = "from QuemSomos qs"),
@NamedQuery(name = "QuemSomos.findById", query = "from QuemSomos qs where qs.Id=:Id"),
@NamedQuery(name = "QuemSomos.findAtivo", query = "from QuemSomos qs where qs.Ativo=:Ativo"),
@NamedQuery(name = "QuemSomos.updateInativo", query = "update QuemSomos qs set qs.Ativo=false"),
})
public class QuemSomos implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1,initialValue = 1,name="SEQ_QUEMSOMOS",sequenceName="SEQ_QUEMSOMOS")
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SEQ_QUEMSOMOS")
	private Integer Id;
	@Column(nullable=false, columnDefinition = "TINYINT(1) default false")
	private boolean Ativo;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="quemSomos", targetEntity = Paragrafo.class)
	private List<Paragrafo> listQuemSomos = new ArrayList<>();

	public QuemSomos(List<Paragrafo> listQuemSomos) {
		this.listQuemSomos = listQuemSomos;
	}
	
	public QuemSomos() {
		this.listQuemSomos = new ArrayList<>();
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}
	
	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public void addQuemSomos(Paragrafo p){
		this.listQuemSomos.add(p);
	}
	
	public List<Paragrafo> getSomos(){
		return listQuemSomos;
	}
}
