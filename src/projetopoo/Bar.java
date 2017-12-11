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
class Bar extends Local{

    private int contGuestList = 0;
    private final int maxGuestList, lotacao, custoMin;
    private final String coordGPS;
  
    protected Convivio convInscrito;    

    protected ArrayList<Pessoa> guestList = new ArrayList<>();
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Bar(String coordGPS, int lotacao, int maxPercentage, int custoMin) {
        this.coordGPS = coordGPS;
        this.lotacao = lotacao;
        this.custoMin = custoMin;
        this.maxGuestList = (int)(120*(double)(maxPercentage/100.0));
    }
    
    @Override
    protected int addGuestList(Pessoa p){
        if(contGuestList>=maxGuestList){
            System.out.println("Erro.Numero maximo de pessoas na guest list.");
            return 0;
        }
        else{
            for(Pessoa pessoa:this.guestList){
                if(pessoa == p){
                    System.out.println("Erro.Pessoa já esta na guest list.");
                    return 0;
                }
            }
            
            guestList.add(p);
            contGuestList++;
            
            return 1;
        }
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
    public int getLotacao() {
        return lotacao;
    }
    
    @Override
    public int getCustoMin() {
        return custoMin;
    }
    
    @Override
    public int getMaxGuestList() {
        return maxGuestList;
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
        return this.getClass().getSimpleName() + ", lotacao: " + this.lotacao + ", Num.Max. Guest list: " + this.maxGuestList + ", Custo min: " + this.custoMin;
    }
}
