package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Producto;

public class ProductoDAO {
    private static final String SQL_SELECT = "SELECT TP.ID_PRODUCTO, TP.DESCRIPCION, TP.STOCK, TP.IMAGEN, TP.ID_CATEGORIA, TC.NOMBRE FROM TB_PRODUCTOS TP INNER JOIN TB_CATEGORIAS TC ON TP.ID_CATEGORIA=TC.ID_CATEGORIA";

    private static final String SQL_SELECT_BY_ID = "SELECT TP.ID_PRODUCTO, TP.DESCRIPCION, TP.STOCK, TP.IMAGEN, TP.ID_CATEGORIA, TC.NOMBRE FROM TB_PRODUCTOS TP INNER JOIN TB_CATEGORIAS TC ON TP.ID_CATEGORIA=TC.ID_CATEGORIA WHERE TP.ID_PRODUCTO = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_PRODUCTOS (DESCRIPCION, STOCK, IMAGEN, ID_CATEGORIA) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE TB_CATEGORIAS SET DESCRIPCION=?, STOCK=?, IMAGEN=?, ID_CATEGORIA=? WHERE ID_PRODUCTO = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_PRODUCTOS WHERE ID_PRODUCTO=?";

    /* INICIO METODO LISTAR PRODUCTOS */
    public List<Producto> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idProducto = rs.getInt(1);
                String descripcion = rs.getString(2);
                int stock = rs.getInt(3);
                String imagen = rs.getString(4);
                int idCategoria = rs.getInt(5);
                String nombreCategoria = rs.getString(6);

                producto = new Producto(idProducto, descripcion, stock, imagen, idCategoria, nombreCategoria);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return productos;
    } /* FIN METODO LISTAR PRODUCTOS */

    /* INICIO METODO ENCONTRAR PRODUCTO */
    public Producto encontrar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, producto.getIdProducto());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idProducto = rs.getInt(1);
            String descripcion = rs.getString(2);
            int stock = rs.getInt(3);
            String imagen = rs.getString(4);
            int idCategoria = rs.getInt(5);
            String nombreCategoria = rs.getString(6);

            producto.setIdProducto(idProducto);
            producto.setDescripcion(descripcion);
            producto.setStock(stock);
            producto.setImagen(imagen);
            producto.setIdCategoria(idCategoria);
            producto.setNombreCategoria(nombreCategoria);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return producto;
    } /* FIN METODO ENCONTRAR PRODUCTO */

    /* INICIO METODO INSERTAR PRODUCTO */
    public int insertar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, producto.getDescripcion());
            stmt.setInt(2, producto.getStock());
            stmt.setString(3, producto.getImagen());
            stmt.setInt(4, producto.getIdCategoria());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR PRODUCTO */

    /* INICIO METODO ACTUALIZAR PRODUCTO */
    public int actualizar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, producto.getDescripcion());
            stmt.setInt(2, producto.getStock());
            stmt.setString(3, producto.getImagen());
            stmt.setInt(4, producto.getIdCategoria());
            stmt.setInt(5, producto.getIdProducto());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR PRODUCTO */

    /* INICIO METODO ELIMINAR PRODUCTO */
    public int eliminar(Producto producto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR PRODUCTO */
}
