package Logica;

public class Casilla {
    int posFila;
    int posColumna;
    int numMinasCercanas;
    private boolean abierta;
    
    //Constructores
    public Casilla() {
    }

    public Casilla(int posFila, int posColumna) {
        this.posFila = posFila;
        this.posColumna = posColumna;
    }
  
    public Casilla(int posFila, int posColumna, boolean mina) {
        this.posFila = posFila;
        this.posColumna = posColumna;
        this.mina = mina;
    }
    

    //Metodos Setter & Getter
    private boolean mina;

    public int getPosFila() {
        return posFila;
    }

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getPosColumna() {
        return posColumna;
    }

    public void setPosColumna(int posColumna) {
        this.posColumna = posColumna;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public int getNumMinasCercanas() {
        return numMinasCercanas;
    }

    public void setNumMinasCercanas(int numMinasCercanas) {
        this.numMinasCercanas = numMinasCercanas;
    }
    
    public void incrementarNumMinasCercanas(){
        this.numMinasCercanas++;
    }
    
     public boolean isAbierta() {
        return abierta;
    }

    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
}
