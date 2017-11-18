/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.util.ArrayList;

/**
 *
 * @author filipe
 */
class Exposicao extends Local{

    private String forma;
    private int custoIngresso;
    protected Convivio convivioInscrito;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Exposicao(String forma, int custo){
        this.forma = forma;
        this.custoIngresso = custo;
    }
    
    @Override
    protected int addPessoa(Pessoa p){
        for(Pessoa pessoa:this.listaPessoas){
            if(p == pessoa){
                System.out.println("Erro.Pessoa ja esta inscrita no local.");
                return 0;
            }
        }
        
        listaPessoas.add(p);
        return 1;
    }
    
    @Override
    protected int receita(){
        return 1;
    }
    
    @Override
    public String toString(){
        return "";
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public int getCustoIngresso() {
        return custoIngresso;
    }

    public void setCustoIngresso(int custoIngresso) {
        this.custoIngresso = custoIngresso;
    }
}
