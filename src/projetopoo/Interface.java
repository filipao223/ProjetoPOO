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


class Inscriçao extends JFrame{
    private final JCheckBox buttonInscrever;
    private final JButton buttonSai;
    private final JRadioButton Exposições;
    private final JRadioButton Bares;
    private final JRadioButton Jardins;
    private final JRadioButton Desporto;
    private final JComboBox combo;
    //private final JComboBox combo_2;
    
    public Inscriçao(){
        this.setPreferredSize(new Dimension(400,400));
        this.setTitle("Inscrições");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        buttonInscrever = new JCheckBox("Inscrever");this.add(buttonInscrever);
        buttonInscrever.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if(buttonInscrever.isSelected()){
                    //increver
                    buttonInscrever.setSelected(false);
                    //combo_2.removeAllItems();
                    //combo_2.addItem("a");
                    
                }
            }
        });
        
        buttonSai = new JButton("Sai");this.add(buttonSai);
        buttonSai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
    });
        combo = new JComboBox(new String[]{"...","..."});
                        
        this.add(combo);
        
        //combo_2 = new JComboBox(new String[]{"..."});
                        
        //this.add(combo_2);
        
        ButtonGroup group = new ButtonGroup();
        Exposições = new JRadioButton("Exposições",true);
        Exposições.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (Exposições.isSelected()){
                    combo.removeAllItems();
                    combo.addItem("Exposição1");
                    combo.addItem("Exposição2");
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
                    combo.addItem("Bar1");
                    combo.addItem("Bar2");
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
                    combo.addItem("Jardim1");
                    combo.addItem("Jardim2");
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
                    combo.addItem("Desporto1");
                    combo.addItem("Desporto2");
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
    private final JTextField password;
    private final JLabel label1;
    private final JLabel label2;
    private final JButton buttonCria;
    private final JButton buttonLimpa;
    private final JButton buttonSai;
    
    public Cria(){
        this.setPreferredSize(new Dimension(200,200));
        this.setTitle("Criar Conta");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        label1 = new JLabel("Nome"); this.add(label1);
        nome = new JTextField(); this.add(nome);
        nome.setPreferredSize(new Dimension(60,20));
    
        
        label2 = new JLabel("Password"); this.add(label2);
        password = new JTextField(); this.add(password);
        password.setPreferredSize(new Dimension(80,20));
        
        buttonCria = new JButton("Cria");this.add(buttonCria);
        
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
                System.exit(0);
            }
    });
        
        this.pack();
    }
}

class Login extends JFrame{
    
    private final JTextField nome;
    private final JTextField password;
    private final JLabel label1;
    private final JLabel label2;
    private final JButton buttonLogin;
    private final JButton buttonLimpa;
    private final JButton buttonSai;
    
    
    
    public Login(){
        
        this.setPreferredSize(new Dimension(200,200));
        this.setTitle("Login");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        label1 = new JLabel("Nome"); this.add(label1);
        nome = new JTextField(); this.add(nome);
        nome.setPreferredSize(new Dimension(60,20));
    
        
        label2 = new JLabel("Password"); this.add(label2);
        password = new JTextField(); this.add(password);
        password.setPreferredSize(new Dimension(80,20));
        
        buttonLogin = new JButton("Login");this.add(buttonLogin);
        
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
                System.exit(0);
            }
    });
        
        this.pack();
    }
}