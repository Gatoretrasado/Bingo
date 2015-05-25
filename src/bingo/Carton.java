package bingo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Carton extends JFrame {

    JPanel panel_principal;
    JPanel panel_botones;
    JButton boton[];
    int espacios[][] = new int[3][9];
    int compColumna[] = new int[9];
    int contL = 0;
    int htotales;

    public Carton() {
        //TITULO DE LA VENTANA
        setTitle("Carton");
        //TAMAÑO DE LA VENTANA
        setSize(550, 240);
        //SI NOS DEJA CAMBIAR SUS DIMENSIONES O NO 
        setResizable(true);
        //POSICION EN LA QUE APARECE
        setLocationRelativeTo(null);
        //SALIR AL DARLE A LA X
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //METODO PARA CREAR INTERFAZ Y AGREGAR EVENTOS A BOTONES
        visible();
        //HACEMOS VISIBLE LA VENTANA
        setVisible(true);
    }

    void visible() {

        panel_principal = new JPanel();
        panel_principal.setLayout(new BorderLayout());
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(3, 9, 8, 8));
        crearBotones();
        panel_principal.add("Center", panel_botones);
        getContentPane().add(panel_principal);
    }

    void crearBotones() {
        boton = new JButton[27];

        superMetodoCrearCartones();
        int i = 0;
        int n = (int) (Math.random() * 10);
        for (int col = 0; col < 3; col++) {
            for (int f = 0; f < 9; f++) {
                boton[i] = new JButton("" + espacios[col][f]);
                if (espacios[col][f] == 0) {
                    boton[i].setBackground(Color.BLACK);
                    boton[i].setText("");
                }
                panel_botones.add(boton[i]);
                boton[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            System.out.println("Pulsado");

                        } catch (Exception err) {
                            System.out.println("Error: " + err);
                        }
                    }
                });
                i++;
            }
        }
    }

    void superMetodoCrearCartones() {
        do {
            //reset
            htotales = 0;
            contL = 0;
            for (int f = 0; f < 9; f++) {
                compColumna[f] = 0;
            }

            for (int col = 0; col < 3; col++) {
                for (int f = 0; f < 9; f++) {
                    espacios[col][f] = 1;
                }
            }

            for (int col = 0; col < 3; col++) {
                for (int f = 0; f < 9; f++) {
                    int aux = (int) (Math.random() * 10) + 1;

                    if (aux % 2 == 0 && contL < 4 && compColumna[f] < 2) {
                        espacios[col][f] = 0;
                        contL++;
                        compColumna[f]++;
                        htotales++;
                    }
                }
                contL = 0;
            }
        } while (htotales != 12);
    }

    void rellenarTablaNumeros() {

    }

    public static void main(String[] args) {
        Carton c = new Carton();
    }

}
