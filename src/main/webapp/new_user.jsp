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
	<h1>Sign new user</h1>
    <form action="main.do?action=newUser" method="POST">
        <div>
            <label for="username">Nome</label>
            <input type="text" id="username" name="username" placeholder="Nome de usuário" required>
        </div>
        <div>
            <label for="password">Senha</label>
            <input type="password" id="password" name="password" placeholder="Senha do usuário" required>
        </div>
        <button type="submit" class="btn">Sign</button>
    </form>
    <a href="main.do?action=logged">Voltar</a>
</body>
</html>