package Components.Ventanas;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Models.Calculo;
import Components.Paneles.PanelGrafica;
import Components.Paneles.PanelSuperior;

public class VentanaGrafica extends JFrame {
    private int anchoVentana = 1000;
    private int alturaVentana = 600;
    private Calculo calculo;
    
    public VentanaGrafica(Calculo calculo) {
        this.calculo = calculo;
        iniciarVentana();
        iniciarComponentes();
    }

    public void iniciarVentana() {
        this.setTitle("Sistema de Inventarios - Grafica de Lineas");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocation(500, 0);
        this.setSize(anchoVentana,alturaVentana);
        this.setVisible(true);
    }

    private void iniciarComponentes() {
        PanelSuperior encabezado = new PanelSuperior();
        PanelGrafica panel = new PanelGrafica(calculo);
        encabezado.setPreferredSize(new Dimension(anchoVentana,70));
        panel.setPreferredSize(new Dimension(anchoVentana,300));
        this.add(encabezado, BorderLayout.NORTH);
        this.add(panel,BorderLayout.CENTER);
    }
}
