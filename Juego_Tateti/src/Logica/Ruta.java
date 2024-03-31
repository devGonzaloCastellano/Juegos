//En esta clase se generan las rutas a las imagenes que contiene el proyecto
package Logica;

public class Ruta {

    public static final String EQUIS = "/img/Equis.png";
    public static final String CIRCULO = "/img/Circulo.png";
    public static final String JUGADORAUXILIAR = "/img/JugadorAuxiliar.png";
    public static final String JUGADOREQUIS = "/img/JugadorEquis.png";
    public static final String JUGADORCIRCULO = "/img/JugadorCirculo.png";

    public static String LINEA1 = "/img/CirculoLinea1.png";
    public static String LINEA2 = "/img/CirculoLinea2.png";
    public static String LINEA3 = "/img/CirculoLinea3.png";
    public static String LINEA4 = "/img/CirculoLinea4.png";
    public static String LINEA5 = "/img/CirculoLinea5.png";
    public static String LINEA6 = "/img/CirculoLinea6.png";
    public static String LINEA7 = "/img/CirculoLinea7.png";
    public static String LINEA8 = "/img/CirculoLinea8.png";

    public static void cambiarRutas(TipoImagen tipoImagen) {
        if (tipoImagen == TipoImagen.Circulo) {

            LINEA1 = "/img/CirculoLinea1.png";
            LINEA2 = "/img/CirculoLinea2.png";
            LINEA3 = "/img/CirculoLinea3.png";
            LINEA4 = "/img/CirculoLinea4.png";
            LINEA5 = "/img/CirculoLinea5.png";
            LINEA6 = "/img/CirculoLinea6.png";
            LINEA7 = "/img/CirculoLinea7.png";
            LINEA8 = "/img/CirculoLinea8.png";

        } else if (tipoImagen == TipoImagen.Equis) {

            LINEA1 = "/img/EquisLinea1.png";
            LINEA2 = "/img/EquisLinea2.png";
            LINEA3 = "/img/EquisLinea3.png";
            LINEA4 = "/img/EquisLinea4.png";
            LINEA5 = "/img/EquisLinea5.png";
            LINEA6 = "/img/EquisLinea6.png";
            LINEA7 = "/img/EquisLinea7.png";
            LINEA8 = "/img/EquisLinea8.png";
        }
    }
}
