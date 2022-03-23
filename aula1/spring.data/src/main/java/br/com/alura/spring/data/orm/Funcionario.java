package br.com.alura.spring.data.orm;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		private String nome;
		private Long CPF;
		private Double salario;
		private Date data_contratacao;
		
		@ManyToOne
		@JoinColumn(name = "cargo_id", nullable = false	)
		private Cargo cargo;
		
		@Fetch(FetchMode.SELECT)
		@ManyToMany(fetch = FetchType.EAGER)
		@JoinTable(name = "funcionarios_unidades", joinColumns = {@JoinColumn(name = "fk_funcionario") },
		inverseJoinColumns = { @JoinColumn(name = "fk_unidade") })
		private List<Trabalho> trabalhos;
	
	public Funcionario() {}
	

	public Funcionario(String nome, Long cpf, Double salario, Date data_contratacao) {
		super();
		this.nome = nome;
		CPF = cpf;
		this.salario = salario;
		this.data_contratacao = data_contratacao;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCPF() {
		return CPF;
	}

	public void setCPF(Long cPF) {
		CPF = cPF;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Date getData_contratacao() {
		return data_contratacao;
	}

	public void setData_contratacao(Date data_contratacao) {
		this.data_contratacao = data_contratacao;
	}
	
	
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", CPF=" + CPF + ", salario=" + salario
				+ ", data_contratacao=" + data_contratacao + "]";
	}
	
}
