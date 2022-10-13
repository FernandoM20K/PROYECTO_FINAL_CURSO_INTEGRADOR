package Entidades;

public class Usuario {
    private int idUsuario;
    private String username;
    private String password;
    private int idRol;
    private String nombreRol;
    
    public Usuario() {
    
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String username, String password, int idRol) {
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }

    public Usuario(int idUsuario, String username, String password, int idRol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.idRol = idRol;
    }

    public Usuario(int idUsuario, String username, String password, int idRol, String nombreRol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.idRol = idRol;
        this.nombreRol = nombreRol;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", idRol="
                + idRol + ", nombreRol=" + nombreRol + "]";
    }
}
