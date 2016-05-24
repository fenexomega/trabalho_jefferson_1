<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Funcionario</title>
</head>
<body>
<b>Funcionario:</b>${funcionario_logado.nome} <br/>
<table border="1">
	<c:forEach var="f" items="${lista}">
	<tr>
		<td>${f.id}</td>
		<td>${f.nome}</td>
		<td>${f.salario}</td>
		<td><a href="alterarFuncionarioFormulario?id=${f.id}">ALTERAR</a></td>
		<td><a href="apagarFuncionario?id=${f.id}">APAGAR</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>