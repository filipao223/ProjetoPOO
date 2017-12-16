/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author filipe
 */
class Convivio implements Serializable{
    
    protected final String nome;
    protected int contPessoas = 0;
    
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private ArrayList<Local> listaLocais = new ArrayList<>();
    
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
        
        contPessoas+=1;
        
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
            System.out.println("\nErro. Local inexistente.");
            return 0;
        }
        
        p.addLocal(l);
        
        return 1;
    }
    
    protected int removeLocalFromPessoa(Pessoa p, Local l){
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
        
        p.removeLocal(l);
        
        return 1;
    }
    
    protected int addPessoaToGuestList(Pessoa p,Local l){
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
        l.addToGuestList(p);
        
        return 1;
    }
    
    private boolean login(Pessoa p, String pw){
        return true;
    }
    
    public ArrayList<Pessoa> getPessoas(){
        ArrayList<Pessoa> temp = new ArrayList<>();
        temp.addAll(this.listaPessoas);
        return temp;
    }
    
    public ArrayList<Local> getLocais(){
        ArrayList<Local> temp = new ArrayList<>();
        temp.addAll(this.listaLocais);
        return temp;
    }
    
    public int addLocal(Local l){
        //Verifica se o local ainda não está na lista
        for(Local local:this.listaLocais){
            if(local == l){
                System.out.println("Erro. Local já se encontra na lista");
                return 0;
            }
        }
        
        this.listaLocais.add(l);
        return 1;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getNome();
    }
}
