/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
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
        
        ArrayList<Pessoa> comunidadeDEI = new ArrayList<>();
        ArrayList<Local> listaLocais = new ArrayList<>();
        ArrayList<Convivio> listaConvivios = new ArrayList<>();
        ArrayList<Desporto> listaDesportos = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        String convEsc;
        
        Inicial Interface = new Inicial(listaConvivios,listaLocais,comunidadeDEI);

        //Lê dos ficheiros
        try{
            //if(new File("ConfigObj").isFile()){
                //System.out.println("Ficheiro obj existe");
                //FicheiroObjecto f = new FicheiroObjecto();
                //loadConfigObj(f, comunidadeDEI, listaLocais, listaConvivios, listaDesportos);
            //}
            //else{
                //System.out.println("Nao existe ficheiro Obj");
                //FicheiroObjecto f = new FicheiroObjecto();
                loadConfigText(comunidadeDEI, listaLocais, listaConvivios, listaDesportos);
                //saveConfigObj(f, comunidadeDEI, listaLocais, listaConvivios, listaDesportos);
            //}
        }catch(IOException ioexcep){
            //System.out.println("Erro ao carregar as informaçoes: " + ioexcep);
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
     *
     * @param comunidadeDEI
     * @param listaLocais
     * @return
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
    
    /*static int saveConfigObj(FicheiroObjecto f, ArrayList<Pessoa> comunidadeDEI, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        f.abreEscrita("ConfigObj");
        for(Pessoa pessoa:comunidadeDEI){
            f.escreveObjecto(pessoa);
        }
        for(Local local:listaLocais){
            f.escreveObjecto(local);
        }
        for(Convivio convivio:listaConvivios){
            f.escreveObjecto(convivio);
        }
        for(Desporto desporto:listaDesportos){
            f.escreveObjecto(desporto);
        }
        f.fechaEscrita();
        return 1;
    }*/
    
    /*static int loadConfigObj(FicheiroObjecto f, ArrayList<Pessoa> comunidadeDEI, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        f.abreLeitura("ConfigObj");
        Object temp = null, temp2 = null;
        
        try{
            while(true){
                temp = f.leObjecto();
                Pessoa p = (Pessoa)temp;
                comunidadeDEI.add((Pessoa)f.leObjecto());
            }
        }catch(ClassNotFoundException | ClassCastException e){
            comunidadeDEI.add((Pessoa)temp);
            System.out.println("Leu pessoas de objectos");
            System.out.println(comunidadeDEI);
        }
        
        try{
            while(true){
                temp = f.leObjecto();
                Local l = (Local)temp;
                listaLocais.add((Local)f.leObjecto());
            }
        }catch(ClassNotFoundException | ClassCastException e){
            listaConvivios.add((Convivio)temp);
            System.out.println("Leu locais de Obj");
            System.out.println(listaLocais);
        }
        
        try{
            while(true){
                temp = f.leObjecto();
                Convivio c = (Convivio)temp;
                listaConvivios.add(c);
            }
        }catch(ClassNotFoundException | ClassCastException e){
            listaDesportos.add((Desporto)temp);
            System.out.println("Leu convivios de Obj");
            System.out.println(listaConvivios);
        }
        
        try{
            while(true){
                temp = f.leObjecto();
                Desporto d = (Desporto)temp;
                listaDesportos.add(d);
            }
        }catch(ClassNotFoundException | ClassCastException e){
            System.out.println("Leu desportos de Obj");
            System.out.println(listaDesportos);
        }
        f.fechaLeitura();
        return 1;
    }*/
    
    /**
     *
     * @param listaD
     * @param listaP
     * @param listaL
     * @param listaC
     */
    static void printInfo(ArrayList<Desporto> listaD, ArrayList<Pessoa> listaP, ArrayList<Local> listaL, ArrayList<Convivio> listaC){
        System.out.println("Desportos:");
        System.out.println(listaD);
        
        System.out.println("Comunidade do DEI:");
        System.out.println(listaP);
        
        System.out.println("Locais:");
        System.out.println(listaL);
        
        System.out.println("Convivios:");
        System.out.println(listaC);
    }
        
    
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
