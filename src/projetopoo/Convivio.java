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
class Convivio implements Serializable{
    
    protected final String nome;
    protected int contPessoas = 0;
    
    private ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private ArrayList<Local> listaLocais = new ArrayList<>();
    
    /**
     * Construtor da classe
     * @param nome  Nome do convivio
     * @param listaLocais   Lista de locais existentes
     */
    public Convivio(String nome, ArrayList<Local> listaLocais) {
        this.nome = nome;
        this.listaLocais.addAll(listaLocais);
    }
    
    /**
     * Devolve nome do convivio
     * @return Nome do convivio
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Adiciona a pessoa passada por parametro ao convivio, verificando se 
     * a pessoa já se encontra inscrita.
     * @param p Pessoa a inscrever no convivio
     * @return  1 se a pessoa for inscrita, 0 caso contrário
     */
    protected int addPessoa(Pessoa p){
        for(Pessoa pessoa:this.listaPessoas){
            if(pessoa == p){
                System.out.println("Erro.Pessoa já está inscrita no convivio.");
                return 0;
            }
        }
        
        if(p.inscricao(this) == 1){
            this.listaPessoas.add(p);
            System.out.println("\nPessoa adicionada ao convivio!");
        }
        
        contPessoas+=1;
        
        return 1;
    }
    
    /**
     * Verifica se a pessoa passada por parametro existe na lista de pessoas do convivio
     * @param p Pessoa a verificar
     * @return  1 se a pessoa existir, 0 caso contrário
     */
    protected int checkPessoa(Pessoa p){
        for(Pessoa pessoa:this.listaPessoas){
            if(pessoa == p){
                return 1;
            }
        }
        
        return 0;
    }
    
    /**
     * Verifica se o local passado por parametro existe na lista de locais do convivio
     * @param l Local a ser verificado
     * @return  1 se o local existir, 0 caso contrário
     */
    protected int checkLocal(Local l){
        for(Local local:this.listaLocais){
            if(local == l){
                return 1;
            }
        }
        
        return 0;
    }
    
    /**
     * Adiciona a pessoa p ao local l. Se a pessoa e o local ambos existirem na lista de pessoas
     * e na lista de locais, o método chama o método addLocal da pessoa p, passando-lhe o local l.
     * @param p Pessoa a ser a adicionada
     * @param l Local ao qual vai ser adicionada a pessoa
     * @return  1 se a pessoa for adicionada, 0 caso contrario
     */
    protected int addLocalToPessoa(Pessoa p, Local l){
        //Verifica existencia da pessoa
        if(checkPessoa(p) != 1){
            System.out.println("\nErro. Pessoa inexistente.");
            return 0;
        }
        //Verifica existencia do local
        if(checkLocal(l) != 1){
            System.out.println("\nErro. Local inexistente.");
            return 0;
        }
        
        if(p.addLocal(l) == 1) return 1;
        else return 0;
    }
    
    /**
     * Remove a pessoa p do local l. Se a pessoa e o local ambos existirem na lista de pessoas e 
     * na lista de locais, é chamado o método removeLocal da pessoa p, passando-lhe o local l.
     * @param p Pessoa a ser removida
     * @param l Local do qual a pessoa vai ser removida
     * @return  1 se a pessoa for removida, 0 caso contrário
     */
    protected int removeLocalFromPessoa(Pessoa p, Local l){
        //Verifica existencia da pessoa
        if(checkPessoa(p) != 1){
            System.out.println("\nErro. Pessoa inexistente.");
            return 0;
        }
        //Verifica existencia do local
        if(checkLocal(l) != 1){
            System.out.println("1nErro. Local inexistente.");
            return 0;
        }
        
        if(p.removeLocal(l) == 1) return 1;
        else return 0;
    }
    
    /**
     * Adiciona a pessoa p à guest list do local (bar) l. Se a pessoa e o bar ambos existirem
     * na lista de pessoas e na lista de locais, é chamado o método addToGuestList de l, passando-lhe
     * a pessoa p.
     * @param p Pessoa a ser adicionada à guest list
     * @param l Local que contem a guest list ao qual a pessoa vai ser adicionada
     * @return  1 se a pessoa for adicionada, 0 caso contrário
     */
    protected int addPessoaToGuestList(Pessoa p,Local l){
        //Verifica existencia da pessoa
        if(checkPessoa(p) != 1){
            System.out.println("\nErro. Pessoa inexistente.");
            return 0;
        }
        //Verifica existencia do local
        if(checkLocal(l) != 1){
            System.out.println("1nErro. Local inexistente.");
            return 0;
        }
        if(l.addToGuestList(p)==1) return 1;
        else return 0;
    }
    
    /**
     * Devolve uma cópia da lista de pessoas deste convívio.
     * @return Cópia da lista de pessoas do convivio
     */
    public ArrayList<Pessoa> getPessoas(){
        ArrayList<Pessoa> temp = new ArrayList<>();
        temp.addAll(this.listaPessoas);
        return temp;
    }
    
    /**
     * Devolve uma cópia da lista de locais deste convívio
     * @return Cópia da lista de locais do convívio
     */
    public ArrayList<Local> getLocais(){
        ArrayList<Local> temp = new ArrayList<>();
        temp.addAll(this.listaLocais);
        return temp;
    }
    
    /**
     * Adiciona o local passado por parametro á lista de locais deste convívio.
     * Usado para atualizar a lista após carregar os convivios do ficheiros de objectos.
     * @param l Local a ser adicionado
     * @return  1 se o local for adicionado, 0 caso contrário
     */
    public int addLocal(Local l){
        //Verifica se o local ainda não está na lista
        for(Local local:this.listaLocais){
            if(local == l){
                System.out.println("Erro. Local já se encontra na lista");
                return 0;
            }
        }
        
        this.listaLocais.add(l);
        return 1;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getNome();
    }
}
