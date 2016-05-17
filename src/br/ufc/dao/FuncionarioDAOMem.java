package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufc.model.Funcionario;

public class FuncionarioDAOMem {
	
	private static FuncionarioDAOMem instance;
	private List<Funcionario> lista;
	
	
	public static FuncionarioDAOMem getInstance()
	{
		if(instance == null)
			instance = new FuncionarioDAOMem();
		return instance;
	}
	
	private FuncionarioDAOMem() 
	{
		
		lista = new ArrayList<Funcionario>();
	}

	public void adicionar(Funcionario f)
	{
		lista.add(f);
	}
	
	public void excluir(Long id)
	{
		lista.remove(id.intValue());
	}
	
	public void alterar(Long id,Funcionario f)
	{
	 	Funcionario fOld = lista.get(id.intValue());
	 	fOld.setNome(f.getNome());
	 	fOld.setSalario(f.getSalario());
	 	
	}
	
	public Funcionario recuperar(Long id)
	{
		return lista.get(id.intValue());
	}
	
	public List<Funcionario> listar()
	{
		for (int i = 0; i < lista.size(); i++)
		{
			lista.get(i).setId(i);
		}
		return lista;
	}
}
