---

# Tiempo Activa

Es una aplicación que registra el tiempo transcurrido desde que la actividad se inició hasta que se pausó. Utiliza la arquitectura de Compose para construir la interfaz de usuario y registra mensajes de depuración para proporcionar información sobre los estados de vida de la actividad.

## Características

- Registra el tiempo transcurrido desde que la actividad se inició hasta que se pausó.
- Utiliza la arquitectura de Compose para la construcción de la interfaz de usuario.
- Muestra mensajes de depuración para los diferentes estados de vida de la actividad.

### Paquete y Declaración de Clase

```kotlin
package com.example.tiempo_activa

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.tiempo_activa.ui.theme.Tiempo_activaTheme

class MainActivity : ComponentActivity() {
```

- Se declara el paquete y se importan las clases necesarias.
- Se declara la clase `MainActivity`, que hereda de `ComponentActivity`.

### Variables de Clase y Método `onCreate()`

```kotlin
// TAG para la etiqueta de depuración
val TAG: String = "Estado" // val es para constantes
// Tiempo de inicio, final y transcurrido
var timeStart: Long = 0
var timeFinish: Long = 0
var timePassed: Long = 0

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    // Establecer el contenido de la actividad con Compose
    setContent {
        Tiempo_activaTheme {
            // Contenedor de superficie utilizando el color de fondo del tema
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                // Llamada a la función Greeting para mostrar un saludo
                Greeting("Android")
            }
        }
    }
}
```

- Se declaran las variables de clase para registrar el tiempo.
- Se sobrescribe el método `onCreate()` para establecer el contenido de la actividad con Compose.

  ![onCreate](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/511d7ca3-b262-4fa3-8cba-10e079aa2244)


## Implementación y Explicación

### Método `onStart()`

El método `onStart()` se llama cuando la actividad está a punto de hacerse visible para el usuario.

```kotlin
// onStart
override fun onStart() {
    super.onStart()
    // Obtener el tiempo de inicio de la actividad
    timeStart = System.currentTimeMillis()
    // Registro de mensaje de depuración
    Log.d(TAG, "He llegado al Start")
}
```

![onStart](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/5cd96bf4-e014-4a4b-b432-04c96f40bee2)

- Se obtiene el tiempo de inicio de la actividad utilizando `System.currentTimeMillis()`.
- Se registra un mensaje de depuración utilizando `Log.d()`.

### Método `onResume()`

El método `onResume()` se llama cuando la actividad va a empezar a interactuar con el usuario.

```kotlin
// onResume
override fun onResume() {
    super.onResume()
    // Registro de mensaje de depuración
    Log.d(TAG, "He llegado al Resume")
    // Actualizar la interfaz de usuario
    updateUI()
}
```
![onResume](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/a04b075d-07c1-4611-b521-58995f7bb20f)

- Se registra un mensaje de depuración utilizando `Log.d()`.
- Se llama al método `updateUI()` para actualizar la interfaz de usuario.

### Método `onPause()`

El método `onPause()` se llama cuando la actividad está a punto de ser detenida por otra actividad.

```kotlin
// onPause
override fun onPause() {
    super.onPause()
    // Obtener el tiempo de finalización de la actividad
    timeFinish = System.currentTimeMillis()
    // Calcular el tiempo transcurrido y agregarlo al tiempo total pasado en la actividad
    timePassed += ((timeFinish - timeStart) * 0.001).toLong()
    // Registro de mensaje de depuración con el tiempo total pasado en la actividad
    Log.d(TAG, "Tiempo que ha estado en ejecucion: $timePassed segundos")
}
```
![OnPauseDEMOSTRACION](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/bc4c45d7-d367-4475-be40-887e5b2609a1)
![onPauseIMG](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/f4d430e6-a77f-4b02-8a34-804ee96337ce)
![onPauseTEXTO](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/333d9191-ddaa-44ad-80f4-16ffbb39e548)

- Se obtiene el tiempo de finalización de la actividad utilizando `System.currentTimeMillis()`.
- Se calcula el tiempo transcurrido y se agrega al tiempo total pasado en la actividad.
- Se registra un mensaje de depuración con el tiempo total pasado en la actividad.

### Método `onStop()`

El método `onStop()` se llama cuando la actividad ya no está visible para el usuario.

```kotlin
// onStop
override fun onStop() {
    super.onStop()
    // Registro de mensaje de depuración
    Log.d(TAG, "Entro en el estado pausado")
}
```
![onStop](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/0eb28a0e-5f18-454f-9cf6-852d6de67eb9)

- Se registra un mensaje de depuración utilizando `Log.d()`.

### Método `onDestroy()`

El método `onDestroy()` se llama antes de que la actividad sea destruida.

```kotlin
// onDestroy
override fun onDestroy() {
    super.onDestroy()
    // Registro de mensaje de depuración
    Log.d(TAG, "Entro en el estado destruido")
}
```
- Se registra un mensaje de depuración utilizando `Log.d()`.
![onDestroy](https://github.com/JorgeGonzalez-castelao/Tiempo_Activa_REC/assets/113522749/f5a95441-d727-4a48-abac-c426166715ee)
---

Este proyecto fue creado por Jorge Gonzalez Ruiz 
