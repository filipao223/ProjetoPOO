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
class Convivio {
    
    private final String nome;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Convivio(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    protected int addPessoa(Pessoa p){
        for(Pessoa pessoa:this.listaPessoas){
            if(pessoa == p){
                System.out.println("Erro.Pessoa já está inscrita no convivio.");
                return 0;
            }
        }
        
        
        return 1;
    }
    
    public int checkPessoa(Pessoa p){
        return 1;
    }
    
    private boolean login(String pw){
        return true;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getNome();
    }
}
