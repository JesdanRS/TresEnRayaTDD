# TresEnRayaTDD
Proyecto de Tres en Raya implementado con metodología TDD (Test-Driven Development) en Java

## Estructura del Proyecto

El proyecto sigue la estructura estándar de Maven:

```
TresEnRayaTDD/
├── .github/
│   └── workflows/
│       └── maven.yml      # Configuración de CI/CD con GitHub Actions
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               └── tresenraya/
│   │                   └── ...     # Clases principales del juego
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   └── tresenraya/
│                       └── ...     # Clases de prueba
└── pom.xml              # Configuración de Maven y dependencias
```

## Tecnologías Utilizadas

- Java 11
- JUnit 5.8.2 para pruebas unitarias
- Maven para gestión de dependencias
- GitHub Actions para CI/CD

## Cómo Empezar

### Requisitos Previos

- JDK 11 o superior
- Maven 3.6 o superior

### Compilación

```bash
mvn clean compile
```

### Ejecución de Pruebas

```bash
mvn test
```

### Empaquetado

```bash
mvn package
```

## Desarrollo con TDD

Este proyecto sigue la metodología TDD (Test-Driven Development), que consiste en:

1. Escribir una prueba que falle
2. Implementar el código mínimo para que la prueba pase
3. Refactorizar el código manteniendo las pruebas en verde

## Integración Continua

El proyecto está configurado con GitHub Actions para ejecutar automáticamente las pruebas en cada push o pull request a la rama main.
