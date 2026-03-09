package mx.desarrolloautenticacion.dao;

import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.persistence.AbstractDAO;
import java.util.List;

public class ProfesorDAO extends AbstractDAO<Profesor> {
    private final EntityManager entityManager;

    public ProfesorDAO(EntityManager em) {
        super(Profesor.class);
        this.entityManager = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Profesor> obtenerTodosOrdenados() {
        return entityManager
                .createQuery("SELECT p FROM Profesor p ORDER BY p.nombreProfesor ASC", Profesor.class)
                .getResultList();
    }

    // ¡Bórralo todo lo demás! Adiós a los create()
}