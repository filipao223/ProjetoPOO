/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author filipe
 */
abstract class Pessoa implements Serializable{
    
    abstract int addLocal(Local local);
    abstract int removeLocal(Local local);
    abstract String getNome();
    abstract String getPerfil();
    abstract String getTipo();
    abstract ArrayList<Local> getLocais();
    abstract void addToListaLocal(Local l);
    abstract String getPassword();
    abstract int setPassword(String password);
    abstract int inscricao(Convivio convivio);
    abstract String getDescricao();
}
