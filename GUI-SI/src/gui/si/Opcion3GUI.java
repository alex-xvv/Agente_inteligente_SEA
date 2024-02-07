package gui.si;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Opcion3GUI extends JFrame implements KeyListener {
    private JLabel etiqueta;
    private int opcionSeleccionada;

    public Opcion3GUI() throws IOException {
        super("Opción 3");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        python voz = new python();
        voz.hablar("Opcion 3");
        etiqueta = new JLabel("Selecciona una opción para Opción 3:");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 16));
        add(etiqueta, BorderLayout.CENTER);

        opcionSeleccionada = 1; // Opción inicial

        setSize(300, 200);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se utiliza en este ejemplo
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_UP:
                if (opcionSeleccionada > 1) {
                    opcionSeleccionada--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (opcionSeleccionada < 3) {
                    opcionSeleccionada++;
                }
                break;
        }

        actualizarEtiqueta();
    }

    private void actualizarEtiqueta() {
        etiqueta.setText("Seleccionaste la opción " + opcionSeleccionada);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No se utiliza en este ejemplo
    }
}
