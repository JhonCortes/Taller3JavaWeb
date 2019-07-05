/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import Modelo.Usuario;
import Persistencia.UsuarioFacadeLocal;

/**
 *
 * @author usuario
 */
@Stateless
public class usuarioLogica implements usuarioLogicaLocal {

    @EJB
    private UsuarioFacadeLocal usuarioDAO;

    @Override
    public Usuario ingresar(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("Usuario vacio");
        }
        if (usuario.getDocumento().equals("")) {
            throw new Exception("Nombre de usuario obligatorio");
        }
        if (usuario.getClave().equals("")) {
            throw new Exception("Clave es obligatorio");
        }
        Usuario objUsuario = usuarioDAO.find(usuario.getDocumento());
        if (objUsuario == null) {
            throw new Exception("Usuario no registrado!");
        }
        if (!usuario.getClave().equals(objUsuario.getClave())) {
            throw new Exception("La clave no es valida!");
        }
        return objUsuario;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
