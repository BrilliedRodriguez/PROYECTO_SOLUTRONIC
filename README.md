# Proyecto CRUD de Personas y Empresas 📋 🔨

## Descripción del Proyecto
📝 Este proyecto se centra en el desarrollo de un módulo de gestión de personas y empresas. En este sistema, una empresa puede estar asociada a una persona  que actúan como representantes de la misma. La implementación sigue el patrón de diseño **Modelo Vista Controlador (MVC)** para estructurar el código de manera modular y mantener una separación clara de responsabilidades.

## Características Principales
- **Gestión de Personas**: Permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades de personas, incluyendo campos como nombre, apellido, dirección, entre otros.
- **Gestión de Empresas**: Proporciona funcionalidades CRUD para manejar entidades de empresas.
- **Asociación Empresa-Persona**: Permite asociar una persona como representantes de una empresa, estableciendo así una relación entre las dos entidades.

## Tecnologías Utilizadas
- **Spring Boot**: Framework de desarrollo de aplicaciones basado en Java que simplifica la configuración y el desarrollo de aplicaciones empresariales.
- **Thymeleaf**: Motor de plantillas Java para crear vistas HTML en aplicaciones web, facilitando la integración de datos del backend en las páginas web.
- **MySQL**: Sistema de gestión de bases de datos relacional utilizado para almacenar y recuperar datos de personas, empresas y relaciones entre ellas.

## Configuración de la Base de Datos
- **Nombre de la Base de Datos**: SOLUTRONIC
- Se utilizará MySQL como el sistema de gestión de bases de datos. Asegúrate de tener MySQL instalado y configurado en tu entorno de desarrollo.

## Ejecución del Proyecto
1. **Clona el repositorio desde GitHub**: `git clone <url-del-repositorio>`
2. **Importa el proyecto en tu IDE preferido**.
3. **Configura la conexión a la base de datos** en el archivo `application.properties`, asegurándote de especificar correctamente la URL, el nombre de usuario y la contraseña de tu instancia de MySQL.


