package Principal.graficos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Toolkit;

import Principal.controles.Teclado;
import Principal.maquinaestado.GestorEstados;

public class SupreficieDeDibujo extends Canvas {
    
    private int ancho;
    private int alto;
    
    private Teclado teclado;

    public SupreficieDeDibujo(final int ancho, final int alto){
        this.ancho = ancho;
        this.alto = alto;

        teclado = new Teclado();
        
        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(ancho, alto));
        addKeyListener(teclado);
        setFocusable(true);
        requestFocus();


    }

    public void dibujar(GestorEstados ge){

        BufferStrategy buffer = getBufferStrategy();

        if (buffer == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = buffer.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, ancho, alto);

        ge.dibujar(g);

        Toolkit.getDefaultToolkit().sync();

        g.dispose();

        buffer.show();
        
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

}
