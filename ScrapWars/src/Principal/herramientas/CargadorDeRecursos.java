package Principal.herramientas;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Principal.maquinaestado.estados.juego.GestorDeJuego;

public class CargadorDeRecursos {
    
    public static BufferedImage cargarImagenCompatibleOpaca(final String ruta){
        Image imagen = null;
        try {
            imagen = ImageIO.read(GestorDeJuego.class.getResource(ruta));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        
        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.OPAQUE);

        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        return imagenAcelerada;

    }

    public static BufferedImage cargarImagenCompatibleTranlucida(final String ruta){
        Image imagen = null;

        try {
            imagen = ImageIO.read(ClassLoader.class.getResource(ruta));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        
        BufferedImage imagenAcelerada = gc.createCompatibleImage(imagen.getWidth(null), imagen.getHeight(null), Transparency.TRANSLUCENT);

        Graphics g = imagenAcelerada.getGraphics();
        g.drawImage(imagen, 0, 0, null);
        g.dispose();
        return imagenAcelerada;

    }
}
