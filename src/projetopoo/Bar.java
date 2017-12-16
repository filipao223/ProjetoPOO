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
    private int nInscritos=0;
  
    private Convivio convInscrito;    

    private ArrayList<Pessoa> guestList = new ArrayList<>();
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Bar(String coordGPS, int lotacao, int maxPercentage, int custoMin) {
        this.coordGPS = coordGPS;
        this.lotacao = lotacao;
        this.custoMin = custoMin;
        this.maxGuestList = (int)(120*(double)(maxPercentage/100.0));
    }
    
    @Override
    protected int addToGuestList(Pessoa p){
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
    protected int removeFromGuestList(Pessoa p){
        //Verifica se está na guest list
        for(Pessoa pessoa:this.guestList){
            if(pessoa == p){
                this.guestList.remove(p);
                return 1;
            }
        }
        
        return 0;
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
    protected int receita(){
        return 1;
    }
    
    @Override
    public int getLotacao() {
        return lotacao;
    }
    
    @Override
    public int getCusto() {
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
        return "GPS:" + this.coordGPS + " Preço:" + this.custoMin + "€ Guests:" + this.maxGuestList + "NºInsc:" + this.getNInscritos();
    }
    
    @Override
    public String getDescricao(){
        return this.getClass().getSimpleName() + ", lotacao: " + this.lotacao + ", Num.Max. Guest list: " + this.maxGuestList + ", Custo min: " + this.custoMin;
    }
    @Override
    public int getNInscritos(){
        return this.nInscritos;
    }
    @Override
    public ArrayList<Pessoa> getGuestList(){
        ArrayList<Pessoa> temp = new ArrayList<>();
        temp.addAll(this.guestList);
        return temp;
    }
}
