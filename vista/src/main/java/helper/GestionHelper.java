package helper;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.annotation.PostConstruct;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.facade.FacadeProfesor;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.delegate.DelegateUnidad;
import mx.desarrolloautenticacion.entity.Profesor_Imparte;
import mx.desarrolloautenticacion.facade.FacadeAsignacion;
import java.io.Serializable;
import java.util.List;
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

    private Integer idProfesorSeleccionado;
    private Integer idUnidadSeleccionada;

    private List<Profesor_Imparte> asignaciones;

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

            this.asignaciones = new FacadeAsignacion().obtenerTodas();
            if(this.asignaciones == null) {
                this.asignaciones = new ArrayList<>();
            }

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
        System.out.println("Intentando asignar materia...");
        try {
            if (this.idProfesorSeleccionado != null && this.idUnidadSeleccionada != null) {

                Profesor_Imparte pi = new Profesor_Imparte();
                pi.setIdProfesor(this.idProfesorSeleccionado);
                pi.setIdUnidad(this.idUnidadSeleccionada);

                FacadeAsignacion fa = new FacadeAsignacion();
                fa.guardarAsignacion(pi);


                this.asignaciones = fa.obtenerTodas();

                System.out.println("Asignación completada y lista actualizada.");

                this.idProfesorSeleccionado = null;
                this.idUnidadSeleccionada = null;
            } else {
                System.out.println("Error: No se recibió ID de Profesor o Unidad");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void limpiarCamposUnidad() {
        this.unidadNombre = "";
        this.hrsClase = 0;
        this.hrsTaller = 0;
        this.hrsLab = 0;
    }

    public String obtenerNombreProfesor(Integer id) {
        if (id == null || listaProfesores == null) return "";
        return listaProfesores.stream()
                .filter(p -> p.getId().equals(id))
                .map(p -> p.getNombreProfesor() + " " + p.getApellidopaternoProfesor())
                .findFirst()
                .orElse("ID: " + id);
    }

    public String obtenerNombreUnidad(Integer id) {
        if (id == null || listaUnidades == null) return "";
        return listaUnidades.stream()
                .filter(u -> u.getIdUnidades().equals(id))
                .map(u -> u.getNombreUnidad())
                .findFirst()
                .orElse("ID: " + id);
    }

    public List<Unidad_Aprendizaje> getListaUnidades() { return listaUnidades; }
    public void setListaUnidades(List<Unidad_Aprendizaje> listaUnidades) { this.listaUnidades = listaUnidades; }
    public Unidad_Aprendizaje getUnidadSeleccionada() { return unidadSeleccionada; }
    public void setUnidadSeleccionada(Unidad_Aprendizaje unidadSeleccionada) { this.unidadSeleccionada = unidadSeleccionada; }

    // Corregido el Getter de asignaciones
    public List<Profesor_Imparte> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(List<Profesor_Imparte> asignaciones) { this.asignaciones = asignaciones; }

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
    public Profesor getProfesorSeleccionado() { return profesorSeleccionado; }
    public void setProfesorSeleccionado(Profesor profesorSeleccionado) { this.profesorSeleccionado = profesorSeleccionado; }
    public Integer getIdProfesorSeleccionado() { return idProfesorSeleccionado; }
    public void setIdProfesorSeleccionado(Integer idProfesorSeleccionado) { this.idProfesorSeleccionado = idProfesorSeleccionado; }
    public Integer getIdUnidadSeleccionada() { return idUnidadSeleccionada; }
    public void setIdUnidadSeleccionada(Integer idUnidadSeleccionada) { this.idUnidadSeleccionada = idUnidadSeleccionada; }
}