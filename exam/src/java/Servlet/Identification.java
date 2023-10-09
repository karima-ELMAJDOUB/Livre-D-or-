/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Beans.Utilisateur;
import DAO.UtilisateurDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Identification", urlPatterns = {"/Identification"})
public class Identification extends HttpServlet {
     private UtilisateurDAO user;

    @Override
    public void init() throws ServletException {
        user = new UtilisateurDAO();
    }  

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();{
           
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
       String pseudo=request.getParameter("pseudo");
        String motDePasse=request.getParameter("motDePasse");
        
        Utilisateur u=new Utilisateur();
        
        u.setPseudo(pseudo);
        u.setMotDePasse(motDePasse); 
        
        HttpSession session=request.getSession();
        session.setAttribute("u", u);
        
        

        

        String message="";
        if ((pseudo.equals("")) || (motDePasse.equals("")) ) {
            
            message = "Remplir Les champs";    
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/Identification.jsp").forward(request, response); 

             
            }
        else{
          UtilisateurDAO ud=new UtilisateurDAO();
           //String result=pd.Enregistrer(e);
           String result=ud.authentification(u);
           if(result.equals("OK"))
           {
               session.setAttribute("UserConnected",pseudo );
               
               getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            
            }
            else{
                 message = "Nom d'utilisateur ou mot de passe est incorrect";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/Identification.jsp").forward(request,response);
            }
        }
        }        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   