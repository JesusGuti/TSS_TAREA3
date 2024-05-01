package Components.Paneles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GraphicsEnvironment;
import java.awt.FontFormatException;
import Components.Listeners.CampoIteracionesListener;
import Components.Ventanas.VentanaGrafica;
import Components.Ventanas.VentanaTabla;
import Models.HookeJeeves;
import Models.Calculo;

public class Panel extends JPanel {
    private JTextField campoIteraciones;
    private HookeJeeves hookeJeeves;
    private VentanaTabla tabla = null;
    private VentanaGrafica grafica = null;

    public Panel() {
        iniciarPanel();
        iniciarComponentes();
    }

    public void iniciarPanel() {
        this.setLayout(new GridLayout(3, 1)); // GridLayout con 3 filas y 1 columna
        this.setBorder(BorderFactory.createEmptyBorder(10, 50, 20, 50));
        this.setBackground(new Color(255, 255, 255));
    }

    public void iniciarComponentes() {
        definirParrafoIntroduccion();
        definirCampoIteraciones();
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotones.setBackground(new Color(255, 255, 255));
        definirBotones(panelBotones);
        this.add(panelBotones);
    }

    private void definirParrafoIntroduccion() {
        try {
            // create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src\\Fonts\\Roboto-Regular.ttf")).deriveFont(18f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);
            JLabel textoIntroductorio = new JLabel();
        String texto = "Toda empresa tiene la preocupación de maximizar sus ganancias por lo que este es su\r\n" + //
                "objetivo principal. Para lograr esto, la empresa debe valorar, cuantificar y expresar de\r\n" + //
                "alguna manera aquellos factores que reporte el más alto beneficio posible.\r\n" + //
                "Este pequeño programa simula el comportamiento de una empresa donde ciertas variables son simuladas con distribuciones estadisticas.<br>"
                + //
                "\r\n" + //
                "<b>Para continuar ingrese el numero de iteraciones que desea probar<b>";
        textoIntroductorio.setText("<html> <p>" + texto + "</p></html>");
        textoIntroductorio.setFont(customFont);
        this.add(textoIntroductorio);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
        
    }

    private void definirCampoIteraciones() {
        JPanel panelCampo = new JPanel(new BorderLayout()); // Panel para el campo de iteraciones
        JLabel label = new JLabel("Definir el numero de iteraciones a probar");
        String placeholder = "Ingrese el numero de iteraciones a ejecutar";
        campoIteraciones = new JTextField(placeholder);
        campoIteraciones.setMaximumSize(new Dimension(500, 20));
        CampoIteracionesListener campoListener = new CampoIteracionesListener();
        campoIteraciones.addKeyListener(campoListener);
        campoIteraciones.addMouseListener(campoListener);
        panelCampo.add(label, BorderLayout.NORTH);
        panelCampo.add(campoIteraciones, BorderLayout.CENTER);
        this.add(panelCampo);
    }

    private void definirBotones(JPanel panelBotones) {
        JButton botonLimpiar = new JButton("Limpiar");
        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    campoIteraciones.setText("");
                    hookeJeeves = null;
                } catch (Error error) {

                }
            }
        });
        JButton botonTabla = new JButton("Ver Tabla");
        botonTabla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textoIteraciones = campoIteraciones.getText();
                    int numeroIteraciones = Integer.parseInt(textoIteraciones);
                    if (hookeJeeves == null) {
                        hookeJeeves = new HookeJeeves(numeroIteraciones);
                    }
                    Calculo calculo = hookeJeeves.obtenerMejorCalculo();
                    String mensaje = obtenerMensajeValoresValidos();
                    JOptionPane.showMessageDialog(null, mensaje, "Valores Optimos", JOptionPane.INFORMATION_MESSAGE);
                    tabla = new VentanaTabla(calculo);
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Debe insertar un número válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton botonGrafica = new JButton("Ejecutar");
        botonGrafica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textoIteraciones = campoIteraciones.getText();
                    int numeroIteraciones = Integer.parseInt(textoIteraciones);
                    if (hookeJeeves == null) {
                        hookeJeeves = new HookeJeeves(numeroIteraciones);
                    }
                    Calculo calculo = hookeJeeves.obtenerMejorCalculo();
                    String mensaje = obtenerMensajeValoresValidos();
                    JOptionPane.showMessageDialog(null, mensaje, "Valores Optimos", JOptionPane.INFORMATION_MESSAGE);
                    grafica = new VentanaGrafica(calculo);
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Debe insertar un número válido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        darEstiloABotones(botonLimpiar);
        darEstiloABotones(botonGrafica);
        darEstiloABotones(botonTabla);
        panelBotones.add(botonLimpiar);
        panelBotones.add(botonTabla);
        panelBotones.add(botonGrafica);
    }

    private void darEstiloABotones(JButton boton) {
        boton.setForeground(new Color(255, 255, 255));
        boton.setBackground(new Color(15, 157, 201));
    }

    private void cerrarVentana(JFrame ventana) {
        if (ventana != null) {
            ventana.dispose();
            ventana = null;
        }
    }

    private String obtenerMensajeValoresValidos() {
        String mensaje = "Los valores optimos son, r: " + hookeJeeves.obtenerR() + " y q:" + hookeJeeves.obtenerQ();
        return mensaje;
    }
}
