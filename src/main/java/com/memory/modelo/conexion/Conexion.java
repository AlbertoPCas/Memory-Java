/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.modelo.conexion;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class Conexion {

    private static Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/memory";
    private static final String username = "root";
    private static final String password = "";
    
        private Blob image = null;
    private byte[] imgData = null;

    public static Connection abrirConexion() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    
    public ImageIcon setIcono(int idNum, int modo) {
        try (Connection conn = abrirConexion()) {
            String sql = "";
            switch (modo) {
                case 0:
                    sql = "SELECT * FROM numeros WHERE id=?";
                    break;
                case 1:
                    sql = "SELECT * FROM vocales WHERE id=?";
                    break;
                case 2:
                    sql = "SELECT * FROM formas WHERE id=?";
                    break;
            }
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (idNum + 1));
            ResultSet rs = ps.executeQuery();
            rs.next();
            this.image = rs.getBlob("imagen");
            imgData = this.image.getBytes(1, (int) this.image.length());
            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(imgData));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Image imagen = img;
            ImageIcon imagenIcono = new ImageIcon(imagen);
            return imagenIcono;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
