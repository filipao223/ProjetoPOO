/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

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
        
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        ArrayList<Local> listaLocais = new ArrayList<>();
        ArrayList<Convivio> listaConvivios = new ArrayList<>();
        ArrayList<Desporto> listaDesportos = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);
        String convEsc;
        
        Inicial Interface = new Inicial(listaConvivios,listaLocais,comunidadeDEI);

        //Lê dos ficheiros
        try{
            loadConfig(comunidadeDEI, listaLocais, listaConvivios, listaDesportos);
            System.out.println("Configuraçoes carregadas.");
        }catch(IOException ioexcep){
            System.out.println("Erro ao carregar as informaçoes: " + ioexcep);
        }
        
        while(true){
            System.out.println("OPÇÕES:\n\t1.Listar listas\n\t2.Adicionar pessoa a convivio"
                    + "\n\t3.Adicionar local a pessoa\n\t4.Listar locais de pessoa\n\t"
                    + "5.Listar pessoas de local\n\t6.Sair: ");
            int esc = sc.nextInt();
            sc.nextLine();
            switch(esc){
                case 1:
                    printInfo(listaDesportos, comunidadeDEI, listaLocais, listaConvivios);
                    break;
                case 2:
                    System.out.println("A que convivio?: ");
                    convEsc = sc.nextLine();
                    for(Convivio c:listaConvivios){
                        if(Objects.equals(convEsc, c.getNome())){
                            Pessoa p;
                            if((p = getPessoa(comunidadeDEI)) == null){
                                System.out.println("Pessoa não encontrada.");
                                break;
                            }
                            if(c.addPessoa(p) != 1){
                                System.out.println("Pessoa nao adicionada.");
                                break;
                            }
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("A que convivio?: ");
                    convEsc = sc.nextLine();
                    for(Convivio c:listaConvivios){
                        if(Objects.equals(convEsc, c.getNome())){
                            Pessoa p;
                            Local l;
                            if((p = getPessoa(c.listaPessoas)) == null){
                                System.out.println("Pessoa nao encontrada.");
                                break;
                            }
                            if((l = getLocal(c.listaLocais)) == null){
                                System.out.println("Local nao encontrado.");
                                break;
                            }
                            if(c.addLocalToPessoa(p, l)!=1) System.out.println("Não adicionado.");
                            else System.out.println("Adicionado.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("A que convivio?: ");
                    convEsc = sc.nextLine();
                    for(Convivio c:listaConvivios){
                        if(Objects.equals(convEsc, c.getNome())){
                            Pessoa p;
                            if((p = getPessoa(c.listaPessoas)) == null){
                                System.out.println("Pessoa nao encontrada.");
                                break;
                            }
                            System.out.println("Locais:\n" + p.getLocais());
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("A que convivio?: ");
                    convEsc = sc.nextLine();
                    for(Convivio c:listaConvivios){
                        if(Objects.equals(convEsc, c.getNome())){
                            Local l;
                            if((l = getLocal(c.listaLocais)) == null){
                                System.out.println("Local não encontrado.");
                                break;
                            }
                            System.out.println("Pessoas:\n" + l.getPessoas());
                            break;
                        }
                    }
                    break;
                case 6:
                    exit(0);
            }
        }
    }
    
    /**
     *
     * @param comunidadeDEI
     * @param listaLocais
     * @return
     * @throws IOException
     */
    static int loadConfig(ArrayList<Pessoa> comunidadeDEI, ArrayList<Local> listaLocais, ArrayList<Convivio> listaConvivios, ArrayList<Desporto> listaDesportos) throws IOException{
        
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
