package Logica;

    import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.Icon;


public class CargadorImagenes {
    
    
    public static ImageIcon cargarSonrisa(int ancho, int alto) {
        ImageIcon icono = new ImageIcon(CargadorImagenes.class.getResource("/img/carita.png"));
        Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }
    
    public static ImageIcon cargarBomba(int ancho, int alto) {
        ImageIcon icono = new ImageIcon(CargadorImagenes.class.getResource("/img/bomba.png"));
        Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }
    
    public static ImageIcon cargarBandera(int ancho, int alto) {
        ImageIcon icono = new ImageIcon(CargadorImagenes.class.getResource("/img/bandera.png"));
        Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }
    
    public static ImageIcon cargarExplosion(int ancho, int alto) {
        ImageIcon icono = new ImageIcon(CargadorImagenes.class.getResource("/img/explosion.png"));
        Image imagen = icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagen);
    }

    
}
    

