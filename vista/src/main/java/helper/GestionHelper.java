package helper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GestionHelper implements Serializable {

    public boolean guardarMateria(String nombre, String clave, int hClase, int hTaller, int hLab) {

        System.out.println("Insertando materia: " + nombre);
        return true;
    }

    public boolean vincularProfesorMateria(int idProfesor, int idMateria) {
        System.out.println("Vinculando Prof: " + idProfesor + " con Materia: " + idMateria);
        return true;
    }
}