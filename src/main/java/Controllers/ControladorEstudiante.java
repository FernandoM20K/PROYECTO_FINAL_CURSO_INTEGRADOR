package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.EstudianteDAO;
import Entidades.Estudiante;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.*;

@WebServlet("/ControladorEstudiante")
public class ControladorEstudiante extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                case "editar": 
                    this.editarEstudiante(request, response);
                    break;
                case "eliminar":
                    this.eliminarEstudiante(request, response);
                    break;
                case "retiro":
                    this.retiroEstudiante(request, response);
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
                    this.insertarEstudiante(request, response);
                    break;
                case "modificar":
                    this.modificarEstudiante(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Estudiante> estudiantes = new EstudianteDAO().listar();
        System.out.println("estudiantes" + estudiantes);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalEstudiantes", estudiantes.size());
        sesion.setAttribute("estudiantes", estudiantes);
        response.sendRedirect("admin/estudiantes.jsp");
    }

    private void editarEstudiante(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAR EL ID ESTUDIANTE
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        Estudiante estudiante = new EstudianteDAO().encontrar(new Estudiante(idEstudiante));
        request.setAttribute("estudiante", estudiante);
        String jspEditar = "admin/editarEstudiante.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void insertarEstudiante(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARESTUDIANTE
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String genero = request.getParameter("genero");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String estado = "Activo";
        String fechaIngreso = request.getParameter("fechaIngreso");
        String imagenPerfil = "1234445454.jpg";

        //CRREAMOS EL OBJETO ESTUDIANTE (MODELO)
        Estudiante estudiante = new Estudiante(nombres, apellidos, dni, edad, genero, celular, direccion, email, estado, fechaIngreso, imagenPerfil);
        //INSERTAR EN LA BASE DE DATOS
        int registrosModificados = new EstudianteDAO().insertar(estudiante);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void retiroEstudiante(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARESTUDIANTE
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        String estado = "Retirado";
        LocalDate hoy = LocalDate.now();
        String fechaRetiro = hoy.toString();
        //CREAMOS EL OBJETO ESTUDIANTE (MODELO)
        Estudiante estudiante = new Estudiante(idEstudiante, estado, fechaRetiro);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new EstudianteDAO().cambiarEstado(estudiante);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void modificarEstudiante(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARESTUDIANTE
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String dni = request.getParameter("dni");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String genero = request.getParameter("genero");
        String celular = request.getParameter("celular");
        String direccion = request.getParameter("direccion");
        String email = request.getParameter("email");
        String fechaIngreso = request.getParameter("fechaIngreso");
        String imagenPerfil = "12334565GTGTGF";

        //CREAMOS EL OBJETO ESTUDIANTE (MODELO)
        Estudiante estudiante = new Estudiante(idEstudiante, nombres, apellidos, dni, edad, genero, celular, direccion, email, fechaIngreso, imagenPerfil);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new EstudianteDAO().actualizar(estudiante);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARESTUDIANTE
        int idEstudiante = Integer.parseInt(request.getParameter("idEstudiante"));

        //CREAMOS EL OBJETO ESTUDIANTE (MODELO)
        Estudiante estudiante = new Estudiante(idEstudiante);

        //ELIMINAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new EstudianteDAO().eliminar(estudiante);
        System.out.println("Registro Eliminado"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }
}
