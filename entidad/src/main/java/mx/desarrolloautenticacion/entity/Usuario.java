package mx.desarrolloautenticacion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Se cambio el tipo de ingreso por correo y contraseña en vez de usuario y password para coincidir con el LoginBean
//Se agrego un ID para el usuario
public class Usuario {
    private Integer id;
    private String correo;
    private String contrasena;

    public Usuario() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
