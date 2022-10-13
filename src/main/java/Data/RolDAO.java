package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Rol;

public class RolDAO {
    private static final String SQL_SELECT = "SELECT ID_ROL, NOMBRE FROM TB_ROLES";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_ROL, NOMBRE FROM TB_ROLES WHERE ID_ROL = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_ROLES(NOMBRE) VALUES(?)";

    private static final String SQL_UPDATE = "UPDATE TB_ROLES SET NOMBRE=? WHERE ID_ROL = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_ROLES WHERE ID_ROL=?";

    /* INICIO METODO LISTAR ROLES */
    public List<Rol> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Rol rol = null;
        List<Rol> roles = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idRol = rs.getInt(1);
                String nombreRol = rs.getString(2);

                rol = new Rol(idRol, nombreRol);
                roles.add(rol);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return roles;
    } /* FIN METODO LISTAR ROLES */

    /* INICIO METODO ENCONTRAR ROL */
    public Rol encontrar(Rol rol) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, rol.getIdRol());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idRol = rs.getInt(1);
            String nombreRol = rs.getString(2);

            rol.setIdRol(idRol);
            rol.setNombre(nombreRol);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rol;
    } /* FIN METODO ENCONTRAR ROL */

    /* INICIO METODO INSERTAR ROL */
    public int insertar(Rol rol) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, rol.getNombre());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR ROL */

    /* INICIO METODO ACTUALIZAR ROL */
    public int actualizar(Rol rol) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, rol.getNombre());
            stmt.setInt(2, rol.getIdRol());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR ROL */

    /* INICIO METODO ELIMINAR ROL */
    public int eliminar(Rol rol) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, rol.getIdRol());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR ROL */
}
