package com.mari.cursos.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.ArrayList;

/**
 * Representa a un estudiante dentro del sistema académico.
 * Hereda los datos personales de la clase Persona y administra
 * las inscripciones y calificaciones del alumno.
 */
@Entity
@Table(name = "estudiantes")
public class Estudiante extends Persona {

    private String codigoEstudiante;
    private int semestre;
    private ArrayList<Inscripcion> inscripciones = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Estudiante() {
        super();
    }

    /**
     * Constructor útil para pruebas y creación rápida de estudiantes.
     *
     * @param nombre nombre del estudiante
     * @param correo correo electrónico
     * @param documento documento de identidad
     * @param codigoEstudiante código asignado al estudiante
     */
    public Estudiante(String nombre, String correo, String documento, String codigoEstudiante) {
        super(nombre, "", documento, correo);
        this.codigoEstudiante = codigoEstudiante;
        this.semestre = 0;
    }

    /**
     * Constructor completo con información académica.
     *
     * @param nombre nombre del estudiante
     * @param apellido apellido del estudiante
     * @param documento documento de identidad
     * @param correo correo electrónico
     * @param codigoEstudiante código del estudiante
     * @param semestre semestre actual
     */
    public Estudiante(String nombre, String apellido, String documento, String correo, String codigoEstudiante, int semestre) {
        super(nombre, apellido, documento, correo);
        this.codigoEstudiante = codigoEstudiante;
        this.semestre = semestre;
    }

    /**
     * Registra la inscripción del estudiante en un curso.
     */
    public void inscribirseCurso() {
        System.out.println("Estudiante inscrito en el curso.");
    }

    /**
     * Permite consultar los cursos del estudiante.
     */
    public void consultarCursos() {
        System.out.println("Consultando cursos...");
    }

    /**
     * Permite consultar las calificaciones del estudiante.
     */
    public void consultarCalificaciones() {
        System.out.println("Consultando calificaciones...");
    }

    /**
     * Obtiene el código del estudiante.
     *
     * @return código del estudiante
     */
    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    /**
     * Establece el código del estudiante.
     *
     * @param codigoEstudiante código del estudiante
     */
    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    /**
     * Obtiene el semestre actual del estudiante.
     *
     * @return semestre actual
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre actual del estudiante.
     *
     * @param semestre semestre actual
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene la lista de inscripciones del estudiante.
     *
     * @return lista de inscripciones
     */
    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}

