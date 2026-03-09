package mx.desarrolloautenticacion.facade;

import mx.desarrolloautenticacion.delegate.DelegateProfesor;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.integration.ServiceLocator;

import java.util.List;

public class FacadeProfesor {
    private final DelegateProfesor  delegateProfesor;

    public FacadeProfesor(){
      this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor){
        delegateProfesor.saveProfesor(profesor);
    }


    public List<Profesor> listarProfesores() {
        // Usamos el ServiceLocator para obtener el DAO y llamar al método que ya tienes
        return ServiceLocator.getInstanceProfesorDAO().obtenerTodosOrdenados();
    }



}
