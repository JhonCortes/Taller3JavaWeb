/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Docente;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.component.inputtext.InputText;

/**
 *
 * @author usuario
 */
@Named(value = "secretariaVista")
@Dependent
public class secretariaVista {
    
    private InputText txtDocumento;
    private InputText txtNombre;
    private InputText txtApellido;
    private InputText txtCorreo;
    private InputText txtTelefono;

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

    /**
     * Creates a new instance of secretariaVista
     */
    public secretariaVista() {
    }
    
     
    
}
