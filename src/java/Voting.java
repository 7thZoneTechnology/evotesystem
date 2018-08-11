/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JASWANTH K
 */
@WebServlet(urlPatterns = {"/Voting"})
public class Voting extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>VOTE</title>");            
            out.println("<script src='newjavascript.js'></script>");
            
                    
            out.println("</head>");
            out.println("<body bgcolor=#bedbae>");
            out.println("<center><div>Checked..You are ready to vote!!!</div>");
            out.println("<div>You will be redirected after casting vote...</div>");
            out.println("<div>CLICK ON SYMBOL TO CAST VOTE!!!!</div></center>");
            out.println("<form action=vote method=post>");
            //Class.forName("sun.jdbc.odbc.JdobcOdbcDriver");
//            Connection cn=DriverManager.getConnection("jdbc:ucanaccess://F:\\WebApplication\\Evote\\Vote.accdb");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/vote","root","jaswanth");
//            Statement ps=con.createStatement();
//            ResultSet rs=ps.executeQuery("select * from candidates order by 1");
            PreparedStatement ps=con.prepareStatement("select * from candidates order by 1");
            ResultSet rs=ps.executeQuery();
            
            out.println("<table bgcolor=cyan align=center cellpadding=20 cellspacing=10 width='75%'>");
            out.println("<tr bgcolor=gold><td>CANDIDATE NAME</td><td>SYMBOL</td>");
            out.println("<input type=hidden name=votedfor id=votedfor value=''>");
            while(rs.next())
            {
                out.println("<tr><td>");
                out.println(rs.getString(1));
                String sy=rs.getString(2);
                
                out.println("</td><td><a href=javascript:votefor('"+sy+"');><img width='50px' src="+ sy+ ".jpg></a>");
                out.println("</td></tr>");
            }
           // out.println("</center>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
        
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Voting.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(Voting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
