/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import mx.desarrolloautenticacion.integration.ServiceFacadeLocator;
import mx.desarrolloautenticacion.entity.Usuario;

import java.io.Serializable;

public class LoginHelper implements Serializable {
    

    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @paramcorreo
     * @parampassword
     * @return 
     */
    public boolean validarLogin(String password, String nombre){
        Usuario usuario = new Usuario();
        return usuario.getUsuario().equals(nombre) && usuario.getPassword().equals(password);
    }
}
