package mx.desarrolloautenticacion.service;

import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.dao.UsuarioDAO;
import mx.desarrolloautenticacion.dao.ProfesorDAO;
import java.util.List;

public class ProfesorService {

    private UsuarioDAO usuarioDAO;
    private ProfesorDAO profesorDAO;


    public ProfesorService(EntityManager em) {
        this.profesorDAO = new ProfesorDAO(em);
        this.usuarioDAO = new UsuarioDAO(em);
    }


    public boolean validarRFC(String rfc) {
        return rfc != null && (rfc.length() == 13 || rfc.length() == 12);
    }

    public void registrarProfesor(Profesor p, String nombreUsuario) {
        if (usuarioDAO.encontrar(nombreUsuario) == null) {
            throw new RuntimeException("Error: El usuario no existe. No se puede registrar al profesor.");
        }

        if (!validarRFC(p.getRfcProfesor())) {
            throw new RuntimeException("Error: El RFC del profesor no es válido.");
        }

        System.out.println("Usuario validado. Registrando profesor...");
        profesorDAO.create(p);
    }


    public List<Profesor> consultarProfesoresOrdenados() {
        return profesorDAO.obtenerTodosOrdenados();
    }

    public void mostrarUnidadesAsignadas(int idProfesor) {

        System.out.println("Consultando unidades para el profesor ID: " + idProfesor);

    }
}