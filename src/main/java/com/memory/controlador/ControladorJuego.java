/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.memory.controlador;

import com.memory.modelo.conexion.Conexion;
import com.memory.modelo.dao.PuntuacionDAO;
import com.memory.modelo.entidades.Puntuacion;
import com.memory.vista.GUIInicio;
import com.memory.vista.GUIJuego;
import com.memory.vista.GUIVictoria;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Alberto Pérez Castañeda
 */
public class ControladorJuego {

    private PuntuacionDAO puntuacionDAO = new PuntuacionDAO();
    private Conexion conexion = new Conexion();
    private GUIJuego guiJuego;
    private int modoJuego;

    private ArrayList<Integer> listaNumOrd = new ArrayList<Integer>();

    Timer timer = new Timer();
    private int segundos = 0;
    private boolean start = false;
    private int contadorAciertos = 0;

    private Dimension dimensionBotones = new Dimension(100, 100);
    private Color colorFondo = new Color(255, 250, 148);
    private String rutaImgInterr = "./src/main/java/com/memory/resources/interrogacion.png";

    private ArrayList<JButton> listaBotones = new ArrayList<>();
    private JButton botNort;
    private JButton botSur;
    private JButton botEste;
    private JButton botOeste;
    private JButton botCentro;

    TimerTask tarea = new TimerTask() {
        @Override
        public void run() {
            guiJuego.getContadorSegundos().setText(String.valueOf(segundos));
            segundos++;

            if (segundos == 15) {
                start = true;
                if (modoJuego == 0) {
                    reiniciarBotonesNum();
                }

                if (modoJuego == 1 || modoJuego == 2) {
                    reiniciarBotonesVocForm();
                }
            }

            if (start == true) {
                if (modoJuego == 0) {
                    guiJuego.getBotonEjemplo().setIcon(seleccionarImagenNumeros(listaNumOrd.get(contadorAciertos)));
                } else if (modoJuego == 1) {
                    guiJuego.getBotonEjemplo().setIcon(seleccionarImagenVocales(listaNumOrd.get(contadorAciertos)));
                } else if (modoJuego == 2) {
                    guiJuego.getBotonEjemplo().setIcon(seleccionarImagenFormas(listaNumOrd.get(contadorAciertos)));
                }
            }
        }
    };

    public ControladorJuego(int modo) {
        guiJuego = new GUIJuego(modo);
        modoJuego = modo;
        timer.schedule(tarea, 0, 1000);

    }

    public void setVentanaJuego(GUIJuego guiJuego) {
        this.guiJuego = guiJuego;
        setFrame(modoJuego);
        guiJuego.setVisible(true);
    }

    private void setFrame(int mode) {
        guiJuego.setSize(500, 600);
        guiJuego.setLocationRelativeTo(null);
        guiJuego.setResizable(false);
        guiJuego.getContentPane().setBackground(colorFondo);
        guiJuego.getPanelBotones().setBackground(colorFondo);
        guiJuego.getBotonAtras().setIcon(new ImageIcon("./src/main/java/com/memory/resources/volver.png"));
        guiJuego.getBotonEjemplo().setIcon(new ImageIcon(rutaImgInterr));
        guiJuego.getBotonAtras().addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAtrasActionPerformed();
            }
        });

        if (mode == 0) {
            // Generar botones números 1-10
            guiJuego.setTitle("Memorizar números");
            configBotNum();
        } else if (mode == 1) {
            // Generar botones vocales
            guiJuego.setTitle("Memorizar vocales");
            configBotVoc(1);
        } else if (mode == 2) {
            // Generar botones figuras
            guiJuego.setTitle("Memorizar figuras geométricas");
            configBotVoc(2);
        }
    }

    private void configBotNum() {
        guiJuego.setSize(500, 850);
        guiJuego.setLocationRelativeTo(null);
        ArrayList<Integer> listaNum = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            listaNum.add(i);
        }
        listaNumOrd.addAll(listaNum);
        Collections.shuffle(listaNum);

        guiJuego.getPanelBotones().setLayout(new GridLayout(0, 2, 10, 10));
        for (int i = 0; i < listaNum.size(); i++) {
            JPanel panelProv = new JPanel();
            panelProv.setBackground(colorFondo);
            JButton botonProv = new JButton();
            botonProv.setIcon(new ImageIcon(rutaImgInterr));
            botonProv.setPreferredSize(dimensionBotones);
            panelProv.add(botonProv);
            guiJuego.getPanelBotones().add(panelProv);
            listaBotones.add(botonProv);
        }

        for (int i = 0; i < 10; i++) {
            ListenerBotNum(i, listaNum);
        }
    }

    private void ListenerBotNum(int boton, ArrayList listaNum) {
        listaBotones.get(boton).addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botNumMouseEntered(listaBotones.get(boton), listaNum, boton);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseSalirBoton(listaBotones.get(boton));
            }
        });
        listaBotones.get(boton).addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botNumActionPerformed(listaBotones.get(boton), listaNum, boton);
            }
        });
    }

    private void configBotVoc(int modoJuego) {
        ArrayList<Integer> listaNum = new ArrayList<Integer>();
        for (int i = 0; i <= 4; i++) {
            listaNum.add(i);
        }
        listaNumOrd.addAll(listaNum);
        Collections.shuffle(listaNum);

        guiJuego.getPanelBotones().setLayout(new GridBagLayout());
        botNort = new JButton();
        botNort.setIcon(new ImageIcon(rutaImgInterr));
        GridBagConstraints consNort = new GridBagConstraints();
        consNort.gridx = 1;
        consNort.gridy = 0;
        botNort.setPreferredSize(dimensionBotones);
        botNort.setMinimumSize(dimensionBotones);
        listenerBotonForm(botNort, listaNum, 0);

        botSur = new JButton();
        botSur.setIcon(new ImageIcon(rutaImgInterr));
        GridBagConstraints consSur = new GridBagConstraints();
        consSur.gridx = 1;
        consSur.gridy = 2;
        botSur.setPreferredSize(dimensionBotones);
        botSur.setMinimumSize(dimensionBotones);
        listenerBotonForm(botSur, listaNum, 1);

        botEste = new JButton();
        botEste.setIcon(new ImageIcon(rutaImgInterr));
        GridBagConstraints consEste = new GridBagConstraints();
        consEste.gridx = 2;
        consEste.gridy = 1;
        botEste.setPreferredSize(dimensionBotones);
        botEste.setMinimumSize(dimensionBotones);
        listenerBotonForm(botEste, listaNum, 2);

        botOeste = new JButton();
        botOeste.setIcon(new ImageIcon(rutaImgInterr));
        GridBagConstraints consOeste = new GridBagConstraints();
        consOeste.gridx = 0;
        consOeste.gridy = 1;
        botOeste.setPreferredSize(dimensionBotones);
        botOeste.setMinimumSize(dimensionBotones);
        listenerBotonForm(botOeste, listaNum, 3);

        botCentro = new JButton();
        botCentro.setIcon(new ImageIcon(rutaImgInterr));
        GridBagConstraints consCentro = new GridBagConstraints();
        consCentro.gridx = 1;
        consCentro.gridy = 1;
        botCentro.setPreferredSize(dimensionBotones);
        botCentro.setMinimumSize(dimensionBotones);
        listenerBotonForm(botCentro, listaNum, 4);

        guiJuego.getPanelBotones().add(botNort, consNort);
        guiJuego.getPanelBotones().add(botSur, consSur);
        guiJuego.getPanelBotones().add(botEste, consEste);
        guiJuego.getPanelBotones().add(botOeste, consOeste);
        guiJuego.getPanelBotones().add(botCentro, consCentro);
    }

    private void listenerBotonForm(JButton boton, ArrayList listaNum, int numBoton) {
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botVocFormMouseEntered(boton, listaNum, modoJuego, numBoton);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseSalirBoton(boton);
            }
        });
        boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVocFormActionPerformed(boton, listaNum, modoJuego, numBoton);
            }
        });
    }

    private ImageIcon seleccionarImagenNumeros(Integer numero) {
        switch (numero) {
            case 0:
                return conexion.setIcono(0, 0);
            case 1:
                return conexion.setIcono(1, 0);
            case 2:
                return conexion.setIcono(2, 0);
            case 3:
                return conexion.setIcono(3, 0);
            case 4:
                return conexion.setIcono(4, 0);
            case 5:
                return conexion.setIcono(5, 0);
            case 6:
                return conexion.setIcono(6, 0);
            case 7:
                return conexion.setIcono(7, 0);
            case 8:
                return conexion.setIcono(8, 0);
            case 9:
                return conexion.setIcono(9, 0);
        }
        return null;
    }

    private ImageIcon seleccionarImagenVocales(Integer numero) {
        switch (numero) {
            case 0:
                return conexion.setIcono(0, 1);
            case 1:
                return conexion.setIcono(1, 1);
            case 2:
                return conexion.setIcono(2, 1);
            case 3:
                return conexion.setIcono(3, 1);
            case 4:
                return conexion.setIcono(4, 1);
        }
        return null;
    }

    private ImageIcon seleccionarImagenFormas(Integer numero) {
        switch (numero) {
            case 0:
                return conexion.setIcono(0, 2);
            case 1:
                return conexion.setIcono(1, 2);
            case 2:
                return conexion.setIcono(2, 2);
            case 3:
                return conexion.setIcono(3, 2);
            case 4:
                return conexion.setIcono(4, 2);
        }
        return null;
    }

    private void botNumMouseEntered(JButton boton, ArrayList<Integer> listaNum, int numeroBot) {
        if (!start) {
            boton.setIcon(seleccionarImagenNumeros(listaNum.get(numeroBot)));
        }
    }

    private void botNumActionPerformed(JButton boton, ArrayList<Integer> listaNum, int numeroBot) {
        if (start) {
            if (listaNum.get(numeroBot) == listaNumOrd.get(contadorAciertos)) {
                boton.setIcon(seleccionarImagenNumeros(listaNum.get(numeroBot)));
                contadorAciertos++;
                if (contadorAciertos == 10) {
                    salir(segundos);
                }
            } else {
                contadorAciertos = 0;
                reiniciarBotonesNum();
            }
        }
    }

    // EVENTOS DE VOCALES Y FORMAS
    private void botVocFormMouseEntered(JButton boton, ArrayList<Integer> listaNum, int modo, int numeroBot) {
        if (!start) {
            if (modo == 1) {
                boton.setIcon(seleccionarImagenVocales(listaNum.get(numeroBot)));
            } else if (modo == 2) {
                boton.setIcon(seleccionarImagenFormas(listaNum.get(numeroBot)));
            }
        }
    }

    private void botVocFormActionPerformed(JButton boton, ArrayList<Integer> listaNum, int modo, int numeroBot) {
        if (start) {
            if (listaNum.get(numeroBot) == listaNumOrd.get(contadorAciertos)) {
                if (modo == 1) {
                    boton.setIcon(seleccionarImagenVocales(listaNum.get(numeroBot)));
                } else if (modo == 2) {
                    boton.setIcon(seleccionarImagenFormas(listaNum.get(numeroBot)));
                }
                contadorAciertos++;
                if (contadorAciertos == 5) {
                    salir(segundos);
                }
            } else {
                contadorAciertos = 0;
                reiniciarBotonesVocForm();
            }
        }
    }
    
    private void mouseSalirBoton(JButton boton) {
        if (!start) {
            boton.setIcon(new ImageIcon(rutaImgInterr));
        }
    }

    private void botonAtrasActionPerformed() {
        guiJuego.dispose();
        ControladorInicio controladorInicio = new ControladorInicio();
        GUIInicio guiInicio = new GUIInicio();
        controladorInicio.setVentanaInicio(guiInicio);
    }

    private void reiniciarBotonesVocForm() {
        botNort.setIcon(new ImageIcon(rutaImgInterr));
        botSur.setIcon(new ImageIcon(rutaImgInterr));
        botEste.setIcon(new ImageIcon(rutaImgInterr));
        botOeste.setIcon(new ImageIcon(rutaImgInterr));
        botCentro.setIcon(new ImageIcon(rutaImgInterr));
    }

    private void reiniciarBotonesNum() {
        for (int i = 0; i < listaBotones.size(); i++) {
            listaBotones.get(i).setIcon(new ImageIcon(rutaImgInterr));
        }
    }

    private void salir(int segundos) {
        Puntuacion nuevaPunt = new Puntuacion(segundos);
        puntuacionDAO.insert(nuevaPunt);
        start = false;
        tarea.cancel();
        ControladorVictoria cv = new ControladorVictoria(segundos);
        GUIVictoria gui = new GUIVictoria();
        cv.setVentanaVictoria(gui);
        guiJuego.dispose();
    }
}
