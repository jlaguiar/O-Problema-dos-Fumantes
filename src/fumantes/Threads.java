/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fumantes;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joao luiz
 */
public class Threads extends Thread {

    Thread fumantes[] = new Thread[3];
    boolean vender;
    int itens[] = new int[3];
    Random random = new Random();
    int naoPodeSerIgual, venderEsteProduto;

    public void inicializar() {
        fumantes[0] = new Thread(venda);
        fumantes[1] = new Thread(venda);
        fumantes[2] = new Thread(venda);
        fumantes[0].setName("Dono do fumo ");
        fumantes[1].setName("dono do papel");
        fumantes[2].setName("dono do fosforo");
        vender = false;
        //11 = fumo, 12 = papel, 13 = fosforo
        itens[0] = 11;
        itens[1] = 12;
        itens[2] = 13;
    }

    public void vendedorVendeEsteProdutoNessaHora() {
        venderEsteProduto = random.nextInt(3);
        naoPodeSerIgual = venderEsteProduto;
        while (naoPodeSerIgual == venderEsteProduto) {
            naoPodeSerIgual = random.nextInt(3);
        }
    }
    public Runnable venda = new Runnable() {
        @Override
        public void run() {
            while (true) {
                //falso no vender quer dizer q ele pode vender
                if (!vender) {
                    System.out.println("Intens Que estao a venda 11 = fumo , 12 = papel, 13 = fosforo, este "
                            + itens[venderEsteProduto] + " e esse outro " + itens[naoPodeSerIgual]
                            + " para o vc " + Thread.currentThread().getName());
                    if (itens[venderEsteProduto] == Thread.currentThread().getId()
                            || itens[naoPodeSerIgual] == Thread.currentThread().getId()) {
                        System.out.println("Nao vai pode comprar pq nao serve para vc " + Thread.currentThread().getName());
                    } else {
                        System.out.println("Voce pode comprar " + Thread.currentThread().getName());
                        vender = true;
                        System.out.println("Fumando ");
                        try {
                            sleep(200);
                        } catch (InterruptedException ex) {
                            System.out.println(ex);
                        }
                        vendedorVendeEsteProdutoNessaHora();
                        System.out.println("Terminou de fumar");
                        vender = false;
                        System.out.println("vendedor ja esta vendendo");

                    }
                } else {
                    System.out.println("Esperando vendedor " + Thread.currentThread().getName());
                }
            }
        }
    };
}
