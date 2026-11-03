package com.mari.cursos.services;

import com.mari.cursos.domain.models.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de integración del servicio de estudiantes.
 * Se ejecutan contra H2 y cada prueba se revierte al finalizar.
 */
@SpringBootTest
@Transactional
public class EstudianteServiceTest {

    @Autowired
    private EstudianteService estudianteService;

    private Estudiante estudiantePrueba;

    @BeforeEach
    void setUp() {
        estudiantePrueba = new Estudiante("Maria Lopez", "maria@gmail.com", "3001234567", "EST-001");
    }

    @Test
    @DisplayName("Debe guardar un estudiante correctamente en la BD H2")
    void testGuardarEstudiante() {
        // Act
        Estudiante guardado = estudianteService.guardar(estudiantePrueba);

        // Assert
        assertNotNull(guardado.getId(), "El ID no debería ser nulo tras guardarlo en H2");
        assertEquals("Maria Lopez", guardado.getNombre());
        assertEquals("EST-001", guardado.getCodigoEstudiante());
    }

    @Test
    @DisplayName("Debe listar todos los estudiantes registrados")
    void testObtenerTodos() {
        // Arrange
        estudianteService.guardar(estudiantePrueba);

        // Act
        List<Estudiante> lista = estudianteService.obtenerTodos();

        // Assert
        assertFalse(lista.isEmpty(), "La lista de estudiantes no debería estar vacía");
        assertTrue(lista.stream().anyMatch(e -> e.getCodigoEstudiante().equals("EST-001")));
    }

    @Test
    @DisplayName("Debe buscar un estudiante por su ID")
    void testObtenerPorId() {
        // Arrange
        Estudiante guardado = estudianteService.guardar(estudiantePrueba);

        // Act
        Optional<Estudiante> resultado = estudianteService.obtenerPorId(guardado.getId());

        // Assert
        assertTrue(resultado.isPresent(), "El estudiante debería ser encontrado");
        assertEquals("maria@gmail.com", resultado.get().getEmail());
    }

    @Test
    @DisplayName("Debe eliminar un estudiante por su ID")
    void testEliminarEstudiante() {
        // Arrange
        Estudiante guardado = estudianteService.guardar(estudiantePrueba);
        Long id = guardado.getId();

        // Act
        estudianteService.eliminar(id);
        Optional<Estudiante> eliminado = estudianteService.obtenerPorId(id);

        // Assert
        assertTrue(eliminado.isEmpty(), "El estudiante ya no debería existir en la BD");
    }
}