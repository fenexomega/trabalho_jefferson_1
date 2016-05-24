package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IFuncionarioDAO;
import br.ufc.model.Funcionario;

@Controller
public class LoginController {

	@Autowired
	@Qualifier(value="funcionarioDAO")
	private IFuncionarioDAO fDAO;
	
	@RequestMapping("/loginFormulario")
	public String loginFormulario(){
		return "login_formulario";
	}
	
	@RequestMapping("/login")
	public String login(Funcionario funcionario, HttpSession session){
		Funcionario candidato = fDAO.recuperar(funcionario.getLogin());
		if(candidato!=null){
			if(candidato.getSenha().equals(funcionario.getSenha())){
				session.setAttribute("funcionario_logado", candidato);
				return "funcionario/index";
			}
		}
		return "redirect:loginFormulario";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:loginFormulario";
	}
}










