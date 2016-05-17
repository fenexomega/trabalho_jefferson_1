package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FuncionarioDAOMem;
import br.ufc.model.Funcionario;

@Controller
public class FuncionarioController {
	
	
	
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
		
		FuncionarioDAOMem dao = FuncionarioDAOMem.getInstance();
		dao.adicionar(f);
		
		return "redirect:listarFuncionario";
	}
	
	@RequestMapping("/listarFuncionario")
	public String listarFuncionario(Model model)
	{
		FuncionarioDAOMem dao = FuncionarioDAOMem.getInstance();
		List<Funcionario> lista = dao.listar();
		model.addAttribute("lista", lista);
		
		return "funcionario/listar_funcionario";
	}
	
	@RequestMapping("/apagarFuncionario")
	public String apagarFuncionario(Long id)
	{
		FuncionarioDAOMem dao = FuncionarioDAOMem.getInstance();
		dao.excluir(id);
		return "redirect:listarFuncionario";
	}
	
	@RequestMapping("/alterarFuncionarioFormulario")
	public String alterarFuncionarioFormulario(Long id, Model model)
	{
		FuncionarioDAOMem dao = FuncionarioDAOMem.getInstance();
		List<Funcionario> lista = dao.listar();
		Funcionario f = lista.get(id.intValue());
		model.addAttribute("funcionario", f);
		
		return "funcionario/alterar_funcionario_formulario";
	}
	
	@RequestMapping("/alterarFuncionario")
	public String alterarFuncionario(Funcionario f)
	{
		FuncionarioDAOMem dao = FuncionarioDAOMem.getInstance();
		dao.alterar(f.getId(), f);
		System.out.println("Id: " + f.getId());
		
		return "redirect:listarFuncionario";
	}
	
}
