package Entidades;

public class Curso {
    private int idCurso;
    private String nombreCurso;
    private int horasSemanales;
    private int duracion;
    private int idTurno;
    private String nombreTurno;
    private int idProfesor;
    private String nombresProfesor;
    private String apellidosProfesor;
    
    public Curso() {
    
    }

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(String nombreCurso, int horasSemanales, int duracion, int idTurno, int idProfesor) {
        this.nombreCurso = nombreCurso;
        this.horasSemanales = horasSemanales;
        this.duracion = duracion;
        this.idTurno = idTurno;
        this.idProfesor = idProfesor;
    }

    public Curso(int idCurso, String nombreCurso, int horasSemanales, int duracion, int idTurno, String nombreTurno,
            int idProfesor, String nombresProfesor, String apellidosProfesor) {
        this.idCurso = idCurso;
        this.nombreCurso = nombreCurso;
        this.horasSemanales = horasSemanales;
        this.duracion = duracion;
        this.idTurno = idTurno;
        this.nombreTurno = nombreTurno;
        this.idProfesor = idProfesor;
        this.nombresProfesor = nombresProfesor;
        this.apellidosProfesor = apellidosProfesor;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getNombreTurno() {
        return nombreTurno;
    }

    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombresProfesor() {
        return nombresProfesor;
    }

    public void setNombresProfesor(String nombresProfesor) {
        this.nombresProfesor = nombresProfesor;
    }

    public String getApellidosProfesor() {
        return apellidosProfesor;
    }

    public void setApellidosProfesor(String apellidosProfesor) {
        this.apellidosProfesor = apellidosProfesor;
    }

    @Override
    public String toString() {
        return "Curso [idCurso=" + idCurso + ", nombreCurso=" + nombreCurso + ", horasSemanales=" + horasSemanales
                + ", duracion=" + duracion + ", idTurno=" + idTurno + ", nombreTurno=" + nombreTurno + ", idProfesor="
                + idProfesor + ", nombresProfesor=" + nombresProfesor + ", apellidosProfesor=" + apellidosProfesor
                + "]";
    }
}
