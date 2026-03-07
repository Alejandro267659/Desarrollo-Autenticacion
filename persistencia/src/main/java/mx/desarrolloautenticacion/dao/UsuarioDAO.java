package mx.desarrolloautenticacion.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

public class UsuarioDAO {

    private final EntityManager entityManager;


    public UsuarioDAO(EntityManager em) {
        this.entityManager = em;
    }

    public Object encontrar(String usuario) {

        String jpql = "SELECT p FROM Profesor p WHERE p.nombreProfesor = :nombre";

        try {
            System.out.println("Buscando al usuario en BD: " + usuario);


            return entityManager.createQuery(jpql)
                    .setParameter("nombre", usuario)
                    .getSingleResult();

        } catch (NoResultException e) {

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}