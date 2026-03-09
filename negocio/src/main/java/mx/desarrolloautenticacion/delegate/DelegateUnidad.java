package mx.desarrolloautenticacion.delegate;

import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.integration.ServiceLocator;

import java.util.List;

public class DelegateUnidad {

    public void saveUnidad(Unidad_Aprendizaje unidad_aprendizaje){
        ServiceLocator.getInstanceUnidadDAO().save(unidad_aprendizaje);
    }


    public List<Unidad_Aprendizaje> listarUnidades() {
        return ServiceLocator.getInstanceUnidadDAO().obtenerTodas();
    }
}
