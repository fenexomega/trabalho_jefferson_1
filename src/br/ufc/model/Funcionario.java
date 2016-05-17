package br.ufc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Funcionario {

	private long id;
	@NotNull(message="{funcionario.nome.vazio}")
	@Size(min=5,message="{funcionario.nome.min}")
	private String nome;
	@NotNull(message="{aluno.salario.vazio}")
	private double salario;
	
	
	
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
	
}
