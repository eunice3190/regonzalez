/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.interfaces;

import java.util.List;
import org.models.ModelUsuario;


public interface CrudUsuario {
    public List listar();
    public ModelUsuario list (int id);
    public boolean insertar(ModelUsuario usuario);
    public boolean modificar(ModelUsuario usuario);
    public boolean eliinar(ModelUsuario usuario);
}

