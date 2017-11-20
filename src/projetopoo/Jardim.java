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
class Jardim extends Parque{

    private final String coordGPS;
    private final String area;
    protected Convivio convInscrito;
    
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
        return 1;
    }
    
    @Override
    public String getForma(){
        return "";
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
    protected int receita(){
        return 1;
    }
    
    @Override
    public ArrayList<Pessoa> getPessoas(){
        return this.listaPessoas;
    }
    
    @Override
    public String toString(){
        return this.getClass().getSimpleName() + ", area: " + area;
    }
}
