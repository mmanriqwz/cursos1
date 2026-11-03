package com.mari.cursos.domain.models;

/*Representa una calificación asociada a un estudiante
y a su inscripción en un curso.*/
public class Calificacion {

    private int idCalificacion;
    private double nota;
    private String periodo;

    /*Registra una nota.
     */
    public void registrarNota() {
        System.out.println("Nota registrada.");
    }

    /*Modifica una nota.
     */
    public void modificarNota() {
        System.out.println("Nota modificada.");
    }

    /*Consulta la nota registrada.
    @return valor de la nota*/
    public double consultarNota() {
        return nota;
    }

    /*Obtiene el identificador de la calificación.
    @return identificador de la calificación*/
    public int getIdCalificacion() {
        return idCalificacion;
    }

    /*Establece el identificador de la calificación.*/
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    /*Obtiene la nota.
    @return nota registrada */
    public double getNota() {
        return nota;
    }

    /*Establece la nota.*/
    public void setNota(double nota) {
        this.nota = nota;
    }

    /*Obtiene el periodo académico.
    @return periodo de la calificación*/
    public String getPeriodo() {
        return periodo;
    }

    /*Establece el periodo académico.*/
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
