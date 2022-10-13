package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.TurnoDAO;
import Entidades.Turno;

import java.util.List;
import javax.servlet.http.*;

@WebServlet("/ControladorTurno")
public class ControladorTurno extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                case "editar": 
                    this.editarTurno(request, response);
                    break;
                case "eliminar":
                    this.eliminarTurno(request, response);
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
                    this.insertarTurno(request, response);
                    break;
                case "modificar":
                    this.modificarTurno(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Turno> turnos = new TurnoDAO().listar();
        System.out.println("turnos" + turnos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalTurnos", turnos.size());
        sesion.setAttribute("turnos", turnos);
        response.sendRedirect("admin/turnos.jsp");
    }

    private void editarTurno(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAR EL ID TURNO
        int idTurno = Integer.parseInt(request.getParameter("idTurno"));
        Turno turno = new TurnoDAO().encontrar(new Turno(idTurno));
        request.setAttribute("turno", turno);
        String jspEditar = "admin/editarTurno.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void insertarTurno(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARTURNO
        String nombre = request.getParameter("nombreTurno");

        //CRREAMOS EL OBJETO TURNO (MODELO)
        Turno turno = new Turno(nombre);
        //INSERTAR EN LA BASE DE DATOS
        int registrosModificados = new TurnoDAO().insertar(turno);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void modificarTurno(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARTURNO
        int idTurno = Integer.parseInt(request.getParameter("idTurno"));
        String nombre = request.getParameter("nombreTurno");

        //CREAMOS EL OBJETO TURNO (MODELO)
        Turno turno = new Turno(idTurno, nombre);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new TurnoDAO().actualizar(turno);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void eliminarTurno(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARTURNO
        int idTurno = Integer.parseInt(request.getParameter("idTurno"));

        //CREAMOS EL OBJETO TURNO (MODELO)
        Turno turno = new Turno(idTurno);

        //ELIMINAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new TurnoDAO().eliminar(turno);
        System.out.println("Registro Eliminado"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }
}
