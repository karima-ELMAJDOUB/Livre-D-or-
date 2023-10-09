<%-- 
    Document   : Accueil
    Created on : 28 déc. 2022, 08:37:30
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil :</title>
    </head>
    <body>
         <form action="Accueil" method="post" >
                        <% String dd = (String) session.getAttribute("UserConnected");
                           
                            if (dd == null) {
                                dd = "";
                            }%>                      
                    <h2>Bonjour <%= dd %>, Mon site vous plait? Laissez-moi un message !</h2>                
                        <% String msg = (String) request.getAttribute("msg");
                            if (msg == null) {
                                msg = "";
                            }%>       

                        <font COLOR=" #ff0000"><%=msg%></font>            
            <table>
                <tr>
                    <td>Message :</td>
                    <td><textarea rows="4" name="message"></textarea></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Poster"></td>
                    <td><a href="Identification.jsp">Se Connecter</a></td>
                    
                </tr>
               
                <c:forEach var="msg" items="${listeMsg}">
                <tr>
                    <td><c:out value="${msg.pseudo} a ecrit le ${msg.date} " /></td>
                    <td>    <c:out value="${msg.message}"/></td>
                </tr> 
                 </c:forEach>
            </table>
           </form>

    </body>
</html>
