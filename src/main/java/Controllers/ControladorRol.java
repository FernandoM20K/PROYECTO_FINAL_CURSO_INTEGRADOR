package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.RolDAO;
import Entidades.Rol;
import java.util.List;
import javax.servlet.http.*;

@WebServlet("/ControladorRol")
public class ControladorRol extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Rol> roles = new RolDAO().listar();
        System.out.println("roles" + roles);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalRoles", roles.size());
        sesion.setAttribute("roles", roles);
        response.sendRedirect("admin/roles.jsp");
    }
}
