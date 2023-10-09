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
@WebServlet(name = "CreerUtilisateur", urlPatterns = {"/CreerUtilisateur"})
public class CreerUtilisateur extends HttpServlet {
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
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String pseudo=request.getParameter("pseudo");
        String motDePasse=request.getParameter("motDePasse");
        String confirmation=request.getParameter("confirmation");
        
        Utilisateur u=new Utilisateur();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setPseudo(pseudo);
        u.setMotDePasse(motDePasse);
        
        HttpSession session=request.getSession();
        session.setAttribute("u",u);
        
        String msg="";
        if ((nom.equals("")) || (prenom.equals("")) || (pseudo.equals("")) || (motDePasse.equals("")) || (confirmation.equals("")) ) {
 
                 msg = " Remplir Les champs";
                 request.setAttribute("msg", msg);                 
                 getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
            
            }
        else if(!confirmation.equals(motDePasse)){
            msg="Le mot de passe et la confirmation sont differentes  !!";
            request.setAttribute("msg", msg);                 
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        }
        
        else{
        
           UtilisateurDAO ud=new UtilisateurDAO();
          
           String result=ud.Enregistrer(u);
           if(result.equals("ok")){
               
               msg="Ajout avec succés";
             
               
            }
            else{
                msg="Erreur !!!!";
            }
           request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        }        
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   


