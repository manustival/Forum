<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto</title>
    </head>
    <body>
        <h1><c:out value="${votarProjeto.titulo}"></c:out></h1><br><br>
        <c:out value="${votarProjeto.descricao}"></c:out><br><br>
        <a href="/VoteNaWeb/votar/${votarProjeto.id}/1">Votar Sim</a>
        <a href="/VoteNaWeb/votar/${votarProjeto.id}/2">Votar Não</a>
        
    </body>
</html>
