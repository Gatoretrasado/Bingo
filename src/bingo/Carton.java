package bingo;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.red;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Carton extends JFrame {

    JPanel panel_principal;
    JPanel panel_botones;
    JButton boton[];
    int espacios[][] = new int[3][9];
    int compColumna[] = new int[9];
    int contL = 0, contIntro = 0;
    //cuenta huecos y numeros totales
    int htotales, contNumeros = 0, contadorPosicion = 0;
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    int i = 0;

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
        i = 0;

        superMetodoCrearCartones();

        for (int col = 0; col < 3; col++) {
            for (int f = 0; f < 9; f++) {
                boton[i] = new JButton("" + espacios[col][f]);
                if (espacios[col][f] == 0) {
                    boton[i].setBackground(Color.BLACK);
                    boton[i].setText("");
                }
                panel_botones.add(boton[i]);
                i++;
            }
        }
    }

    void superMetodoCrearCartones() {
        do {
            //reset
            htotales = 0;
            contL = 0;
            contadorPosicion = 0;
            contIntro = 0;
            for (int f = 0; f < 9; f++) {
                compColumna[f] = 0;
            }

            for (contadorPosicion = 0; contadorPosicion < 27; contadorPosicion++) {
                rellenarTablaNumeros();
            }
            Collections.sort(numeros);

            for (int f = 0; f < 9; f++) {
                for (int col = 0; col < 3; col++) {
                    espacios[col][f] = numeros.get(contIntro);
                    //System.out.print(contIntro+" ->  ");
                    //System.out.println(numeros.get(contIntro));
                    contIntro++;
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
        int preNumero;
        switch (numeros.size()) {
            case 0:
            case 1:
            case 2:
                preNumero = ((int) (Math.random() * 10) + 1);
                if (preNumero != 10 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 3:
            case 4:
            case 5:
                preNumero = ((int) (Math.random() * 10) + 10);
                if (preNumero != 20 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 6:
            case 7:
            case 8:
                preNumero = ((int) (Math.random() * 10) + 20);
                if (preNumero != 30 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 9:
            case 10:
            case 11:
                preNumero = ((int) (Math.random() * 10) + 30);
                if (preNumero != 40 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 12:
            case 13:
            case 14:
                preNumero = ((int) (Math.random() * 10) + 40);
                if (preNumero != 40 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 15:
            case 16:
            case 17:
                preNumero = ((int) (Math.random() * 10) + 50);
                if (preNumero != 50 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 18:
            case 19:
            case 20:
                preNumero = ((int) (Math.random() * 10) + 60);
                if (preNumero != 60 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 21:
            case 22:
            case 23:
                preNumero = ((int) (Math.random() * 10) + 70);
                if (preNumero != 70 && numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;
            case 24:
            case 25:
            case 26:
                preNumero = ((int) (Math.random() * 10) + 80);
                if (numeros.contains(preNumero) == false) {
                    numeros.add(preNumero);
                    contNumeros++;
                } else {
                    contadorPosicion--;
                }
                break;

        }

    }

    public void buscarNumero(int numeroMagico) {
        int nboton = 0;

        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {

                if (espacios[fila][columna] == numeroMagico) {
                    boton[nboton].setBackground(Color.red);
                    if (cantadoLinea == false) {
                        compLinea();
                        
                    }
                    if(cantadoBingo==false){
                        compBingo();
                    }
                }
                nboton++;
            }
        }
    }

    static public boolean cantadoLinea = false, linea = false;

    public void compLinea() {
        int nboton = 0, correcto;
        for (int fila = 0; fila < 3; fila++) {
            correcto = 0;
            for (int columna = 0; columna < 9; columna++) {
                if (boton[nboton].getBackground().equals(red) || boton[nboton].getBackground().equals(BLACK)) {
                    correcto++;

                }
                nboton++;
            }
            if (correcto == 9) {
                linea = true;
                cantadoLinea = true;
                JOptionPane.showMessageDialog(null, "Linea Realizada", "LINEA", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("linea");
            }
        }
    }

    static public boolean cantadoBingo = false, bingo = false;

    public void compBingo() {
        int nboton = 0, correcto = 0;
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (boton[nboton].getBackground().equals(red) || boton[nboton].getBackground().equals(BLACK)) {
                    correcto++;
                }
                nboton++;
            }
            if (correcto == 27) {
                bingo = true;
                cantadoBingo = true;
                JOptionPane.showMessageDialog(null, "Bingo Realizado", "BINGO!!!", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("bingo");
                //Bingo.cartones.
            }
        }
    }

    public static void main(String[] args) {
        Carton c = new Carton();
    }

}
