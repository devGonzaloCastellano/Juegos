package IGU;

import java.awt.Image;
import java.awt.Toolkit;

public class PartidaPerdida extends javax.swing.JFrame {

    private final Juego juego;

    public PartidaPerdida(Juego juego) {
        initComponents();
        setTitle("Juego Terminado");
        setResizable(false);
        setLocationRelativeTo(null);
        this.juego = juego;
    }

    //Cambia el icono de la interfaz
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource(
                "img/bomba.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        btnSi = new javax.swing.JButton();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 449, 80, 30));

        btnSi.setBackground(new java.awt.Color(0, 102, 204));
        btnSi.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnSi.setForeground(new java.awt.Color(255, 255, 255));
        btnSi.setText("SI");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        getContentPane().add(btnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 449, 80, 30));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PartidaPerdida.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        juego.JuegoNuevo();
        this.dispose();
    }//GEN-LAST:event_btnSiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSi;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables
}
