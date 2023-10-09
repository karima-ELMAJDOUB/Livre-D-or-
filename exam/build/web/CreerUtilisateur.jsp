<%-- 
    Document   : CreerUtilisateur
    Created on : 28 déc. 2022, 08:37:57
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
         <h1>Formulaire d'inscription</h1>
        <form method="Post" action='CreerUtilisateur'>

        <%
        String msg=(String)request.getAttribute("msg");
        if(msg==null){
            msg="";
        }
        %>
        <font COLOR=" #ff0000"><%=msg %></font>
            <table>
                <tr>
                    <td>Nom :</td>
                    <td><input type="text" name="nom" value="${u.nom}"></td>
                </tr>
                <tr>
                    <td>Prenom :</td>
                    <td><input type="text" name="prenom" value="${u.prenom}"></td>
                </tr>
                <tr>
                    <td>Pseudo :</td>
                    <td><input type="text" name="pseudo" value="${u.pseudo}"></td>
                </tr>
                <tr>
                    <td>Mot dePasse :</td>
                    <td><input type="password" name="motDePasse" value="${u.motDePasse}"></td>
                </tr>
                <tr>
                    <td>Confirmation :</td>
                    <td><input type="password" name="confirmation"></td>
                </tr> 
                <tr>
                    <td><input type="submit" value='Creer Mon Compte'></td>
                    <td><input type="reset" value="Effacer"></td>
                </tr> 
                 
            </table>
        </form>
    </body>
</html>
