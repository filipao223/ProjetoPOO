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
class Func extends Pessoa{

    private String nome, perfil, password, tipo;
    
    protected ArrayList<Local> listaLocais = new ArrayList<>();
    private final int maxLocais = 5;
    private int contLocais = 0;
    
    protected Convivio convInscrito;
    
    Scanner sc = new Scanner(System.in);
    
    public Func(String nome, String perfil, String tipo) {
        this.nome = nome;
        this.perfil = perfil;
        this.tipo = tipo;
    }
    
    @Override
    public int inscricao(Convivio convivio){
        if(convInscrito != null){
            System.out.println("Erro. Pessoa já inscrita num convivio.");
            return 0;
        }
        else{
            convInscrito = convivio;
            
            return 1;
        }
    }
    
    @Override
    protected int addLocal(Local local){
        if(this.contLocais>=this.maxLocais){
            System.out.println("\nErro. Numero maximo de locais incritos atingido.");
            return 0;
        }
        
        for(Local l:this.listaLocais){
            if(local == l){
                System.out.println("\nErro. Pessoa já está inscrita neste local.");
                return 0;
            }
        }
        
        this.listaLocais.add(local);
        local.addPessoa(this);
        this.incrContLocais();
        System.out.println("Pessoa inscrita no local.");
        
        return 1;
    }
    
    private void incrContLocais(){
        this.contLocais++;
    }
    
    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public String getPerfil() {
        return perfil;
    }
    
    @Override
    protected String getPassword() {
        return password;
    }
    
    @Override
    protected int setPassword(String password) {
        this.password = password;
        return 1;
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public ArrayList<Local> getLocais(){
        return this.listaLocais;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ", nome: " + this.getNome() + ", perfil: " + this.getPerfil() + ", tempo: " + this.getTipo();
    }
}
