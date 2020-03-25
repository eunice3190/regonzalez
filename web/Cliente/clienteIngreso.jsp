

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Cliente</title>
    </head>
    <body>
        <div class="container">
            <form id="form-work" class="" name="form-work" action="ControllerCliente" method="get">
      
                
                    
                  <div class="form-group" >                      
                      
                      <div class="col-md-4">
                          <label class="control-label" for="nombre">Nombre</label>
                          <input name="nombre" class="form-control" placeholder="Nombres" type="text">
                      </div>
                      <br><br><br>
                      <div class="col-md-4">
                          <label class="control-label" for="apellido">Apellido</label>
                          <input name="apellido" class="form-control" placeholder="Apellidos" type="text">
                      </div>
                      <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="nit">Nit</label>
                          <input name="nit" class="form-control" placeholder="Nit" type="text">
                      </div>
                       <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="telefono">Telefono</label>
                          <input name="telefono" class="form-control" placeholder="Telefono" type="text">
                      </div>
                        <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="direccion">Dirección</label>
                          <input name="direccion" class="form-control" placeholder="Dirección" type="text">
                      </div>
                        <br><br><br><br>
                      <div class="col-md-3">
                          <button type="submit" name="accion" value="create" class="btn btn-success btn-lg btn-block info">Guardar</button>
                      </div>
                        
                  </div>

                
            </form>
        </div>
    </body>
</html>
