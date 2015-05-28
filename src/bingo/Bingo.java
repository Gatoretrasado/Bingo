package bingo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Bingo extends JFrame {

    JPanel panel_principal;
    JPanel panel_botones;
    static ArrayList<Carton> cartones = new ArrayList<>();
    static ArrayList<Integer> numerosNombrados = new ArrayList<>();
    int numeroMagico = 0;

    public Bingo() {
        //TITULO DE LA VENTANA
        setTitle("Bingo");
        //TAMAÑO DE LA VENTANA
        setSize(300, 300);
        //SI NOS DEJA CAMBIAR SUS DIMENSIONES O NO 
        setResizable(true);
        //POSICION EN LA QUE APARECE
        setLocationRelativeTo(null);
        //SALIR AL DARLE A LA X
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //METODO PARA CREAR INTERFAZ Y AGREGAR EVENTOS A BOTONES
        visible();
        //HACEMOS VISIBLE LA VENTANA
        setVisible(true);
    }

    void visible() {
        panel_principal = new JPanel();
        panel_principal.setLayout(new BorderLayout());
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(3, 1, 8, 8));
        crearBotones();
        panel_principal.add("Center", panel_botones);
        getContentPane().add(panel_principal);
    }

    public static void main(String[] args) {
        Bingo b = new Bingo();
    }

    void crearBotones() {
        JButton btn_iniciar = new JButton();
        btn_iniciar.setText("Iniciar");
        btn_iniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (cartones.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Primero debes tener algun carton", "ALTO!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        btn_iniciar.setText("Jugar");
                        jugar();
                    }
                } catch (Exception err) {
                    System.out.println("Error: " + err);
                }
            }
        });
        panel_botones.add(btn_iniciar);

        JButton btn_carton = new JButton();
        btn_carton.setText("Carton");
        btn_carton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    if (cartones.isEmpty()) {
                        cartones.add(new Carton());
                    } else {               
                    JOptionPane.showMessageDialog(null, "La partida esta en marcha, deberas esperar", "ALTO!", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (Exception err) {
                    System.out.println("Error: " + err);
                }
            }
        });
        panel_botones.add(btn_carton);

        JButton btn_salir = new JButton();
        btn_salir.setText("Salir");
        panel_botones.add(btn_salir);
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    System.exit(0);
                } catch (Exception err) {
                    System.out.println("Error: " + err);
                }
            }
        });
    }

    public void jugar() {
        boolean esta = false;

        do {
            numeroMagico = ((int) (Math.random() * 90));
            if (numerosNombrados.contains(numeroMagico) == false && numeroMagico != 0) {
                numerosNombrados.add(numeroMagico);
                System.out.println("numero: " + numeroMagico);
                esta = true;
            }
        } while (!esta);

        for (Carton nCarton : cartones) {
            nCarton.buscarNumero(numeroMagico);

        }
    }

}
