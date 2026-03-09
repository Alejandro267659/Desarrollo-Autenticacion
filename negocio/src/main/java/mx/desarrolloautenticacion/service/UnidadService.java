package mx.desarrolloautenticacion.service;

import jakarta.persistence.EntityManager;
import mx.desarrolloautenticacion.entity.Unidad_Aprendizaje;
import mx.desarrolloautenticacion.dao.UnidadDAO;

public class UnidadService {

    private UnidadDAO unidadDAO;

    public UnidadService(EntityManager em) {
        this.unidadDAO = new UnidadDAO(em);
    }

    public boolean validarHoras(int c, int t, int l) {
        return (c >= 0 && t >= 0 && l >= 0) && (c + t + l) > 0;
    }

    public void registrarUnidad(Unidad_Aprendizaje u) {

        if (u.getNombreUnidad() == null || u.getNombreUnidad().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la unidad no puede estar vacío.");
        }

        if (u.getNombreUnidad().length() > 50) {
            throw new IllegalArgumentException("El nombre excede los 50 caracteres permitidos.");
        }

        if (!validarHoras(u.getHorasClase(), u.getHorasTaller(), u.getHorasLaboratorio())) {
            throw new IllegalArgumentException("La distribución de horas es inválida.");
        }

        System.out.println("Validaciones aprobadas. Registrando unidad: " + u.getNombreUnidad());

        // ¡AQUÍ ESTÁ LA MAGIA! Cambiamos .create() por .save()
        unidadDAO.save(u);
    }
}