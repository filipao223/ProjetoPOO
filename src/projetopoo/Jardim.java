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

    private String area, coordGPS;
    protected Convivio convInscrito;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Jardim(String area, String coordGPS) {
        this.area = area;
        this.coordGPS = coordGPS;
    }

    public String getCoordGPS() {
        return coordGPS;
    }

    public void setCoordGPS(String coordGPS) {
        this.coordGPS = coordGPS;
    }

    public String getArea() {
        return area;
    }

    private void setArea(String area) {
        this.area = area;
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
    protected int receita(){
        return 1;
    }
    
    @Override
    public String toString(){
        return "Area: " + area;
    }
}
