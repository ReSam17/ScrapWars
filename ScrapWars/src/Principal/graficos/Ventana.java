package Principal.graficos;


import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Ventana extends JFrame {

    private String titulo;

    public Ventana(final String titulo, final SupreficieDeDibujo sd){
        this.titulo=titulo;
        
        configurarVentana(sd);
    
    }

    private void configurarVentana(final SupreficieDeDibujo sd) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        //setIconImage();
        setLayout(new BorderLayout());
        add(sd, BorderLayout.CENTER);
        //setUndecorated(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
