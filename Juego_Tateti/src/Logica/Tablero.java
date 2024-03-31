package Logica;

import IGU.Resultado;
import IGU.TaTeTi;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Tablero extends JPanel {

    private int anchoCI;//CI = Cuadrados Internos
    private int alturaCI;//CI = Cuadrados Internos
    private int margen;//Lineas divisorias de la cuadricula
    private Color colorTablero;
    private Color colorCi;

    private TipoImagen turnoPartida;
    private TipoImagen jugadorActual;
    private Jugador jugador1;
    private Jugador jugador2;

    private ArrayList<CuadroInterno> cuadros;
    private CuadroInterno cuadroFrontal;

    private int RondasTotales;

    //Constructor
    public Tablero() {
        init();
    }

    private void init() {
        anchoCI = 80;
        alturaCI = 80;
        colorCi = Color.BLUE;
        colorTablero = Color.RED;
        margen = 6;
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        cuadros = new ArrayList<>();
        jugadorActual = TipoImagen.Equis;
        turnoPartida = TipoImagen.Equis;
    }

    //Definicion del tablero
    public void CrearTablero() {
        setLayout(null);
        setSize(anchoCI * 3 + margen * 4, alturaCI * 3 + margen * 4);
        setBackground(colorTablero);
        cuadroFrontal = new CuadroInterno(this.getWidth(), this.getHeight(), Color.RED);
        cuadroFrontal.setLocation(0, 0);
        cuadroFrontal.setOpaque(false);
        cuadroFrontal.setEnabled(false);
        add(cuadroFrontal);
        CrearCuadrosInternos();
    }

    public void CrearCuadrosInternos() {
        int EjeX = margen;
        int EjeY = margen;

        for (int f = 0; f < 3; f++) {
            EjeX = margen;
            for (int c = 0; c < 3; c++) {
                CuadroInterno cuadroInt = new CuadroInterno(anchoCI, alturaCI, colorCi);
                cuadroInt.setCursor(new Cursor(Cursor.HAND_CURSOR));
                cuadroInt.setLocation(EjeX, EjeY);
                cuadroInt.setF(f);
                cuadroInt.setC(c);
                add(cuadroInt);
                cuadros.add(cuadroInt);
                CrearEventosCuadros(cuadroInt);

                EjeX += (anchoCI + margen);
            }
            EjeY += (alturaCI + margen);

        }
    }

    //Metodo para interactuar con el tablero
    public void CrearEventosCuadros(CuadroInterno cuadro) {
        MouseListener evt = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

                if (cuadro.isDibujado()) {
                    return;
                }

                TipoImagen tipoImagenResultado = null;

                if (jugadorActual == TipoImagen.Equis) {
                    cuadro.setTipoImagen(TipoImagen.Equis);
                    jugador1.getTablero()[cuadro.getF()][cuadro.getC()] = 1;
                    tipoImagenResultado = jugador1.Tateti(jugador2);
                    Resultado(tipoImagenResultado, TipoImagen.Equis);
                    jugadorActual = TipoImagen.Circulo;
                    CambiarTurnos(TipoImagen.Circulo);

                } else if (jugadorActual == TipoImagen.Circulo) {
                    cuadro.setTipoImagen(TipoImagen.Circulo);
                    jugador2.getTablero()[cuadro.getF()][cuadro.getC()] = 1;
                    tipoImagenResultado = jugador2.Tateti(jugador1);
                    Resultado(tipoImagenResultado, TipoImagen.Circulo);
                    jugadorActual = TipoImagen.Equis;
                    CambiarTurnos(TipoImagen.Equis);
                }

                cuadro.setDibujado(true);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        cuadro.addMouseListener(evt);
    }

    //Metodo para cambiar el turno de un jugador al interactuar con el tablero
    public void CambiarTurnos(TipoImagen jugadorAct) {

        if (jugadorAct == TipoImagen.Circulo) {
            TaTeTi.imgJugadorEquis.setRuta(Ruta.JUGADORAUXILIAR);
            TaTeTi.imgJugadorEquis.repaint();
            TaTeTi.nombreJugadorEquis.setForeground(new Color(240, 240, 240, 100));

            TaTeTi.imgJugadorCirculo.setRuta(Ruta.JUGADORCIRCULO);
            TaTeTi.imgJugadorCirculo.repaint();
            TaTeTi.imgJugadorCirculo.setForeground(new Color(255, 200, 255));
        } else if (jugadorAct == TipoImagen.Equis) {
            TaTeTi.imgJugadorCirculo.setRuta(Ruta.JUGADORAUXILIAR);
            TaTeTi.imgJugadorCirculo.repaint();
            TaTeTi.nombreJugadorCirculo.setForeground(new Color(240, 240, 240, 100));

            TaTeTi.imgJugadorEquis.setRuta(Ruta.JUGADOREQUIS);
            TaTeTi.imgJugadorEquis.repaint();
            TaTeTi.imgJugadorEquis.setForeground(new Color(180, 232, 255));
        }
    }

    //Metodo para definir el resultado de la ronda
    public void Resultado(TipoImagen tipoImagenResultado, TipoImagen jugadorGanador) {   
            if (tipoImagenResultado == TipoImagen.EMPATE) {
                Tablero tablero = this;
                Timer timer = new Timer();
                TimerTask tarea = new TimerTask() {
                    @Override
                    public void run() {
                        Resultado result = new Resultado(TipoImagen.EMPATE, tablero);
                        result.setVisible(true);
                    }
                };
                timer.schedule(tarea, 800);

            } else if (tipoImagenResultado != null) {
                Ruta.cambiarRutas(jugadorGanador);
                cuadroFrontal.setTipoImagen(tipoImagenResultado);
                DesactivarCuadros(true);

                Tablero tablero = this;
                Timer timer = new Timer();
                TimerTask tarea = new TimerTask() {
                    @Override
                    public void run() {
                        Resultado result = new Resultado(jugadorGanador, tablero);
                        result.setVisible(true);
                    }
                };

                timer.schedule(tarea, 800);
                RondasTotales++;
            }
        

    }

    //Metodo para reiniciar el tablero cuando una ronda termine
    public void ReiniciarTablero(TipoImagen Ganador) {
        DesactivarCuadros(false);
        BorrarJugadaTerminada();
        cuadroFrontal.setTipoImagen(null);

        if (Ganador == TipoImagen.Equis) {
            int PuntajeNuevoEquis = Integer.parseInt(TaTeTi.puntajeEquis.getText()) + 1;
            TaTeTi.puntajeEquis.setText(String.valueOf(PuntajeNuevoEquis));
        } else if (Ganador == TipoImagen.Circulo) {
            int PuntajeNuevoEquis = Integer.parseInt(TaTeTi.puntajeCirculo.getText()) + 1;
            TaTeTi.puntajeCirculo.setText(String.valueOf(PuntajeNuevoEquis));
        }

        if (turnoPartida == TipoImagen.Equis) {
            jugadorActual = TipoImagen.Circulo;
            turnoPartida = TipoImagen.Circulo;
        } else {
            jugadorActual = TipoImagen.Equis;
            turnoPartida = TipoImagen.Equis;
        }

        CambiarTurnos(jugadorActual);
        jugador1.Limpiar();
        jugador2.Limpiar();
        repaint();
    }

    //al completar Tateti, no permite seguir dibujando X/O
    public void DesactivarCuadros(boolean valor) {
        for (CuadroInterno cuadro : cuadros) {
            cuadro.setDibujado(valor);
        }
    }

    //Limpia el tablero para volver a jugar
    public void BorrarJugadaTerminada() {
        for (CuadroInterno cuadro : cuadros) {
            cuadro.setTipoImagen(null);
        }
    }

    //--------------------------------------------------------------------------
    //Metodos Getter & Setter
    public TipoImagen getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(TipoImagen jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public ArrayList<CuadroInterno> getCuadros() {
        return cuadros;
    }

    public void setCuadros(ArrayList<CuadroInterno> cuadros) {
        this.cuadros = cuadros;
    }

    public int getAnchoCI() {
        return anchoCI;
    }

    public void setAnchoCI(int anchoCI) {
        this.anchoCI = anchoCI;
    }

    public int getAlturaCI() {
        return alturaCI;
    }

    public void setAlturaCI(int alturaCI) {
        this.alturaCI = alturaCI;
    }

    public int getMargen() {
        return margen;
    }

    public void setMargen(int margen) {
        this.margen = margen;
    }

    public Color getColorTablero() {
        return colorTablero;
    }

    public void setColorTablero(Color colorTablero) {
        this.colorTablero = colorTablero;
    }

    public Color getColorCi() {
        return colorCi;
    }

    public void setColorCi(Color colorCi) {
        this.colorCi = colorCi;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

}
