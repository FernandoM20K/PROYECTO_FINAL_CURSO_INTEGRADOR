package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Categoria;

public class CategoriaDAO {
    private static final String SQL_SELECT = "SELECT ID_CATEGORIA, NOMBRE FROM TB_CATEGORIAS";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_CATEGORIA, NOMBRE FROM TB_CATEGORIAS WHERE ID_CATEGORIA = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_CATEGORIAS(NOMBRE) VALUES(?)";

    private static final String SQL_UPDATE = "UPDATE TB_CATEGORIAS SET NOMBRE=? WHERE ID_CATEGORIA = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_CATEGORIAS WHERE ID_CATEGORIA=?";

    /* INICIO METODO LISTAR CATEGORIAS */
    public List<Categoria> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Categoria categoria = null;
        List<Categoria> categorias = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idCategoria = rs.getInt(1);
                String nombre = rs.getString(2);

                categoria = new Categoria(idCategoria, nombre);
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return categorias;
    } /* FIN METODO LISTAR CATEGORIAS */

    /* INICIO METODO ENCONTRAR CATEGORIA */
    public Categoria encontrar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, categoria.getIdCategoria());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idCategoria = rs.getInt(1);
            String nombre = rs.getString(2);

            categoria.setIdCategoria(idCategoria);
            categoria.setNombreCategoria(nombre);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return categoria;
    } /* FIN METODO ENCONTRAR CATEGORIA */

    /* INICIO METODO INSERTAR CATEGORIA */
    public int insertar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, categoria.getNombreCategoria());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR CATEGORIA */

    /* INICIO METODO ACTUALIZAR CATEGORIA */
    public int actualizar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, categoria.getNombreCategoria());
            stmt.setInt(2, categoria.getIdCategoria());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR CATEGORIA */

    /* INICIO METODO ELIMINAR CATEGORIA */
    public int eliminar(Categoria categoria) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, categoria.getIdCategoria());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR CATEGORIA */
}
