package Principal.controles;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Teclado implements KeyListener{
    
    private static final int NUMERO_TECLAS = 256;
    private final boolean[] teclas = new boolean[NUMERO_TECLAS];
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean correr;

    public boolean salir;

    public void actualizar() {
        arriba=teclas[KeyEvent.VK_W];
        abajo=teclas[KeyEvent.VK_S];
        izquierda=teclas[KeyEvent.VK_A];
        derecha=teclas[KeyEvent.VK_D];

        correr=teclas[KeyEvent.VK_SHIFT];

        salir=teclas[KeyEvent.VK_ESCAPE];
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()]=true;
    }

    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()]=false;
    }

}
