import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MemoTest {

    //Listado de cartas
    String[] ListaCartas = {
            "agua", "doble", "electrico", "fuego","hada",
            "hierba", "metal", "oscuro", "pelea", "psiquico"
    };

    ArrayList<Cartas> mazo;
    ImageIcon ImagenDorso;

    //Elementos Interfaz Gráfica
    JFrame ventana = new JFrame("MemoTest Pokemon");
    JLabel lbTexto = new JLabel();
    JPanel pnlTexto = new JPanel();
    JPanel pnlTablero = new JPanel();
    JPanel pnlReseteo = new JPanel();
    JButton btnReset = new JButton();

    //Variables de Estado
    int contadorError = 0;
    ArrayList<JButton> btnTablero;
    Timer Reloj;
    boolean Comienzo = false;
    JButton cartaSelect1;
    JButton cartaSelect2;

    //Constructor
    MemoTest() {
        setupCartas();
        barajarCartas();
        configVentana();
        crearTablero();
        iniciarReloj();
        configBotonReset();

        ventana.pack();
        ventana.setVisible(true);
    }

    //Métodos

    //Configuración de Interfaz Gráfica
    /***
     * Top de la Interfaz grafica,
     * muestra Titulo y Etiqueta de errores
     */
    private void configVentana(){
        ventana.setLayout(new BorderLayout());
        ventana.setSize(Constantes.TABLERO_ANCHO, Constantes.TABLERO_ALTO);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbTexto.setFont(new Font("Arial", Font.PLAIN, 20));
        lbTexto.setHorizontalAlignment(JLabel.CENTER);
        lbTexto.setText("Errores: " + Integer.toString(contadorError));

        pnlTexto.setPreferredSize(new Dimension(Constantes.TABLERO_ANCHO, 30));
        pnlTexto.add(lbTexto);
        ventana.add(pnlTexto, BorderLayout.NORTH);
    }

    /***
     * Body de la Interfaz gráfica
     * muestra las cartas, cada una asignada a un botón
     */
    private void crearTablero(){
        btnTablero = new ArrayList<>();
        pnlTablero.setLayout(new GridLayout(Constantes.FILAS, Constantes.COLUMNAS));
        for (Cartas cartas : mazo) {
            JButton tile = new JButton();
            tile.setPreferredSize(new Dimension(Constantes.ANCHO_CARTA, Constantes.ALTO_CARTA));
            tile.setOpaque(true);
            tile.setIcon(cartas.ImagenCarta);
            tile.setFocusable(false);
            tile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    manejarClickCarta(tile);
                }
            });
            btnTablero.add(tile);
            pnlTablero.add(tile);
        }
        ventana.add(pnlTablero);
    }

    /***
     * Footer de la Interfaz gráfica
     * Muestra el botón para resetear el juego
     */
    private void configBotonReset(){
        btnReset.setFont(new Font("Arial", Font.PLAIN, 16));
        btnReset.setText("Resetear Juego");
        btnReset.setPreferredSize(new Dimension(Constantes.TABLERO_ANCHO, 30));
        btnReset.setFocusable(false);
        btnReset.setEnabled(false);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetearJuego();
            }
        });
        pnlReseteo.add(btnReset);
        ventana.add(pnlReseteo, BorderLayout.SOUTH);

    }

    //Control del Juego
    /***
     * Maneja los eventos cuando se aprietan las cartas
     * @param tile es cada Boton representado por una carta
     *  Su función consiste en no permitir que haya más de 2 cartas seleccionadas
     */
    private void manejarClickCarta(JButton tile){
        if (!Comienzo) {
            return;
        }
        if (tile.getIcon() == ImagenDorso) {
            if (cartaSelect1 == null) {
                cartaSelect1 = tile;
                int indice = btnTablero.indexOf(cartaSelect1);
                cartaSelect1.setIcon(mazo.get(indice).ImagenCarta);
            } else if (cartaSelect2 == null) {
                cartaSelect2 = tile;
                int indice = btnTablero.indexOf(cartaSelect2);
                cartaSelect2.setIcon(mazo.get(indice).ImagenCarta);

                if (cartaSelect1.getIcon() != cartaSelect2.getIcon()) {
                    contadorError += 1;
                    lbTexto.setText("Error: " + Integer.toString(contadorError));
                    Reloj.start();
                } else {
                    cartaSelect1 = null;
                    cartaSelect2 = null;
                }
            }
        }
    }

    /***
     * Resetea el juego, cambiando las posiciones de las cartas
     */
    private void resetearJuego(){
        if (!Comienzo) {
            return;
        }

        Comienzo = false;
        btnReset.setEnabled(false);
        cartaSelect1 = null;
        cartaSelect2 = null;
        barajarCartas();

        //Reasignar botones con cartas nuevas
        for (int i = 0; i < btnTablero.size(); i++) {
            btnTablero.get(i).setIcon(mazo.get(i).ImagenCarta);
        }

        contadorError = 0;
        lbTexto.setText("Error: " + Integer.toString(contadorError));
        Reloj.start();
    }

    /***
     * Temporizador para marcar los tiempos en que se muestran las cartas
     */
    private void iniciarReloj(){
        Reloj = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ocultarCartas();
            }
        });
        Reloj.setRepeats(false);
        Reloj.start();
    }


    //Manejo de Cartas
   /* /***
     * Carga las imagenes para el juego
     * @param nombre nombre del archivo de cada carta
     * @return imagen representativa de la carta
     */
    private ImageIcon cargarImagen(String nombre) {
        Image img = new ImageIcon(getClass().getResource("/img/" + nombre)).getImage();
        return new ImageIcon(img.getScaledInstance(Constantes.ANCHO_CARTA, Constantes.ALTO_CARTA, Image.SCALE_SMOOTH));
    }

    /***
     * Setea las cartas para mostrar la imagen del dorso, o las de tipos de energía
     */
    public void setupCartas() {
        mazo = new ArrayList<Cartas>();
        for (String nombreCarta : ListaCartas) {
            mazo.add(new Cartas(nombreCarta, cargarImagen(nombreCarta + ".jpg")));
        }
        mazo.addAll(mazo);
        ImagenDorso = cargarImagen("dorso.jpg");
    }

    /***
     * Mezcla la lista de cartas de manera aleatoria
     */
    public void barajarCartas() {
        //System.out.println(mazo);
        //Barajar
        for (int i = 0; i < mazo.size(); i++) {
            int j = (int) (Math.random() * mazo.size()); //Obtiene un indice random
            Cartas temp = mazo.get(i);
            mazo.set(i, mazo.get(j));
            mazo.set(j, temp);
        }
        //System.out.println(mazo); Es para corroborar que se barajan los tipos de cartas
    }

    /***
     * Voltea las cartas en cuanto son seleccionados
     */
     public void ocultarCartas() {
        if (Comienzo && cartaSelect1 != null && cartaSelect2 != null) {//Solo es posible voltear 2 cartas
            cartaSelect1.setIcon(ImagenDorso);
            cartaSelect1 = null;
            cartaSelect2.setIcon(ImagenDorso);
            cartaSelect2 = null;
        } else {
            for (int i = 0; i < btnTablero.size(); i++) {
                btnTablero.get(i).setIcon(ImagenDorso);
            }
            Comienzo = true;
            btnReset.setEnabled(true);
        }
    }
}