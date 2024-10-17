package ads.poo;

import ads.poo.exceptions.PilhaCheiaException;
import ads.poo.exceptions.PilhaVaziaException;

import java.util.ArrayList;
import java.util.Arrays;

public class Pilha <E>{
    private int tamanho;
    private int topo = -1;
    private E[] elementos;

    public Pilha(int tamanho){
        this.tamanho = tamanho;
        this.elementos = (E[]) new Object[tamanho];
    }

    public void empilhar(E elemento) throws PilhaCheiaException{
        if(topo == tamanho-1){
            throw new PilhaCheiaException("Pilha Cheia");
        }
        this.elementos[++topo] = elemento;
    }

    public E desempilhar() throws PilhaVaziaException{
        if(topo == -1){
            throw new PilhaVaziaException("Pilha Vazia");
        }
        E elemento = (E) this.elementos[--topo];
        return elemento;
    }

    public E mostrar


}
