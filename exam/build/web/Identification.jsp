<%-- 
    Document   : Identification
    Created on : 28 déc. 2022, 08:38:14
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Identification </title>
    </head>
    <body>
         <h1>Formule de Connexion</h1>
        <form method="Post" action="Identification">
            <%
                String message= (String) request.getAttribute("message");
                if(message==null){
                    message="";
                }%>
                <font COLOR=" #ff0000"><%=message %></font>
            
            <table>
                <tr>
                    <td>Pseudo :</td>
                    <td><input type="text" name="pseudo" value="${u.pseudo}"></td>
                </tr>
                <tr>
                    <td>Mot de passe :</td>
                    <td><input type="password" name="motDePasse"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Se Connecter"></td>
                    <td><a href="CreerUtilisateur.jsp">Creer un Compte</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
