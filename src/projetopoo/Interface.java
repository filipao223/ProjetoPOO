package projetopoo;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JOptionPane;

class Inscriçao_Convivio extends JFrame{
    private final JCheckBox buttonInscrever;
    private final JCheckBox buttonEntrar;
    private final JButton buttonSai;
    private final JComboBox combo;
    
    public Inscriçao_Convivio(ArrayList<Convivio> listaC,ArrayList<Local> listaL,ArrayList<Pessoa> listaP){
        this.setPreferredSize(new Dimension(400,400));
        this.setTitle("Inscrições Convívio");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        buttonInscrever = new JCheckBox("Inscrever");this.add(buttonInscrever);
        buttonInscrever.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(buttonInscrever.isSelected()){
                    Convivio convivio = ((Convivio)combo.getSelectedItem());
                    Login Interface = new Login(listaC,listaL,listaP,convivio);
                    buttonInscrever.setSelected(false);
                    
                }
            }
        });
        buttonEntrar = new JCheckBox("Entrar");this.add(buttonEntrar);
        buttonEntrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(buttonEntrar.isSelected()){
                    Convivio convivio = ((Convivio)combo.getSelectedItem());
                    Login Interface = new Login(listaC,listaL,listaP,convivio);
                    buttonEntrar.setSelected(false);
                    
                }
            }
        });
        
        buttonSai = new JButton("Sai");this.add(buttonSai);
        buttonSai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
            }
    });
        
        combo = new JComboBox(listaC.toArray());
                        
        this.add(combo);
        
        this.pack();
    }
    
}


class Inscriçao_Locais extends JFrame{
    private final JCheckBox buttonInscrever;
    private final JButton buttonSai;
    private final JRadioButton Exposições;
    private final JRadioButton Bares;
    private final JRadioButton Jardins;
    private final JRadioButton Desporto;
    private final JComboBox combo;
    
    public Inscriçao_Locais(String nomeInterface,Convivio convivio,ArrayList<Convivio> listaC,ArrayList<Local> listaL,ArrayList<Pessoa> listaP){
        this.setPreferredSize(new Dimension(400,400));
        this.setTitle("Inscrições Locais");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        buttonInscrever = new JCheckBox("Inscrever");this.add(buttonInscrever);
        buttonInscrever.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(buttonInscrever.isSelected()){
                    for(int i=0; i<listaP.size() ; i++){
                        if(Objects.equals(nomeInterface,listaP.get(i).getNome())){
                            //addLocalToPessoa(listaP.get(i),((Local)combo.getSelectedItem())) ;
                            System.out.println(listaP.get(i).listaLocais);
                            buttonInscrever.setSelected(false);
                        }
                    }
                }
            }
        });
        
        buttonSai = new JButton("Sai");this.add(buttonSai);
        buttonSai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
            }
    });
        combo = new JComboBox(new String[]{"...","..."});
                        
        this.add(combo);
        
        ButtonGroup group = new ButtonGroup();
        Exposições = new JRadioButton("Exposições",true);
        Exposições.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (Exposições.isSelected()){
                    combo.removeAllItems();
                    for(int i=0; i<listaL.size() ; i++){
                        if (listaL.get(i).getClass() == Exposicao.class) {
                            combo.addItem(listaL.get(i));
                        }
                        
                    }
                    
                    
                }
            }
        });
             
            
        group.add(Exposições);
        this.add(Exposições);
        
        Bares = new JRadioButton("Bares",true);
        Bares.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (Bares.isSelected()){
                    combo.removeAllItems();
                    for(int i=0; i<listaL.size() ; i++){
                        if (listaL.get(i).getClass() == Bar.class) {
                            combo.addItem(listaL.get(i));
                        }
                        
                    }
                    
                }
            }
        });
        group.add(Bares);
        this.add(Bares);
        
        
        Jardins = new JRadioButton("Jardins",true);
        Jardins.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (Jardins.isSelected()){
                    combo.removeAllItems();
                    for(int i=0; i<listaL.size() ; i++){
                        if (listaL.get(i).getClass() == ParqueDesporto.class) {
                            combo.addItem(listaL.get(i));
                        }
                        
                    }
                }
            }
        });
        group.add(Jardins);
        this.add(Jardins);
        
        Desporto = new JRadioButton("Parques Desportivos",true);
        Desporto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (Desporto.isSelected()){
                    combo.removeAllItems();
                    for(int i=0; i<listaL.size() ; i++){
                        if (listaL.get(i).getClass() == ParqueDesporto.class) {
                            combo.addItem(listaL.get(i));
                        }
                    }
                }
            }
        });
        group.add(Desporto);
        this.add(Desporto);
        
        this.pack();
    }
}
  
class Login extends JFrame{
    
    private final JTextField nome;
    private final JPasswordField password;
    private final JLabel label1;
    private final JLabel label2;
    private final JButton buttonLogin;
    private final JButton buttonLimpa;
    private final JButton buttonSai;
    
    
    
    public Login(ArrayList<Convivio> listaC,ArrayList<Local> listaL,ArrayList<Pessoa> listaP,Convivio convivio){
        
        this.setPreferredSize(new Dimension(200,300));
        this.setTitle("Login");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        label1 = new JLabel("Nome"); this.add(label1);
        nome = new JTextField(); this.add(nome);
        nome.setPreferredSize(new Dimension(60,20));
    
        
        label2 = new JLabel("Password"); this.add(label2);
        password = new JPasswordField(); this.add(password);
        password.setPreferredSize(new Dimension(80,20));
        
        buttonLogin = new JButton("Login");this.add(buttonLogin);
        buttonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                String passwords = new String(password.getPassword());
                String nomeInterface = new String(nome.getText());
                int check = 0;
                for(int i=0; i<listaP.size() ; i++){
                    if(Objects.equals(nomeInterface,listaP.get(i).getNome())){
                        check = 1;
                        if (Objects.equals(listaP.get(i).getPassword(),passwords)){
                            convivio.addPessoa(listaP.get(i));
                            Inscriçao_Locais Interface = new Inscriçao_Locais(nomeInterface,convivio,listaC,listaL,listaP);
                        }
                        if (Objects.equals(listaP.get(i).getPassword(),null)){
                            listaP.get(i).setPassword(passwords);
                            convivio.addPessoa(listaP.get(i));
                            Inscriçao_Locais Interface = new Inscriçao_Locais(nomeInterface,convivio,listaC,listaL,listaP);
                        }
                        if (!Objects.equals(listaP.get(i).getPassword(),passwords)){
                            JOptionPane.showMessageDialog(null, "Password Incorreta", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                    if(check == 0){
                         JOptionPane.showMessageDialog(null, "Não se encontra a pessoa", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                
                    if(Objects.equals(nomeInterface,"")){
                         JOptionPane.showMessageDialog(null, "Insira uma pessoa", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                    }
                    
                
            }
        });
        
        buttonLimpa = new JButton("Limpa");this.add(buttonLimpa);
        buttonLimpa.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent event){
                    nome.setText("");
                    password.setText("");           
            }
        });
        buttonSai = new JButton("Sai");this.add(buttonSai);
        buttonSai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                dispose();
            }
    });
        
        this.pack();
    }
}
    
class Inicial extends JFrame{
        
    private final JButton buttonLogin;
    private final JButton buttonSai;
        
        
    public Inicial(ArrayList<Convivio> listaC,ArrayList<Local> listaL,ArrayList<Pessoa> listaP){
        
        this.setPreferredSize(new Dimension(200,300));
        this.setTitle("Inicio");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
            
        buttonLogin = new JButton("Entrar na Conta");this.add(buttonLogin);
        buttonLogin.addActionListener(new ActionListener(){
        @Override 
            public void actionPerformed(ActionEvent event){
                Inscriçao_Convivio Interface = new Inscriçao_Convivio(listaC,listaL,listaP);
            }
        });
            
        buttonSai = new JButton("Sair");this.add(buttonSai);
        buttonSai.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent event){
                System.exit(0);
        }
    });
            
        this.pack();
    }
}