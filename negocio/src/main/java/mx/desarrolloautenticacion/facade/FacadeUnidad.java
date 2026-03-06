package mx.desarrolloautenticacion.facade;

import mx.desarrolloautenticacion.delegate.DelegateUnidad;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;

public class FacadeUnidad {

    private final DelegateUnidad delegateUnidad;

    public FacadeUnidad(){
        this.delegateUnidad = new DelegateUnidad();
    }
    public void guardarUnidad(Unidad_Aprendizaje unidad_aprendizaje){
        delegateUnidad.saveUnidad(unidad_aprendizaje);
    }

}
