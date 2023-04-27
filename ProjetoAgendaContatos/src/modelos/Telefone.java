/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package visao;

/**
 *
 * @author Gustavo Camargo
 */
public class Telefone {
    // atributos
    private int ddi = 0 ;
    private int ddd = 0;
    private int numero= 0;
    
    //Metodos
    public Telefone(){
        this.ddi = 0;
        this.ddd = 0;
        this.numero = 0;
    }

    public Telefone(int ddi, int ddd, int numero) {
        this.ddi = ddi;
        this.ddd = ddd;
        this.numero = numero;
    }

    public int getDdi() {
        return ddi;
    }

    public void setDdi(int ddi) {
        this.ddi = ddi;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return  ddi + ";" + ddd + ";" + numero;
    }
    
}
