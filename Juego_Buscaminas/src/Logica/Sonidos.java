package Logica;

import java.io.InputStream;
import javazoom.jl.player.Player;

public class Sonidos {

    boolean sonidosActivados = true;
    
    public static void reproducir(String filePath) {
        try {
            // Obtener el flujo de entrada del recurso
            InputStream inputStream = Sonidos.class.getResourceAsStream(filePath);
            if (inputStream != null) {
                // Crear un nuevo reproductor a partir del flujo de entrada
                Player player = new Player(inputStream);
                player.play();
            } else {
                // El recurso no pudo ser encontrado
                System.err.println("Error: Archivo no encontrado: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("Error al reproducir el archivo de sonido: " + e);
            e.printStackTrace();
        }
    }

    public void Estallido() {
        reproducir("/sound/explosion.mp3");
    }

    public void GameOver() {
        reproducir("/sound/lose.mp3");
    }

    public void Win() {
        reproducir("/sound/win.mp3");

    }

    public void setSonidosActivados(boolean sonidosActivados) {
        this.sonidosActivados = sonidosActivados;
    }

    
}
