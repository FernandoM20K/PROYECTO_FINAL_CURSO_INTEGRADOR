package Entidades;

public class Profesor {
    private int idProfesor;
    private String nombres;
    private String apellidos;
    private String dni;
    private int edad;
    private String genero;
    private String celular;
    private String direccion;
    private String email;
    private double sueldo;
    private String imagenPerfil;
    private String estado;
    private int idUsuario;

    public Profesor() {
    
    }

    public Profesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor(int idProfesor, String estado) {
        this.idProfesor = idProfesor;
        this.estado = estado;
    }

    public Profesor(String nombres, String apellidos, String dni, int edad, String genero, String celular,
            String direccion, String email, double sueldo, String imagenPerfil, String estado, int idUsuario) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.sueldo = sueldo;
        this.imagenPerfil = imagenPerfil;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public Profesor(String nombres, String apellidos, String dni, int edad, String genero, String celular,
            String direccion, String email, double sueldo, String imagenPerfil, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.sueldo = sueldo;
        this.imagenPerfil = imagenPerfil;
        this.estado = estado;
    }

    public Profesor(int idProfesor, String nombres, String apellidos, String dni, int edad, String genero,
            String celular, String direccion, String email, double sueldo, String imagenPerfil) {
        this.idProfesor = idProfesor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.sueldo = sueldo;
        this.imagenPerfil = imagenPerfil;
    }

    public Profesor(int idProfesor, String nombres, String apellidos, String dni, int edad, String genero,
            String celular, String direccion, String email, double sueldo, String imagenPerfil, String estado,
            int idUsuario) {
        this.idProfesor = idProfesor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.sueldo = sueldo;
        this.imagenPerfil = imagenPerfil;
        this.estado = estado;
        this.idUsuario = idUsuario;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Profesores [idProfesor=" + idProfesor + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni="
                + dni + ", edad=" + edad + ", genero=" + genero + ", celular=" + celular + ", direccion=" + direccion
                + ", email=" + email + ", sueldo=" + sueldo + ", imagenPerfil=" + imagenPerfil + ", estado=" + estado
                + ", idUsuario=" + idUsuario + "]";
    }
}
