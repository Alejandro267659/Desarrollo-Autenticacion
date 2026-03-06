package mx.desarrolloautenticacion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class Usuario {
    private String usuario = "root";
    private String password = "password";


    public String getPassword() {
        return password;
    }
    public String getUsuario(){
        return usuario;
    }
}