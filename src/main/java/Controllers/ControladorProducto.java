package Controllers;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import Data.CategoriaDAO;
import Data.ProductoDAO;
import Entidades.Categoria;
import Entidades.Producto;
import java.util.List;
import javax.servlet.http.*;

@MultipartConfig
@WebServlet("/ControladorProducto")
public class ControladorProducto extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String accion = request.getParameter("accion");
        if(accion != null) {
            switch(accion) {
                case "editar": 
                    this.editarProducto(request, response);
                    break;
                case "eliminar":
                    this.eliminarProducto(request, response);
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
                    this.insertarProducto(request, response);
                    break;
                case "modificar":
                    this.modificarProducto(request, response);
                    break;
                default: 
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Producto> productos = new ProductoDAO().listar();
        System.out.println("productos" + productos);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("totalProductos", productos.size());
        sesion.setAttribute("productos", productos);
        response.sendRedirect("admin/productos.jsp");
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        List<Categoria> categorias = new CategoriaDAO().listar();
        System.out.println("categorias" + categorias);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("categorias", categorias);
        request.getRequestDispatcher("admin/agregarProducto.jsp").forward(request, response);
    }

    private void editarProducto(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAR EL ID CATEGORIA
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        Producto producto = new ProductoDAO().encontrar(new Producto(idProducto));
        request.setAttribute("producto", producto);
        String jspEditar = "admin/editarProducto.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void insertarProducto(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARPRODUCTO
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String imagen = "sdsdsdsdsdsds";
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

        //CRREAMOS EL OBJETO PRODUCTO (MODELO)
        Producto producto = new Producto(descripcion, stock, imagen, idCategoria);
        //INSERTAR EN LA BASE DE DATOS
        int registrosModificados = new ProductoDAO().insertar(producto);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void modificarProducto(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARPRODUCTO
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String descripcion = request.getParameter("descripcion");
        int stock = Integer.parseInt(request.getParameter("stock"));
        String imagen = "123456766767";
        int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));

        //CREAMOS EL OBJETO PRODUCTO (MODELO)
        Producto producto = new Producto(idProducto, descripcion, stock, imagen, idCategoria);

        //MODIFICAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new ProductoDAO().actualizar(producto);
        System.out.println("Registros Modificados"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        //RECUPERAMOS LOS VALORES DEL FORMULARIO AGREGARPRODUCTO
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));

        //CREAMOS EL OBJETO PRODUCTO (MODELO)
        Producto producto = new Producto(idProducto);

        //ELIMINAR EL OBJETO EN LA BASE DE DATOS
        int registrosModificados = new ProductoDAO().eliminar(producto);
        System.out.println("Registro Eliminado"+ registrosModificados);

        //REDIRIGIMOS HACIA LA ACCION POR DEFAULT
        this.accionDefault(request, response);
    }
}
