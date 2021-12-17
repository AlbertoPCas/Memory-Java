/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.vista;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class GUIVictoria extends javax.swing.JFrame {

    public GUIVictoria() {
        initComponents();
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JLabel getLabelTiempo() {
        return labelTiempo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        labelTiempo = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        labelTit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        labelTiempo.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        labelTiempo.setForeground(new java.awt.Color(102, 102, 255));
        labelTiempo.setText("Tu puntuación: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        getContentPane().add(labelTiempo, gridBagConstraints);

        botonSalir.setText("Salir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        getContentPane().add(botonSalir, gridBagConstraints);

        labelTit.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        labelTit.setForeground(new java.awt.Color(51, 0, 255));
        labelTit.setText("¡HAS GANADO!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        getContentPane().add(labelTit, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel labelTiempo;
    private javax.swing.JLabel labelTit;
    // End of variables declaration//GEN-END:variables
}
