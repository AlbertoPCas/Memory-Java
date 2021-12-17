/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.app;

import com.memory.controlador.ControladorInicio;

import com.memory.vista.GUIInicio;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class Principal {

    public static void main(String[] args) {
        ControladorInicio ci = new ControladorInicio();
        GUIInicio gui = new GUIInicio();
        ci.setVentanaInicio(gui);
    }
}
