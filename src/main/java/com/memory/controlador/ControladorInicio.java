/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.controlador;

import com.memory.modelo.conexion.Conexion;
import com.memory.vista.GUIInicio;
import com.memory.vista.GUIJuego;
import com.memory.vista.GUIPuntuacion;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class ControladorInicio {

    private GUIInicio guiInicio;
    private GUIJuego guiJuego;

    ControladorPuntuacion controladorPuntuacion = new ControladorPuntuacion();
    GUIPuntuacion guiPuntuacion = new GUIPuntuacion();

    private Conexion conexion = new Conexion();

    public ControladorInicio() {
        guiInicio = new GUIInicio();
    }

    public void setVentanaInicio(GUIInicio guiInicio) {
        this.guiInicio = guiInicio;
        setFrame();
        guiInicio.setVisible(true);
    }

    private void setFrame() {
        guiInicio.setTitle("Inicio");
        guiInicio.setSize(500, 500);
        guiInicio.setResizable(false);
        guiInicio.getContentPane().setBackground(new Color(255, 250, 148));
        guiInicio.setLocationRelativeTo(null);
        configurarBotones();
    }

    private void configurarBotones() {
        Dimension tamanioBot = new Dimension(100, 100);

        guiInicio.getBotonForm().setIcon(conexion.setIcono(1, 2));
        guiInicio.getBotonForm().setPreferredSize(tamanioBot);
        guiInicio.getBotonForm().setMinimumSize(tamanioBot);
        guiInicio.getBotonForm().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(2);
            }
        });

        guiInicio.getBotonVoc().setIcon(conexion.setIcono(1, 1));
        guiInicio.getBotonVoc().setPreferredSize(tamanioBot);
        guiInicio.getBotonVoc().setMinimumSize(tamanioBot);
        guiInicio.getBotonVoc().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(1);
            }
        });

        guiInicio.getBotonNum().setPreferredSize(tamanioBot);
        guiInicio.getBotonNum().setMinimumSize(tamanioBot);
        guiInicio.getBotonNum().setIcon(conexion.setIcono(9, 0));
        guiInicio.getBotonNum().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActionPerformed(0);
            }
        });

        guiInicio.getBotonPuntuacion().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRankActionPerformed(evt);
            }
        });
    }

    private void botonActionPerformed(int modo) {
        guiInicio.dispose();
        ControladorJuego controladorJuego = new ControladorJuego(modo);
        GUIJuego guijuego = new GUIJuego(modo);
        controladorJuego.setVentanaJuego(guijuego);
    }

    private void botonRankActionPerformed(java.awt.event.ActionEvent evt) {
        guiInicio.dispose();
        controladorPuntuacion.setVentanaPuntuacion(guiPuntuacion);
    }
}
