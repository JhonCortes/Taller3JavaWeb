/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Docente;
import javax.ejb.Stateless;

/**
 *
 * @author usuario
 */
@Stateless
public class docenteLogica implements docenteLogicaLocal {

    @Override
    public void registrarDocente(Docente c) throws Exception {
         if (c==null) {
            throw new Exception("Todos los datos son necesarios");
        }
         if (c.getDocumento().equals("") ||  c.getDocumento() == null){
             throw new Exception("El Documento es necesario");
         }
         
    }

    @Override
    public void modificarDocente(Docente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarDocente(Docente c) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
