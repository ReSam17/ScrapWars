package Principal.mapas;

import java.awt.Rectangle;

import Principal.sprites.Sprite;

public class Tiles {
    
    private final Sprite sprite;
    private final int id;
    private boolean solido;

    public Tiles(Sprite sprite, int id){
        this.sprite = sprite;
        this.id = id;
        this.solido = false;
    }

    public Tiles(Sprite sprite, int id, final boolean solido){
        this.sprite = sprite;
        this.id = id;
        this.solido = solido;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    public boolean isSolido() {
        return solido;
    }

    public Rectangle getLimites(int x, int y){
        return new Rectangle(sprite.getAncho(), sprite.getAlto());
    }
}
