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
import javax.swing.JOptionPane;

class Inscriçao_Convivio extends JFrame{
    private final JCheckBox buttonInscrever;
    private final JButton buttonSai;
    private final JComboBox combo;
    
    public Inscriçao_Convivio(ArrayList<Convivio> listaC,ArrayList<Local> listaL){
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
                    
                    Inscriçao_Locais Interface = new Inscriçao_Locais(listaC,listaL);
                    buttonInscrever.setSelected(false);
                    
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
    
    public Inscriçao_Locais(ArrayList<Convivio> listaC,ArrayList<Local> listaL){
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
                    buttonInscrever.setSelected(false);
                    
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
    
class Cria extends JFrame{
    private final JTextField nome;
    private final JPasswordField password;
    private final JPasswordField confirmapass;
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JButton buttonCria;
    private final JButton buttonLimpa;
    private final JButton buttonSai;
    
    public Cria(ArrayList<Pessoa> listaP){
        this.setPreferredSize(new Dimension(275,200));
        this.setTitle("Criar Conta");
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
        
        label3 = new JLabel("Confirma Password"); this.add(label3);
        confirmapass = new JPasswordField(); this.add(confirmapass);
        confirmapass.setPreferredSize(new Dimension(80,20));
        
        buttonCria = new JButton("Cria");this.add(buttonCria);
        buttonCria.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent event){
               
                    String passwords = new String(password.getPassword());
                    String confirmapassword = new String(confirmapass.getPassword());
                    String nomeInterface = new String(nome.getText());
                    
                    //for(int i=0; i<listaP.size() ; i++){
                        //if(nomeInterface.equals(listaP.get(i))){
                            if ((passwords.equals(confirmapassword)) == false){
                                JOptionPane.showMessageDialog(null, "Passwords não iguais", "Erro " + "", JOptionPane.INFORMATION_MESSAGE);
                            }
                            if ((passwords.equals(confirmapassword))){
                                JOptionPane.showMessageDialog(null, "Passwords iguais", "Erro " + "", JOptionPane.INFORMATION_MESSAGE);
                                //listaP.get(i).setPassword(passwords);
                            }
                        //}
                    //}
           }
        });
        
        buttonLimpa = new JButton("Limpa");this.add(buttonLimpa);
        buttonLimpa.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent event){
                    nome.setText("");
                    password.setText("");
                    confirmapass.setText("");
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

class Login extends JFrame{
    
    private final JTextField nome;
    private final JPasswordField password;
    private final JLabel label1;
    private final JLabel label2;
    private final JButton buttonLogin;
    private final JButton buttonLimpa;
    private final JButton buttonSai;
    
    
    
    public Login(ArrayList<Convivio> listaC,ArrayList<Local> listaL){
        
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
                //for(int i=0; i<listaP.size() ; i++){
                    //if(nomeInterface.equals(listaP.get(i))){
                //if ((passwords.equals(listaP.password))){    
                    Inscriçao_Convivio Interface = new Inscriçao_Convivio(listaC,listaL);
                    //}
                //}
                //}
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
        
    private final JButton buttonCria;
    private final JButton buttonLogin;
    private final JButton buttonSai;
        
        
    public Inicial(ArrayList<Convivio> listaC,ArrayList<Local> listaL,ArrayList<Pessoa> listaP){
        
        this.setPreferredSize(new Dimension(200,300));
        this.setTitle("Inicio");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
            
        buttonCria = new JButton("Cria Conta");this.add(buttonCria);
        buttonCria.addActionListener(new ActionListener(){
        @Override 
            public void actionPerformed(ActionEvent event){
                Cria Interface = new Cria(listaP);
            }
        
        });
            
        buttonLogin = new JButton("Entrar na Conta");this.add(buttonLogin);
        buttonLogin.addActionListener(new ActionListener(){
        @Override 
            public void actionPerformed(ActionEvent event){
                Login Interface = new Login(listaC,listaL);
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