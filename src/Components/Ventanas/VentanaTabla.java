package Components.Ventanas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import Models.Calculo;
import Components.Paneles.PanelTabla;
import Components.Paneles.PanelSuperior;
import Components.Paneles.PanelTabla;


public class VentanaTabla extends JFrame {
    private int anchoVentana = 1000;
    private int alturaVentana = 600;
    private Calculo calculo;

    public VentanaTabla(Calculo calculo) {
        this.calculo = calculo;
        iniciarVentana();
        iniciarComponentes();
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
        PanelTabla panel = new PanelTabla(calculo);
        encabezado.setPreferredSize(new Dimension(anchoVentana,70));
        panel.setPreferredSize(new Dimension(anchoVentana,300));
        this.add(encabezado, BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
    }
}
