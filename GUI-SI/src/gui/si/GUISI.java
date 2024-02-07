package gui.si;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUISI extends JFrame implements KeyListener {
    
    private JLabel etiqueta;
    private int opcionSeleccionada;

    public GUISI() {
        super("GUI tareas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        etiqueta = new JLabel("Selecciona una opción:");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 16));
        add(etiqueta, BorderLayout.CENTER);

        opcionSeleccionada = 1; // Opción inicial

        setSize(300, 200);
        setLocationRelativeTo(null);
        addKeyListener(this);
        setFocusable(true);
    }

    private void mostrarVentanaOpcion(String nombreOpcion) throws IOException {
    JFrame ventanaOpcion = null;

    switch (nombreOpcion) {
        case "Opción 1":
            ventanaOpcion = new Opcion1GUI();
            break;
        case "Opción 2":
            ventanaOpcion = new Opcion2GUI();
            break;
        case "Opción 3":
            ventanaOpcion = new Opcion3GUI();
            break;
    }

    if (ventanaOpcion != null) {
        ventanaOpcion.setVisible(true);
        this.setVisible(false); // Oculta la ventana principal GUISI
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUISI tecladoGUI = new GUISI();
            tecladoGUI.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No se utiliza en este ejemplo
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (opcionSeleccionada > 1) {
                    opcionSeleccionada--;
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (opcionSeleccionada < 3) {
                    opcionSeleccionada++;
                }
                break;
            case KeyEvent.VK_ENTER:
                switch (opcionSeleccionada) {
                    case 1:                        
            {
                try {
                    mostrarVentanaOpcion("Opción 1");
                } catch (IOException ex) {
                    Logger.getLogger(GUISI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        break;

                    case 2:
            {
                try {
                    mostrarVentanaOpcion("Opción 2");
                } catch (IOException ex) {
                    Logger.getLogger(GUISI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        break;

                    case 3:
            {
                try {
                    mostrarVentanaOpcion("Opción 3");
                } catch (IOException ex) {
                    Logger.getLogger(GUISI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                        break;

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
