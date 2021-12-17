/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.vista;

import javax.swing.JButton;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class GUIInicio extends javax.swing.JFrame {

    public GUIInicio() {
        initComponents();
    }

    public JButton getBotonForm() {
        return botonForm;
    }

    public JButton getBotonNum() {
        return botonNum;
    }

    public JButton getBotonVoc() {
        return botonVoc;
    }

    public JButton getBotonPuntuacion() {
        return botonPuntuacion;
    }

    public void setBotonForm(JButton botonForm) {
        this.botonForm = botonForm;
    }

    public void setBotonNum(JButton botonNum) {
        this.botonNum = botonNum;
    }

    public void setBotonVoc(JButton botonVoc) {
        this.botonVoc = botonVoc;
    }

    public void setBotonPuntuacion(JButton botonPuntuacion) {
        this.botonPuntuacion = botonPuntuacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        botonForm = new javax.swing.JButton();
        botonVoc = new javax.swing.JButton();
        botonPuntuacion = new javax.swing.JButton();
        botonNum = new javax.swing.JButton();
        labelOrdenar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());
        getContentPane().add(botonForm, new java.awt.GridBagConstraints());
        getContentPane().add(botonVoc, new java.awt.GridBagConstraints());

        botonPuntuacion.setText("Puntuación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        getContentPane().add(botonPuntuacion, gridBagConstraints);
        getContentPane().add(botonNum, new java.awt.GridBagConstraints());

        labelOrdenar.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        labelOrdenar.setForeground(new java.awt.Color(0, 0, 153));
        labelOrdenar.setText("ORDENAR");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(labelOrdenar, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonForm;
    private javax.swing.JButton botonNum;
    private javax.swing.JButton botonPuntuacion;
    private javax.swing.JButton botonVoc;
    private javax.swing.JLabel labelOrdenar;
    // End of variables declaration//GEN-END:variables
}
