/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fumantes;

import java.util.Scanner;

/**
 *
 * @author joao luiz
 */
public class Fumantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Threads threads = new Threads();
        threads.inicializar();
        threads.vendedorVendeEsteProdutoNessaHora();
        for(int i = 0; i < 3; i++){
            threads.fumantes[i].start();
        }
    }

}
