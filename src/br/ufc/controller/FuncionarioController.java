package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FuncionarioDAOMem;
import br.ufc.dao.IFuncionarioDAO;
import br.ufc.model.Funcionario;

@Transactional
@Controller
public class FuncionarioController {
	
	@Autowired
	@Qualifier(value="funcionarioDAO")
	private IFuncionarioDAO fdao;
	
	@RequestMapping("/inserirFuncionarioFormulario")
	public String inserirFuncionarioFormulario()
	{
		return "funcionario/inserir_funcionario_formulario";
	}
	
	
	@RequestMapping("/inserirFuncionario")
	public String inserirFuncionario(@Valid Funcionario f, BindingResult r)
	{
		if(r.hasFieldErrors("nome") || r.hasFieldErrors("salario"))
		{
			return "funcionario/inserir_funcionario_formulario";
		}
		
		fdao.inserir(f);
		
		return "redirect:listarFuncionario";
	}
	
	@RequestMapping("/listarFuncionario")
	public String listarFuncionario(Model model)
	{
		List<Funcionario> lista = fdao.listar();
		model.addAttribute("lista", lista);
		
		return "funcionario/listar_funcionario";
	}
	
	@RequestMapping("/apagarFuncionario")
	public String apagarFuncionario(Long id)
	{
		fdao.apagar(id);
		return "redirect:listarFuncionario";
	}
	
	@RequestMapping("/alterarFuncionarioFormulario")
	public String alterarFuncionarioFormulario(Long id, Model model)
	{
		Funcionario f = fdao.recuperar(id);
		model.addAttribute("funcionario", f);
		
		return "funcionario/alterar_funcionario_formulario";
	}
	
	@RequestMapping("/alterarFuncionario")
	public String alterarFuncionario(Funcionario f)
	{
		fdao.alterar(f);
		System.out.println("Id: " + f.getId());
		
		return "redirect:listarFuncionario";
	}
	
}
