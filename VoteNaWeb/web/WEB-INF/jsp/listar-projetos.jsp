<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Projetos</title>
    </head>
    <body>
        <h1>Lista de Projetos</h1>
        <table>
                <thead>
                    <tr>
                        <th>Título do Projeto</th>
                        <th>Sim</th>
                        <th>Não</th>
                    </tr>
                </thead>
                <c:forEach var="p" items="${projetos}">
                    <tr>
                        <td><a href="/VoteNaWeb/projeto/${p.id}"><c:out value="${p.titulo}"></c:out></a></td>
                        <td><c:out value="${p.votosSim}"></c:out></td>
                        <td><c:out value="${p.votosNao}"></c:out></td>
                    </tr>
                </c:forEach>
        </table>
    </body>
</html>
