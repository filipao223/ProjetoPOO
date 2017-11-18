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

            System.out.print("Introduza password: ");
            this.setPassword(sc.nextLine());
            return 1;
        }
    }
    
    public String getNome() {
        return nome;
    }

    public String getPerfil() {
        return perfil;
    }

    private String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }
    
    @Override
    public String toString(){
        return this.getClass().getName() + ", nome: " + this.getNome() + ", perfil: " + this.getPerfil() + ", tempo: " + this.getTipo();
    }
}
