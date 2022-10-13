package Entidades;

public class Estudiante {
    private int idEstudiante;
    private String nombres;
    private String apellidos;
    private String dni;
    private int edad;
    private String genero;
    private String celular;
    private String direccion;
    private String email;
    private String estado;
    private String fechaIngreso;
    private String fechaRetiro;
    private String imagenPerfil;
    private int idUsuario;
    private String username;
    
    public Estudiante() {
    
    }

    public Estudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Estudiante(int idEstudiante, int idUsuario) {
        this.idEstudiante = idEstudiante;
        this.idUsuario = idUsuario;
    }

    public Estudiante(int idEstudiante, String estado, String fechaRetiro) {
        this.idEstudiante = idEstudiante;
        this.estado = estado;
        this.fechaRetiro = fechaRetiro;
    }

    public Estudiante(String nombres, String apellidos, String dni, int edad, String genero, String celular,
            String direccion, String email, String estado, String fechaIngreso, String imagenPerfil) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.imagenPerfil = imagenPerfil;
    }

    public Estudiante(int idEstudiante, String nombres, String apellidos, String dni, int edad, String genero,
            String celular, String direccion, String email, String fechaIngreso, String imagenPerfil) {
        this.idEstudiante = idEstudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.fechaIngreso = fechaIngreso;
        this.imagenPerfil = imagenPerfil;
    }

    

    public Estudiante(int idEstudiante, String nombres, String apellidos, String dni, int edad, String genero,
            String celular, String direccion, String email, String estado, String fechaIngreso, String fechaRetiro,
            String imagenPerfil, int idUsuario) {
        this.idEstudiante = idEstudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.imagenPerfil = imagenPerfil;
        this.idUsuario = idUsuario;
    }

    public Estudiante(int idEstudiante, String nombres, String apellidos, String dni, int edad, String genero,
            String celular, String direccion, String email, String estado, String fechaIngreso, String fechaRetiro,
            String imagenPerfil, int idUsuario, String username) {
        this.idEstudiante = idEstudiante;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.celular = celular;
        this.direccion = direccion;
        this.email = email;
        this.estado = estado;
        this.fechaIngreso = fechaIngreso;
        this.fechaRetiro = fechaRetiro;
        this.imagenPerfil = imagenPerfil;
        this.idUsuario = idUsuario;
        this.username = username;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(String fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Estudiante [idEstudiante=" + idEstudiante + ", nombres=" + nombres + ", apellidos=" + apellidos
                + ", dni=" + dni + ", edad=" + edad + ", genero=" + genero + ", celular=" + celular + ", direccion="
                + direccion + ", email=" + email + ", estado=" + estado + ", fechaIngreso=" + fechaIngreso
                + ", fechaRetiro=" + fechaRetiro + ", imagenPerfil=" + imagenPerfil + ", idUsuario=" + idUsuario
                + ", username=" + username + "]";
    }
}
