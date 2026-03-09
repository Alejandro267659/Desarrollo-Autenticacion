package mx.desarrolloautenticacion.delegate;

import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.integration.ServiceLocator;

public class DelegateProfesor {

    // TIENE que llamarse saveProfesor para que el Facade lo encuentre
    public void saveProfesor(Profesor profesor){
        // ¡Usamos el save() mágico que ya trae tu AbstractDAO!
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }
}
