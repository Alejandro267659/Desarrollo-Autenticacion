package helper;

import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.facade.FacadeProfesor;
import java.io.Serializable;

public class ProfesorHelper implements Serializable {

    public void altaProfesor(String nombre, String apP, String apM, String rfc) {

        Profesor profe = new Profesor();
        profe.setNombreProfesor(nombre);
        profe.setApellidopaternoProfesor(apP);
        profe.setApellidoMaternoProfesor(apM);
        profe.setRfcProfesor(rfc);


        FacadeProfesor facade = new FacadeProfesor();
        facade.guardarProfesor(profe);
    }
}