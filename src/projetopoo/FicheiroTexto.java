/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author filipe
 */
public class FicheiroTexto {
    
    private BufferedReader fR;
    private BufferedWriter fW;
    
    public void abreLeitura(String filename) throws IOException{
        fR = new BufferedReader(new FileReader(filename));
    }
    
    public void abreEscrita(String filename) throws IOException{
        fW = new BufferedWriter(new FileWriter(filename));
    }
    
    public void fechaLeitura() throws IOException {
        fR.close();
    }

    public void fechaEscrita() throws IOException {
        fW.close();
    }
    
    public String leLinha() throws IOException{
        return fR.readLine();
    }
    
    public void escreveLinha(String linha) throws IOException
    {
        fW.write(linha,0,linha.length());
        fW.newLine();
    }
}


//Formato do ficheiro texto
/*
    ---Pessoas---
        1 nome perfil tipo parametro //Tipo varia entre 1 e 3, 1 se Prof, 2 se Func, 3 se Aluno
        2 nome perfil tipo parametro
        3 nome perfil tipo parametro

    ---Locais---
        1 coordGPS tipo parametro
        2 coordGPS tipo parametro

    ---Convivio---
        1 nome

*/
