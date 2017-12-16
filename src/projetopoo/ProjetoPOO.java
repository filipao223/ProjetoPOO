/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author João Montenegro
 * @author João Mendes
 */
public class ProjetoPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Pessoa> comunidadeDEI = new ArrayList<>();
        ArrayList<Local> listaLocais = new ArrayList<>();
        ArrayList<Convivio> listaConvivios = new ArrayList<>();
        ArrayList<Desporto> listaDesportos = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        String convEsc;
        
        Inicial Interface = new Inicial(listaConvivios,listaLocais,comunidadeDEI);

        //Lê dos ficheiros
        try{
            //Verifica se os ficheiros existem
            if(new File("Pessoas").isFile() && new File("Locais").isFile() && new File("Convivios").isFile() && new File("Desportos").isFile()){
                System.out.println("Ficheiro obj existe");
                loadConfigObj(comunidadeDEI, listaLocais, listaConvivios, listaDesportos);                
            }
            else{
                System.out.println("Nao existe ficheiro Obj");
                loadConfigText(comunidadeDEI, listaLocais, listaConvivios, listaDesportos);
                saveConfigObj(comunidadeDEI, listaLocais, listaConvivios, listaDesportos);
            }
        }catch(IOException ioexcep){
            System.out.println("Erro ao carregar as informaçoes: " + ioexcep);
        }
        
        while(true){
            System.out.println("OPÇÕES:\n\t1.Listar listas\n\t2.Increver pessoa em convivio"
                    + "\n\t3.Adicionar local a pessoa\n\t4.Listar locais de pessoa\n\t"
                    + "5.Listar pessoas de local\n\t6.Sair: ");
            int esc = sc.nextInt();
            sc.nextLine();
        }
    }
    
    /**
     * Lê as informações de um ficheiro de texto relativas a pessoas, locais, convivios e desportos e
     * coloca cada um na sua lista, construindo um objecto novo de acordo com as informações no ficheiro
     * @param comunidadeDEI     A lista que vai conter todas as pessoas
     * @param listaLocais       A lista que vai conter todos os locais
     * @param listaConvivios    A lista que vai conter todos os convivios
     * @param listaDesportos    A lista que vai conter todos os desportos
     * @return  1
     * @throws IOException 
     */
    static int loadConfigText(ArrayList<Pessoa> comunidadeDEI, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        
        String linha;
        
        FicheiroTexto fText = new FicheiroTexto();
        fText.abreLeitura("config");
        
        //Trata das pessoas
        fText.leLinha();
        while(!Objects.equals(linha = fText.leLinha(), "---Locais---")){
            String tokens[] = linha.split(" ");
            if(Objects.equals(tokens[3], "prof")) comunidadeDEI.add(new Prof(tokens[1], tokens[2], tokens[4]));
            if(Objects.equals(tokens[3], "func")) comunidadeDEI.add(new Func(tokens[1], tokens[2], tokens[4]));
            if(Objects.equals(tokens[3], "aluno")) comunidadeDEI.add(new Aluno(tokens[1], tokens[2], tokens[4]));
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
            listaConvivios.add(new Convivio(tokens[1], listaLocais));
        }
        while((linha = fText.leLinha()) != null){
            String tokens[] = linha.split(" ");
            listaDesportos.add(new Desporto(tokens[1]));
        }
        
        return 1;
    }
    
    /**
     * Guarda o conteúdo das listas de pessoas, locais, convivios e desportos no seu respectivo ficheiro de objectos.
     * Este método só é chamado se estes ficheiros ainda não existirem na directoria.
     * @param comunidadeDEI     A lista de pessoas
     * @param listaLocais       A lista de locais
     * @param listaConvivios    A lista de convivios
     * @param listaDesportos    A lista de desportos
     * @return  1
     * @throws IOException 
     */
    static int saveConfigObj(ArrayList<Pessoa> comunidadeDEI, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        FicheiroObjecto f = new FicheiroObjecto();
        f.abreEscrita("Pessoas");
        for(Pessoa pessoa:comunidadeDEI){
            f.escreveObjecto(pessoa);
        }
        f.fechaEscrita();
        
        f = new FicheiroObjecto();
        f.abreEscrita("Locais");
        for(Local local:listaLocais){
            f.escreveObjecto(local);
        }
        f.fechaEscrita();
        
        f = new FicheiroObjecto();
        f.abreEscrita("Convivios");
        for(Convivio conv:listaConvivios){
            f.escreveObjecto(conv);
        }
        f.fechaEscrita();
        
        f = new FicheiroObjecto();
        f.abreEscrita("Desportos");
        for(Desporto desp:listaDesportos){
            f.escreveObjecto(desp);
        }
        f.fechaEscrita();
        
        return 1;
    }
    
    /**
     * Carrega pessoas, locais, convivios e desportos do respectivo ficheiro de objectos.
     * Este método só é chamado se estes ficheiros já existirem na directoria.
     * @param comunidadeDEI     A lista de pessoas
     * @param listaLocais       A lista de locais
     * @param listaConvivios    A lista de convivios
     * @param listaDesportos    A lista de desportos
     * @return  1
     * @throws IOException 
     */
    static int loadConfigObj(ArrayList<Pessoa> comunidadeDEI, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        FicheiroObjecto f = new FicheiroObjecto();
        f.abreLeitura("Pessoas");
        try{
            while(true){
                Pessoa p = (Pessoa)f.leObjecto();
                comunidadeDEI.add(p);
            }
        }catch(ClassNotFoundException | EOFException ex) {
        }
        
        f = new FicheiroObjecto();
        f.abreLeitura("Locais");
        try{
            while(true){
                Local l = (Local)f.leObjecto();
                listaLocais.add(l);
            }
        }catch(ClassNotFoundException | EOFException ex) {
        }
        
        f = new FicheiroObjecto();
        f.abreLeitura("Convivios");
        try{
            while(true){
                Convivio c = (Convivio)f.leObjecto();
                listaConvivios.add(c);
            }
        }catch(ClassNotFoundException | EOFException ex) {
        }
        
        f = new FicheiroObjecto();
        f.abreLeitura("Desportos");
        try{
            while(true){
                Desporto d = (Desporto)f.leObjecto();
                listaDesportos.add(d);
            }
        }catch(ClassNotFoundException | EOFException ex) {
        }
        
        //Adiciona as listas aos convivios
        for(Convivio conv:listaConvivios){
            for(Local local:listaLocais){
                conv.addLocal(local);
            }
        }
        
        return 1;
    }
    
    /**
     * Pede o nome da pessoa que se quer obter e procura-a na lista de pessoas passada por parametro.
     * @param listaPessoas
     * @return Devolve a pessoa se existir na lista de pessoas, null caso contrário
     */
    static Pessoa getPessoa(ArrayList<Pessoa> listaPessoas){
        System.out.println("Nome da pessoa?: ");
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        for(Pessoa p:listaPessoas){
            if(Objects.equals(p.getNome(), nome)){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Pede as coordenadas do local ao utilizador e procura-o na lista de locais
     * passada por parametro.
     * @param listaLocais Lista de locais
     * @return Devolve o local se existir na lista, null caso contrário
     */
    static Local getLocal(ArrayList<Local> listaLocais){
        System.out.println("Coord do local?: ");
        Scanner sc = new Scanner(System.in);
        String coord = sc.nextLine();
        for(Local l:listaLocais){
            if(Objects.equals(l.getCoordGPS(), coord)){
                return l;
            }
        }
        return null;
    }
}
