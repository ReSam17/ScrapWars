package Principal.maquinaestado.estados.juego;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Principal.maquinaestado.EstadoJuego;
import Principal.sprites.HojasDeSprites;

public class GestorDeJuego implements EstadoJuego{

    private GestorDelMapa gestorMapa; 
    HojasDeSprites hs = new HojasDeSprites("/data/Imagenes/HojasSprite/HojaTexturas/ScrapCity.png", 32, true);

    
    @Override
    public void actualizar() {
        
    }

    @Override
    public void dibujar(Graphics g) {
        BufferedImage imagen = hs.getSprite(0, 0).getImagen();
        g.drawImage(imagen, 100, 100, null);
    }
    
}
