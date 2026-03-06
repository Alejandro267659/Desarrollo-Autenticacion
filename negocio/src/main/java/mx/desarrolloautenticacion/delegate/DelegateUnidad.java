package mx.desarrolloautenticacion.delegate;

import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.integration.ServiceLocator;

public class DelegateUnidad {

public void saveUnidad(Unidad_Aprendizaje unidad_aprendizaje){
    ServiceLocator.getInstanceUnidadDAO().save(unidad_aprendizaje);
}


}
