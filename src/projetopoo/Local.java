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
 * @author filipe
 */
abstract class Local implements Serializable{
    
    abstract int addPessoa(Pessoa p);
    abstract int removePessoa(Pessoa p);
    abstract int receita();
    abstract String getCoordGPS();
    abstract String getDescricao();
    String getForma(){
        return "";
    }
    int getLotacao(){
        return 1;
    }
    int getCustoMin(){
        return 1;
    }
    int getMaxGuestList(){
        return 1;
    }
    int addGuestList(Pessoa p){
        return 1;
    }
    int getCustoIngresso(){
        return 1;
    }
    int getNInscritos(){
        return 1;
    }
    String getArea(){
        return "";
    }
    ArrayList<Pessoa> getGuestList(){
        return null;
    }
    abstract ArrayList<Pessoa> getPessoas();
}

class LocalComparator implements Comparator<Local>{
    
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
