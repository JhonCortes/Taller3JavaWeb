/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Docente;
import Persistencia.DocenteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author usuario
 */
@Stateless
public class docenteLogica implements docenteLogicaLocal {

    @EJB
    public DocenteFacadeLocal docenteDAO;

    @Override
    public void registrarDocente(Docente c) throws Exception {
        if (c == null) {
            throw new Exception("Todos los datos son necesarios");
        }
        if (c.getDocumento().equals("") || c.getDocumento() == null) {
            throw new Exception("El Documento es necesario");
        }
        if (c.getNombre().equals("")) {
            throw new Exception("El Nombre es necesario");
        }
        if (c.getApellido().equals("")) {
            throw new Exception("El Apellido es necesario");
        }
        if (c.getCorreoElectronico().equals("")) {
            throw new Exception("El Correo electronico es necesario");
        }
        if (c.getTelefono().equals("") || c.getTelefono() == null) {
            throw new Exception("El Telefono es necesario");
        }
        docenteDAO.create(c);
    }

    @Override
    public void modificarDocente(Docente c) throws Exception {
        if (c == null) {
            throw new Exception("El Docente no tiene información");
        }
        if (c.getDocumento() == null || c.getDocumento().equals(c)) {
            throw new Exception("El Documento es obligatorio");
        }
        if (c.getNombre().equals("")) {
            throw new Exception("El nombre es obligatorio");
        }
        if (c.getApellido().equals("")) {
            throw new Exception("El Apellido es necesario");
        }
        if (c.getCorreoElectronico().equals("")) {
            throw new Exception("El Correo electronico es necesario");
        }
        if (c.getTelefono().equals("") || c.getTelefono() == null) {
            throw new Exception("El Telefono es necesario");
        }
        docenteDAO.edit(c);
    }

    @Override
    public void eliminarDocente(Docente c) throws Exception {
        if (c==null) {
            throw new Exception("El Docente no tiene información");
        }
        
        Docente objBorrar = docenteDAO.find(c.getDocumento());
        
        if(objBorrar == null){
            throw new Exception("El Docente no existe");
        }
        docenteDAO.remove(c);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Docente> consultasDocente() {
       return docenteDAO.findAll();
    }

}
