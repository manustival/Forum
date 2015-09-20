<%-- 
    Document   : cadastroUsuario
    Created on : 20/09/2015, 16:53:53
    Author     : Manu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Usuario para utilização do Fórum!</h1>
        <form action="cadastro" method="POST">
            <label for="nomeUser">Nome de Usuario:</label><input type="text" name="name" id="nomeUser"></br>
            <label for="senhaUser">Senha:</laber><input type="text" name="senha" id="senhaUser"></br>
            <input type="submit" name="Cadastrar"></input>
            
            <h1>Se já é usuario, favor fazer login abaixo</h1>
            <label for="usuario">Nome de Usuario:</label><input type="text" name="name" id="usuario"></br>
            <label for="senha">Senha:</laber><input type="text" name="senhaUsuario" id="senha"></br
            <input type="submit" name="Entrar"></input>
        </form>
    </body>
</html>
