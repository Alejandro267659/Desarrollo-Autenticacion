package mx.desarrolloautenticacion.dao;

import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.persistence.AbstractDAO;
import java.util.List;

public class UnidadDAO extends AbstractDAO<Unidad_Aprendizaje> {
    private final EntityManager entityManager;

    public UnidadDAO(EntityManager em) {
        super(Unidad_Aprendizaje.class);
        this.entityManager = em;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public List<Unidad_Aprendizaje> obtenerTodas(){
        return entityManager
                .createQuery("SELECT u FROM Unidad_Aprendizaje u", Unidad_Aprendizaje.class)
                .getResultList();
    }

    // ¡Bórralo todo lo demás! Adiós a los create()
}