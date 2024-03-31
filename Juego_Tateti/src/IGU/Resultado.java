package IGU;

import Logica.Ruta;
import Logica.Tablero;
import Logica.TipoImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

public class Resultado extends javax.swing.JFrame {

    private Tablero tablero;
    private TipoImagen jugadorGanador;

    public Resultado(TipoImagen jugadorGanador, Tablero tablero) {
        // setUndecorated(true);//Borra el menu de interfaz
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelFondo.requestFocus();
        this.tablero = tablero;
        this.jugadorGanador = jugadorGanador;

        //int partida = 0;
        // for (partida = 0; partida <= 5; partida++) {
        if (jugadorGanador == TipoImagen.Equis) {
            imgIzquierda.setRuta(Ruta.JUGADOREQUIS);
            imgDerecha.setRuta(Ruta.EQUIS);
            lbNombre.setText(TaTeTi.nombreJugadorEquis.getText());
        } else if (jugadorGanador == TipoImagen.Circulo) {
            imgIzquierda.setRuta(Ruta.JUGADORCIRCULO);
            imgDerecha.setRuta(Ruta.CIRCULO);
            lbNombre.setText(TaTeTi.nombreJugadorCirculo.getText());
        } else if (jugadorGanador == TipoImagen.EMPATE) {
            imgIzquierda.setRuta(Ruta.JUGADOREQUIS);
            imgDerecha.setRuta(Ruta.JUGADORCIRCULO);
            lbNombre.setText("EMPATE");
            //}
        }

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
        lbTitulo = new javax.swing.JLabel();
        imgIzquierda = new Logica.imagen();
        imgDerecha = new Logica.imagen();
        lbNombre = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        panelFondo.setBackground(new java.awt.Color(14, 19, 49));
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
        lbCerrar.setBounds(380, 0, 30, 60);

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbTitulo.setForeground(new java.awt.Color(230, 251, 255));
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("¡¡¡ Victoria !!!");
        panelFondo.add(lbTitulo);
        lbTitulo.setBounds(0, 50, 415, 40);

        imgIzquierda.setText("imagen1");
        imgIzquierda.setRuta("/img/JugadorEquis.png");
        panelFondo.add(imgIzquierda);
        imgIzquierda.setBounds(40, 150, 40, 40);

        imgDerecha.setText("imagen3");
        imgDerecha.setRuta("/img/Equis.png");
        panelFondo.add(imgDerecha);
        imgDerecha.setBounds(340, 150, 40, 40);

        lbNombre.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbNombre.setForeground(new java.awt.Color(230, 251, 255));
        lbNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNombre.setText("NOMBRE");
        panelFondo.add(lbNombre);
        lbNombre.setBounds(80, 150, 260, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lbCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCerrarMouseClicked
        //Cierre de ventana 
        dispose();
        tablero.ReiniciarTablero(jugadorGanador);
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
    private Logica.imagen imgDerecha;
    private Logica.imagen imgIzquierda;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
}
