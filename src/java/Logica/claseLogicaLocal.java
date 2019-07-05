/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Clase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ALEJANDRA
 */
@Local
public interface claseLogicaLocal {
    public void registrarClase (Clase c) throws Exception;
    public void modificarClase(Clase c) throws Exception;
    public void eliminarClase(Clase c) throws Exception;
    public List<Clase> consultasClase();
    
}
