/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.modelo.entidades;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class Puntuacion {
    private int id;
    private int segundos;

    public Puntuacion(int segundos) {
        this.segundos = segundos;
    }

    public Puntuacion() {
    }

    public int getId() {
        return id;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public String toString() {
        return "Tiempo: " + segundos + " / ID: " + id;
    }
}
