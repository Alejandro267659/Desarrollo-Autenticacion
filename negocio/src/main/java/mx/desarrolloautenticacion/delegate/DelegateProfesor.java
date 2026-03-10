package mx.desarrolloautenticacion.delegate;

import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.integration.ServiceLocator;

public class DelegateProfesor {


    public void saveProfesor(Profesor profesor){

        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }
}
