/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.modelo.dao;

import com.memory.modelo.conexion.Conexion;
import com.memory.modelo.entidades.Puntuacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class PuntuacionDAO {

    public int insert(Puntuacion puntuacion) {
        String sql = "INSERT INTO ranking (tiempo) VALUES (?)";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, puntuacion.getSegundos());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int delete() {
        String sql = "DELETE FROM ranking";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            return ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public Puntuacion get(Integer idPuntos) {
        String sql = "SELECT * FROM alumno WHERE idPuntos=?";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ps.setInt(1, idPuntos);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Puntuacion puntuacion = new Puntuacion();
                puntuacion.setId(rs.getInt(1));
                puntuacion.setSegundos(rs.getInt(2));
                return puntuacion;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Puntuacion> list() {
        List<Puntuacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM ranking";
        try (PreparedStatement ps = Conexion.abrirConexion().prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Puntuacion puntuacion = new Puntuacion();
                puntuacion.setId(rs.getInt(1));
                puntuacion.setSegundos(rs.getInt(2));
                lista.add(puntuacion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PuntuacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
