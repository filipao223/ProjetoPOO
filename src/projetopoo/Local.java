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
abstract class Local{
    
    abstract int addPessoa(Pessoa p);
    abstract int receita();
    abstract String getCoordGPS();
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
    String getArea(){
        return "";
    }
    abstract ArrayList<Pessoa> getPessoas();
}
