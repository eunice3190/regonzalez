
<%@page import="org.models.ModelCliente"%>
<%@page import="org.dao.DaoCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <form id="form-work" class="" name="form-work" action="ControllerCliente" method="get">
                    <h1>Modifica Cliente</h1>
                  <div class="form-group" >  
                      <%
                          DaoCliente daoCliente = new DaoCliente();
                          //Variable que nos envian desde el controller por medio de la instrucción setAttribute
                          int idCliente = Integer.parseInt((String) request.getAttribute("idCliente"));
                          ModelCliente cliente = new ModelCliente();
                          cliente = daoCliente.list(idCliente);
                      %>
                      
                      <input type="hidden" name="codigo" value="<%= cliente.getIdCliente()%>">
                      <div class="col-md-4">
                          <label class="control-label" for="nombre">Nombre</label>
                          <input name="nombre" class="form-control" placeholder="Nombres" type="text" value ="<%= cliente.getNombre()%>">
                      </div>
                      <br><br><br>
                      <div class="col-md-4">
                          <label class="control-label" for="apellido">Apellido</label>
                          <input name="apellido" class="form-control" placeholder="Apellidos" type="text" value="<%= cliente.getApellido()%>">
                      </div>
                      <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="nit">Nit</label>
                          <input name="nit" class="form-control" placeholder="Nit" type="text" value="<%= cliente.getNit()%>">
                      </div>
                       <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="telefono">Telefono</label>
                          <input name="telefono" class="form-control" placeholder="Telefono" type="text" value="<%= cliente.getTelefono()%>">
                      </div>
                        <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="direccion">Dirección</label>
                          <input name="direccion" class="form-control" placeholder="Dirección" type="text" value="<%= cliente.getDireccion()%>">
                      </div>
                        <br><br><br><br>
                      <div class="col-md-3">
                          <button type="submit" name="accion" value="update" class="btn btn-success btn-lg btn-block info">Actualizar</button>
                      </div>
                      <div class="col-md-3">
                          <a class="btn btn-success btn-lg btn-block info" href="ControllerCliente?accion=read"  > Regresar</a>
                      </div>
                  </div>

                
            </form>
        </div>
    </body>
</html>
