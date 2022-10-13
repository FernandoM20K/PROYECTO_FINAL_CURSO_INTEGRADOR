package Entidades;

public class Rol {
    private int idRol;
    private String nombre;
    
    public Rol() {
    
    }

    public Rol(int idRol) {
        this.idRol = idRol;
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

    public Rol(int idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", nombre=" + nombre + "]";
    }
}
