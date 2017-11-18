/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author filipe
 */
public class ProjetoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        ArrayList<Local> listaLocais = new ArrayList<>();
        ArrayList<Convivio> listaConvivios = new ArrayList<>();
        ArrayList<Desporto> listaDesportos = new ArrayList<>();

        //Lê dos ficheiros
        try{
            loadConfig(listaPessoas, listaLocais, listaConvivios, listaDesportos);
            System.out.println("Config carregadoo . ");
        }catch(IOException ioexcep){
            System.out.println("Erro ao carregar as informaçoes: " + ioexcep);
        }
        
        System.out.println("Desportos:");
        System.out.println(listaDesportos);
        
        System.out.println("Pessoas:");
        System.out.println(listaPessoas);
        
        System.out.println("Locais:");
        System.out.println(listaLocais);
        
        System.out.println("Convivios:");
        System.out.println(listaConvivios);
    }
    
    /**
     *
     * @param listaPessoas
     * @param listaLocais
     * @return
     * @throws IOException
     */
    static int loadConfig(ArrayList<Pessoa> listaPessoas, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        
        String linha;
        
        FicheiroTexto fText = new FicheiroTexto();
        fText.abreLeitura("config");
        
        //Trata das pessoas
        fText.leLinha();
        while(!Objects.equals(linha = fText.leLinha(), "---Locais---")){
            String tokens[] = linha.split(" ");
            if(Objects.equals(tokens[3], "prof")) listaPessoas.add(new Prof(tokens[1], tokens[2], tokens[4]));
            if(Objects.equals(tokens[3], "func")) listaPessoas.add(new Func(tokens[1], tokens[2], tokens[4]));
            if(Objects.equals(tokens[3], "aluno")) listaPessoas.add(new Aluno(tokens[1], tokens[2], tokens[4]));
        }
        
        while(!Objects.equals(linha = fText.leLinha(), "---Convivio---")){
            String tokens[] = linha.split(" ");
            if(Objects.equals(tokens[2], "exposicao")) listaLocais.add(new Exposicao(tokens[1], tokens[3], Integer.parseInt(tokens[4])));
            if(Objects.equals(tokens[2], "bar")) listaLocais.add(new Bar(tokens[1], Integer.parseInt(tokens[3]), Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5])));
            if(Objects.equals(tokens[2], "jardim")) listaLocais.add(new Jardim(tokens[1], tokens[3]));
            if(Objects.equals(tokens[2], "parquedesporto")) listaLocais.add(new ParqueDesporto(tokens[1]));
        }
        while(!Objects.equals(linha = fText.leLinha(), "---Desportos---")){
            String tokens[] = linha.split(" ");
            listaConvivios.add(new Convivio(tokens[1]));
        }
        while((linha = fText.leLinha()) != null){
            String tokens[] = linha.split(" ");
            listaDesportos.add(new Desporto(tokens[1]));
        }
        
        return 1;
    }
}
