/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import Logica.usuarioLogicaLocal;
import Modelo.Usuario;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;

/**
 *
 * @author usuario
 */
@Named(value = "usuarioVista")
@RequestScoped
public class usuarioVista {

    @EJB
    private usuarioLogicaLocal usuarioLogica;

    private InputText txtUsuario;
    private Password txtClave;
    private CommandButton btnIngresar;

    public usuarioVista() {
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtClave() {
        return txtClave;
    }

    public void setTxtClave(Password txtClave) {
        this.txtClave = txtClave;
    }

    public CommandButton getBtnIngresar() {
        return btnIngresar;
    }

    public void setBtnIngresar(CommandButton btnIngresar) {
        this.btnIngresar = btnIngresar;
    }

    public void ingresar() {
        try {
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setDocumento(Integer.parseInt(txtUsuario.getValue().toString()));
            nuevoUsuario.setClave(txtClave.getValue().toString());
            Usuario usuarioLogueado = usuarioLogica.ingresar(nuevoUsuario);
            
            //Guarda al usuario que se carga en la sesion.
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("usuario", usuarioLogueado);
            
            //Redirecciono a la pagina deseada
            if (usuarioLogueado.getDependencia().equals("secretaria")){
                FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("admin/secretaria.xhtml");
            }else{
                FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("admin/sala.xhtml");
            }
            
            
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje", 
                            ex.getMessage()));
            Logger.getLogger(usuarioVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void cerrarSesion(){
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().remove("usuario");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(usuarioVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
