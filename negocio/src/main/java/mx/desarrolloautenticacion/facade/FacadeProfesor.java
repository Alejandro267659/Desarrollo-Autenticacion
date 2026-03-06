package mx.desarrolloautenticacion.facade;

import mx.desarrolloautenticacion.delegate.DelegateProfesor;
import mx.desarrolloautenticacion.entity.Profesor;

public class FacadeProfesor {
    private final DelegateProfesor  delegateProfesor;

    public FacadeProfesor(){
      this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }




}
