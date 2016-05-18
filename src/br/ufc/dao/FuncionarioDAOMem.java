package br.ufc.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufc.model.Funcionario;

public class FuncionarioDAOMem implements IFuncionarioDAO {
	
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

	public void inserir(Funcionario funcionario)
	{
		lista.add(funcionario);
	}
	
	public void alterar(Funcionario funcionario)
	{
	 	Funcionario fOld = lista.get((int) funcionario.getId());
	 	fOld.setNome(funcionario.getNome());
	 	fOld.setSalario(funcionario.getSalario());
	 	
	}
	
	public Funcionario recuperar(long id)
	{
		return lista.get((int) id);
	}
	
	public List<Funcionario> listar()
	{
		
		for (int i = 0; i < lista.size(); i++)
		{
			lista.get(i).setId(i);
		}
		return lista;
	}

	@Override
	public void apagar(long id) {
		// TODO Auto-generated method stub
		lista.remove(id);

	}
}
