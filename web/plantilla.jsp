<%-- 
    Document   : Platilla.jsp
    Created on : 20/03/2019, 04:49:01 PM
    Author     : josef
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Aplicación Web</title>
        <link href="../Styles/Site.css" rel="stylesheet" type="text/css"/>
        <link href="../Content/bootstrap.css" rel="stylesheet" type="text/css"/>
       <script src="../Scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
       <script src="../Scripts/bootstrap.min.js" type="text/javascript"></script>
   </head>
    <body>
        <form id="Form1" method="post" >

            <div  class="container">
                        <div id="logo" >
                            <img id="Img1" src="../Images/logo.png" alt="Freshdesign" />
                        </div>
             </div>
            <nav class="navbar navbar-default" role="navigation"  >
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>                    
                </div>
                
                <div class="navbar-header">
                       <a class="navbar-brand" href="../index.jsp">Inicio</a>
                 </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">                        
                        <li id="Li2" class="dropdown" >
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"  id="A1">Mantenimientos<b class="caret"></b></a>
                            <ul id="Ul2" class="dropdown-menu" >
                                <li> 
                                    <a href="ControllerCliente?accion=read" id="A2">Consulta Cliente</a>
                                </li>                      
                            </ul>
                         </li>                         
                         <li > <a href="#" id="A4" > Opción X</a></li>              
                    </ul>                   
                </div>
            </div>
        </nav>
            <div class="container body-content">
                <div style=" float:right;">                    
                </div>         
            </div>  
       </form>   

    </body>
</html>
