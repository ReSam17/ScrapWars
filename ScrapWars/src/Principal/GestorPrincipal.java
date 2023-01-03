package Principal;

import Principal.graficos.SupreficieDeDibujo;
import Principal.graficos.Ventana;
import Principal.maquinaestado.GestorEstados;

public class GestorPrincipal{
    private boolean enFuncionamiento = false;
    private String titulo;
    private int ancho;
    private int alto;

    private SupreficieDeDibujo sd;
    private Ventana ventana;
    private GestorEstados ge;

    private GestorPrincipal (final String titulo, final int ancho, final int alto){
        this.titulo = titulo;
        this.ancho = ancho;
        this.alto = alto;
    }
    public static void main(String[] args) throws Exception {
        
        GestorPrincipal GP=new GestorPrincipal("Scrap Wars", 640,360);

        GP.iniciarBuclePrincipal();
        GP.iniciarJuego();
    }

    private void iniciarBuclePrincipal() {
        enFuncionamiento = true;
        inicializar();
    }

    private void inicializar() {
        sd = new SupreficieDeDibujo(ancho, alto);
        ventana = new Ventana(titulo, sd);
        ge = new GestorEstados();
    }

    private void iniciarJuego() {

        int aps = 0;
        int fps = 0;
        final int NS_Por_Sec=1000000000;
        final byte ATS_Max=60;
        final double NS_POR_ACTUALIZACION=NS_Por_Sec/ATS_Max;

        long refActualizacion=System.nanoTime();
        long refCOntador=System.nanoTime();

        double tiempoTranscurrido;
        double delta=0;

        while(enFuncionamiento){
            final long inicioBUcle=System.nanoTime();
            tiempoTranscurrido=inicioBUcle-refActualizacion;
            refActualizacion=inicioBUcle;
            delta+=tiempoTranscurrido/NS_POR_ACTUALIZACION;
            
            while (delta>=1) {
                actualizar();
                aps++;
                delta--;
            }
            
            dibujar();
            fps++;
            if(System.nanoTime()-refCOntador>NS_Por_Sec){
                System.out.println("FPS: " + fps +" || APS: " + aps  );
                aps=0;
                fps=0;
                refCOntador=System.nanoTime();
            }
        }
    }

    private void actualizar() {
        sd.getTeclado().actualizar();
        ge.actualizar();
    }

    private void dibujar(){
        sd.dibujar(ge);
    }
}

