package IGU;

import Logica.CargadorImagenes;
import Logica.Casilla;
import Logica.Dificultad;
import Logica.Tablero;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.Consumer;
import javax.swing.JButton;

public class Juego extends javax.swing.JFrame {

    public int numFilas = 10;
    public int numColumnas = 10;
    public int numMinas = 10;

    //Tamaño de los botones
    public int anchoControl = 50;
    public int altoControl = 50;

    JButton[][] botonesTablero;
    Tablero tablero;
    
    
    //Constructor
    public Juego() {
        initComponents();
        setTitle("Buscaminas");
        setResizable(false);
        JuegoNuevo();
    }

    //Inicia un juego nuevo
    public void JuegoNuevo() {
        descargarControles();
        cargarControles();
        crearTablero();
        repaint();
        centrarVentana();
    }

    //Inicia un tablero con sus respectivos eventos
    public void crearTablero() {
        tablero = new Tablero(numFilas, numColumnas, numMinas, this);
        tablero.setEventoPartidaPerdida(new Consumer<List<Casilla>>() {
            @Override

            //Al tocar una mina aparecera una imagen de explosion
            public void accept(List<Casilla> t) {
                for (Casilla casillaMina : t) {
                    botonesTablero[casillaMina.getPosFila()][casillaMina.getPosColumna()]
                            .setIcon(CargadorImagenes.cargarExplosion(40, 40));
                }
            }

        });

        //Al ganar la partida, las casillas que contengan una bomba se mostraran con una carita
        tablero.setEventoPartidaGanada(new Consumer<List<Casilla>>() {
            @Override
            public void accept(List<Casilla> t) {
                for (Casilla casillaMina : t) {
                    botonesTablero[casillaMina.getPosFila()][casillaMina.getPosColumna()]
                            .setIcon(CargadorImagenes.cargarSonrisa(40, 40));
                }
            }
        });

        //Al seleccionar una casilla sin minas cercanas, elimina los botones
        //solo deja las casillas que contengan alguna mina contigua
        tablero.setEventoCasillaAbierta(new Consumer<Casilla>() {
            @Override
            public void accept(Casilla t) {
                JButton boton = botonesTablero[t.getPosFila()][t.getPosColumna()];

                boton.setEnabled(false);

                if (t.getNumMinasCercanas() == 0) {
                    boton.setText("");
                } else {
                    boton.setText(String.valueOf(t.getNumMinasCercanas()));
                    
                    // Cambiar el color del texto según el número de minas cercanas
                    switch (t.getNumMinasCercanas()) {
                        case 1:
                            boton.setFont(new Font("Arial Black", Font.PLAIN, 30));
                            boton.setForeground(new Color(10, 29, 126));//Azul
                            break;
                        case 2:
                            boton.setFont(new Font("Arial Black", Font.PLAIN, 30));
                            boton.setForeground(new Color(23, 118, 8));//Verde oscuro
                            break;
                        case 3:
                            boton.setFont(new Font("Arial Black", Font.PLAIN, 30));
                            boton.setForeground(new Color(138, 30, 12));//Rojo oscuro 
                            break;
                        case 4:
                            boton.setFont(new Font("Arial Black", Font.PLAIN, 30));
                            boton.setForeground(new Color(157, 164, 52));//Amarillo Oscuro
                            break;
                        case 5:
                            boton.setFont(new Font("Arial Black", Font.PLAIN, 30));
                            boton.setForeground(new Color(141, 14, 169));//Violeta Oscuro
                            break;
                        default:
                            boton.setFont(new Font("Arial Black", Font.PLAIN, 30));
                            boton.setForeground(Color.BLACK); // Color predeterminado para otros números
                    }
                }

            }
        });
    }

    //Rellena el tablero con Botones para tener casillas interactivas
    private void cargarControles() {

        //Posicionamiento del primer boton
        int posXReferencia = 15;
        int posYReferencia = 55;

        botonesTablero = new JButton[numFilas][numColumnas];

        //Recorrida de la matriz
        for (int f = 0; f < botonesTablero.length; f++) {
            for (int c = 0; c < botonesTablero[0].length; c++) {
                //Asigna un boton a cada indice de la matriz
                botonesTablero[f][c] = new JButton();
                //Setea cada boton con el nombre de su indice X,Y
                botonesTablero[f][c].setName(f + "," + c);
                //Quita el borde a los botones
                botonesTablero[f][c].setBorder(null);

                //Carga el primer boton de la matriz
                if (f == 0 && c == 0) {
                    botonesTablero[f][c].setBounds(posXReferencia, posYReferencia,
                            anchoControl, altoControl);

                    //Carga los botones contiguos de cada fila
                } else if (f == 0 && c != 0) {
                    botonesTablero[f][c].setBounds(
                            botonesTablero[f][c - 1].getX() + botonesTablero[f][c - 1].getWidth(),
                            posYReferencia, anchoControl, altoControl);

                    //Carga los botones en las columnas restantes
                } else {
                    botonesTablero[f][c].setBounds(
                            botonesTablero[f - 1][c].getX(),
                            botonesTablero[f - 1][c].getY() + botonesTablero[f - 1][c].getHeight(),
                            anchoControl, altoControl);
                }

                //crea un evento de accion a cada boton que se genera
                botonesTablero[f][c].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnClic(e);
                    }
                });
                //Agrega los botones al contenedor principal
                getContentPane().add(botonesTablero[f][c]);
            }
        }

        //Regula el tamaño de la ventana segun la cantidad de casillas existentes
        this.setSize(botonesTablero[numFilas - 1][numColumnas - 1].getX()
                + botonesTablero[numFilas - 1][numColumnas - 1].getWidth() + 30,
                botonesTablero[numFilas - 1][numColumnas - 1].getY()
                + botonesTablero[numFilas - 1][numColumnas - 1].getHeight() + 75
        );
    }

    //Limpia los eventos de los controles anteriores al crear un nuevo tablero
    void descargarControles() {
        if (botonesTablero != null) {
            for (int f = 0; f < botonesTablero.length; f++) {
                for (int c = 0; c < botonesTablero[f].length; c++) {

                    if (botonesTablero[f][c] != null) {
                        getContentPane().remove(botonesTablero[f][c]);
                    }
                }
            }
        }
    }

    //Evento de clickear un boton
    private void btnClic(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        String[] coordenada = btn.getName().split(",");
        int posFila = Integer.parseInt(coordenada[0]);
        int posColumna = Integer.parseInt(coordenada[1]);
        tablero.SeleccionarCasilla(posFila, posColumna);
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

        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        NuevoJuego = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        NvFacil = new javax.swing.JMenuItem();
        nvMedio = new javax.swing.JMenuItem();
        nvDificil = new javax.swing.JMenuItem();
        NvMuyDificil = new javax.swing.JMenuItem();
        NvExperto = new javax.swing.JMenuItem();
        NvLeyenda = new javax.swing.JMenuItem();
        AyudaM = new javax.swing.JMenu();
        Ayuda = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        AcercaDe = new javax.swing.JMenuItem();

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setIconImages(getIconImages());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jMenu1.setText("Juego");

        NuevoJuego.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        NuevoJuego.setText("Nuevo");
        NuevoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoJuegoActionPerformed(evt);
            }
        });
        jMenu1.add(NuevoJuego);

        jMenu4.setText("Dificultad");

        NvFacil.setText("Facil");
        NvFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NvFacilActionPerformed(evt);
            }
        });
        jMenu4.add(NvFacil);

        nvMedio.setText("Medio");
        nvMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvMedioActionPerformed(evt);
            }
        });
        jMenu4.add(nvMedio);

        nvDificil.setText("Dificil");
        nvDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nvDificilActionPerformed(evt);
            }
        });
        jMenu4.add(nvDificil);

        NvMuyDificil.setText("Muy Dificil");
        NvMuyDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NvMuyDificilActionPerformed(evt);
            }
        });
        jMenu4.add(NvMuyDificil);

        NvExperto.setText("Experto");
        NvExperto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NvExpertoActionPerformed(evt);
            }
        });
        jMenu4.add(NvExperto);

        NvLeyenda.setText("Leyenda");
        NvLeyenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NvLeyendaActionPerformed(evt);
            }
        });
        jMenu4.add(NvLeyenda);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        AyudaM.setText("Ayuda");

        Ayuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        Ayuda.setText("Ayuda");
        Ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AyudaActionPerformed(evt);
            }
        });
        AyudaM.add(Ayuda);

        jMenuBar1.add(AyudaM);

        jMenu3.setText("Acerca De");

        AcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        AcercaDe.setText("Acerca De");
        AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcercaDeActionPerformed(evt);
            }
        });
        jMenu3.add(AcercaDe);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 300, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NuevoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoJuegoActionPerformed
        JuegoNuevo();
    }//GEN-LAST:event_NuevoJuegoActionPerformed

    private void AyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AyudaActionPerformed

        Ayuda ayuda = new Ayuda();
        ayuda.setVisible(true);

    }//GEN-LAST:event_AyudaActionPerformed

    private void AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcercaDeActionPerformed

        AcercaDe acerca = new AcercaDe();
        acerca.setVisible(true);

    }//GEN-LAST:event_AcercaDeActionPerformed

    private void NvFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NvFacilActionPerformed

        Dificultad facil = new Dificultad(10, 10, 10, 50, 50);
        facil.aplicarDificultad(this);

    }//GEN-LAST:event_NvFacilActionPerformed

    private void nvMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvMedioActionPerformed

        Dificultad medio = new Dificultad(12, 12, 20, 45, 45);
        medio.aplicarDificultad(this);

    }//GEN-LAST:event_nvMedioActionPerformed

    private void nvDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nvDificilActionPerformed

        Dificultad dificil = new Dificultad(15, 15, 25, 40, 40);
        dificil.aplicarDificultad(this);

    }//GEN-LAST:event_nvDificilActionPerformed

    private void NvMuyDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NvMuyDificilActionPerformed

        Dificultad muyDificil = new Dificultad(20, 20, 35, 35, 35);
        muyDificil.aplicarDificultad(this);

    }//GEN-LAST:event_NvMuyDificilActionPerformed

    private void NvExpertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NvExpertoActionPerformed

        Dificultad experto = new Dificultad(25, 25, 50, 28, 28);
        experto.aplicarDificultad(this);

    }//GEN-LAST:event_NvExpertoActionPerformed

    private void NvLeyendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NvLeyendaActionPerformed

        Dificultad leyenda = new Dificultad(60, 60, 100, 23, 23);
        leyenda.aplicarDificultad(this);

    }//GEN-LAST:event_NvLeyendaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AcercaDe;
    private javax.swing.JMenuItem Ayuda;
    private javax.swing.JMenu AyudaM;
    private javax.swing.JMenuItem NuevoJuego;
    private javax.swing.JMenuItem NvExperto;
    private javax.swing.JMenuItem NvFacil;
    private javax.swing.JMenuItem NvLeyenda;
    private javax.swing.JMenuItem NvMuyDificil;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem nvDificil;
    private javax.swing.JMenuItem nvMedio;
    // End of variables declaration//GEN-END:variables

    // Método para centrar la ventana horizontalmente
    private void centrarVentana() {
        // Obtiene las dimensiones de la pantalla
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        // Obtiene las dimensiones de la ventana
        Dimension ventana = getSize();
        // Calcula la posición en el eje X para centrar la ventana horizontalmente
        int posX = (pantalla.width - ventana.width) / 2;
        // Establece la posición de la ventana
        setLocation(posX, getY());
    }

    
    //Metodos Set
    public void setNumFilas(int numFilas) {
        this.numFilas = numFilas;
    }

    public void setNumColumnas(int numColumnas) {
        this.numColumnas = numColumnas;
    }

    public void setNumMinas(int numMinas) {
        this.numMinas = numMinas;
    }

    public void setAnchoControl(int anchoControl) {
        this.anchoControl = anchoControl;
    }

    public void setAltoControl(int altoControl) {
        this.altoControl = altoControl;
    }

}
