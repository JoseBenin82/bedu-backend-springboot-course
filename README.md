## Curso Backend con Spring Boot

Este repositorio contiene los ejercicios y proyectos desarrollados a lo largo del **módulo 5** del curso de backend con **Spring Boot** (Java).  
Cada carpeta de sesión incluye un proyecto Gradle independiente, con su propia configuración y código fuente.

### Estructura general

- **`sesion_2/primerproyecto`**  
  Proyecto de introducción a Spring Boot:
  - Configuración básica de un proyecto con Gradle.
  - Uso de `@RestController` y `@RequestMapping`.
  - Endpoints simples que regresan cadenas de texto, por ejemplo:
    - `GET /hello` → `"hello world "`
    - `GET /mundo` → `"Goodbye World"`

- **`sesion_3/tipoCambio`**  
  API sencilla para **tipo de cambio** entre divisas:
  - Modelo `TipoCambio` y una “base de datos” en memoria con conversiones predefinidas (USD, MXN, ARS).
  - Ejemplos de paso de parámetros con:
    - `@PathVariable` (segmentos de la URL).
    - `@RequestParam` (query string).
  - Endpoints principales:
    - `GET /conversiones/{codigo}`: devuelve todas las conversiones disponibles para una moneda.
    - `GET /conversiones/{codigo}/convertir/{destino}?cantidad=NN`: convierte una cantidad específica entre dos monedas.

- **`sesion_4/games`**  
  API tipo **CRUD** para administrar videojuegos:
  - Modelo `Game` y una lista en memoria que simula una base de datos.
  - Ejemplos de operaciones CRUD:
    - `GET /getAllGames`: obtiene todos los juegos.
    - `GET /getGameById/{id}`: obtiene un juego por ID.
    - `POST /createGame`: crea un nuevo juego usando `@RequestBody`.
    - `PUT/POST /updateGame/{id}`: actualiza parcialmente un juego.
    - `DELETE /deleteGame/{id}`: elimina un juego por ID.
  - Reforzamiento de conceptos como `@RestController`, `@RequestBody`, `@PathVariable` y manejo de listas en memoria.

- **`sesion_5/netflix`**  
  API estilo **Netflix** para administrar películas:
  - Modelo `Movie` y capa de servicio `MovieService`.
  - Ejemplo de inyección de dependencias con `@Autowired` e inversión de control (IoC).
  - Endpoints REST usando buenas prácticas:
    - `GET /movies`: obtiene todas las películas.
    - `GET /movies/{id}`: obtiene una película por ID.
    - `POST /movies`: crea una nueva película.
  - Discusión sobre diseño de APIs REST:
    - Uso correcto de verbos HTTP (GET, POST, PUT, DELETE).
    - Nomenclatura de endpoints con sustantivos en plural.
    - Representación de jerarquías en las URLs.

### Requisitos previos

- **Java JDK** 17 (o la versión requerida por los proyectos).
- **Gradle** (opcional, los proyectos incluyen `gradlew` y `gradlew.bat` para usar el wrapper).
- Un IDE como IntelliJ IDEA, VS Code o Eclipse (con soporte para proyectos Gradle y Spring Boot).

### Cómo ejecutar cada proyecto

1. Abrir una terminal en la carpeta del proyecto de la sesión, por ejemplo:
   - `sesion_2/primerproyecto`
   - `sesion_3/tipoCambio`
   - `sesion_4/games`
   - `sesion_5/netflix`
2. Ejecutar con el wrapper de Gradle:
   - En Windows:
     - `gradlew bootRun`
   - En Linux/Mac:
     - `./gradlew bootRun`
3. Abrir el navegador o una herramienta como Postman/Insomnia y probar los endpoints en:
   - `http://localhost:8080/...`

### Objetivo del módulo

El objetivo de este módulo es que el estudiante:

- Comprenda la **estructura básica** de un proyecto Spring Boot con Gradle.
- Domine la creación de **endpoints REST** y el uso de anotaciones fundamentales (`@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PathVariable`, `@RequestParam`, `@RequestBody`).
- Practique el diseño de **APIs RESTful** siguiendo buenas prácticas.
- Implemente pequeños servicios backend (tipo de cambio, CRUD de videojuegos, catálogo de películas) que sirvan como base para proyectos más complejos.

Cada sesión está pensada para construir sobre la anterior, incrementando gradualmente la complejidad y profundizando en los conceptos de desarrollo backend con Spring Boot.

