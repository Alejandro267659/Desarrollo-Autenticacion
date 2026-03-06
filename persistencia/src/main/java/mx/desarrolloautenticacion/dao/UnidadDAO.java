package mx.desarrolloautenticacion.dao;

import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.entity.Alumno;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.persistence.AbstractDAO;

import java.util.List;

public class UnidadDAO extends AbstractDAO<Unidad_Aprendizaje> {
    private final EntityManager entityManager;

    public UnidadDAO(EntityManager em) {
        super(Unidad_Aprendizaje.class);
        this.entityManager = em;
    }
    public List<Alumno> obtenerTodos(){
        return entityManager
                .createQuery("SELECT a FROM Alumno a", Alumno.class)
                .getResultList();
    }
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}

