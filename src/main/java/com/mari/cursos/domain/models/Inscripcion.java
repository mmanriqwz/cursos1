package com.mari.cursos.domain.models;

import java.util.ArrayList;

/*Representa la inscripción de un estudiante en un curso.
Contiene la fecha, el estado, el estudiante, el curso
y las calificaciones relacionadas.*/
public class Inscripcion {

    private int idInscripcion;
    private String fecha;
    private String estado;

    private Estudiante estudiante;
    private Curso curso;

    private ArrayList<Calificacion> calificaciones = new ArrayList<>();

    /*Registra una inscripción.*/
    public void registrarInscripcion() {
        System.out.println("Inscripción registrada.");
    }

    /*Cancela una inscripción. */
    public void cancelarInscripcion() {
        System.out.println("Inscripción cancelada.");
    }

    /*Permite consultar la información de una inscripción.*/
    public void consultarInscripcion() {
        System.out.println("Consultando inscripción...");
    }

    /*Obtiene el identificador de la inscripción.
    @return identificador de la inscripción*/
    public int getIdInscripcion() {
        return idInscripcion;
    }

    /*Establece el identificador de la inscripción.*/
    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    /*Obtiene la fecha de la inscripción.
    @return fecha de la inscripción*/
    public String getFecha() {
        return fecha;
    }

    /*Establece la fecha de la inscripción.*/
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /*Obtiene el estado de la inscripción.
    @return estado de la inscripción*/
    public String getEstado() {
        return estado;
    }

    /*Establece el estado de la inscripción.*/
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /*Obtiene el estudiante relacionado con la inscripción.
    @return estudiante inscrito*/
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /*Establece el estudiante de la inscripción.*/
    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    /*Obtiene el curso relacionado con la inscripción.
    @return curso seleccionado*/
    public Curso getCurso() {
        return curso;
    }

    /*Establece el curso de la inscripción.*/
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    /*Obtiene las calificaciones de la inscripción.
    @return lista de calificaciones*/
    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }
}
