package mx.desarrolloautenticacion.service;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;

import java.util.List;

public class AsignacionService {
    public boolean validar(Profesor p, Unidad_Aprendizaje u) {

        return p != null && u != null;
    }
    public List<Unidad_Aprendizaje> obtenerUnidadesPorProfesor(int idProfesor) {

        System.out.println("Consultando unidades para el profesor: " + idProfesor);
        return null;
    }
    public void realizarAsignacion(Profesor p, Unidad_Aprendizaje u) {
        if (validar(p, u)) {
            System.out.println("Asignando unidad " + u.getNombreUnidad() + " al profesor " + p.getNombreProfesor());

        }
    }
}
