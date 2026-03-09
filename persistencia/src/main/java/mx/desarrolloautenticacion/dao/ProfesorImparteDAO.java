package mx.desarrolloautenticacion.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.desarrolloautenticacion.entity.Profesor_Imparte;

public class ProfesorImparteDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencePU");

    public void guardarAsignacion(Profesor_Imparte asignacion) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
            System.out.println("Asignación guardada en BD exitosamente.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error en DAO al guardar asignación: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public java.util.List<Profesor_Imparte> listarAsignaciones() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT pi FROM Profesor_Imparte pi", Profesor_Imparte.class)
                    .getResultList();
        } catch (Exception e) {
            System.out.println("Error al listar asignaciones: " + e.getMessage());
            return new java.util.ArrayList<>();
        } finally {
            em.close();
        }
    }
}
