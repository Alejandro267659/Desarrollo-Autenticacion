package mx.desarrolloautenticacion.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesores", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "nombreProfesor", nullable = false, length = 50)
    private String nombreProfesor;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidopaternoProfesor", nullable = false, length = 50)
    private String apellidopaternoProfesor;

    @Size(max = 50)
    @NotNull
    @Column(name = "apellidoMaternoProfesor", nullable = false, length = 50)
    private String apellidoMaternoProfesor;

    @Size(max = 13)
    @NotNull
    @Column(name = "rfcProfesor", nullable = false, length = 13)
    private String rfcProfesor;


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombreProfesor() { return nombreProfesor; }
    public void setNombreProfesor(String nombreProfesor) { this.nombreProfesor = nombreProfesor; }

    public String getApellidopaternoProfesor() { return apellidopaternoProfesor; }
    public void setApellidopaternoProfesor(String apellidopaternoProfesor) { this.apellidopaternoProfesor = apellidopaternoProfesor; }

    public String getApellidoMaternoProfesor() { return apellidoMaternoProfesor; }
    public void setApellidoMaternoProfesor(String apellidoMaternoProfesor) { this.apellidoMaternoProfesor = apellidoMaternoProfesor; }

    public String getRfcProfesor() { return rfcProfesor; }
    public void setRfcProfesor(String rfcProfesor) { this.rfcProfesor = rfcProfesor; }

    public String toString(){
        return nombreProfesor + " " + apellidopaternoProfesor + " - " + rfcProfesor;
    }

}