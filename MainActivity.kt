package com.example.tiempo_activa

import android.os.Bundle
import android.util.AndroidException
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.tiempo_activa.ui.theme.Tiempo_activaTheme

class MainActivity : ComponentActivity() {

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

    override fun onStart(){
        super.onStart()
        // Obtener el tiempo de inicio de la actividad
        timeStart=System.currentTimeMillis()
        // Registro de mensaje de depuración
        Log.d(TAG,"He llegado al Start")
    }

    override fun onResume() {
        super.onResume()
        // Registro de mensaje de depuración
        Log.d(TAG,"He llegado al Resume")
        // Actualizar la interfaz de usuario
        updateUI()
    }

    override fun onPause() {
        super.onPause()
        // Obtener el tiempo de finalización de la actividad
        timeFinish=System.currentTimeMillis()
        // Calcular el tiempo transcurrido y agregarlo al tiempo total pasado en la actividad
        timePassed+=((timeFinish-timeStart)*0.001).toLong()
        // Registro de mensaje de depuración con el tiempo total pasado en la actividad
        Log.d(TAG,"Tiempo que ha estado en ejecucion: "+timePassed+" segundos")
    }
    override fun onDestroy() {
        super.onDestroy()
        // Registro de mensaje de depuración
        Log.d(TAG,"Entro en el estado destruido")
    }

    override fun onStop() {
        super.onStop()
        // Registro de mensaje de depuración
        Log.d(TAG,"Entro en el estado pausado")
    }
    // Método para mostrar un mensaje de Toast con el tiempo total pasado en la actividad
    fun updateUI(){
        Toast.makeText(this,"Tiempo de activacion: $timePassed segundos",Toast.LENGTH_SHORT).show()
    }
}

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        // Mostrar un texto de saludo con el nombre proporcionado
        Text(
            text = "Hello, $name",
            modifier = modifier
        )
    }
