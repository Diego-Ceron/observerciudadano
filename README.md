# Sistema de Votación Ciudadana - Patrón Observer

Sistema de mensajería para notificar a ciudadanos sobre proyectos de votación utilizando el patrón de diseño Observer con polimorfismo.

## 📋 Descripción

Este sistema envía notificaciones de votación a ciudadanos de diferentes distritos. Implementa el patrón Observer con polimorfismo para distinguir entre:

- **Proyectos de Distrito**: Solo los ciudadanos del distrito específico reciben notificaciones
- **Proyectos Corredor**: Todos los ciudadanos de todos los distritos reciben notificaciones

## 🏗️ Arquitectura

### Estructura MVC

```
observerciudadano/
├── src/
│   ├── modelo/              (Modelo - Lógica de negocio)
│   │   ├── Observer.java    - Interfaz Observer
│   │   ├── Subject.java     - Interfaz Subject
│   │   ├── Proyecto.java    - Clase abstracta base
│   │   ├── Distrito.java    - Proyectos de distrito
│   │   ├── Corredor.java    - Proyectos corredor
│   │   └── Ciudadano.java   - Observador (ciudadano)
│   │
│   ├── controlador/         (Controlador - Gestión de flujo)
│   │   └── SistemaMensajeria.java - Coordina notificaciones
│   │
│   ├── vista/               (Vista - Presentación)
│   │   └── VistaConsola.java - Interfaz de consola
│   │
│   └── Main.java            - Punto de entrada
│
├── bin/                     (Archivos .class compilados)
└── README.md
```

### Patrón Observer
- **Subject**: `SistemaMensajeria` - Gestiona la lista de observadores y notificaciones
- **Observer**: `Ciudadano` - Recibe y procesa notificaciones según su distrito
- **Polimorfismo**: Los proyectos implementan `debeNotificar()` de forma diferente

### Jerarquía de Clases

```
Observer (interface)
    └── Ciudadano

Subject (interface)
    └── SistemaMensajeria

Proyecto (abstract)
    ├── Distrito
    └── Corredor
```

## 📦 Componentes del Proyecto

### Modelo (`src/modelo/`)
- `Observer.java` - Interfaz del patrón Observer
- `Subject.java` - Interfaz del Subject
- `Proyecto.java` - Clase abstracta base para proyectos
- `Distrito.java` - Proyectos específicos de distrito
- `Corredor.java` - Proyectos para todos los distritos
- `Ciudadano.java` - Implementación del Observer

### Controlador (`src/controlador/`)
- `SistemaMensajeria.java` - Gestiona notificaciones y observadores

### Vista (`src/vista/`)
- `VistaConsola.java` - Presenta información en consola

### Principal
- `Main.java` - Punto de entrada y demostración

## 🎯 Polimorfismo en Acción

El polimorfismo se aplica en dos niveles:

1. **En Proyecto.debeNotificar()**:
   - `Distrito`: Retorna `true` solo si el distrito coincide
   - `Corredor`: Siempre retorna `true` (para todos)

2. **En Ciudadano.actualizar()**:
   - Usa el método polimórfico del proyecto para decidir si procesar la notificación
   - Cada ciudadano filtra automáticamente según su distrito

## 🚀 Compilación y Ejecución

### Compilar el proyecto

```cmd
javac -d bin -encoding UTF-8 src\modelo\*.java src\controlador\*.java src\vista\*.java src\Main.java
```

### Ejecutar el programa

```cmd
java -cp bin Main
```

## 💡 Ejemplo de Uso

```java
import modelo.*;
import controlador.*;
import vista.*;
import java.util.ArrayList;
import java.util.List;

// Crear componentes MVC
VistaConsola vista = new VistaConsola();
SistemaMensajeria sistema = new SistemaMensajeria();

// Crear ciudadanos de diferentes distritos
List<Ciudadano> ciudadanos = new ArrayList<>();
ciudadanos.add(new Ciudadano("Juan Pérez", "1", "juan.perez@email.com"));
ciudadanos.add(new Ciudadano("María García", "1", "maria.garcia@email.com"));
ciudadanos.add(new Ciudadano("Carlos López", "2", "carlos.lopez@email.com"));
ciudadanos.add(new Ciudadano("Ana Martínez", "2", "ana.martinez@email.com"));

// Registrar todos los ciudadanos
sistema.registrarCiudadanos(ciudadanos);

// Añadir proyectos a la convocatoria
// Proyecto de Distrito 1 - Solo para ciudadanos del Distrito 1
Proyecto proyectoDistrito1 = new Distrito(
    "Parque Recreativo Distrito 1",
    "Construcción de parque recreativo con áreas verdes",
    "1"
);
sistema.agregarProyectoANotificar(proyectoDistrito1);

// Proyecto de Distrito 2 - Solo para ciudadanos del Distrito 2
Proyecto proyectoDistrito2 = new Distrito(
    "Biblioteca Municipal Distrito 2",
    "Remodelación y ampliación de la biblioteca municipal",
    "2"
);
sistema.agregarProyectoANotificar(proyectoDistrito2);

// Proyecto Corredor - Para TODOS los ciudadanos
Proyecto corredor = new Corredor(
    "Corredor Verde Metropolitano",
    "Creación de corredor verde que conecta todos los distritos"
);
sistema.agregarProyectoANotificar(corredor);

// Enviar todas las convocatorias - Cada ciudadano recibe sus proyectos
sistema.enviarConvocatorias();
```

**Resultado**: 
- Juan y María reciben: 1 proyecto del Distrito 1 + 1 proyecto Corredor
- Carlos y Ana reciben: 1 proyecto del Distrito 2 + 1 proyecto Corredor

## 📬 Cómo Funciona el Sistema de Notificaciones

### Flujo de Notificación

1. **Registro de Ciudadanos**
   - Cada ciudadano se registra en el `SistemaMensajeria` con su nombre, distrito y email
   - El sistema mantiene una lista de todos los ciudadanos observadores

2. **Acumulación de Proyectos**
   - Los proyectos se añaden al sistema mediante `agregarProyectoANotificar()`
   - Pueden ser proyectos de **Distrito** (específicos) o **Corredor** (globales)
   - Todos los proyectos se acumulan antes de enviar las notificaciones

3. **Envío de Convocatorias**
   - Al llamar `enviarConvocatorias()`, el sistema notifica a todos los ciudadanos
   - Cada ciudadano recibe **todos los proyectos** y decide cuáles le corresponden

4. **Filtrado Polimórfico**
   - **Proyectos Distrito**: El método `debeNotificar()` compara el distrito del proyecto con el del ciudadano
   - **Proyectos Corredor**: El método `debeNotificar()` siempre retorna `true` (notifica a todos)
   - El ciudadano **solo acumula** los proyectos que le corresponden según esta lógica

5. **Presentación de Resultados**
   - Cada ciudadano muestra una notificación consolidada con **todos sus proyectos**:
     - Proyectos de su distrito (si existen)
     - Proyectos corredor (siempre reciben)
   - La notificación incluye: nombre del proyecto, tipo y descripción

### Ejemplo de Notificación

**Ciudadano del Distrito 1** recibirá:
- ✓ Proyectos del Distrito 1
- ✓ Todos los proyectos Corredor

**Ciudadano del Distrito 3** (sin proyectos específicos) recibirá:
- ✗ No recibe proyectos de otros distritos
- ✓ Todos los proyectos Corredor

## 🎯 Patrón Observer

El patrón **Observer** establece una relación **uno-a-muchos** donde un objeto (Subject) notifica automáticamente a múltiples objetos (Observers) cuando su estado cambia.

### Cómo Funciona

```
Subject (SistemaMensajeria)
    │
    ├─ registrarObserver()    → Agrega un observador
    ├─ eliminarObserver()     → Elimina un observador
    └─ notificarObservers()   → Notifica a TODOS
         │
         ├─ Observer1.actualizar()
         ├─ Observer2.actualizar()
         ├─ Observer3.actualizar()
         └─ Observer4.actualizar()
```

### En el Proyecto

1. **SistemaMensajeria** (Subject)
   - Mantiene lista de ciudadanos
   - Acumula proyectos
   - Notifica a todos los ciudadanos

2. **Ciudadano** (Observer)
   - Implementa `actualizar(Proyecto)`
   - Recibe notificaciones automáticamente
   - Filtra proyectos según su distrito

3. **Flujo Completo**
   ```
   agregarProyectoANotificar(proyecto)
        ↓
   enviarConvocatorias()
        ↓
   Notifica a todos: ciudadano.actualizar(proyecto)
        ↓
   Cada ciudadano filtra mediante Proyecto.debeNotificar()
        ↓
   Acumula solo sus proyectos
   ```
