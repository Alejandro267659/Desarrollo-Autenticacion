package mx.desarrolloautenticacion.facade;

import mx.desarrolloautenticacion.dao.ProfesorImparteDAO;
import mx.desarrolloautenticacion.entity.Profesor_Imparte;

import java.util.List;

public class FacadeAsignacion {

    private ProfesorImparteDAO dao;

    public FacadeAsignacion() {
        this.dao = new ProfesorImparteDAO();
    }

    public void guardarAsignacion(Profesor_Imparte asignacion) {
        dao.guardarAsignacion(asignacion);
    }


    public List<Profesor_Imparte> obtenerTodas() {
        return dao.listarAsignaciones();
    }
}