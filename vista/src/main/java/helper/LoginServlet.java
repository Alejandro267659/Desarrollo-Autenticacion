package helper;

import helper.LoginHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        LoginHelper helper = new LoginHelper();


        if (helper.validarLogin(pass, user)) {

            response.sendRedirect("MenuPrincipal.xhtml");
        } else {
            request.setAttribute("error", "Credenciales no válidas");
            request.getRequestDispatcher("login.xhtml").forward(request, response);

        }
    }
}