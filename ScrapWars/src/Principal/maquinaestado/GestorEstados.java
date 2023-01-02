package Principal.maquinaestado;

import Principal.maquinaestado.estados.juego.GestorDeJuego;

import java.awt.Graphics;

public class GestorEstados {

    private EstadoJuego[] estados;
    private EstadoJuego estadoActual;
    
    public GestorEstados(){
        iniciarEstados();
        iniciarEstadoActual();
    }

    private void iniciarEstadoActual() {
        estadoActual = estados[0];
    }

    private void iniciarEstados() {
        estados = new EstadoJuego[1];
        estados[0] =  new GestorDeJuego();

        //Añadir estados
    }

    public void actualizar(){
        estadoActual.actualizar();
    }

    public void dibujar(final Graphics g){
        estadoActual.dibujar(g);
    }

    public void cambiarEstadoActual(final int nuevoEstado){
        estadoActual = estados[nuevoEstado];
    }

    public EstadoJuego getEstadoActual() {
        return estadoActual;
    }
}
