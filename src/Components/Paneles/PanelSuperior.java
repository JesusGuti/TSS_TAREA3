package Components.Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;

public class PanelSuperior extends JPanel {
    BufferedImage escudo = null;
    BufferedImage fcyt = null;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Crear colores
        Color azul = new Color(0, 0, 255);
        Color rojo = new Color(255, 0, 0);

        // Crear degradado
        GradientPaint degradado = new GradientPaint(0, 0, azul, getWidth(), getHeight(), rojo);

        // Pintar el fondo con el degradado
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(degradado);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
    
    public PanelSuperior() {
        iniciarPanel();
    }

    public void iniciarPanel() {
        // Crea los JLabels para el logo escudo (izquierdo) y se ajusta el tamaño
        try {
            escudo = ImageIO.read(new File("src/Imgs/escudo.png"));
            fcyt = ImageIO.read(new File("src/Imgs/fcyt.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Se crea el JLabel para el logo escudo (izquierdo) y se ajusta su tamano
        JLabel logoIzquierdo = new JLabel();
        logoIzquierdo.setSize(60, 60);
        //Reescalamos la imagen para que se ajuste al JLabel
        Image imageEscudoEscalado = escudo.getScaledInstance(logoIzquierdo.getWidth(), logoIzquierdo.getHeight(),
        Image.SCALE_SMOOTH);
        //Creamos el icono con la imagen reescalada
        ImageIcon imageEscudoFinal = new ImageIcon(imageEscudoEscalado);
        logoIzquierdo.setIcon(imageEscudoFinal);
        
        // Crea los JLabels para el logo fcyt (derecho) y se ajusta el tamaño
        JLabel logoDerecho = new JLabel();
        logoDerecho.setSize(45, 50);
        //Reescalamos la imagen para que se ajuste al JLabel
        Image imageFcytEscalado = fcyt.getScaledInstance(logoDerecho.getWidth(), logoDerecho.getHeight(),Image.SCALE_SMOOTH);
        //Creamos el icono con la imagen reescalada
        ImageIcon imageFcytFinal = new ImageIcon(imageFcytEscalado);
        logoDerecho.setIcon(imageFcytFinal);
        // Agrega los logos al panel usando BorderLayout
        this.add(logoIzquierdo, BorderLayout.WEST);
        this.add(crearTitulo(), BorderLayout.CENTER); // Título en el centro
        this.add(logoDerecho, BorderLayout.EAST);

        this.setBackground(new Color(77, 72, 72));
        this.setVisible(true);
        // JLabel titulo = crearTitulo();
        // this.add(titulo);
    }

    private JLabel crearTitulo() {
        JLabel titulo = new JLabel("Simulación de Inventario");
        titulo.setForeground(new Color(255, 255, 255));
        titulo.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
        return titulo;
    }
}
