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
abstract class Pessoa{
    
    protected ArrayList<Local> listaLocais;
    abstract int addLocal(Local local);
    abstract String getNome();
    abstract String getPerfil();
    abstract String getTipo();
    abstract ArrayList<Local> getLocais();
    abstract String getPassword();
    abstract int setPassword(String password);
}
