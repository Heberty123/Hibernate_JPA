package br.com.alura.Modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "people")
public class People {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int age;
	@OneToMany(mappedBy = "people", cascade = CascadeType.ALL)
	private List<Pedido> produtos = new ArrayList<>();
	
	
	
	
	public People() {}

	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public List<Pedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Pedido> produtos) {
		this.produtos = produtos;
	}

	
		
}
