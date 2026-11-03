package com.mari.cursos.services;

import com.mari.cursos.domain.models.Estudiante;
import com.mari.cursos.repositories.EstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de gestionar la lógica de negocio de los estudiantes.
 * Proporciona operaciones CRUD básicas sobre la entidad Estudiante.
 */
@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    /**
     * Obtiene la lista completa de todos los estudiantes registrados.
     *
     * @return lista de estudiantes
     */
    public List<Estudiante> obtenerTodos() {
        return estudianteRepository.findAll();
    }

    /**
     * Busca un estudiante por su identificador.
     *
     * @param id identificador del estudiante
     * @return estudiante encontrado, si existe
     */
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    /**
     * Guarda o actualiza un estudiante en la base de datos.
     *
     * @param estudiante estudiante a guardar
     * @return estudiante persistido
     */
    public Estudiante guardar(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    /**
     * Elimina un estudiante por su identificador.
     *
     * @param id identificador del estudiante
     */
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}
