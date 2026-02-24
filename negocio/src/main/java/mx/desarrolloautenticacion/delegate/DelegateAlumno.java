package mx.desarrolloautenticacion.delegate;

import mx.desarrolloautenticacion.entity.Alumno;
import mx.desarrolloautenticacion.integration.ServiceLocator;

public class DelegateAlumno {
    public void saveAlumno(Alumno alumno){
        ServiceLocator.getInstanceAlumnoDAO().save(alumno);
    }

}