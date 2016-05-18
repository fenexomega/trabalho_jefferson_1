package br.ufc.dao;

import java.util.List;

import br.ufc.model.Funcionario;

public interface IFuncionarioDAO {
	
	public void inserir(Funcionario funcionario);
	
	public void alterar(Funcionario funcionario);
	
	public Funcionario recuperar(long id);
	
	public void apagar(long id);
	
	public List<Funcionario> listar();
}
