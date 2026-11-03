package com.mari.cursos.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.ArrayList;

/**
 * Representa a un profesor del sistema académico.
 * Hereda los datos personales de Persona y administra
 * la información de sus cursos y calificaciones.
 */
@Entity
@Table(name = "profesores")
public class Profesor extends Persona {

    private String codigoProfesor;
    private String especialidad;
    private ArrayList<Curso> cursos = new ArrayList<>();

    /**
     * Constructor vacío requerido por JPA.
     */
    public Profesor() {
        super();
    }

    /**
     * Constructor con información principal del profesor.
     *
     * @param nombre nombre del profesor
     * @param apellido apellido del profesor
     * @param documento documento de identificación
     * @param correo correo electrónico
     * @param codigoProfesor código único del profesor
     * @param especialidad especialidad académica
     */
    public Profesor(String nombre, String apellido, String documento, String correo, String codigoProfesor, String especialidad) {
        super(nombre, apellido, documento, correo);
        this.codigoProfesor = codigoProfesor;
        this.especialidad = especialidad;
    }

    /**
     * Permite consultar los cursos asignados al profesor.
     */
    public void consultarCursos() {
        System.out.println("Consultando cursos...");
    }

    /**
     * Registra una calificación para un estudiante.
     */
    public void registrarCalificacion() {
        System.out.println("Calificación registrada.");
    }

    /**
     * Modifica una calificación registrada.
     */
    public void modificarCalificacion() {
        System.out.println("Calificación modificada.");
    }

    /**
     * Obtiene el código del profesor.
     *
     * @return código del profesor
     */
    public String getCodigoProfesor() {
        return codigoProfesor;
    }

    /**
     * Establece el código del profesor.
     *
     * @param codigoProfesor código del profesor
     */
    public void setCodigoProfesor(String codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    /**
     * Obtiene la especialidad del profesor.
     *
     * @return especialidad académica
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Establece la especialidad del profesor.
     *
     * @param especialidad especialidad académica
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la lista de cursos asignados al profesor.
     *
     * @return lista de cursos
     */
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}

