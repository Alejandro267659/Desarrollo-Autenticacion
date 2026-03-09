package mx.desarrolloautenticacion.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "unidadesdeAprendizaje")
public class Unidad_Aprendizaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUnidades", nullable = false)
    private Integer idUnidades;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombreUnidad", nullable = false, length = 50)
    private String nombreUnidad;

    @NotNull
    @Column(name = "horasClase", nullable = false)
    private Integer horasClase;

    @NotNull
    @Column(name = "horasTaller", nullable = false)
    private Integer horasTaller;

    @NotNull
    @Column(name = "horasLaboratorio", nullable = false)
    private Integer horasLaboratorio;

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }

    public Integer getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(Integer horasTaller) {
        this.horasTaller = horasTaller;
    }

    public Integer getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(Integer horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    public String toString(){
        return nombreUnidad + " - " + idUnidades;
    }

}
