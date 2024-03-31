package Logica;

public class Jugador {

    private String nombre;
    private TipoImagen tipoImagen;
    private int tablero[][];

    //Constructores
    public Jugador() {
    }

    public Jugador(TipoImagen tipoImagen) {
        this.tipoImagen = tipoImagen;
        tablero = new int[3][3];
        Limpiar();
    }

    public Jugador(String nombre, TipoImagen tipoImagen) {
        this.nombre = nombre;
        this.tipoImagen = tipoImagen;
    }

    //Metodo para reestablecer el tablero
    public void Limpiar() {

        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                tablero[f][c] = 0;
            }
        }

    }

    //Metodo que verifica cuando gana un jugador
    public TipoImagen Tateti(Jugador jugadorRival) {

        /*
        Cada if marca las diferentes maneras de ganar que se tiene en el tablero
        marcando las posiciones de la matriz segun corresponda
        el recorrido esta marcado de arriba hacia abajo y de izquierda a derecha
        los 2 ultimos corresponden a las diagonales    
         */
        if (tablero[0][0] == 1 && tablero[0][1] == 1 && tablero[0][2] == 1) {
            return TipoImagen.LINEA1;
        } else if (tablero[1][0] == 1 && tablero[1][1] == 1 && tablero[1][2] == 1) {
            return TipoImagen.LINEA2;
        } else if (tablero[2][0] == 1 && tablero[2][1] == 1 && tablero[2][2] == 1) {
            return TipoImagen.LINEA3;
        } else if (tablero[0][0] == 1 && tablero[1][0] == 1 && tablero[2][0] == 1) {
            return TipoImagen.LINEA4;
        } else if (tablero[0][1] == 1 && tablero[1][1] == 1 && tablero[2][1] == 1) {
            return TipoImagen.LINEA5;
        } else if (tablero[0][2] == 1 && tablero[1][2] == 1 && tablero[2][2] == 1) {
            return TipoImagen.LINEA6;
        } else if (tablero[2][0] == 1 && tablero[1][1] == 1 && tablero[0][2] == 1) {
            return TipoImagen.LINEA7;
        } else if (tablero[0][0] == 1 && tablero[1][1] == 1 && tablero[2][2] == 1) {
            return TipoImagen.LINEA8;
        }

        //Recorrido de la matriz
        int contador = 0;
        for (int f = 0; f < 3; f++) {
            for (int c = 0; c < 3; c++) {
                if (tablero[f][c] == 1) {
                    contador++;
                }
                if (jugadorRival.getTablero()[f][c] == 1) {
                    contador++;
                }
            }
        }
        //si todas las casillas estan completas y no hay coincidencia de 3 es empate.
        if (contador == 9) {
            return TipoImagen.EMPATE;
        }
        return null;
    }
    
    //---------------------------------------------------------------------------------------------------
    //Metodos Setter & Getter

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoImagen getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(TipoImagen tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

}
