package IGU;

import Logica.Jugador;
import Logica.TipoImagen;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class Acceso extends javax.swing.JFrame {

    public Acceso() {
        setUndecorated(true);//Borra el menu de interfaz
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelFondo.requestFocus();
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
        txtJugador1 = new javax.swing.JTextField();
        txtJugador2 = new javax.swing.JTextField();
        btnIniciar = new javax.swing.JButton();
        imagen1 = new Logica.imagen();
        imagen2 = new Logica.imagen();
        imagen3 = new Logica.imagen();
        imagen4 = new Logica.imagen();

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
        lbTitulo.setText("TA-TE-TI");
        panelFondo.add(lbTitulo);
        lbTitulo.setBounds(0, 40, 415, 40);

        txtJugador1.setBackground(new java.awt.Color(214, 252, 249));
        txtJugador1.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        txtJugador1.setForeground(new java.awt.Color(101, 175, 245));
        txtJugador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJugador1.setText("Jugador 1");
        txtJugador1.setToolTipText("");
        txtJugador1.setBorder(null);
        txtJugador1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador1FocusLost(evt);
            }
        });
        txtJugador1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtJugador1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtJugador1MouseExited(evt);
            }
        });
        txtJugador1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJugador1KeyTyped(evt);
            }
        });
        panelFondo.add(txtJugador1);
        txtJugador1.setBounds(100, 100, 230, 40);

        txtJugador2.setBackground(new java.awt.Color(249, 230, 254));
        txtJugador2.setFont(new java.awt.Font("Cooper Black", 1, 24)); // NOI18N
        txtJugador2.setForeground(new java.awt.Color(202, 105, 220));
        txtJugador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtJugador2.setText("Jugador 2");
        txtJugador2.setBorder(null);
        txtJugador2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtJugador2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtJugador2FocusLost(evt);
            }
        });
        txtJugador2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtJugador2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtJugador2MouseExited(evt);
            }
        });
        txtJugador2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJugador2KeyTyped(evt);
            }
        });
        panelFondo.add(txtJugador2);
        txtJugador2.setBounds(100, 160, 230, 40);

        btnIniciar.setBackground(new java.awt.Color(42, 22, 79));
        btnIniciar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(241, 227, 252));
        btnIniciar.setText("INICIAR");
        btnIniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 211, 246), 2));
        btnIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIniciarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIniciarMouseExited(evt);
            }
        });
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        panelFondo.add(btnIniciar);
        btnIniciar.setBounds(130, 230, 160, 50);

        imagen1.setText("imagen1");
        imagen1.setRuta("/img/JugadorEquis.png");
        panelFondo.add(imagen1);
        imagen1.setBounds(40, 100, 40, 40);

        imagen2.setText("imagen2");
        imagen2.setRuta("/img/JugadorCirculo.png");
        panelFondo.add(imagen2);
        imagen2.setBounds(40, 160, 40, 40);

        imagen3.setText("imagen3");
        imagen3.setRuta("/img/Equis.png");
        panelFondo.add(imagen3);
        imagen3.setBounds(340, 100, 40, 40);

        imagen4.setText("imagen3");
        imagen4.setRuta("/img/Circulo.png");
        panelFondo.add(imagen4);
        imagen4.setBounds(340, 160, 40, 40);

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

    private void txtJugador1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador1MouseEntered
        //Coloca un borde al pasar el mouse
        Border borde = BorderFactory.createLineBorder(new Color(52, 136, 235), 2);
        txtJugador1.setBorder(borde);
    }//GEN-LAST:event_txtJugador1MouseEntered

    private void txtJugador1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador1MouseExited
        //Quita el borde al sacar el mouse
        txtJugador1.setBorder(null);
    }//GEN-LAST:event_txtJugador1MouseExited

    private void txtJugador2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador2MouseEntered
        //Coloca un borde al pasar el mouse
        Border borde = BorderFactory.createLineBorder(new Color(165, 40, 174), 2);
        txtJugador2.setBorder(borde);
    }//GEN-LAST:event_txtJugador2MouseEntered

    private void txtJugador2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtJugador2MouseExited
        //Quita el borde al sacar el mouse
        txtJugador2.setBorder(null);
    }//GEN-LAST:event_txtJugador2MouseExited

    private void txtJugador1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador1FocusGained
        if (txtJugador1.getText().equals("Jugador 1")) {
            txtJugador1.setText("");
        }
    }//GEN-LAST:event_txtJugador1FocusGained

    private void txtJugador2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador2FocusGained
        if (txtJugador2.getText().equals("Jugador 2")) {
            txtJugador2.setText("");
        }
    }//GEN-LAST:event_txtJugador2FocusGained

    private void txtJugador1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador1FocusLost
        if (txtJugador1.getText().equals("")) {
            txtJugador1.setText("Jugador 1");
        }
    }//GEN-LAST:event_txtJugador1FocusLost

    private void txtJugador2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtJugador2FocusLost
        if (txtJugador2.getText().equals("")) {
            txtJugador2.setText("Jugador 2");
        }
    }//GEN-LAST:event_txtJugador2FocusLost

    private void btnIniciarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseEntered
        btnIniciar.setBackground(new Color(126, 49, 196));
    }//GEN-LAST:event_btnIniciarMouseEntered

    private void btnIniciarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIniciarMouseExited
        btnIniciar.setBackground(new Color(42, 22, 79));
    }//GEN-LAST:event_btnIniciarMouseExited

    private void txtJugador1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJugador1KeyTyped
        char caracter = Character.toUpperCase(evt.getKeyChar());
        evt.setKeyChar(caracter);

        if (txtJugador1.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtJugador1KeyTyped

    private void txtJugador2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJugador2KeyTyped
        char caracter = Character.toUpperCase(evt.getKeyChar());
        evt.setKeyChar(caracter);

        if (txtJugador2.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtJugador2KeyTyped

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        this.dispose();

        Jugador jugador1 = new Jugador(TipoImagen.Equis);
        if (txtJugador1.getText().equals("")) {
            jugador1.setNombre("JUGADOR 1");
        } else {
            jugador1.setNombre(txtJugador1.getText());
        }

        Jugador jugador2 = new Jugador(TipoImagen.Circulo);
        if (txtJugador2.getText().equals("")) {
            jugador2.setNombre("JUGADOR 2");
        } else {
            jugador2.setNombre(txtJugador2.getText());
        }

        TaTeTi taTeTi = new TaTeTi(jugador1, jugador2);
        taTeTi.setVisible(true);


    }//GEN-LAST:event_btnIniciarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private Logica.imagen imagen1;
    private Logica.imagen imagen2;
    private Logica.imagen imagen3;
    private Logica.imagen imagen4;
    private javax.swing.JLabel lbCerrar;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextField txtJugador1;
    private javax.swing.JTextField txtJugador2;
    // End of variables declaration//GEN-END:variables
}
