package IGU;

import Logica.Jugador;
import Logica.Tablero;
import Logica.TipoImagen;
import Logica.imagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class TaTeTi extends javax.swing.JFrame {

    public static imagen imgJugadorEquis;
    public static imagen imgJugadorCirculo;
    public static JLabel nombreJugadorEquis;
    public static JLabel nombreJugadorCirculo;
    public static JLabel puntajeEquis;
    public static JLabel puntajeCirculo;

    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;

    public TaTeTi(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        init();
        imgJugadorEquis = jugadorEquis;
        imgJugadorCirculo = jugadorCirculo;
        nombreJugadorEquis = lbJugador1;
        nombreJugadorCirculo = lbJugador2;
        puntajeEquis = lbPuntajeJ1;
        puntajeCirculo = lbPuntajeJ2;
        tablero.CambiarTurnos(TipoImagen.Equis);
    }

    public void init() {
        // setUndecorated(true);
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);

        lbJugador1.setText(jugador1.getNombre());
        lbJugador2.setText(jugador2.getNombre());
        tablero = new Tablero();
        tablero.setJugador1(jugador1);
        tablero.setJugador2(jugador2);
        tablero.setAlturaCI(100);
        tablero.setAnchoCI(100);
        tablero.setMargen(5);
        tablero.setColorCi(new Color(14, 19, 43));
        tablero.setColorTablero(new Color(239, 180, 255));
        tablero.setLocation(40, 150);
        tablero.CrearTablero();
        tablero.setVisible(true);

        panelFondo.add(tablero);
    }

    //Cambia el icono de la interfaz
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "img/iconoTaTeTi.png"));

        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        lbCerrar = new javax.swing.JLabel();
        jugadorEquis = new Logica.imagen();
        jugadorCirculo = new Logica.imagen();
        lbJugador1 = new javax.swing.JLabel();
        lbJugador2 = new javax.swing.JLabel();
        lbPuntajeJ1 = new javax.swing.JLabel();
        lbPuntajeJ2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        panelFondo.setBackground(new java.awt.Color(14, 19, 43));
        panelFondo.setLayout(null);

        lbCerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbCerrar.setForeground(new java.awt.Color(240, 192, 255));
        lbCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCerrar.setText("X");
        lbCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbCerrarMouseExited(evt);
            }
        });
        panelFondo.add(lbCerrar);
        lbCerrar.setBounds(370, 0, 30, 60);

        jugadorEquis.setBackground(new java.awt.Color(14, 19, 43));
        jugadorEquis.setText("imagen1");
        jugadorEquis.setRuta("/img/JugadorEquis.png");
        panelFondo.add(jugadorEquis);
        jugadorEquis.setBounds(75, 50, 50, 50);

        jugadorCirculo.setBackground(new java.awt.Color(14, 19, 43));
        jugadorCirculo.setText("imagen2");
        jugadorCirculo.setRuta("/img/JugadorCirculo.png");
        panelFondo.add(jugadorCirculo);
        jugadorCirculo.setBounds(275, 50, 50, 50);

        lbJugador1.setBackground(new java.awt.Color(180, 232, 255));
        lbJugador1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbJugador1.setForeground(new java.awt.Color(180, 232, 255));
        lbJugador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJugador1.setText("nombre");
        panelFondo.add(lbJugador1);
        lbJugador1.setBounds(55, 100, 90, 17);

        lbJugador2.setBackground(new java.awt.Color(255, 200, 255));
        lbJugador2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbJugador2.setForeground(new java.awt.Color(255, 200, 255));
        lbJugador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbJugador2.setText("nombre");
        panelFondo.add(lbJugador2);
        lbJugador2.setBounds(255, 100, 90, 17);

        lbPuntajeJ1.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        lbPuntajeJ1.setForeground(new java.awt.Color(255, 255, 255));
        lbPuntajeJ1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPuntajeJ1.setText("0");
        panelFondo.add(lbPuntajeJ1);
        lbPuntajeJ1.setBounds(130, 50, 60, 52);

        lbPuntajeJ2.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        lbPuntajeJ2.setForeground(new java.awt.Color(255, 255, 255));
        lbPuntajeJ2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPuntajeJ2.setText("0");
        panelFondo.add(lbPuntajeJ2);
        lbPuntajeJ2.setBounds(210, 50, 60, 52);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("-");
        panelFondo.add(jLabel3);
        jLabel3.setBounds(190, 45, 20, 52);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        //Cierre de sistema
        System.exit(0);
    }//GEN-LAST:event_lbCerrarMouseClicked

    private void lbCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseEntered
        //Cambia el label a rojo cuando se posiciona el mouse sobre el
        lbCerrar.setForeground(Color.red);
    }//GEN-LAST:event_lbCerrarMouseEntered

    private void lbCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseExited
        //Regresa el label a su estado original
        lbCerrar.setForeground(new Color(240, 192, 255));
    }//GEN-LAST:event_lbCerrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private Logica.imagen jugadorCirculo;
    private Logica.imagen jugadorEquis;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbJugador1;
    private javax.swing.JLabel lbJugador2;
    private javax.swing.JLabel lbPuntajeJ1;
    private javax.swing.JLabel lbPuntajeJ2;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables

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
