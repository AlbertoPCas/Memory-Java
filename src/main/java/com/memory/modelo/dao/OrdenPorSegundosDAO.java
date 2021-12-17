/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.modelo.dao;

import com.memory.modelo.entidades.Puntuacion;
import java.util.Comparator;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class OrdenPorSegundosDAO implements Comparator<Puntuacion> {
    
    @Override
    public int compare(Puntuacion o1, Puntuacion o2) {
        if (o1.getSegundos()< o2.getSegundos()) {
            return -1;
        } else if (o1.getSegundos()< o2.getSegundos()) {
            return 0;
        } else {
            return 1;
        }
    }

}
