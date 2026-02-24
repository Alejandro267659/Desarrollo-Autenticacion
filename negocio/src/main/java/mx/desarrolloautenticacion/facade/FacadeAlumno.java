package mx.desarrolloautenticacion.facade;

import mx.desarrolloautenticacion.delegate.DelegateAlumno;
import mx.desarrolloautenticacion.entity.Alumno;

public class FacadeAlumno {

    private final DelegateAlumno delegateAlumno;

    public FacadeAlumno() {
        this.delegateAlumno = new DelegateAlumno();
    }

    public void guardarAlumno(Alumno alumno){
        delegateAlumno.saveAlumno(alumno);
    }

}
