package mx.desarrolloautenticacion.facade;

import mx.desarrolloautenticacion.delegate.DelegateUsuario;
import mx.desarrolloautenticacion.entity.Usuario;

public class FacadeUsuario {

    private final DelegateUsuario delegateUsuario;

    public FacadeUsuario() {
        this.delegateUsuario = new DelegateUsuario();
    }

    public Usuario login(String password, String correo){
        return delegateUsuario.login(password, correo);
    }

    public void saveUsario(Usuario usuario){
        delegateUsuario.saveUsario(usuario);
    }

}