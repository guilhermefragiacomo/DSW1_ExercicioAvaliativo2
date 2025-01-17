<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("message");
	if (msg != null ) {
		out.println(msg);
	}
	%>
	<h1>Incluir novo pedido</h1>
    <form action="main.do?action=addRequest" method="POST">
        <div>
            <label for="nomeCliente">Nome do cliente</label>
            <input type="text" id="nomeCliente" name="nomeCliente" placeholder="Nome do cliente" required>
        </div>
        <div>
            <label for="enderecoCliente">Endereço do cliente</label>
            <input type="text" id="enderecoCliente" name="enderecoCliente" placeholder="Endereço do cliente" required>
        </div>
        <div>
            <label for="valor">Valor</label>
            <input type="number" id="valor" name="valor" placeholder="Valor do pedido" required>
        </div>
        <div>
            <label for="descricao">Descrição</label>
            <input type="text" id="descricao" name="descricao" placeholder="Descrição do pedido" required>
        </div>
        <button type="submit" class="btn">Incluir</button>
    </form>
    <a href="main.do?action=logged">Voltar</a>
</body>
</html>