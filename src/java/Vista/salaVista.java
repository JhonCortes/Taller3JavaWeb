/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.claseLogica;
import Logica.claseLogicaLocal;
import Modelo.Clase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.inputtext.InputText;
/**
 *
 * @author ALEJANDRA
 */
@Named(value = "salaVista")
@Dependent
public class salaVista {
    @EJB
    private claseLogicaLocal claseLogica;
    
    private List<Clase> listaClase;
    private InputText Numero;
    private InputText Fecha;
    private InputText Asignatura;
    private InputText Tema;
    private InputText HoraIncio;
    private InputText HoraFin;
    private InputText Profesor;
   
    public List<Clase> getListaClase() {
         listaClase = claseLogica.consultasClase();
        return listaClase;
    }

    public void setListaClase(List<Clase> listaClase) {
        this.listaClase = listaClase;
    }
    public InputText getNumero() {
        return Numero;
    }

    public void setNumero(InputText Numero) {
        this.Numero = Numero;
    }

    public InputText getFecha() {
        return Fecha;
    }

    public void setFecha(InputText Fecha) {
        this.Fecha = Fecha;
    }

    public InputText getAsignatura() {
        return Asignatura;
    }

    public void setAsignatura(InputText Asignatura) {
        this.Asignatura = Asignatura;
    }

    public InputText getTema() {
        return Tema;
    }

    public void setTema(InputText Tema) {
        this.Tema = Tema;
    }

    public InputText getHoraIncio() {
        return HoraIncio;
    }

    public void setHoraIncio(InputText HoraIncio) {
        this.HoraIncio = HoraIncio;
    }

    public InputText getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(InputText HoraFin) {
        this.HoraFin = HoraFin;
    }

    public InputText getProfesor() {
        return Profesor;
    }

    public void setProfesor(InputText Profesor) {
        this.Profesor = Profesor;
    }
    
    public salaVista() {
    }
    public void registrarClase() {
      try {
        Clase nuevaClase = new Clase();
       
        claseLogica.registrarClase(nuevaClase);
        
        FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_INFO,"Mensaje",
                 "La Clase se registro Satisfactoriamente"));
    } catch (Exception ex){
      FacesContext.getCurrentInstance().addMessage(null,
         new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error al Registrar",
                 ex.getMessage()));
      Logger.getLogger(salaVista.class.getName()).log(Level.SEVERE,null,ex);
    }        
       
    }
}
