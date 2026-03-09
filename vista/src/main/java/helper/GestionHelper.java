package helper;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.dao.ProfesorDAO;
import mx.desarrolloautenticacion.delegate.DelegateProfesor;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.facade.FacadeProfesor;

import java.io.Serializable;

@Named("gestionBean")
@RequestScoped
public class GestionHelper implements Serializable {

    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rfc;

    public GestionHelper() {
        // Constructor vacío, sin crear otra instancia de sí mismo
    }

    public boolean registrarProfesor() {
        Profesor p = new Profesor();
        p.setNombreProfesor(this.nombre);
        p.setApellidopaternoProfesor(this.apellidoP);
        p.setApellidoMaternoProfesor(this.apellidoM);
        p.setRfcProfesor(this.rfc);

        // Aquí deberías llamar a tu capa de negocio/persistencia para guardar el profesor
        // Ejemplo: profesorService.guardar(p);
        FacadeProfesor fp = new FacadeProfesor();
        fp.guardarProfesor(p);

        System.out.println("¡Profesor guardado con éxito!");

        // Limpiar campos después de guardar
        this.nombre = "";
        this.apellidoP = "";
        this.apellidoM = "";
        this.rfc = "";

        return true;
    }

    // --- Getters y Setters ---
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidoP() { return apellidoP; }
    public void setApellidoP(String apellidoP) { this.apellidoP = apellidoP; }

    public String getApellidoM() { return apellidoM; }
    public void setApellidoM(String apellidoM) { this.apellidoM = apellidoM; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
}