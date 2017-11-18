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
class Aluno extends Pessoa{

    private String perfil, password, tipo;
    
    protected ArrayList<Local> listaLocais = new ArrayList<>();
    private final int maxLocais = 5, countLocais = 0;
    
    protected Convivio convInscrito;
    
    Scanner sc = new Scanner(System.in);
    
    public Aluno(String perfil, String tipo) {
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
