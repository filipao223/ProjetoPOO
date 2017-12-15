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
class Exposicao extends Local{

    private final String forma, coordGPS;
    private final int custoIngresso;
    protected Convivio convivioInscrito;
    private int nInscritos=0;
    
    protected ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    
    public Exposicao(String coordGPS, String forma, int custo){
        this.forma = forma;
        this.coordGPS = coordGPS;
        this.custoIngresso = custo;
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
    public String getCoordGPS(){
        return this.coordGPS;
    }
    
    @Override
    protected int receita(){
        return 1;
    }
    
    @Override
    public String toString(){
        return this.forma + " Preço:" + this.custoIngresso + "€ NºInsc:" + this.getNInscritos();
    }
    
    @Override
    public String getDescricao(){
        return this.getClass().getSimpleName() + ", forma: " + this.forma + ", Coordenadas: " + this.coordGPS + ", Custo: " + this.custoIngresso;
    }
    
    @Override
    public String getForma() {
        return forma;
    }
    
    @Override
    public int getCustoMin() {
        return custoIngresso;
    }
    
    @Override
    public ArrayList<Pessoa> getPessoas(){
        return this.listaPessoas;
    }
    @Override
    public int getNInscritos(){
        return this.nInscritos;
    }
}
