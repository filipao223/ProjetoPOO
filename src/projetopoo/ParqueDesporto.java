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
class ParqueDesporto extends Parque{
    
    protected ArrayList<Desporto> listaDesportos = new ArrayList<>();
    protected Convivio convInscrito;
    private final String coordGPS;
    private int nInscritos=0;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public ParqueDesporto(String coordGPS) {
        this.coordGPS = coordGPS;
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
        this.nInscritos++;
        return 1;
    }
    
    @Override
    protected int receita(){
        return 1;
    }
    
    @Override
    public String getCoordGPS(){
        return this.coordGPS;
    }
    
    @Override
    public ArrayList<Pessoa> getPessoas(){
        return this.listaPessoas;
    }
    
    @Override
    public String toString(){
        return "GPS:" + this.coordGPS;
    }
    
    @Override
    public String getDescricao(){
        return this.getClass().getSimpleName() + ", coordenadas: " + this.getCoordGPS();
    }
    @Override
    public int getNInscritos(){
        return this.nInscritos;
    }
}
