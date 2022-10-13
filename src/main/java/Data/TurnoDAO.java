package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Turno;

public class TurnoDAO {
    private static final String SQL_SELECT = "SELECT ID_TURNO, TURNO FROM TB_TURNOS";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_TURNO, TURNO FROM TB_TURNOS WHERE ID_TURNO = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_TURNOS(TURNO) VALUES(?)";

    private static final String SQL_UPDATE = "UPDATE TB_TURNOS SET TURNO=? WHERE ID_TURNO = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_TURNOS WHERE ID_TURNO=?";

    /* INICIO METODO LISTAR TURNOS */
    public List<Turno> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Turno turno = null;
        List<Turno> turnos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idTurno = rs.getInt(1);
                String nombreTurno = rs.getString(2);

                turno = new Turno(idTurno, nombreTurno);
                turnos.add(turno);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return turnos;
    } /* FIN METODO LISTAR TURNOS */

    /* INICIO METODO ENCONTRAR TURNO */
    public Turno encontrar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, turno.getIdTurno());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idTurno = rs.getInt(1);
            String nombreTurno = rs.getString(2);

            turno.setIdTurno(idTurno);
            turno.setTurno(nombreTurno);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return turno;
    } /* FIN METODO ENCONTRAR TURNO */

    /* INICIO METODO INSERTAR TURNO */
    public int insertar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, turno.getTurno());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR TURNO */

    /* INICIO METODO ACTUALIZAR TURNO */
    public int actualizar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, turno.getTurno());
            stmt.setInt(2, turno.getIdTurno());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR TURNO */

    /* INICIO METODO ELIMINAR TURNO */
    public int eliminar(Turno turno) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, turno.getIdTurno());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR TURNO */
}
