# 🏠 Práctica 1 — Sistema de gestión de sensores (Java)

**Asignatura:** Bases de Datos  
**Curso:** 2025–2026  
**Autores:** `Vitor Miranda y Pedro Henrique`

## 📘 Descripción

Aplicación Java para gestionar un sistema de domótica con **viviendas**, **habitaciones** y **sensores**.  
Incluye las operaciones **CRUD** (crear, leer, actualizar y eliminar) de todos los elementos del sistema, además de **guardado y carga** de datos mediante **serialización**.

## 🎯 Objetivos

- Reforzar los conceptos básicos de **Programación Orientada a Objetos en Java**.  
- Establecer relaciones entre clases (herencia y composición).  
- Almacenar información en disco usando **serialización**.  
- Desarrollar una pequeña base de datos **orientada a objetos**.

## ⚙️ Funcionalidad principal

- **Centralita**
  - Alta y baja de viviendas.  
  - Listado de viviendas, habitaciones y sensores.  
  - Añadir y eliminar habitaciones o sensores.  
  - Guardar y cargar datos desde archivo.  

- **Vivienda**
  - Añadir o eliminar habitaciones.  
  - Mostrar información detallada.  

- **Habitación**
  - Alta y baja de sensores.  
  - Listado completo de sensores.  

- **Sensores**
  - Tipos: `SensorPresencia`, `SensorTemperatura`, `SensorMagnético`.  
  - Control de batería (si la batería es 0, lanza excepción).  
  - Validación de límites de temperatura (máx./mín. del fabricante).  

- **Persistencia**
  - Métodos `guardar()` y `cargarDatos()` para serializar todos los objetos.

## 🧩 Estructura del paquete

Todos los archivos deben estar dentro del mismo paquete (por ejemplo, `domotica`):

```
domotica/
│
├── Centralita.java
├── Vivienda.java
├── Habitacion.java
├── Sensor.java
├── SensorPresencia.java
├── SensorTemperatura.java
├── SensorMagnetico.java
├── Main.java
│
├── exceptions/        # (Opcional)
└── data/              # Ficheros serializados
```

## 💻 Ejecución del proyecto

Requisitos: **Java 11 o superior**

```bash
# Compilar
javac -d out src/domotica/*.java

# Ejecutar
java -cp out domotica.Main
```

El programa mostrará un **menú por consola**, que se repite hasta que el usuario introduce `0`.  
Desde este menú se puede gestionar todo el sistema (CRUD + guardar/cargar datos).

## 💾 Persistencia de datos

- `guardar()` → serializa las estructuras de datos (p. ej. `Map<int, Vivienda>`) y las guarda en archivos dentro de `/data`.  
- `cargarDatos()` → recupera el estado anterior del sistema a partir de los archivos serializados.  

📄 *Desarrollado como parte de la asignatura de Bases de Datos (Práctica 1 — Curso 2025/2026).*
