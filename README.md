# fixnow-microservice

Este proyecto consta de un microservicio desarrollado en Java utilizando spring boot, enfocado en la gestion de incidencias. Permite realizar operaciones básicas mediante endpoints REST


# Tecnologias usadas
- Java 21
- Spring Boot
- Maven
- Git y GitHub
- Github Actions


# Ejecución del proyecto

Para ejecutar el microservicio se utiliza el siguiente comando:

mvn spring-boot:run


# Uso de ramas

Se utilizo el modelo de ramas GitFlow para organizar el desarrollo del proyecto

- main: contiene una version estable del proyecto
- develop: rama de integración de cambios
- feature: desarrollo de nuevas funcionalidades
- hotfix: corrección de errores

Este tipo de modelo permite tener un flujo de trabajo ordenado y facilitando la colaboracion del código


# Flujo de trabajo

El desarrollo se realizo mediante un flujo colaborativo utilizando git

1. Creacion de ramas feature desde develop
2. Implementacion de cambios
3. Registro de commits con mensajes descriptivos
4. Envío de cambios al repositorio remoto
5. Creacion de Pull Requests
6. Revisión e integración de cambios

Durante el desarrollo se resolvieron conflictos de merge al integrar cambios entre ramas, asegurando la correcta unificación del código.


# Funcionalidades

- Endpoint de prueba (/test)
- Endpoint de estado (/status)
- Validaciones en la creación de incidencias
- Corrección de errores mediante hotfix


# Convenciones

## Commits
- feat: nuevas funcionalidades
- fix: corrección de errores
- ci: integración continua
- docs: documentación
- chore: mantenimiento

## Naming de ramas
- feature/nombre-funcionalidad
- hotfix/nombre-error


# Integración continua

Se implementó un pipeline de integración continua utilizando GitHub Actions.

Este se ejecuta automáticamente en:
- push a la rama develop
- pull request hacia main

El pipeline realiza la compilación del proyecto mediante Maven, permitiendo validar la integridad del código antes de su integración.


# Estructura del proyecto

- controller: manejo de endpoints
- service: lógica de negocio
- model: entidades
- repository: acceso a datos


# Utilizacion de IA

Se utilizó ChatGPT como herramienta de apoyo para la resolución de errores, mejora en la redacción y comprensión del uso de Git.
