package IGU;

import java.awt.Image;
import java.awt.Toolkit;

public class PartidaGanada extends javax.swing.JFrame {

    private final Juego juego;

    public PartidaGanada(Juego juego) {
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

        btnNo = new javax.swing.JButton();
        btnSI = new javax.swing.JButton();
        jlWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNo.setBackground(new java.awt.Color(0, 102, 204));
        btnNo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnNo.setForeground(new java.awt.Color(255, 255, 255));
        btnNo.setText("NO");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 449, 80, 30));

        btnSI.setBackground(new java.awt.Color(0, 102, 204));
        btnSI.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btnSI.setForeground(new java.awt.Color(255, 255, 255));
        btnSI.setText("SI");
        btnSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIActionPerformed(evt);
            }
        });
        getContentPane().add(btnSI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 449, 80, 30));

        jlWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PartidaGanada.jpg"))); // NOI18N
        getContentPane().add(jlWallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIActionPerformed
        Juego juego = new Juego();
        juego.JuegoNuevo();
        this.dispose();
    }//GEN-LAST:event_btnSIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSI;
    private javax.swing.JLabel jlWallpaper;
    // End of variables declaration//GEN-END:variables
}
