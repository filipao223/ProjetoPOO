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
 * @author João Montenegro
 * @author João Mendes
 */
abstract class Pessoa implements Serializable{
    
    /**
     * Adiciona o local passado como argumento á lista de locais da pessoa, verificando
     * se a pessoa ainda se pode inscrever em locais e se a pessoa já está inscrita nele
     * @param local Local ao qual a pessoa se pretende inscrever
     * @return      1 se a pessoa for inscrita, 0 caso contrário
     */
    abstract int addLocal(Local local);
    /**
     * Remove o local passado por parametro da lista de locais da pessoa, verificando
     * se existe na lista de locais da pessoa
     * @param local Local que se pretende remover da pessoa
     * @return      1 se o local for removido, -1 se o numero maximo de locais for atingido, 0 caso contrário
     */
    abstract int removeLocal(Local local);
    /**
     * Devolve o nome da pessoa
     * @return  O nome da pessoa
     */
    abstract String getNome();
    /**
     * Devolve o perfil da pessoa (boemio, cultural, ...)
     * @return  O perfil da pessoa
     */
    abstract String getPerfil();
    /**
     * Devolve o tipo da pessoa
     * @return  O tipo da pessoa
     */
    abstract String getTipo();
    /**
     * Devolve uma cópia da lista de locais da pessoa
     * @return  Cópia de lista de locais da pessoa
     */
    abstract ArrayList<Local> getLocais();
    /**
     * Devolve a password definida pela pessoa
     * @return  A password da pessoa
     */
    abstract String getPassword();
    /**
     * Define a string passada por parametro como password da pessoa
     * @param password 
     */
    abstract void setPassword(String password);
    /**
     * Inscreve a pessoa no convivio passado por argumento, verificando
     * se já está inscrita
     * @param convivio  O convivio em qual pretende ser inscrita
     * @return          1 se for inscrita, caso contrario 0
     */
    abstract int inscricao(Convivio convivio);
    /**
     * Devolve uma outra descrição da pessoa, em alternativa a toString()
     * @return  Descrição alternativa da pessoa
     */
    abstract String getDescricao();
}
