package Logica;

import IGU.Juego;
import IGU.PartidaGanada;
import IGU.PartidaPerdida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.Timer;

public class Tablero {

    Casilla[][] casillas;

    int numFilas;
    int numColumnas;
    int numMinas;

    int numCasillasAbiertas;

    //Crea una lista para guardar todas las minas generadas
    private Consumer<List<Casilla>> eventoPartidaPerdida;
    private Consumer<List<Casilla>> eventoPartidaGanada;
    Consumer<Casilla> eventoCasillaAbierta;
    private Juego juego;
    Sonidos sonido = new Sonidos();

    //Constructores
    public Tablero() {

    }

    public Tablero(int numFilas, int numColumnas, int numMinas, Juego juego) {
        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        this.numMinas = numMinas;
        this.juego = juego;
        InicializarCasillas();

    }

    public void InicializarCasillas() {
        casillas = new Casilla[this.numFilas][this.numColumnas];

        for (int f = 0; f < casillas.length; f++) {
            for (int c = 0; c < casillas.length; c++) {
                casillas[f][c] = new Casilla(f, c);
            }
        }
        GenerarMinas();
    }

    //Genera las minas seleccionadas de forma aleatoria
    private void GenerarMinas() {
        int minasGeneradas = 0;

        while (minasGeneradas != numMinas) {
            int posTMPfila = (int) (Math.random() * casillas.length);
            int posTMPColumna = (int) (Math.random() * casillas[0].length);

            if (!casillas[posTMPfila][posTMPColumna].isMina()) {
                casillas[posTMPfila][posTMPColumna].setMina(true);
                minasGeneradas++;
            }
        }
        actualizarNumMinasCercanas();
    }

    public void actualizarNumMinasCercanas() {
        for (int f = 0; f < casillas.length; f++) {
            for (int c = 0; c < casillas.length; c++) {

                if (casillas[f][c].isMina()) {
                    List<Casilla> casillaCercana = obtenerCasillaCercana(f, c);

                    for (Casilla casilla : casillaCercana) {
                        casilla.incrementarNumMinasCercanas();
                    }
                }
            }
        }
    }

    public List<Casilla> obtenerCasillaCercana(int posFila, int posColumna) {
        List<Casilla> listaCasilla = new LinkedList<>();

        for (int i = 0; i < 8; i++) {
            int temPosFila = posFila;
            int temPosColumna = posColumna;
            switch (i) {
                case 0: //Arriba
                    temPosFila--;
                    break;
                case 1: //ArribaDerecha
                    temPosFila--;
                    temPosColumna++;
                    break;
                case 2: //Derecha
                    temPosColumna++;
                    break;
                case 3: //Derecha abajo
                    temPosColumna++;
                    temPosFila++;
                    break;
                case 4: //Abajo
                    temPosFila++;
                    break;
                case 5://Abajo Izquierda
                    temPosFila++;
                    temPosColumna--;
                    break;
                case 6://Izquierda
                    temPosColumna--;
                    break;
                case 7://Izquierda Arriba
                    temPosFila--;
                    temPosColumna--;
                    break;
            }

            if (temPosFila >= 0 && temPosFila < this.casillas.length
                    && temPosColumna >= 0 && temPosColumna < this.casillas[0].length) {
                listaCasilla.add(this.casillas[temPosFila][temPosColumna]);
            }
        }
        return listaCasilla;

    }

    List<Casilla> obtenerCasillasconMina() {
        List<Casilla> casillasMina = new LinkedList<>();
        //Recorrida de cada casilla
        for (int f = 0; f < casillas.length; f++) {
            for (int c = 0; c < casillas.length; c++) {

                //Si hay una mina carga todas en una lista y las muestra en pantalla
                if (casillas[f][c].isMina()) {
                    casillasMina.add(casillas[f][c]);
                }
            }
        }
        return casillasMina;
    }

    //Metodo para crear eventos al seleccionar las casillas
    public void SeleccionarCasilla(int posFila, int posColumna) {

        eventoCasillaAbierta.accept(this.casillas[posFila][posColumna]);

        //Si se selecciona una casilla donde hay minas
        if (this.casillas[posFila][posColumna].isMina()) {
            eventoPartidaPerdida.accept(obtenerCasillasconMina());
            finalizarPartida(false);
            sonido.Estallido();

            //si no hay minas alrededor muestra todos los espacios vacios   
        } else if (this.casillas[posFila][posColumna].getNumMinasCercanas() == 0) {
            MarcarCasillaAbierta(posFila, posColumna);
            List<Casilla> casillasCercanas = obtenerCasillaCercana(posFila, posColumna);
            for (Casilla casillasCercana : casillasCercanas) {
                if (!casillasCercana.isAbierta()) {
                    SeleccionarCasilla(casillasCercana.getPosFila(), casillasCercana.getPosColumna());
                }
            }
        } else {
            MarcarCasillaAbierta(posFila, posColumna);
        }

        if (partidaGanada()) {
            eventoPartidaGanada.accept(obtenerCasillasconMina());
            finalizarPartida(true);
        }
    }

    public void finalizarPartida(boolean fin) {
        if (fin) {
            Timer timer = new Timer(700, new ActionListener() {
                @Override
                //Delay para mostrar la pantalla de Game Over despues de perder
                public void actionPerformed(ActionEvent e) {
                    PartidaGanada win = new PartidaGanada(juego);
                    win.setVisible(true);

                    //Delay para que la musica suene luego de que aparezca la interfaz
                    Timer soundTimer = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sonido.Win();
                        }
                    });
                    soundTimer.setRepeats(false);
                    soundTimer.start();

                }
            });
            timer.setRepeats(false);
            timer.start();

        } else {
            Timer timer = new Timer(200, new ActionListener() {
                @Override
                //Delay para mostrar la pantalla de Game Over despues de perder
                public void actionPerformed(ActionEvent e) {
                    PartidaPerdida lose = new PartidaPerdida(juego);
                    lose.setVisible(true);

                    //Genera un delay para que la musica suene luego de que aparezca la interfaz
                    Timer soundTimer = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            sonido.GameOver();
                        }
                    });
                    soundTimer.setRepeats(false);
                    soundTimer.start();
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    void MarcarCasillaAbierta(int posFila, int posColumna) {
        if (!this.casillas[posFila][posColumna].isAbierta()) {
            numCasillasAbiertas++;
            this.casillas[posFila][posColumna].setAbierta(true);
        }
    }

    boolean partidaGanada() {
        return numCasillasAbiertas >= (numFilas * numColumnas) - numMinas;
    }

    //Metodo Setter
    public void setEventoPartidaPerdida(Consumer<List<Casilla>> eventoPartidaPerdida) {
        this.eventoPartidaPerdida = eventoPartidaPerdida;
    }

    public void setEventoCasillaAbierta(Consumer<Casilla> eventoCasillaAbierta) {
        this.eventoCasillaAbierta = eventoCasillaAbierta;
    }

    public void setEventoPartidaGanada(Consumer<List<Casilla>> eventoPartidaGanada) {
        this.eventoPartidaGanada = eventoPartidaGanada;
    }
}
