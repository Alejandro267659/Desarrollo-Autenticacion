package helper;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.annotation.PostConstruct;
import mx.desarrolloautenticacion.dao.ProfesorDAO;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.facade.FacadeProfesor;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.delegate.DelegateUnidad;
import java.io.Serializable;
import java.util.List; // Importante
import java.util.ArrayList;

@Named("gestionBean")
@RequestScoped
public class GestionHelper implements Serializable {


    private String nombre, apellidoP, apellidoM, rfc;
    private List<Profesor> listaProfesores;
    private Profesor profesorSeleccionado;
    private List<Unidad_Aprendizaje> listaUnidades;


    private String unidadNombre, claveMateria;
    private int hrsClase, hrsTaller, hrsLab;
    private Unidad_Aprendizaje unidadSeleccionada;


    private List<Object> asignaciones;

    public GestionHelper() {
    }

    @PostConstruct
    public void init() {
        try {
            FacadeProfesor fp = new FacadeProfesor();
            this.listaProfesores = fp.listarProfesores();


            this.listaUnidades = new DelegateUnidad().listarUnidades();

            if(this.listaUnidades == null) {
                this.listaUnidades = new ArrayList<>();
            }

            this.asignaciones = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("ERROR EN INIT");
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


    public void registrarMateria() {
        try {
            Unidad_Aprendizaje u = new Unidad_Aprendizaje();
            u.setNombreUnidad(this.unidadNombre);

            u.setHorasClase(this.hrsClase);
            u.setHorasTaller(this.hrsTaller);
            u.setHorasLaboratorio(this.hrsLab);

            DelegateUnidad du = new DelegateUnidad();
            du.saveUnidad(u);

            this.listaUnidades = du.listarUnidades();

            limpiarCamposUnidad();
            System.out.println("Unidad guardada y lista actualizada con: " + listaUnidades.size() + " elementos.");
        } catch (Exception e) {
            System.out.println("Error fatal al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void limpiarCamposUnidad() {
        this.unidadNombre = "";
        this.hrsClase = 0;
        this.hrsTaller = 0;
        this.hrsLab = 0;
    }


    public List<Unidad_Aprendizaje> getListaUnidades() { return listaUnidades; }
    public void setListaUnidades(List<Unidad_Aprendizaje> listaUnidades) { this.listaUnidades = listaUnidades; }

    public Unidad_Aprendizaje getUnidadSeleccionada() { return unidadSeleccionada; }
    public void setUnidadSeleccionada(Unidad_Aprendizaje unidadSeleccionada) { this.unidadSeleccionada = unidadSeleccionada; }

    public List<Object> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(List<Object> asignaciones) { this.asignaciones = asignaciones; }
    public List<Profesor> getListaProfesores() { return listaProfesores; }
    public void setListaProfesores(List<Profesor> listaProfesores) { this.listaProfesores = listaProfesores; }
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
    public Profesor getProfesorSeleccionado() {
        return profesorSeleccionado;
    }
    public void setProfesorSeleccionado(Profesor profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }
}