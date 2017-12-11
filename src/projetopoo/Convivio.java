/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author filipe
 */
class Convivio {
    
    protected final String nome;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    protected ArrayList<Local> listaLocais = new ArrayList<>();
    
    Scanner sc = new Scanner(System.in);
    
    public Convivio(String nome, ArrayList<Local> listaLocais) {
        this.nome = nome;
        this.listaLocais.addAll(listaLocais);
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
        
        if(p.inscricao(this) == 1){
            this.listaPessoas.add(p);
            System.out.println("\nPessoa adicionada ao convivio!");
        }
        
        return 1;
    }
    
    protected int checkPessoa(Pessoa p){
        for(Pessoa pessoa:this.listaPessoas){
            if(pessoa == p){
                return 1;
            }
        }
        
        return 0;
    }
    
    protected int checkLocal(Local l){
        for(Local local:this.listaLocais){
            if(local == l){
                return 1;
            }
        }
        
        return 0;
    }
    
    protected int addLocalToPessoa(Pessoa p, Local l){
        //Verifica existencia da pessoa
        if(checkPessoa(p) != 1){
            System.out.println("\nErro. Pessoa inexistente.");
            return 0;
        }
        //Verifica existencia do local
        if(checkLocal(l) != 1){
            System.out.println("1nErro. Local inexistente.");
            return 0;
        }
        
        p.addLocal(l);
        
        return 1;
    }
    
    private boolean login(Pessoa p, String pw){
        return true;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getNome();
    }
}
