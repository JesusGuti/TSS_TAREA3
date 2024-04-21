package Components.Listeners;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;

public class CampoIteracionesListener implements KeyListener,MouseListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char caracter = e.getKeyChar();
        if (!Character.isDigit(caracter) && caracter != KeyEvent.VK_BACK_SPACE) {
            e.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTextField campo = (JTextField) e.getSource();
        String condicion = "Ingrese el numero de iteraciones a ejecutar";
        if(campo.getText().equals(condicion)){
            campo.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
} 