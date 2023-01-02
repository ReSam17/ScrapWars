package Principal.sprites;

import java.awt.image.BufferedImage;

import Principal.herramientas.CargadorDeRecursos;

public class HojasDeSprites {
    
    private final int anchoPixeles;
    private final int altoPixeles;

    private final int anchoHojaEnSprite;
    private final int altoHoojaEnSprite;

    private final int anchoSprite;
    private final int altoSprite;

    private Sprite[] sprites;

    public HojasDeSprites(final String ruta, final int tamanoSprite, final boolean hojaOpaca){

        final BufferedImage imagen;

        if (hojaOpaca) {
            imagen = CargadorDeRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            imagen = CargadorDeRecursos.cargarImagenCompatibleTranlucida(ruta);
        }

        anchoPixeles = imagen.getWidth();
        altoPixeles = imagen.getHeight();

        anchoHojaEnSprite = anchoPixeles / tamanoSprite;
        altoHoojaEnSprite = altoPixeles / tamanoSprite;

        anchoSprite = tamanoSprite;
        altoSprite = tamanoSprite;

        sprites = new Sprite[anchoHojaEnSprite * altoHoojaEnSprite];

        extraerSpriteDesdeImagen(imagen);

    }

    public HojasDeSprites(final String ruta, final int anchoDesprite, final int altoDeSprite, final boolean hojaOpaca){

        final BufferedImage imagen;
        
        if (hojaOpaca) {
            imagen = CargadorDeRecursos.cargarImagenCompatibleOpaca(ruta);
        } else {
            imagen = CargadorDeRecursos.cargarImagenCompatibleTranlucida(ruta);
        }

        anchoPixeles = imagen.getWidth();
        altoPixeles = imagen.getHeight();

        anchoHojaEnSprite = anchoPixeles / anchoDesprite;
        altoHoojaEnSprite = altoPixeles / altoDeSprite;

        anchoSprite = anchoDesprite;
        altoSprite = altoDeSprite;

        sprites = new Sprite[anchoHojaEnSprite * altoHoojaEnSprite];

        extraerSpriteDesdeImagen(imagen);

    }

    private void extraerSpriteDesdeImagen(final BufferedImage imagen){
        
        for (int y = 0; y < altoHoojaEnSprite; y++) {
            for (int x = 0; x < anchoHojaEnSprite; x++) {
                final int posX = x * anchoSprite;
                final int posY = y * altoSprite;

                sprites[x + y * anchoHojaEnSprite] = new Sprite(imagen.getSubimage(posX, posY, anchoSprite, altoSprite));
            }
        }
    }

    public Sprite getSPrite(final int posicion){
        return sprites[posicion];
    }

    public Sprite getSprite(final int x, final int y){
        return sprites[x + y * anchoHojaEnSprite];
    }
}
