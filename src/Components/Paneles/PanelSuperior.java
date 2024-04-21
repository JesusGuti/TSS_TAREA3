package Components.Paneles;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel{

    public PanelSuperior() {
        iniciarPanel();
    }

    public void iniciarPanel() {
        this.setBackground(new Color(77,72,72));
        this.setVisible(true);     
        JLabel titulo = crearTitulo();
        this.add(titulo);   
    }

    private JLabel crearTitulo() {
        JLabel titulo = new JLabel("Simulación de Inventario - Taller de Simulacion de Sistemas");
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font(Font.MONOSPACED,Font.PLAIN , 15));
        return titulo;
    }
}
