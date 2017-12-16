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
 * @author João Montenegro
 * @author João Mendes
 */
class Func extends Pessoa{

    private String nome, perfil, password, tipo;
    
    private ArrayList<Local> listaLocais = new ArrayList<>();
    private final int maxLocais = 5;
    private int contLocais = 0;
    
    private Convivio convInscrito;
    
    /**
     * Construtor da classe Func
     * @param nome Nome do funcionário
     * @param perfil Perfil do funcionario (boémio, cultural, ...)
     * @param tipo Tipo do funcionario (tempo parcial ou inteiro)
     */
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
    
    @Override
    protected int removeLocal(Local local){
        //verifica a existencia do local
        for(Local l:this.listaLocais){
            if(local == l){
                this.listaLocais.remove(local);
                local.removePessoa(this);
                this.contLocais--;
                return 1;
            }
        }
        
        System.out.println("Erro. Local não existe");
        return 0;
    }
    
    /**
     * Incrementa o contador de locais da pessoa
     */
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
    protected void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String getTipo() {
        return tipo;
    }
    
    @Override
    public ArrayList<Local> getLocais(){
        ArrayList<Local> temp = new ArrayList<>();
        temp.addAll(this.listaLocais);
        return temp;
    }
    
    @Override
    public String toString(){
        return this.getNome() + " " + this.getTipo() + " NºLocais Insc:" + this.getLocais().size();
    }
    
    @Override
    public String getDescricao(){
        return this.getClass().getSimpleName() + ", nome: " + this.getNome() + ", perfil: " + this.getPerfil() + ", tempo: " + this.getTipo();
    }
}
