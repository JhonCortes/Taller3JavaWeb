/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Logica.docenteLogica;
import Logica.docenteLogicaLocal;
import Modelo.Docente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author usuario
 */
@Named(value = "docenteVista")
@RequestScoped
public class docenteVista {

    docenteLogicaLocal docenteL;    
    
    private InputText txtDocumento;
    private InputText txtNombre;
    private InputText txtApellido;
    private InputText txtCorreo;
    private InputText txtTelefono;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnLimpiar;
    private CommandButton btnEliminar;
    private Docente selectedDocente;
    private List<Docente> listaDocente;

    public List<Docente> getListaDocente() {
        try {
         listaDocente = docenteL.consultasDocente();
        return listaDocente; 
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay datos",
                            ex.getMessage()));
            Logger.getLogger(docenteVista.class.getName()).log(Level.SEVERE, null, ex);
            return listaDocente;
        }
        
    }

    public void setListaDocente(List<Docente> listaDocente) {
        this.listaDocente = listaDocente;
    }


    

    public InputText getTxtDocumento() {
        return txtDocumento;
    }

    public void setTxtDocumento(InputText txtDocumento) {
        this.txtDocumento = txtDocumento;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public Docente getSelectedDocente() {
        return selectedDocente;
    }

    public void setSelectedDocente(Docente selectedDocente) {
        this.selectedDocente = selectedDocente;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public CommandButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(CommandButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    /**
     * Creates a new instance of secretariaVista
     */
    public docenteVista() {
    }

    public void registrarDocente() {
        try {
            Docente nuevoDocente = new Docente();
            nuevoDocente.setDocumento(Integer.parseInt(txtDocumento.getValue().toString()));
            nuevoDocente.setNombre(txtNombre.getValue().toString());
            nuevoDocente.setApellido(txtApellido.getValue().toString());
            nuevoDocente.setCorreoElectronico(txtCorreo.getValue().toString());
            nuevoDocente.setTelefono(txtTelefono.getValue().toString());
            docenteL.registrarDocente(nuevoDocente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Docente registrado correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(docenteVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void seleccionarDocente(SelectEvent e) {
        selectedDocente = (Docente) e.getObject();
        txtDocumento.setValue(selectedDocente.getDocumento());
        txtNombre.setValue(selectedDocente.getNombre());
        txtApellido.setValue(selectedDocente.getApellido());
        txtCorreo.setValue(selectedDocente.getCorreoElectronico());
        txtTelefono.setValue(selectedDocente.getTelefono());
    }

    public void modificarDocente() {
        try {
            Docente nuevoDocente = new Docente();
            nuevoDocente.setDocumento(Integer.parseInt(txtDocumento.getValue().toString()));
            nuevoDocente.setNombre(txtNombre.getValue().toString());
            nuevoDocente.setApellido(txtApellido.getValue().toString());
            nuevoDocente.setCorreoElectronico(txtCorreo.getValue().toString());
            nuevoDocente.setTelefono(txtTelefono.getValue().toString());
            docenteL.modificarDocente(nuevoDocente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Docente Modificado correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(docenteVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminarDocente() {
        try {
            docenteL.eliminarDocente(selectedDocente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Docente Eliminado correctamente!"));
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage()));
            Logger.getLogger(docenteVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
