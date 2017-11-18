/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

/**
 *
 * @author filipe
 */
public class Desporto {
    private final String tipo;

    public Desporto(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString(){
        return this.getClass().getName() + ", tipo: " + tipo;
    }
}
