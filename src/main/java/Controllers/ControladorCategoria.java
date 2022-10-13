package Controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.CategoriaDAO;
import Entidades.Categoria;
import java.util.List;
import javax.servlet.http.*;

@WebServlet("/ControladorCategoria")
public class ControladorCategoria extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                case "editar": 
                    this.editarCategoria(request, response);
                    break;
                case "eliminar":
                    this.eliminarCategoria(request, response);
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
                    this.insertarCategoria(request, response);
                    break;
                case "modificar":
                    this.modificarCategoria(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Categoria> categorias = new CategoriaDAO().listar();
        System.out.println("categorias" + categorias);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalCategorias", categorias.size());
        sesion.setAttribute("categorias", categorias);
        response.sendRedirect("admin/categorias.jsp");
    }

    private void editarCategoria(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAR EL ID CATEGORIA
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = new CategoriaDAO().encontrar(new Categoria(idCategoria));
        request.setAttribute("categoria", categoria);
        String jspEditar = "admin/editarCategoria.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }


    private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARCATEGORIA
        String nombre = request.getParameter("nombreCategoria");

        //CRREAMOS EL OBJETO CATEGORIA (MODELO)
        Categoria categoria = new Categoria(nombre);
        //INSERTAR EN LA BASE DE DATOS
        int registrosModificados = new CategoriaDAO().insertar(categoria);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void modificarCategoria(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARCATEGORIA
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
        String nombre = request.getParameter("nombreCategoria");

        //CREAMOS EL OBJETO CATEGORIA (MODELO)
        Categoria categoria = new Categoria(idCategoria, nombre);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new CategoriaDAO().actualizar(categoria);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARCATEGORIA
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

        //CREAMOS EL OBJETO CATEGORIA (MODELO)
        Categoria categoria = new Categoria(idCategoria);

        //ELIMINAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new CategoriaDAO().eliminar(categoria);
        System.out.println("Registro Eliminado"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }
}
