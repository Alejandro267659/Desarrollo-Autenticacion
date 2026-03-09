package helper;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.annotation.PostConstruct; // Importante
import mx.desarrolloautenticacion.dao.ProfesorDAO;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.facade.FacadeProfesor;
import java.io.Serializable;
import java.util.List; // Importante
import java.util.ArrayList;

@Named("gestionBean")
@RequestScoped
public class GestionHelper implements Serializable {

    // --- Variables Profesor ---
    private String nombre, apellidoP, apellidoM, rfc;
    private List<Profesor> listaProfesores;
    private Profesor profesorSeleccionado;

    // --- Variables Unidad de Aprendizaje ---
    private String unidadNombre, claveMateria;
    private int hrsClase, hrsTaller, hrsLab;
    private List<Object> listaUnidades;
    private Object unidadSeleccionada;

    // --- Variables de Asignación (LO QUE TE FALTA AHORA) ---
    private List<Object> asignaciones; // Para el p:dataTable

    public GestionHelper() {
    }

    @PostConstruct
    public void init() {
        try {
            FacadeProfesor fp = new FacadeProfesor();
            this.listaProfesores = fp.listarProfesores();

            // Inicializamos como listas vacías para que el DataTable no truene
            this.listaUnidades = new ArrayList<>();
            this.asignaciones = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("ERROR ERROR ERROR");
            e.printStackTrace();
            this.listaProfesores = new ArrayList<>();
            this.listaUnidades = new ArrayList<>();
            this.asignaciones = new ArrayList<>();

        }
    }

    public String registrarProfesor() {
        try {
            Profesor p = new Profesor();
            p.setNombreProfesor(this.nombre);
            p.setApellidopaternoProfesor(this.apellidoP);
            p.setApellidoMaternoProfesor(this.apellidoM);
            p.setRfcProfesor(this.rfc);
            new FacadeProfesor().guardarProfesor(p);
            return "Menu?faces-redirect=true";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void registrarAsignacion() {
        System.out.println("Intentando asignar materia a profesor...");
    }



    public List<Object> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(List<Object> asignaciones) { this.asignaciones = asignaciones; }

    public List<Profesor> getListaProfesores() { return listaProfesores; }
    public void setListaProfesores(List<Profesor> listaProfesores) { this.listaProfesores = listaProfesores; }

    public List<Object> getListaUnidades() { return listaUnidades; }
    public void setListaUnidades(List<Object> listaUnidades) { this.listaUnidades = listaUnidades; }

    public Profesor getProfesorSeleccionado() { return profesorSeleccionado; }
    public void setProfesorSeleccionado(Profesor profesorSeleccionado) { this.profesorSeleccionado = profesorSeleccionado; }

    public Object getUnidadSeleccionada() { return unidadSeleccionada; }
    public void setUnidadSeleccionada(Object unidadSeleccionada) { this.unidadSeleccionada = unidadSeleccionada; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidoP() { return apellidoP; }
    public void setApellidoP(String apellidoP) { this.apellidoP = apellidoP; }
    public String getApellidoM() { return apellidoM; }
    public void setApellidoM(String apellidoM) { this.apellidoM = apellidoM; }
    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }
    public String getUnidadNombre() { return unidadNombre; }
    public void setUnidadNombre(String unidadNombre) { this.unidadNombre = unidadNombre; }
    public String getClaveMateria() { return claveMateria; }
    public void setClaveMateria(String claveMateria) { this.claveMateria = claveMateria; }
    public int getHrsClase() { return hrsClase; }
    public void setHrsClase(int hrsClase) { this.hrsClase = hrsClase; }
    public int getHrsTaller() { return hrsTaller; }
    public void setHrsTaller(int hrsTaller) { this.hrsTaller = hrsTaller; }
    public int getHrsLab() { return hrsLab; }
    public void setHrsLab(int hrsLab) { this.hrsLab = hrsLab; }
}