package mx.desarrolloautenticacion.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "profesorimparte")
public class Profesor_Imparte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idImparte", nullable = false)
    private Integer id;

    @Column(name = "idUnidad", nullable = false)
    private Integer idUnidad;


    @Column(name = "idProfesor", nullable = false)
    private Integer idProfesor;

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

}
