/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

/**
 *
 * @author joseantonio
 */
public class prueba {
    public static void main(String[] args) {
        
        int espacios [][]= new int [3][9];
        int compColumna []= new int [9];
        int contL =0;
        int htotales;
        
        do{
            //reset
            htotales=0;
            contL=0;
            for(int f= 0;f<9;f++){
                 compColumna[f]=0;
            }
            
            for(int col= 0;col<3;col++){ 
                for(int f= 0;f<9;f++){
                    espacios[col][f]=1;
                }
            }
            
            for(int col= 0;col<3;col++){ 
                for(int f= 0;f<9;f++){
                    int aux = (int) (Math.random()*10)+1;

                    if ( aux%2==0 && contL<4 && compColumna[f]<2){
                        espacios[col][f]=0;
                        contL++;
                        compColumna[f]++;
                        htotales++;
                    }
                }
                contL=0;
            }
        }
        while(htotales!=12);
        
        //Mostrar
        for(int col= 0;col<3;col++){ 
            for(int f= 0;f<9;f++){
                System.out.print(espacios[col][f]);
            }
            System.out.println("");
        }
    }
}
