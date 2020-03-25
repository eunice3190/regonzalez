
<%@page import="java.util.Iterator"%>
<%@page import="org.models.ModelUsuario"%>
<%@page import="java.util.List"%>
<%@page import="org.dao.DaoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../plantillaIndex.jsp"/>
        <title>Consulta Usuario</title>
    </head>
    <body>
        <div class="container">            
            <h1>Usuarios</h1>
            <a class="btn btn-success" href="ControllerUsuario?accion=nuevo"  > Agregar Nuevo</a>
                <table border="1" width="1" cellspacing="1" class="table table-bordered" >
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Nombre</th>
                            <th class="text-center">Usuario</th>
                            <th class="text-center">Clave</th>
                            <th class="text-center">Estado</th>                            
                            <th class="text-center">Acciones</th>
                        </tr>
                    </thead>                                        
                    <tbody>
                        <%
                        DaoUsuario daoUsuario = new  DaoUsuario();
                        List<ModelUsuario> lstUsuario = daoUsuario.listar();
                        Iterator<ModelUsuario> iteratorUsuario = lstUsuario.iterator();
                        ModelUsuario usuario = null;
                        while (iteratorUsuario.hasNext()){
                            usuario = iteratorUsuario.next();                        
                        %> 
                        <tr>
                            <td class="text-center"><%= usuario.getIdUsuario()%></td>
                            <td class="text-center"><%= usuario.getNombre()%></td>
                            <td class="text-center"><%= usuario.getUsuario()%></td>
                            <td class="text-center"><%= usuario.getClave()%></td>
                            <td class="text-center"><%= usuario.getEstado()%></td>                            
                            <td class="text-center">                                
                                <a href="ControllerUsuario?accion=editar&id=<%=usuario.getIdUsuario()%>">Editar</a>
                                <a href="ControllerUsuario?accion=delete&id=<%=usuario.getIdUsuario()%>">Eliminar</a>
                            </td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
        </div>
    </body>
</html>
