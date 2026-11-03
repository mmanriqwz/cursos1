
package com.mari.cursos.domain.models;

/*Representa el horario de un curso.
Contiene el día, la hora de inicio, la hora de finalización
y el aula donde se desarrolla la clase.*/
public class Horario {

    private int idHorario;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private String aula;

    /*Permite consultar la información del horario.
     */
    public void consultarHorario() {
        System.out.println("Consultando horario...");
    }

    /*Permite modificar el horario.
     */
    public void modificarHorario() {
        System.out.println("Horario modificado.");
    }

    /*Obtiene el identificador del horario.
    @return identificador del horario*/
    public int getIdHorario() {
        return idHorario;
    }

    /*Establece el identificador del horario.*/
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    /*Obtiene el día de la clase.
    @return día programado*/
    public String getDia() {
        return dia;
    }

    /*Establece el día de la clase.*/
    public void setDia(String dia) {
        this.dia = dia;
    }

    /*Obtiene la hora de inicio.
    @return hora de inicio */
    public String getHoraInicio() {
        return horaInicio;
    }

    /*Establece la hora de inicio.*/
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    /*Obtiene la hora de finalización.
    @return hora de finalización */
    public String getHoraFin() {
        return horaFin;
    }

    /*Establece la hora de finalización.*/
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    /*Obtiene el aula asignada.
    @return aula de la clase*/
    public String getAula() {
        return aula;
    }

    /*Establece el aula de la clase.*/
    public void setAula(String aula) {
        this.aula = aula;
    }
}
