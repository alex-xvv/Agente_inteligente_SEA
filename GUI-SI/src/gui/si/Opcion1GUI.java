package gui.si;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Opcion1GUI extends JFrame implements KeyListener {
    private JLabel etiqueta;
    private int opcionSeleccionada;

    public Opcion1GUI() throws IOException {
        super("Opción 1");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        python voz = new python();
        voz.hablar("Opcion 1");
        etiqueta = new JLabel("Selecciona una opción para Opción 1:");
        etiqueta.setFont(new Font("Arial", Font.PLAIN, 16));
        add(etiqueta, BorderLayout.CENTER);

        opcionSeleccionada = 1; // Opción inicial

        JButton botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAGUISI();
            }
        });
        add(botonRegresar, BorderLayout.SOUTH);

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

    private void regresarAGUISI() {
        this.dispose(); // Cierra la ventana actual
        GUISI guisi = new GUISI();
        guisi.setVisible(true); // Muestra la ventana principal GUISI
    }
}
