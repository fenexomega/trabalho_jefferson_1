<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Funcionario</title>
</head>
<body>

<h2>Alterar Funcionario</h2>

<form action="alterarFuncionario" method="post">
	<input type="hidden" name="id" value="${funcionario.id}" />
	Nome: <input type="text" name="nome" value="${funcionario.nome}" /><br />
	Salário: <input type="text" name="salario" value="${funcionario.salario}" /><br />
	<input type="submit" value="ALTERAR" />
</form>

</body>
</html>