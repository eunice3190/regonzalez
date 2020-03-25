
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../plantillaIndex.jsp"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso Usuario</title>
    </head>
    <body>
        <div class="container">
            <form id="form-work" class="" name="form-work" action="ControllerUsuario" method="get">
      
                
                    
                  <div class="form-group" >                      
                      
                      <div class="col-md-4">
                          <label class="control-label" for="nombre">Nombre</label>
                          <input name="nombre" class="form-control" placeholder="Nombres" type="text">
                      </div>
                      <br><br><br>
                      <div class="col-md-4">
                          <label class="control-label" for="usuario">Usuario</label>
                          <input name="usuario" class="form-control" placeholder="Usuario" type="text">
                      </div>
                      <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="clave">Clave</label>
                          <input name="clave" class="form-control" placeholder="Clave" type="text">
                      </div>
                       <br><br><br>
                      <div class="col-md-3">
                          <label class="control-label" for="estado">Estado</label>
                          <input name="estado" class="form-control" placeholder="Estado" type="text">
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

