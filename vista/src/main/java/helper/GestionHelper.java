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

    public String registrarProfesor() {
        // RADAR 1: Si esto no se imprime en consola, ¡el problema es tu formulario HTML!
        System.out.println("1. JSF sí me dejó entrar al método. Datos recibidos:");
        System.out.println("Nombre: " + this.nombre + ", RFC: " + this.rfc);

        try {
            Profesor p = new Profesor();
            p.setNombreProfesor(this.nombre);
            p.setApellidopaternoProfesor(this.apellidoP);
            p.setApellidoMaternoProfesor(this.apellidoM);
            p.setRfcProfesor(this.rfc);

            FacadeProfesor fp = new FacadeProfesor();
            fp.guardarProfesor(p);

            // RADAR 2: Si llega aquí, Workbench SÍ lo aceptó
            System.out.println("2. ¡Guardado exitoso en la Base de Datos!");

            // Limpiamos
            this.nombre = ""; this.apellidoP = ""; this.apellidoM = ""; this.rfc = "";

            return "Menu?faces-redirect=true";

        } catch (Exception e) {
            // RADAR 3: Si Workbench lo patea, nos dirá exactamente por qué
            System.out.println("========== ERROR MASIVO AL GUARDAR EN WORKBENCH ==========");
            e.printStackTrace(); // Esto va a imprimir la verdadera razón en rojo
            System.out.println("==========================================================");
            return null;
        }
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