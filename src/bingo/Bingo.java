
package bingo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Bingo extends JFrame{

    JPanel panel_principal;
    JPanel panel_botones;
    
    public Bingo(){
        //TITULO DE LA VENTANA
        setTitle("Bingo");
        //TAMAÑO DE LA VENTANA
        setSize(300,300);
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
    
    void visible(){
        panel_principal = new JPanel();
        panel_principal.setLayout(new BorderLayout());
        panel_botones = new JPanel();
        panel_botones.setLayout(new GridLayout(3,1,8,8));
        crearBotones();
        panel_principal.add("Center",panel_botones);
        getContentPane().add(panel_principal);
    }
    
    public static void main(String[] args) {
        Bingo b = new Bingo();
    }

    void crearBotones() {
        JButton btn_iniciar = new JButton();
        btn_iniciar.setText("Iniciar");
        panel_botones.add(btn_iniciar);
        
        JButton btn_carton = new JButton();
        btn_carton.setText("Carton");
        panel_botones.add(btn_carton);
        
        JButton btn_salir = new JButton();
        btn_salir.setText("Salir");
        panel_botones.add(btn_salir);
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                   
                    
                } catch (Exception err) {
                    System.out.println("Error: " + err);
                }
            }
        });
    }
    
}
