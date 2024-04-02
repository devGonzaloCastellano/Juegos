package Logica;

import IGU.Juego;

public class Dificultad {
    
    private int numFilas;
    private int numColumnas;
    private int numMinas;
    private int anchoControl;
    private int altoControl;
    
    //Constructores
    public Dificultad(){
        
    }

    public Dificultad(int numFilas, int numColumnas, int numMinas, int anchoControl, int altoControl) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.anchoControl = anchoControl;
        this.altoControl = altoControl;
    }

    
    //Metodos Get
    public int getNumFilas() {
        return numFilas;
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    public int getNumMinas() {
        return numMinas;
    }

    public int getAnchoControl() {
        return anchoControl;
    }

    public int getAltoControl() {
        return altoControl;
    }
    
     //Aplica la dificultad asignada
     public void aplicarDificultad(Juego juego) {
        juego.setNumFilas(numFilas);
        juego.setNumColumnas(numColumnas);
        juego.setNumMinas(numMinas);
        juego.setAnchoControl(anchoControl);
        juego.setAltoControl(altoControl);
        juego.JuegoNuevo();
    }
            
            
}
