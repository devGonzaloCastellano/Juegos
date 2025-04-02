import javax.swing.ImageIcon;

public class Cartas {
    String NombreCarta;
    ImageIcon ImagenCarta;

    Cartas(String nombreCarta, ImageIcon imagenCarta){
        this.NombreCarta = nombreCarta;
        this.ImagenCarta = imagenCarta;
    }

    public String toString(){
        return NombreCarta;
    }
}
