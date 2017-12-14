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
class Aluno extends Pessoa{

    private final String nome, perfil, tipo;
    private String password;
    
    protected ArrayList<Local> listaLocais = new ArrayList<>();
    private final int maxLocais = 5;
    private int contLocais = 0;
    
    protected Convivio convInscrito;
    
    public Aluno(String nome, String perfil, String tipo) {
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
    
    private void incrContLocais(){
        this.contLocais++;
    }
    
    @Override
    public String getNome(){
        return this.nome;
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
    public void addToListaLocal(Local l){
        this.listaLocais.add(l);
    }
    
    @Override
    public String toString(){
        return this.getNome() + " " + this.getTipo() + " NºLocais Insc:" + this.getLocais().size();
    }
    
    @Override
    public String getDescricao(){
        return this.getClass().getSimpleName() + ", nome: " + this.getNome() + ", perfil: " + this.getPerfil() + ", curso: " + this.getTipo();
    }
}
