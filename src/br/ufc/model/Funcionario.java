package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name="funcionario")
public class Funcionario {

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull(message="{funcionario.nome.vazio}")
	@Size(min=5,message="{funcionario.nome.min}")
	private String nome;
	
	@NotNull(message="{funcionario.salario.vazio}")
	private double salario;
	
	@NotNull
	private String login;
	
	@NotNull
	private String senha;
	
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getLogin() {
		return login;
	}
	public String getSenha() {
		return senha;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
