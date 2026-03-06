/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrolloautenticacion.integration;

import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.dao.*;
import mx.desarrolloautenticacion.persistence.HibernateUtil;


/**
 *
 * @author total
 */
public class ServiceLocator {

    private static ProfesorDAO profesorDAO;
    private static UnidadDAO unidadDAO;

    private static EntityManager getEntityManager(){
        return HibernateUtil.getEntityManager();
    }

    public static UnidadDAO getInstanceUnidadDAO(){
        if(unidadDAO == null){
            unidadDAO = new UnidadDAO(getEntityManager());
            return unidadDAO;
        } else {
            return unidadDAO;
        }
    }

    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO(getEntityManager());
            return profesorDAO;
        } else {
            return profesorDAO;
        }
    }
}
