/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.controlador;

import com.memory.vista.GUIInicio;
import com.memory.vista.GUIVictoria;
import java.awt.Color;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class ControladorVictoria {

    private GUIVictoria guiVictoria;
    private int segundos;

    public ControladorVictoria(int segundos) {
        guiVictoria = new GUIVictoria();
        this.segundos = segundos;
    }

    public void setVentanaVictoria(GUIVictoria guiVictoria) {
        this.guiVictoria = guiVictoria;
        setFrame();
        guiVictoria.setVisible(true);
    }

    private void setFrame() {
        guiVictoria.setLocationRelativeTo(null);
        guiVictoria.setResizable(false);
        guiVictoria.setTitle("¡HAS GANADO!");
        guiVictoria.getContentPane().setBackground(new Color(255, 250, 148));
        guiVictoria.getLabelTiempo().setText("Tu puntuación: " + segundos + " segundos");
        guiVictoria.getBotonSalir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed();
            }
        });
    }

    private void botonSalirActionPerformed() {
        guiVictoria.dispose();
        ControladorInicio ci = new ControladorInicio();
        GUIInicio gui = new GUIInicio();
        ci.setVentanaInicio(gui);
    }
}
