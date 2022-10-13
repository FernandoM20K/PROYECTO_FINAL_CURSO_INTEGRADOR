package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Curso;

public class CursoDAO {
    private static final String SQL_SELECT = "SELECT TC.ID_CURSO, TC.NOMBRE, TC.HORAS_SEMANA, TC.DURACION_SEMANAS, TC.ID_TURNO, TT.TURNO, TC.ID_PROFESOR, TP.NOMBRES, TP.APELLIDOS FROM TB_CURSOS TC INNER JOIN TB_TURNOS TT ON TC.ID_TURNO=TT.ID_TURNO INNER JOIN TB_PROFESORES TP ON TC.ID_PROFESOR = TP.ID_PROFESOR";

    private static final String SQL_SELECT_BY_ID = "SELECT TC.ID_CURSO, TC.NOMBRE, TC.HORAS_SEMANA, TC.DURACION_SEMANAS, TC.ID_TURNO, TT.TURNO, TC.ID_PROFESOR, TP.NOMBRES, TP.APELLIDOS FROM TB_CURSOS TC INNER JOIN TB_TURNOS TT ON TC.ID_TURNO=TT.ID_TURNO INNER JOIN TB_PROFESORES TP ON TC.ID_PROFESOR = TP.ID_PROFESOR WHERE TC.ID_CURSO = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_CURSOS(NOMBRE, HORAS_SEMANA, DURACION_SEMANAS, ID_TURNO, ID_PROFESOR) VALUES(?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE TB_CURSOS SET NOMBRE=?, HORAS_SEMANA=?, DURACION_SAMANAS=?, ID_TURNO=?, ID_PROFESOR=? WHERE ID_CURSO= ?";

    private static final String SQL_DELETE = "DELETE FROM TB_CURSOS WHERE ID_CURSO=?";

    /* INICIO METODO LISTAR CURSOS */
    public List<Curso> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Curso curso = null;
        List<Curso> cursos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idCurso = rs.getInt(1);
                String nombreCurso = rs.getString(2);
                int horasSemana = rs.getInt(3);
                int duracionSemanas = rs.getInt(4);
                int idTurno = rs.getInt(5);
                String nombreTurno = rs.getString(6);
                int idProfesor = rs.getInt(7);
                String nombresProfesor = rs.getString(8);
                String apellidosProfesor = rs.getString(9);

                curso = new Curso(idCurso, nombreCurso, horasSemana, duracionSemanas, idTurno, nombreTurno, idProfesor, nombresProfesor, apellidosProfesor);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cursos;
    } /* FIN METODO LISTAR CURSOS */

    /* INICIO METODO ENCONTRAR CURSO */
    public Curso encontrar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, curso.getIdCurso());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idCurso = rs.getInt(1);
            String nombreCurso = rs.getString(2);
            int horasSemana = rs.getInt(3);
            int duracionSemanas = rs.getInt(4);
            int idTurno = rs.getInt(5);
            String nombreTurno = rs.getString(6);
            int idProfesor = rs.getInt(7);
            String nombresProfesor = rs.getString(8);
            String apellidosProfesor = rs.getString(9);

            curso.setIdCurso(idCurso);
            curso.setNombreCurso(nombreCurso);
            curso.setHorasSemanales(horasSemana);
            curso.setDuracion(duracionSemanas);
            curso.setIdTurno(idTurno);
            curso.setNombreTurno(nombreTurno);
            curso.setIdProfesor(idProfesor);
            curso.setNombresProfesor(nombresProfesor);
            curso.setApellidosProfesor(apellidosProfesor);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return curso;
    } /* FIN METODO ENCONTRAR CURSO */

    /* INICIO METODO INSERTAR CURSO */
    public int insertar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setInt(2, curso.getHorasSemanales());
            stmt.setInt(3, curso.getDuracion());
            stmt.setInt(4, curso.getIdTurno());
            stmt.setInt(5, curso.getIdProfesor());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR CURSO */

    /* INICIO METODO ACTUALIZAR CURSO */
    public int actualizar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, curso.getNombreCurso());
            stmt.setInt(2, curso.getHorasSemanales());
            stmt.setInt(3, curso.getDuracion());
            stmt.setInt(4, curso.getIdTurno());
            stmt.setInt(5, curso.getIdProfesor());
            stmt.setInt(6, curso.getIdCurso());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR CURSO */

    /* INICIO METODO ELIMINAR CURSO */
    public int eliminar(Curso curso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, curso.getIdCurso());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR CURSO */
}
