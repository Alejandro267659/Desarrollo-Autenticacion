package helper;

import helper.ProfesorHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrar")
public class AltaProfesorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String nombre = request.getParameter("nombre");
        String apellidop = request.getParameter("apellidop");
        String apellidom = request.getParameter("apellidom");
        String rfc = request.getParameter("rfc");


        ProfesorHelper helper = new ProfesorHelper();
        helper.altaProfesor(nombre, apellidop, apellidom, rfc);

        response.sendRedirect("Menu.xhtml");
    }
}