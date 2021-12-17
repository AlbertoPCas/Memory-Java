/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.controlador;

import com.memory.modelo.dao.OrdenPorSegundosDAO;
import com.memory.modelo.dao.PuntuacionDAO;
import com.memory.modelo.entidades.Puntuacion;
import com.memory.vista.GUIInicio;
import com.memory.vista.GUIPuntuacion;
import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class ControladorPuntuacion {

    private GUIPuntuacion guiPuntuacion;
    private PuntuacionDAO puntuacionDAO = new PuntuacionDAO();
    private OrdenPorSegundosDAO ordenDAO = new OrdenPorSegundosDAO();

    private List<Puntuacion> listaPuntuacion;
    private DefaultListModel<Puntuacion> modeloLista;

    public ControladorPuntuacion() {
        guiPuntuacion = new GUIPuntuacion();
    }

    public void setVentanaPuntuacion(GUIPuntuacion guiPuntuacion) {
        this.guiPuntuacion = guiPuntuacion;
        setFrame();
        configurarBotones();
        cargarDatos();
        guiPuntuacion.setVisible(true);
    }

    private void setFrame() {
        guiPuntuacion.setSize(500, 500);
        guiPuntuacion.setTitle("Puntuación");
        guiPuntuacion.setLocationRelativeTo(null);
        guiPuntuacion.setResizable(false);
        guiPuntuacion.getContentPane().setBackground(new Color(255, 250, 148));
        guiPuntuacion.getjLabel2().setAlignmentX(CENTER_ALIGNMENT);
        guiPuntuacion.getBotonSalir().setAlignmentX(CENTER_ALIGNMENT);
        guiPuntuacion.getBotonBorrar().setAlignmentX(CENTER_ALIGNMENT);
    }

    private void configurarBotones() {
        guiPuntuacion.getBotonSalir().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed();
            }
        });

        guiPuntuacion.getBotonBorrar().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBorrarActionPerformed();
            }
        });
    }

    private void cargarDatos() {
        modeloLista = new DefaultListModel<Puntuacion>();
        listaPuntuacion = puntuacionDAO.list();
        Collections.sort(listaPuntuacion, ordenDAO);
        for (int i = 0; i < listaPuntuacion.size(); i++) {
            modeloLista.add(i, listaPuntuacion.get(i));
        }

        guiPuntuacion.getlistaPuntuacion().setModel(modeloLista);
    }

    private void botonSalirActionPerformed() {
        guiPuntuacion.dispose();
        ControladorInicio ci = new ControladorInicio();
        GUIInicio gui = new GUIInicio();
        ci.setVentanaInicio(gui);
    }

    private void botonBorrarActionPerformed() {
        int resp = JOptionPane.showConfirmDialog(null, "Se borrarán todos los resultados. ¿Desea continuar?");
        if (resp == JOptionPane.OK_OPTION) {
            puntuacionDAO.delete();
            modeloLista = new DefaultListModel<>();
            guiPuntuacion.getlistaPuntuacion().setModel(modeloLista);
        }
    }
}
