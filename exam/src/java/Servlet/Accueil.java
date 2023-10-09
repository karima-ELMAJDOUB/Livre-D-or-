/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Messages;
import DAO.MessagesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "Accueil", urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {
  
          private MessagesDAO msg;

    @Override
    public void init() throws ServletException {
        msg = new MessagesDAO();
    }

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); {
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List< Messages> listeMsg = msg.getListMsg();
        request.setAttribute("listeMsg", listeMsg);
        getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String message =request.getParameter("message");
        HttpSession session=request.getSession();
        //
        String user=(String) session.getAttribute("UserConnected");
        String msg="";
        
        if(message.equals("")){
            msg="Remplir les champs ";
            request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            
        }
        else if(user==null){
            msg="Vous devez se connecter";
            request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
        }

        else{
        Messages m=new Messages();
      
        m.setPseudo(user);
        m.setMessage(message);
        Date date=new Date();
        m.setDate(date);
        
           MessagesDAO ud=new MessagesDAO();
           
           String result=ud.Enregistrer(m);
           if(result.equals("ok")){
               
               msg="Ajout avec succés";            
            }
            else{
                msg="Erreur !!!";
            }
           request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
        }        
    }        
       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  


