package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Estudiante;

public class EstudianteDAO {
    private static final String SQL_SELECT = "SELECT ID_ESTUDIANTE, NOMBRES, APELLIDOS, DNI, EDAD, GENERO, CELULAR, DIRECCION, EMAIL, ESTADO, FECHA_INGRESO, FECHA_RETIRO, IMAGEN_PERFIL, ID_USUARIO FROM TB_ESTUDIANTES";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_ESTUDIANTE, NOMBRES, APELLIDOS, DNI, EDAD, GENERO, CELULAR, DIRECCION, EMAIL, ESTADO, FECHA_INGRESO, FECHA_RETIRO, IMAGEN_PERFIL, ID_USUARIO FROM TB_ESTUDIANTES WHERE ID_ESTUDIANTE = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_ESTUDIANTES(NOMBRES, APELLIDOS, DNI, EDAD, GENERO, CELULAR, DIRECCION, EMAIL, ESTADO, FECHA_INGRESO, IMAGEN_PERFIL) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE TB_ESTUDIANTES SET NOMBRES=?, APELLIDOS=?, DNI=?, EDAD=?, GENERO=?, CELULAR=?, DIRECCION=?, EMAIL=?, FECHA_INGRESO=?, IMAGEN_PERFIL=? WHERE ID_ESTUDIANTE = ?";

    private static final String SQL_AÑADIR_USER = "UPDATE TB_ESTUDIANTES SET ID_USUARIO=? WHERE ID_ESTUDIANTE = ?";

    private static final String SQL_CAMBIAR_ESTADO = "UPDATE TB_ESTUDIANTES SET ESTADO=?, FECHA_RETIRO=? WHERE ID_ESTUDIANTE = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_ESTUDIANTES WHERE ID_ESTUDIANTE=?";

    /* INICIO METODO LISTAR ESTUDIANTES */
    public List<Estudiante> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Estudiante estudiante = null;
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idEstudiante = rs.getInt(1);
                String nombres = rs.getString(2);
                String apellidos = rs.getString(3);
                String dni = rs.getString(4);
                int edad = rs.getInt(5);
                String genero = rs.getString(6);
                String celular = rs.getString(7);
                String direccion = rs.getString(8);
                String email = rs.getString(9);
                String estado = rs.getString(10);
                String fechaIngreso = rs.getString(11);
                String fechaRetiro = rs.getString(12);
                String imagenPerfil = rs.getString(13);
                int idUsuario = rs.getInt(14);

                estudiante = new Estudiante(idEstudiante, nombres, apellidos, dni, edad, genero, celular, direccion, email, estado, fechaIngreso, fechaRetiro, imagenPerfil, idUsuario);
                estudiantes.add(estudiante);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return estudiantes;
    } /* FIN METODO LISTAR ESTUDIANTES */

    /* INICIO METODO ENCONTRAR ESTUDIANTE */
    public Estudiante encontrar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, estudiante.getIdEstudiante());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idEstudiante = rs.getInt(1);
            String nombres = rs.getString(2);
            String apellidos = rs.getString(3);
            String dni = rs.getString(4);
            int edad = rs.getInt(5);
            String genero = rs.getString(6);
            String celular = rs.getString(7);
            String direccion = rs.getString(8);
            String email = rs.getString(9);
            String estado = rs.getString(10);
            String fechaIngreso = rs.getString(11);
            String fechaRetiro = rs.getString(12);
            String imagenPerfil = rs.getString(13);
            int idUsuario = rs.getInt(14);

            estudiante.setIdEstudiante(idEstudiante);
            estudiante.setNombres(nombres);
            estudiante.setApellidos(apellidos);
            estudiante.setDni(dni);
            estudiante.setEdad(edad);
            estudiante.setGenero(genero);
            estudiante.setCelular(celular);
            estudiante.setDireccion(direccion);
            estudiante.setEmail(email);
            estudiante.setEstado(estado);
            estudiante.setFechaIngreso(fechaIngreso);
            estudiante.setFechaRetiro(fechaRetiro);
            estudiante.setImagenPerfil(imagenPerfil);
            estudiante.setIdUsuario(idUsuario);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return estudiante;
    } /* FIN METODO ENCONTRAR ESTUDIANTE */

    /* INICIO METODO INSERTAR ESTUDIANTE */
    public int insertar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, estudiante.getNombres());
            stmt.setString(2, estudiante.getApellidos());
            stmt.setString(3, estudiante.getDni());
            stmt.setInt(4, estudiante.getEdad());
            stmt.setString(5, estudiante.getGenero());
            stmt.setString(6, estudiante.getCelular());
            stmt.setString(7, estudiante.getDireccion());
            stmt.setString(8, estudiante.getEmail());
            stmt.setString(9, estudiante.getEstado());
            stmt.setString(10, estudiante.getFechaIngreso());
            stmt.setString(11, estudiante.getImagenPerfil());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR ESTUDIANTE */

    /* INICIO METODO ACTUALIZAR ESTUDIANTE */
    public int actualizar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, estudiante.getNombres());
            stmt.setString(2, estudiante.getApellidos());
            stmt.setString(3, estudiante.getDni());
            stmt.setInt(4, estudiante.getEdad());
            stmt.setString(5, estudiante.getGenero());
            stmt.setString(6, estudiante.getCelular());
            stmt.setString(7, estudiante.getDireccion());
            stmt.setString(8, estudiante.getEmail());
            stmt.setString(9, estudiante.getEstado());
            stmt.setString(10, estudiante.getFechaIngreso());
            stmt.setString(11, estudiante.getImagenPerfil());
            stmt.setInt(12, estudiante.getIdEstudiante());


            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR ESTUDIANTE */

    /* INICIO METODO CAMBIARESTADO ESTUDIANTE */
    public int cambiarEstado(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CAMBIAR_ESTADO);
            stmt.setString(1, estudiante.getEstado());
            stmt.setString(2, estudiante.getFechaRetiro());
            stmt.setInt(3, estudiante.getIdEstudiante());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO CAMBIARESTADO ESTUDIANTE */

    /* INICIO METODO AGREGARUSUARIO ESTUDIANTE */
    public int agregarUsuario(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AÑADIR_USER);
            stmt.setInt(1, estudiante.getIdUsuario());
            stmt.setInt(2, estudiante.getIdEstudiante());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO AGREGARUSUARIO ESTUDIANTE */

    /* INICIO METODO ELIMINAR ESTUDIANTE */
    public int eliminar(Estudiante estudiante) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, estudiante.getIdEstudiante());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR ESTUDIANTE */
}
