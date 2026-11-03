# Manual de usuario y manual técnico

## 1. Información general

El proyecto **Sistema de Gestión de Cursos** es una aplicación académica desarrollada con Java y Spring Boot. Su funcionalidad REST disponible permite registrar, consultar y listar estudiantes. También contiene modelos para cursos, profesores, horarios, inscripciones y calificaciones, aunque estos todavía no cuentan con operaciones REST implementadas.

## 2. Requisitos

- Java 25.
- Maven (se puede usar el Maven Wrapper incluido).
- Un cliente HTTP, como Postman, Insomnia o `curl`, para probar la API.
- Visual Studio Code u otro editor Java (opcional).

## 3. Instalación y ejecución

1. Descargue o clone el repositorio y abra la carpeta raíz, donde se encuentran `pom.xml` y `mvnw.cmd`.
2. Compruebe que Java esté disponible:

   ```powershell
   java -version
   ```

3. En PowerShell, ejecute la aplicación:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

   La configuración no especifica otro puerto, por lo que Spring Boot usa el puerto `8080`.

4. Mantenga abierta la terminal mientras usa la aplicación. Para detenerla, presione `Ctrl+C`.

La primera ejecución puede tardar mientras Maven descarga las dependencias.

## 4. Manual de usuario

### 4.1 API de estudiantes

La API base es `http://localhost:8080/api/estudiantes`. Los datos se envían y reciben en formato JSON.

| Operación | Método y ruta | Resultado |
|---|---|---|
| Listar estudiantes | `GET /api/estudiantes` | Devuelve la lista de estudiantes; si no hay registros, devuelve una lista vacía. |
| Consultar por identificador | `GET /api/estudiantes/{id}` | Devuelve el estudiante si existe; de lo contrario, responde `404 Not Found`. |
| Registrar estudiante | `POST /api/estudiantes` | Guarda el estudiante recibido y devuelve el registro guardado. |

#### Registrar un estudiante

Envíe una solicitud `POST` a `http://localhost:8080/api/estudiantes` con el encabezado `Content-Type: application/json`. Por ejemplo:

```json
{
  "nombre": "Maria Lopez",
  "apellido": "Lopez",
  "documento": "3001234567",
  "correo": "maria@example.com",
  "codigoEstudiante": "EST-001",
  "semestre": 1
}
```

Ejemplo con `curl` en PowerShell:

```powershell
curl.exe -X POST "http://localhost:8080/api/estudiantes" `
  -H "Content-Type: application/json" `
  -d '{"nombre":"Maria Lopez","apellido":"Lopez","documento":"3001234567","correo":"maria@example.com","codigoEstudiante":"EST-001","semestre":1}'
```

La base de datos asigna el identificador al guardar. Use el identificador devuelto para consultar el registro:

```text
GET http://localhost:8080/api/estudiantes/1
```

Para listar todos los registros:

```text
GET http://localhost:8080/api/estudiantes
```

### 4.2 Alcance disponible

- La API no ofrece actualmente una operación HTTP para eliminar o actualizar estudiantes, aunque el servicio interno tiene un método de eliminación.
- No hay endpoints REST para profesores, cursos, horarios, inscripciones ni calificaciones.
- Los métodos de algunas clases de dominio solo imprimen mensajes de ejemplo; no representan operaciones persistentes.

## 5. Base de datos H2

La aplicación usa H2 en memoria con la URL JDBC `jdbc:h2:mem:cursosdb`. La consola web está habilitada en:

```text
http://localhost:8080/h2-console
```

Use estos datos para conectarse:

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:cursosdb` |
| User Name | `sa` |
| Password | (vacío) |

La base de datos es temporal: los registros se pierden al detener la aplicación. La configuración JPA usa `ddl-auto=update` y muestra las consultas SQL en la salida de la aplicación.

## 6. Manual técnico

### 6.1 Tecnologías

- Java 25.
- Spring Boot 4.1.1.
- Spring Web MVC para la API REST.
- Spring Data JPA y Hibernate para persistencia.
- H2 como base de datos en memoria.
- Maven y Maven Wrapper para compilar y ejecutar.
- JUnit y Spring Boot Test para pruebas.
- Lombok está declarado como dependencia opcional.

### 6.2 Organización del código

```text
src/
├── main/
│   ├── java/com/mari/cursos/
│   │   ├── CursosApplication.java
│   │   ├── controllers/       # Controladores REST
│   │   ├── domain/models/     # Entidades y modelos del dominio
│   │   ├── repositories/      # Repositorios Spring Data JPA
│   │   └── services/          # Lógica de negocio
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/mari/cursos/  # Pruebas automatizadas
```

### 6.3 Flujo de una solicitud

Para las operaciones de estudiantes, el flujo es:

1. `EstudianteController` recibe la solicitud HTTP en `/api/estudiantes`.
2. `EstudianteService` coordina la operación.
3. `EstudianteRepository`, que extiende `JpaRepository<Estudiante, Long>`, accede a los datos mediante JPA.
4. Spring/Hibernate persiste o consulta la entidad `Estudiante` en H2.

La entidad `Estudiante` hereda los datos personales de `Persona`. La clave primaria se declara en `Persona` y se genera mediante la estrategia `IDENTITY`.

### 6.4 Configuración

Los parámetros principales están en `src/main/resources/application.properties`:

- Nombre de la aplicación: `cursos`.
- URL de H2 en memoria: `jdbc:h2:mem:cursosdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`.
- Consola H2: habilitada en `/h2-console`.
- Dialecto: H2.
- Actualización del esquema: `spring.jpa.hibernate.ddl-auto=update`.
- Registro SQL y formato de SQL: habilitados.

No se configure esta consola ni credenciales de desarrollo para exponer la aplicación en un entorno público sin revisar primero la seguridad y la configuración de producción.

### 6.5 Compilación y pruebas

Desde la carpeta raíz del proyecto:

```powershell
# Ejecutar las pruebas
.\mvnw.cmd test

# Empaquetar la aplicación
.\mvnw.cmd package
```

Las pruebas existentes verifican que el contexto Spring cargue y que el servicio de estudiantes pueda guardar, listar, buscar y eliminar registros en H2. Las pruebas del servicio se ejecutan con transacción para revertir los cambios al terminar cada prueba.

Para limpiar y compilar desde cero:

```powershell
.\mvnw.cmd clean package
```

Si `clean` falla al eliminar archivos dentro de `target`, puede haber un proceso que los mantiene abiertos (por ejemplo, una ejecución de la aplicación o una herramienta del IDE) o una sincronización de archivos en curso. Detenga la aplicación, espere a que la sincronización termine y vuelva a intentarlo. No elimine procesos sin identificar primero qué los está usando.

## 7. Mantenimiento y extensiones

Para añadir una nueva operación, siga la separación existente entre controlador, servicio y repositorio. Antes de exponer nuevas entidades, defina sus relaciones JPA, validaciones de entrada y respuestas HTTP. Añada pruebas automatizadas para los nuevos casos.

Como mejoras futuras se pueden considerar:

- Endpoints para actualizar y eliminar estudiantes.
- Endpoints y servicios para cursos, profesores, horarios, inscripciones y calificaciones.
- Validaciones de datos y manejo uniforme de errores.
- Persistencia en una base de datos no volátil para conservar información entre ejecuciones.
- Configuración separada para desarrollo y producción.
