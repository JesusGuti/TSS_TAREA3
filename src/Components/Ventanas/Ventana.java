package Components.Ventanas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import Components.Paneles.Panel;
import Components.Paneles.PanelSuperior;

public class Ventana extends JFrame{
    private int anchoVentana = 800;
    private int alturaVentana = 600;

    public Ventana() {
        this.iniciarVentana();
        this.iniciarComponentes();
    }   

    private void iniciarVentana() {
        this.setTitle("Simulacion de Inventario");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(anchoVentana, alturaVentana);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void iniciarComponentes() {
        PanelSuperior encabezado = new PanelSuperior();
        Panel panel = new Panel();
        encabezado.setPreferredSize(new Dimension(anchoVentana,70));
        panel.setPreferredSize(new Dimension(anchoVentana,300));
        this.add(encabezado, BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
    }
}
