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
class Prof extends Pessoa{

    private final String nome, perfil, tipo;
    private String password;
    
    protected ArrayList<Local> listaLocais = new ArrayList<>();
    private int contLocais = 0;
    private final int maxLocais = 5;
    
    protected Convivio convInscrito;
    
    Scanner sc = new Scanner(System.in);
    
    public Prof(String nome, String perfil, String tipo) {
        this.nome = nome;
        this.perfil = perfil;
        this.tipo = tipo;
    }
    
    @Override
    protected int inscricao(Convivio convivio){
        if(convInscrito != null){
            System.out.println("Erro. Pessoa já inscrita num convivio.");
            return 0;
        }
        
        convInscrito = convivio;

        System.out.print("Introduza password: ");
        this.setPassword(sc.nextLine());
        return 1;
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
        System.out.println("Pessoa inscrita em local.");
        
        return 1;
    } 
    
    private void incrContLocais(){
        this.contLocais++;
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    
    private String getPassword() {
        return password;
    }
    
    private void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String getPerfil() {
        return perfil;
    }
    
    @Override
    public String getNome(){
        return this.nome;
    }
    
    @Override
    public ArrayList<Local> getLocais(){
        return this.listaLocais;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ", nome: " + this.getNome() + ", perfil: " + this.getPerfil() + ", professor: " + this.getTipo();
    }
}