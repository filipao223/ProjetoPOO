/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author João Montenegro
 * @author João Mendes
 */
abstract class Local implements Serializable{
    
    /**
     * Adiciona a pessoa passada por parametro à lista de pessoas deste local, verificando
     * se a pessoa já se encontra na lista
     * @param p Pessoa a ser inserida na lista
     * @return  1 se a pessoa for adicionada, 0 caso contrário
     */
    abstract int addPessoa(Pessoa p);
    /**
     * Remove a pessoa passada por parametro da lista de pessoas do local, verificando
     * se a pessoa existe na lista.
     * @param p Pessoa a remover da lista
     * @return  1 se a pessoa for removida, 0 caso contrário
     */
    abstract int removePessoa(Pessoa p);
    /**
     * Devolve as coordenadas GPS do local
     * @return  Coordenadas do local
     */
    abstract String getCoordGPS();
    /**
     * Devolve uma descrição do local, em alternativa ao toString
     * @return  Descrição do local
     */
    abstract String getDescricao();
    /**
     * Devolve a forma da exposição
     * @return Devolve forma da exposição
     */
    String getForma(){
        return "";
    }
    /**
     * Devolve o número máximo de pessoas que podem estar inscritas no bar
     * @return Lotação maxima do bar
     */
    int getLotacao(){
        return 1;
    }
    /**
     * Devolve o valor do consumo mínimo do bar
     * @return Consumo minimo do bar
     */
    int getCusto(){
        return 1;
    }
    /**
     * Devolve o número máximo de pessoas que podem estar na guest list
     * @return Lotação da guest list
     */
    int getMaxGuestList(){
        return 1;
    }
    /**
     * Adiciona a pessoa passada por parametro à guest list do bar, verificando
     * se a guest list está cheia e se a pessoa já está na lista.
     * @param p Pessoa a inscrever na guest list
     * @return  1 se a pessoa for inscrita, 0 caso contrário
     */
    int addToGuestList(Pessoa p){
        return 1;
    }
    /**
     * Remove a pessoa passada por parametro da guest list do bar, verificando
     * se a pessoa está na lista
     * @param p Pessoa a remover da guest list
     * @return  1 se a pessoa for removida, 0 caso contrário
     */
    int removeFromGuestList(Pessoa p){
        return 1;
    }
    /**
     * Devolve o número de pessoas atualmente inscritas no local
     * @return  Numero de pessoas inscritas no local
     */
    int getNInscritos(){
        return 1;
    }
    /**
     * Devolve a area do jardim
     * @return Area do jardim
     */
    String getArea(){
        return "";
    }
    /**
     * Devolve uma cópia da guest list do bar
     * @return Cópia da guest list do bar
     */
    ArrayList<Pessoa> getGuestList(){
        return null;
    }
    /**
     * Devolve uma cópia da lista de pessoas atualmente inscritas neste local
     * @return Cópia da lista de pessoas inscritas no lcoal
     */
    abstract ArrayList<Pessoa> getPessoas();
}

/**
 * 
 * @author João Montenegro
 * @author João Mendes
 */
class LocalComparator implements Comparator<Local>{
    
    /**
     * Recebendo o local l1 e o local l2, o método compara o número de inscritos em cada local
     * @param l1    Local 1
     * @param l2    Local 2
     * @return      1 se o numero de pessoas inscritas em l1 for menor do que em l2, -1 se for maior e 0 caso contrário
     */
    @Override
    public int compare(Local l1, Local l2){
        int nInscritos1 = l1.getNInscritos();
        int nInscritos2 = l2.getNInscritos();
        
        if(nInscritos1 < nInscritos2){
            return 1;
        }
        else if(nInscritos1 > nInscritos2){
            return -1;
        }
        else{
            return 0;
        }
    }
}
