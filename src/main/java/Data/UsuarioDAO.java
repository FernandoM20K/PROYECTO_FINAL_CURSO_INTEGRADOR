package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Usuario;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT TU.ID_USUARIO, TU.USERNAME, TU.PASSWORD, TU.ID_ROL, TR.NOMBRE FROM TB_USUARIOS TU INNER JOIN TB_ROLES TR ON TU.ID_ROL=TR.ID_ROL";

    private static final String SQL_SELECT_BY_ID = "SELECT TU.ID_USUARIO, TU.USERNAME, TU.PASSWORD, TU.ID_ROL, TR.NOMBRE FROM TB_USUARIOS TU INNER JOIN TB_ROLES TR ON TU.ID_ROL=TR.ID_ROL WHERE TU.ID_USUARIO = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_USUARIOS(USERNAME, PASSWORD, ID_ROL) VALUES(?,?,?)";

    private static final String SQL_UPDATE = "UPDATE TB_USUARIOS SET USERNAME=?, PASSWORD=?, ID_ROL=? WHERE ID_USUARIO = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_USUARIOS WHERE ID_USUARIO=?";

    /* INICIO METODO LISTAR USUARIOS */
    public List<Usuario> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idUsuario = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                int idRol = rs.getInt(4);
                String nombreRol = rs.getString(5);

                usuario = new Usuario(idUsuario, username, password, idRol, nombreRol);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return usuarios;
    } /* FIN METODO LISTAR USUARIOS */

    /* INICIO METODO ENCONTRAR USUARIO */
    public Usuario encontrar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getIdUsuario());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idUsuario = rs.getInt(1);
            String username = rs.getString(2);
            String password = rs.getString(3);
            int idRol = rs.getInt(4);
            String nombreRol = rs.getString(5);

            usuario.setIdUsuario(idUsuario);
            usuario.setUsername(username);
            usuario.setPassword(password);
            usuario.setIdRol(idRol);
            usuario.setNombreRol(nombreRol);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuario;
    } /* FIN METODO ENCONTRAR USUARIO */

    /* INICIO METODO INSERTAR USUARIO */
    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdRol());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR USUARIO */

    /* INICIO METODO ACTUALIZAR USUARIO */
    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdRol());
            stmt.setInt(4, usuario.getIdUsuario());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR USUARIO */

    /* INICIO METODO ELIMINAR USUARIO */
    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR USUARIO */
}
