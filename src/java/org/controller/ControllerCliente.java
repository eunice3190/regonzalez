/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.util.HashSet;
//import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dao.DaoCliente;
import org.models.ModelCliente;


public class ControllerCliente extends HttpServlet {
    String listar="Cliente/clienteConsulta.jsp";
    String add="Cliente/clienteIngreso.jsp";
    String edit="Cliente/clienteModifica.jsp";
    String delete="";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerCliente at " + request.getContextPath() + "</h1>");
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
        
        ModelCliente cliente = new ModelCliente();
        DaoCliente daoCliente = new DaoCliente();
        
        switch (action){
            case "read":
                acceso = listar;
            break;
            
            case "nuevo":
                acceso = add;
            break;
                
            case "create" :    
                /*cliente.setNombre(request.getParameter("nombre"));
                cliente.setNombre(request.getParameter("apellido"));
                cliente.setNombre(request.getParameter("nit"));
                cliente.setNombre(request.getParameter("telefono"));
                cliente.setNombre(request.getParameter("direccion"));*/

                
                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                String nit = request.getParameter("nit");
                String telefono = request.getParameter("telefono");
                String direccion= request.getParameter("direccion");

                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setNit(nit);
                cliente.setTelefono(telefono);
                cliente.setDireccion(direccion); 

                daoCliente.insertar(cliente);
                acceso = listar;
            break;
            
            case "editar":
                //obtenemos el id de la fila que estamos seleccionando y se la pasamos al formulario de editar
                request.setAttribute("idCliente", request.getParameter("id"));
                //Redireccionamos a la pagina de edición
                acceso = edit;
            break; 
            
            case "update" :
                int idCliente = Integer.parseInt(request.getParameter("codigo"));
                nombre = request.getParameter("nombre");
                apellido = request.getParameter("apellido");
                nit = request.getParameter("nit");
                telefono = request.getParameter("telefono");
                direccion= request.getParameter("direccion");
                cliente.setIdCliente(idCliente);
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setNit(nit);
                cliente.setTelefono(telefono);
                cliente.setDireccion(direccion);
                
                daoCliente.modificar(cliente);
                acceso = listar;                
            break;
           case "delete" :
                idCliente = Integer.parseInt(request.getParameter("id"));
                cliente.setIdCliente(idCliente);
                daoCliente.eliinar(cliente);
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
