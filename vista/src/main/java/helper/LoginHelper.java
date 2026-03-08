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
    //El metodo Login ahora devuelve un Usuario en vez de Boolean
    public Usuario Login(String correo, String contrasena) {

        Usuario usuario = new Usuario();
        //Agregue unos datos de prueba para que funcione la comparacion
        usuario.setId(1);
        usuario.setCorreo("admin@uabc.mx");
        usuario.setContrasena("1234");
        if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
            return usuario;
        }
        return null;
    }
}
