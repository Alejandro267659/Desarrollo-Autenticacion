
import mx.desarrolloautenticacion.dao.ProfesorDAO;
import mx.desarrolloautenticacion.entity.Profesor;
import mx.desarrolloautenticacion.persistence.HibernateUtil;

public class testDAO {

    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO(HibernateUtil.getEntityManager());



        for (Profesor profesor   : profesorDAO.findAll()) {
            System.out.println("Nombre: " + profesor.getNombreProfesor() + "\n" +
                    "Apellido: " + profesor.getApellidopaternoProfesor() + " " + profesor.getApellidoMaternoProfesor() + "\n" +
                    "RFC: " + profesor.getRfcProfesor());
        }
    }
}
