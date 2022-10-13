package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.CursoDAO;
import Data.ProfesorDAO;
import Data.TurnoDAO;
import Entidades.Curso;
import Entidades.Profesor;
import Entidades.Turno;
import java.util.List;
import javax.servlet.http.*;

@WebServlet("/ControladorCurso")
public class ControladorCurso extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                case "editar": 
                    this.editarCurso(request, response);
                    break;
                case "eliminar":
                    this.eliminarCurso(request, response);
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
                    this.insertarCurso(request, response);
                    break;
                case "modificar":
                    this.modificarCurso(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Curso> cursos = new CursoDAO().listar();
        System.out.println("cursos" + cursos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalCursos", cursos.size());
        sesion.setAttribute("cursos", cursos);
        response.sendRedirect("admin/cursos.jsp");
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //CREAR LISTA DE PROFESORES
        List<Profesor> profesores = new ProfesorDAO().listar();
        System.out.println("profesores" + profesores);
        //CREAR LISTA DE TURNOS
        List<Turno> turnos = new TurnoDAO().listar();
        System.out.println("profesores" + profesores);
        HttpSession sesion = request.getSession();
        //AÑADIR TURNOS Y PROFESORES
        sesion.setAttribute("profesores", profesores);
        sesion.setAttribute("turnos", turnos);
        request.getRequestDispatcher("admin/agregarCurso.jsp").forward(request, response);
    }

    private void editarCurso(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAR EL ID CURSO
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        Curso curso = new CursoDAO().encontrar(new Curso(idCurso));
        request.setAttribute("curso", curso);
        String jspEditar = "admin/editarCurso.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void insertarCurso(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARCURSO
        String nombreCurso = request.getParameter("nombreCurso");
        int horasSemana = Integer.parseInt(request.getParameter("horasSemana"));
        int duracionSemanas = Integer.parseInt(request.getParameter("duracionSemanas"));
        int idTurno = Integer.parseInt(request.getParameter("idTurno"));
        int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));

        //CRREAMOS EL OBJETO CURSO (MODELO)
        Curso curso = new Curso(nombreCurso, horasSemana, duracionSemanas, idTurno, idProfesor);
        //INSERTAR EN LA BASE DE DATOS
        int registrosModificados = new CursoDAO().insertar(curso);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void modificarCurso(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARCURSO
        String nombreCurso = request.getParameter("nombreCurso");
        int horasSemana = Integer.parseInt(request.getParameter("horasSemana"));
        int duracionSemanas = Integer.parseInt(request.getParameter("duracionSemanas"));
        int idTurno = Integer.parseInt(request.getParameter("idTurno"));
        int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));

        //CREAMOS EL OBJETO CURSO (MODELO)
        Curso curso = new Curso(nombreCurso, horasSemana, duracionSemanas, idTurno, idProfesor);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new CursoDAO().actualizar(curso);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARCURSO
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));

        //CREAMOS EL OBJETO CURSO (MODELO)
        Curso curso = new Curso(idCurso);

        //ELIMINAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new CursoDAO().eliminar(curso);
        System.out.println("Registro Eliminado"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }
}
