package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Funcionario;

@Repository
public class FuncionarioDAOHib implements IFuncionarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Funcionario funcionario) {
		// TODO Auto-generated method stub
		manager.persist(funcionario);
	}

	@Override
	public void alterar(Funcionario funcionario) {
		// TODO Auto-generated method stub
		manager.persist(funcionario);
	}

	@Override
	public Funcionario recuperar(long id) {
		// TODO Auto-generated method stub
		
		return manager.find(Funcionario.class, id);
	}

	@Override
	public void apagar(long id) {
		// TODO Auto-generated method stub
		Funcionario ref = recuperar(id);
		if(ref != null)
			manager.remove(ref);
	}

	@Override
	public List<Funcionario> listar() {
		// TODO Auto-generated method stub
		
		return manager
				.createQuery("select a from funcionario as a",Funcionario.class)
				.getResultList();
	}

}
