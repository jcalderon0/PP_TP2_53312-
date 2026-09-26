# Sistema de Gestión de Eventos Universitarios

Este proyecto es una aplicación de consola desarrollada en Java que permite gestionar eventos universitarios, sus actividades asociadas, la inscripción de estudiantes, la emisión de certificados y la generación y envío concurrente de tickets de acceso. 

El desarrollo aplica conceptos avanzados de Programación Orientada a Objetos (POO), manejo de excepciones, colecciones genéricas, serialización de archivos y programación multihilo (concurrencia).

## 🚀 Características Principales

*   **Gestión de Eventos:** Creación de eventos universitarios con asignación de salas y cálculo de costos estimados.
*   **Tipos de Actividades:** Soporte para Charlas, Talleres y Cursos, cada uno con lógicas específicas de costos y requerimientos.
*   **Inscripciones y Control de Cupos:** Registro de estudiantes en actividades con validación de cupo máximo (lanzamiento de excepción personalizada `CupoExcedidoException`).
*   **Emisión de Certificados:** Implementación de la interfaz `Certificable` para Talleres y Cursos, permitiendo generar certificados para los estudiantes inscritos.
*   **Persistencia de Datos:** Guardado y recuperación del estado de los eventos mediante serialización de archivos (`.dat`) utilizando `ObjectOutputStream` y `ObjectInputStream` con el patrón *try-with-resources*.
*   **Concurrencia (Ejercicio 4):** 
    *   Modelado de tickets como **clase anidada miembro** dentro de `Inscripcion`.
    *   Proceso de envío de tickets ejecutado en un **hilo secundario independiente** (`EnvioTicketsThread`), permitiendo que el hilo principal continúe mostrando información por consola sin interrupciones.
*   **Polimorfismo y Genéricos:** Uso de métodos abstractos y métodos parametrizados acotados (ej. `filtrarActividadesPorTipo(Class<T> tipo)` y `calcularCostoMateriales(List<? extends Actividad>)`).

## 🛠️ Tecnologías Utilizadas

*   **Lenguaje:** Java 17 (GraalVM JDK 17.0.12)
*   **Entorno de Desarrollo:** IntelliJ IDEA
*   **Paradigma:** Programación Orientada a Objetos (POO) y Programación Multihilo.

## 📁 Estructura del Proyecto

```text
src/
├── App.java                          # Clase principal, punto de entrada y menú por consola.
├── excepciones/
│   └── CupoExcedidoException.java    # Excepción personalizada para control de cupos.
├── hilos/
│   └── EnvioTicketsThread.java       # Hilo encargado del envío concurrente de tickets.
├── modelo/
│   ├── Estudiante.java               # Datos del estudiante.
│   ├── EventoUniversitario.java      # Entidad principal que compone Sala y Actividades.
│   ├── Inscripcion.java              # Vincula Estudiante y Actividad. Contiene TicketDeAcceso.
│   └── Sala.java                     # Lugar físico donde se realiza el evento.
├── modelo/actividades/
│   ├── Actividad.java                # Clase abstracta base para Charla, Curso y Taller.
│   ├── Charla.java                   # Actividad con disertante (sin costo de materiales).
│   ├── Curso.java                    # Actividad con nivel (implementa Certificable).
│   └── Taller.java                   # Actividad con requerimiento de Notebook (implementa Certificable).
└── modelo/certificacion/
    └── Certificable.java             # Interfaz para la generación de certificados.
