package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.RolDAO;
import Data.UsuarioDAO;
import Entidades.Rol;
import Entidades.Usuario;
import java.util.List;
import javax.servlet.http.*;

@WebServlet("/ControladorUsuario")
public class ControladorUsuario extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                case "editar": 
                    this.editarUsuario(request, response);
                    break;
                case "eliminar":
                    this.eliminarUsuario(request, response);
                    break;
                case "agregar":
                    this.agregar(request, response);
                    break;
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
                case "insertar": 
                    this.insertarUsuario(request, response);
                    break;
                case "modificar":
                    this.modificarUsuario(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Usuario> usuarios = new UsuarioDAO().listar();
        System.out.println("usuarios" + usuarios);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalUsuarios", usuarios.size());
        sesion.setAttribute("usuarios", usuarios);
        response.sendRedirect("admin/usuarios.jsp");
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Rol> roles = new RolDAO().listar();
        System.out.println("roles" + roles);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("roles", roles);
        request.getRequestDispatcher("admin/agregarUsuario.jsp").forward(request, response);
    }

    private void editarUsuario(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAR EL ID USUARIO
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        Usuario usuario = new UsuarioDAO().encontrar(new Usuario(idUsuario));
        request.setAttribute("usuario", usuario);
        String jspEditar = "admin/editarUsuario.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARUSUARIO
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int idRol = Integer.parseInt(request.getParameter("idRol"));

        //CRREAMOS EL OBJETO USUARIO (MODELO)
        Usuario usuario = new Usuario(username, password, idRol);
        //INSERTAR EN LA BASE DE DATOS
        int registrosModificados = new UsuarioDAO().insertar(usuario);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void modificarUsuario(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARUSUARIO
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int idRol = Integer.parseInt(request.getParameter("idRol"));

        //CREAMOS EL OBJETO USUARIO (MODELO)
        Usuario usuario = new Usuario(idUsuario, username, password, idRol);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new UsuarioDAO().actualizar(usuario);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARUSUARIO
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        //CREAMOS EL OBJETO USUARIO (MODELO)
        Usuario usuario = new Usuario(idUsuario);

        //ELIMINAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new UsuarioDAO().eliminar(usuario);
        System.out.println("Registro Eliminado"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }
}
