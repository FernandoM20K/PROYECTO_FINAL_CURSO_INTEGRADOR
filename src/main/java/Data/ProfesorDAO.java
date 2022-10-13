package Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entidades.Profesor;

public class ProfesorDAO {
    private static final String SQL_SELECT = "SELECT ID_PROFESOR, NOMBRES, APELLIDOS, DNI, EDAD, GENERO, CELULAR, DIRECCION, EMAIL, SUELDO, IMAGEN_PERFIL, ESTADO, ID_USUARIO FROM TB_PROFESORES";

    private static final String SQL_SELECT_BY_ID = "SELECT ID_PROFESOR, NOMBRES, APELLIDOS, DNI, EDAD, GENERO, CELULAR, DIRECCION, EMAIL, SUELDO, IMAGEN_PERFIL, ESTADO, ID_USUARIO FROM TB_PROFESORES WHERE ID_PROFESOR = ?";

    private static final String SQL_INSERT = "INSERT INTO TB_PROFESORES(NOMBRES, APELLIDOS, DNI, EDAD, GENERO, CELULAR, DIRECCION, EMAIL, SUELDO, IMAGEN_PERFIL, ESTADO) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE = "UPDATE TB_PROFESORES SET NOMBRES=?, APELLIDOS=?, DNI=?, EDAD=?, GENERO=?, CELULAR=?, DIRECCION=?, EMAIL=?, SUELDO=?, IMAGEN_PERFIL=?, ESTADO=? WHERE ID_PROFESOR = ?";

    private static final String SQL_AÑADIR_USER = "UPDATE TB_PROFESORES SET ID_USUARIO=? WHERE ID_PROFESOR = ?";

    private static final String SQL_CAMBIAR_ESTADO = "UPDATE TB_PROFESORES SET ESTADO=? WHERE ID_PROFESOR = ?";

    private static final String SQL_DELETE = "DELETE FROM TB_PROFESORES WHERE ID_PROFESOR=?";

    /* INICIO METODO LISTAR PROFESORES */
    public List<Profesor> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Profesor profesor = null;
        List<Profesor> profesores = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()) {
                int idProfesor = rs.getInt(1);
                String nombres = rs.getString(2);
                String apellidos = rs.getString(3);
                String dni = rs.getString(4);
                int edad = rs.getInt(5);
                String genero = rs.getString(6);
                String celular = rs.getString(7);
                String direccion = rs.getString(8);
                String email = rs.getString(9);
                double sueldo = rs.getDouble(10);
                String imagen = rs.getString(11);
                String estado = rs.getString(12);
                int idUsuario = rs.getInt(13);

                profesor = new Profesor(idProfesor, nombres, apellidos, dni, edad, genero, celular, direccion, email, sueldo, imagen, estado, idUsuario);
                profesores.add(profesor);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return profesores;
    } /* FIN METODO LISTAR PROFESORES */

    /* INICIO METODO ENCONTRAR PROFESOR */
    public Profesor encontrar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, profesor.getIdProfesor());
            rs = stmt.executeQuery();
            rs.next(); //NOS POSICIONAMOS EN EL PRIMER REGISTRO

            int idProfesor = rs.getInt(1);
            String nombres = rs.getString(2);
            String apellidos = rs.getString(3);
            String dni = rs.getString(4);
            int edad = rs.getInt(5);
            String genero = rs.getString(6);
            String celular = rs.getString(7);
            String direccion = rs.getString(8);
            String email = rs.getString(9);
            double sueldo = rs.getDouble(10);
            String imagen = rs.getString(11);
            String estado = rs.getString(12);
            int idUsuario = rs.getInt(13);

            profesor.setIdProfesor(idProfesor);
            profesor.setNombres(nombres);
            profesor.setApellidos(apellidos);
            profesor.setDni(dni);
            profesor.setEdad(edad);
            profesor.setGenero(genero);
            profesor.setCelular(celular);
            profesor.setDireccion(direccion);
            profesor.setEmail(email);
            profesor.setSueldo(sueldo);
            profesor.setImagenPerfil(imagen);
            profesor.setEstado(estado);
            profesor.setIdUsuario(idUsuario);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return profesor;
    } /* FIN METODO ENCONTRAR PROFESOR */

    /* INICIO METODO INSERTAR PROFESOR */
    public int insertar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, profesor.getNombres());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getDni());
            stmt.setInt(4, profesor.getEdad());
            stmt.setString(5, profesor.getGenero());
            stmt.setString(6, profesor.getCelular());
            stmt.setString(7, profesor.getDireccion());
            stmt.setString(8, profesor.getEmail());
            stmt.setDouble(9, profesor.getSueldo());
            stmt.setString(10, profesor.getImagenPerfil());
            stmt.setString(11, profesor.getEstado());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO INSERTAR PROFESOR */

    /* INICIO METODO ACTUALIZAR PROFESOR */
    public int actualizar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, profesor.getNombres());
            stmt.setString(2, profesor.getApellidos());
            stmt.setString(3, profesor.getDni());
            stmt.setInt(4, profesor.getEdad());
            stmt.setString(5, profesor.getGenero());
            stmt.setString(6, profesor.getCelular());
            stmt.setString(7, profesor.getDireccion());
            stmt.setString(8, profesor.getEmail());
            stmt.setDouble(9, profesor.getSueldo());
            stmt.setString(10, profesor.getImagenPerfil());
            stmt.setString(11, profesor.getEstado());
            stmt.setInt(12, profesor.getIdProfesor());


            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ACTUALIZAR PROFESOR */

    /* INICIO METODO CAMBIARESTADO PROFESOR */
    public int cambiarEstado(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_CAMBIAR_ESTADO);
            stmt.setString(1, profesor.getEstado());
            stmt.setInt(2, profesor.getIdProfesor());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO CAMBIARESTADO PROFESOR */

    /* INICIO METODO AGREGARUSUARIO PROFESOR */
    public int agregarUsuario(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_AÑADIR_USER);
            stmt.setInt(1, profesor.getIdUsuario());
            stmt.setInt(2, profesor.getIdProfesor());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO AGREGARUSUARIO PROFESOR */

    /* INICIO METODO ELIMINAR PROFESOR */
    public int eliminar(Profesor profesor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, profesor.getIdProfesor());

            rows = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    } /* FIN METODO ELIMINAR PROFESOR */
}
