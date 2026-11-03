package com.mari.cursos.domain.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * Representa una persona dentro del sistema de gestión de cursos.
 * Contiene los datos personales que comparten estudiantes y profesores.
 *
 * @author Maria
 * @version 1.0
 */
@MappedSuperclass
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;
    private String apellido;
    private String documento;
    private String correo;

    /**
     * Constructor vacío requerido por JPA.
     */
    protected Persona() {
    }

    /**
     * Crea una persona con sus datos básicos.
     *
     * @param nombre nombre de la persona
     * @param apellido apellido de la persona
     * @param documento documento de identidad
     * @param correo correo electrónico
     */
    public Persona(String nombre, String apellido, String documento, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
    }

    /**
     * Obtiene el identificador de la persona.
     *
     * @return identificador único
     */
    public Long getIdPersona() {
        return idPersona;
    }

    /**
     * Obtiene el identificador de la persona en el formato usado por la capa de servicio/pruebas.
     *
     * @return identificador único
     */
    public Long getId() {
        return idPersona;
    }

    /**
     * Establece el identificador de la persona.
     *
     * @param idPersona identificador único
     */
    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Establece el identificador de la persona.
     *
     * @param idPersona identificador único
     */
    public void setId(Long idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     *
     * @return apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     *
     * @param apellido apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el documento de identidad de la persona.
     *
     * @return documento de identidad
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Establece el documento de identidad de la persona.
     *
     * @param documento documento de identidad
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return correo electrónico
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return correo electrónico
     */
    public String getEmail() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo correo electrónico
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param correo correo electrónico
     */
    public void setEmail(String correo) {
        this.correo = correo;
    }
}

