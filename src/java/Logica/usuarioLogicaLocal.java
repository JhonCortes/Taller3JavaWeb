/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.ejb.Local;
import Modelo.Usuario;

/**
 *
 * @author usuario
 */
@Local
public interface usuarioLogicaLocal {
    public Usuario ingresar(Usuario usuario) throws Exception;
}
