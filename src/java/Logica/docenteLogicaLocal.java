/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Docente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author usuario
 */
@Local
public interface docenteLogicaLocal {
    public List<Docente> consultasDocente();
    public void registrarDocente (Docente c) throws Exception;
    public void modificarDocente(Docente c) throws Exception;
    public void eliminarDocente(Docente c) throws Exception;
}
