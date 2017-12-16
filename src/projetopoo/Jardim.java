/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.util.ArrayList;

/**
 *
 * @author João Montenegro
 * @author João Mendes
 */
class Jardim extends Parque{

    private final String coordGPS;
    private final String area;
    protected Convivio convInscrito;
    private int nInscritos=0;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Jardim(String coordGPS, String area) {
        this.area = area;
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
    protected int removePessoa(Pessoa p){
        //Verifica a existencia da pessoa
        for(Pessoa pessoa:this.listaPessoas){
            if(p == pessoa){
                listaPessoas.remove(p);
                this.nInscritos--;
                return 1;
            }
        }
        
        System.out.println("Erro. Pessoa nao existe");
        return 0;
    }
    
    @Override
    public String getCoordGPS() {
        return coordGPS;
    }
    
    @Override
    public String getArea() {
        return area;
    }
    
    @Override
    public ArrayList<Pessoa> getPessoas(){
        return this.listaPessoas;
    }
    
    @Override
    public String toString(){
        return "GPS:" + this.getCoordGPS() + " "  + this.area + "NºInsc:" + this.getNInscritos();
    }
    
    @Override
    public String getDescricao(){
        return this.getClass().getSimpleName() + ", area: " + area;
    }
    @Override
    public int getNInscritos(){
        return this.nInscritos;
    }
}
