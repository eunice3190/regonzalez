/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.config.Conexion;
import org.interfaces.CrudUsuario;
import org.models.ModelUsuario;

public class DaoUsuario implements CrudUsuario{    
    ModelUsuario usuario = new ModelUsuario();
    //Variable para crear las sentencias SQL
    String strSql =  "";
    //Se crea un obejto de tipo conexión para manejar la persistencia hacia la base de datos
    Conexion conexion = new Conexion();    
    ResultSet rs = null;    
    boolean respuesta = false;    
    @Override
    public List listar() {
        ArrayList<ModelUsuario> lstUsuario = new ArrayList<>();
         try {            
            strSql = "SELECT * FROM POS.SEG_USUARIO";
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {
                ModelUsuario usu = new ModelUsuario();
                usu.setIdUsuario(rs.getInt("ID_USUARIO"));
                usu.setNombre(rs.getString("NOMBRE"));
                usu.setUsuario(rs.getString("USUARIO"));
                usu.setClave(rs.getString("CLAVE"));
                usu.setEstado(rs.getInt("ESTADO"));
                lstUsuario.add(usu);
            }
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return lstUsuario;
    }

    @Override
    public ModelUsuario list(int id) {
        try {            
            strSql = "SELECT * FROM POS.SEG_USUARIO WHERE ID_USUARIO = " + id;
            conexion.open();
            rs = conexion.executeQuery(strSql);                             
            
            while (rs.next()) {                
                usuario.setIdUsuario(rs.getInt("ID_USUARIO"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setClave(rs.getString("CLAVE"));
                usuario.setEstado(rs.getInt("ESTADO"));                           
            } 
            rs.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
         return usuario;
    }

    @Override
    public boolean insertar(ModelUsuario usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "INSERT INTO POS.SEG_USUARIO (NOMBRE, USUARIO, CLAVE, ESTADO) "
                + "VALUES ( " +  
                 "'" + usuario.getNombre() + "', " +                 
                 "'" + usuario.getUsuario()+ "', " +       
                 "'" + usuario.getClave()+ "', " +
                 "" + usuario.getEstado()+ "" +                             
                 ")";
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean modificar(ModelUsuario usuario) {
        //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "UPDATE POS.SEG_USUARIO " +
                 "SET " +
                 "NOMBRE = '" + usuario.getNombre() + "', " +
                 "USUARIO = '" + usuario.getUsuario()+ "', " + 
                 "CLAVE = '" + usuario.getClave()+ "', " + 
                 "ESTADO = " + usuario.getEstado()+ " " +                 
                 "WHERE ID_USUARIO =  " + usuario.getIdUsuario();
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
    }

    @Override
    public boolean eliinar(ModelUsuario usuario) {
        
         //Se prepara la sentencia SQL a ejecutar en la BD
        strSql = "DELETE POS.SEG_USUARIO WHERE ID_USUARIO = " + usuario.getIdUsuario();
        
        try {
            //se abre una conexión hacia la BD
            conexion.open();
            //Se ejecuta la instrucción y retorna si la ejecución fue satisfactoria
            respuesta = conexion.executeSql(strSql);
            //Se cierra la conexión hacia la BD
            conexion.close();
            
            
             
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);     
            return false;
        } catch(Exception ex){
            Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return respuesta;
       
    }
    
}
