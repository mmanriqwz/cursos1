package com.mari.cursos.domain.models;

import java.util.ArrayList;
import jakarta.persistence.*;

/*Representa un curso académico.
Contiene información del curso, su profesor, las
inscripciones de estudiantes y sus horarios.*/
@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    private String nombre;
    private String descripcion;

    public Curso() {
    }
    private int creditos;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    private ArrayList<Inscripcion> inscripciones = new ArrayList<>();
    private ArrayList<Horario> horarios = new ArrayList<>();

    public Curso(String nombre, String descripcion, int creditos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.creditos = creditos;
    }

    /*Agrega un estudiante al curso*/
    public void agregarEstudiante() {
        System.out.println("Estudiante agregado.");
    }

    /*Permite asignar un profesor al curso.*/
    public void asignarProfesor() {
        System.out.println("Profesor asignado.");
    }

    /*Permite consultar los estudiantes inscritos en el curso.*/
    public void consultarEstudiantes() {
        System.out.println("Consultando estudiantes...");
    }

    /*Obtiene el identificador del curso.
    @return identificador del curso*/
    public int getIdCurso() {
        return idCurso;
    }

    /*Establece el identificador del curso*/
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    /*Obtiene el nombre del curso.
    @return nombre del curso*/
    public String getNombre() {
        return nombre;
    }

    /*Establece el nombre del curso.*/
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*Obtiene la descripción del curso.
    @return descripción del curso*/
    public String getDescripcion() {
        return descripcion;
    }

    /*Establece la descripción del curso.*/
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*Obtiene la cantidad de créditos del curso.
    @return cantidad de créditos*/
    public int getCreditos() {
        return creditos;
    }

    /*Establece la cantidad de créditos del curso.*/
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    /*Obtiene el profesor asignado al curso.
    @return profesor del curso*/
    public Profesor getProfesor() {
        return profesor;
    }

    /*Establece el profesor del curso.*/
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /*Obtiene las inscripciones del curso.
    @return lista de inscripciones*/
    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    /*Obtiene los horarios del curso.
    @return lista de horarios*/
    public ArrayList<Horario> getHorarios() {
        return horarios;
    }
}
