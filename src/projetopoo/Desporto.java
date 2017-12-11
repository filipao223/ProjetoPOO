/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;
/**
* Classe de Desporto
*@author Joao Mendes e Joao Motenegro
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
        return "Desporto" + ", tipo: " + tipo;
    }
}
