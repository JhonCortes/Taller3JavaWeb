/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Modelo.Clase;
import Persistencia.ClaseFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author ALEJANDRA
 */
@Stateless
public class claseLogica implements claseLogicaLocal {
    
    @EJB
    public ClaseFacadeLocal claseDAO;
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void registrarClase(Clase c) throws Exception {
        Clase objClase = claseDAO.findNum(c.getNumero());
        if (objClase != null){
          throw new Exception ("La Clase ya existe!");
        }
        claseDAO.create((Clase) c);
    }

    @Override
    public void modificarClase(Clase c) throws Exception {
       Clase objClase = claseDAO.findNum(c.getNumero());
        if(objClase == null){
            throw new Exception("La clase se ha modificado");
        }
        claseDAO.edit(c);
        
    }

    @Override
    public void eliminarClase(Clase c) throws Exception {
        Clase objBorrar = claseDAO.find(c.getNumero());
       if(objBorrar==null){
         throw new Exception("La Clase no existe");  
       }
 
       claseDAO.remove(objBorrar);
    }

    @Override
    public List<Clase> consultasClase() {
       return claseDAO.findAll(); //To change body of generated methods, choose Tools | Templates.
    }
}
