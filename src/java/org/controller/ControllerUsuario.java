/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoUsuario;
import org.models.ModelUsuario;


@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String acceso="";        
        String action = request.getParameter("accion");        
        String listar="Usuario/consultaUsuario.jsp";
        String add="Usuario/ingresoUsuario.jsp";
        String edit="Usuario/modificaUsuario.jsp";
        String delete="";
        ModelUsuario usuario = new ModelUsuario();
        DaoUsuario daoUsuario = new DaoUsuario();
        
        switch (action){
            case "read":
                acceso = listar;
            break;            
            case "nuevo":
                acceso=add;
            break;
            case "create" :                
                String nombre = request.getParameter("nombre");
                String user = request.getParameter("usuario");
                String clave = request.getParameter("clave");
                int estado = Integer.parseInt(request.getParameter("estado"));                

                usuario.setNombre(nombre);
                usuario.setUsuario(user);
                usuario.setClave(clave);
                usuario.setEstado(estado);                

                daoUsuario.insertar(usuario);
                acceso = listar;
            break;
            case "editar":
                //obtenemos el id de la fila que estamos seleccionando y se la pasamos al formulario de editar
                request.setAttribute("idUsuario", request.getParameter("id"));
                //Redireccionamos a la pagina de edición
                acceso = edit;
            break;            
            case "update" :
                int idUsuario = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                user = request.getParameter("usuario");
                clave = request.getParameter("clave");
                estado = Integer.parseInt(request.getParameter("estado"));
                
                usuario.setIdUsuario(idUsuario);
                usuario.setNombre(nombre);
                usuario.setUsuario(user);
                usuario.setClave(clave);
                usuario.setEstado(estado);               
                
                daoUsuario.modificar(usuario);
                acceso = listar;                
            break;
            case "delete" :
                idUsuario = Integer.parseInt(request.getParameter("id"));
                usuario.setIdUsuario(idUsuario);
                daoUsuario.eliinar(usuario);
                acceso = listar;
                                
            break;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso); //invoca de modo directo un recurso web
        vista.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
