/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetopoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author filipe
 */
class FicheiroObjecto{
    
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream;
    
    public boolean abreLeitura(String nome) throws IOException{
        try{
            inStream = new ObjectInputStream(new FileInputStream(nome));
            return true;
        }catch(IOException e){
            return false;
        }
    }
    
    public void abreEscrita(String nome) throws IOException{
        outStream = new ObjectOutputStream(new FileOutputStream(nome));
    }
    
    public Object leObjecto() throws IOException, ClassNotFoundException {
        return inStream.readObject(); 
    }
    
    public void escreveObjecto(Object o) throws IOException {
        outStream.writeObject(o); 
    }
    
    public void fechaEscrita() throws IOException
    {
        outStream.close();
    }
    
    public void fechaLeitura() throws IOException
    {
        inStream.close();
    }
}