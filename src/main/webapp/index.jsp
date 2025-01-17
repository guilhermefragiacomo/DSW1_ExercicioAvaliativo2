<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="front.do?action=login" method="POST">
        <div>
            <label for="username">Nome</label>
            <input type="text" id="username" name="username" placeholder="Nome de usuário" required>
        </div>
        <div>
            <label for="password">Senha</label>
            <input type="password" id="password" name="password" placeholder="Senha do usuário" required>
        </div>
        <button type="submit" class="btn">Login</button>
    </form>
</body>
</html>