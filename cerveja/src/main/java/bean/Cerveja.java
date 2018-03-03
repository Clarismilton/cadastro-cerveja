package bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_cerveja", sequenceName = "cerveja_seq", initialValue = 1, allocationSize = 1)
public class Cerveja {

	@Id
	@GeneratedValue(strategy = 
	GenerationType.SEQUENCE, generator = "seq_cerveja")
	private Integer id;
	private String nome;
	private Double teorAlcoolico;
	private String nacionalidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(Double teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
}
