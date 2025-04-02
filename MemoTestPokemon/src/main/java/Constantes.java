public class Constantes {

    public static final int ANCHO_CARTA = 90;
    public static final int ALTO_CARTA = 150;
    public static final int FILAS = 4;
    public static final int COLUMNAS = 5;
    public static final int TABLERO_ANCHO = COLUMNAS * ANCHO_CARTA;
    public static final int TABLERO_ALTO = Constantes.FILAS * Constantes.ALTO_CARTA;

    // Constructor privado para evitar instanciación
    private Constantes() {
        throw new UnsupportedOperationException("Esta es una clase de constantes y no debe ser instanciada.");
    }


}
