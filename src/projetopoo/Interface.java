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
import java.util.*;
import javax.swing.JOptionPane;


class Inscriçao_Locais extends JFrame{
    private final JCheckBox buttonInscrever;
    private final JButton buttonSai;
    private final JButton buttonLocalInscrito;
    private final JButton buttonGuestList;
    private final JRadioButton Exposições;
    private final JRadioButton Bares;
    private final JRadioButton Jardins;
    private final JRadioButton Desporto;
    private final JComboBox combo;
    private final JComboBox comboLocalPessoa;
    private final JComboBox comboGuestList;
    
    public Inscriçao_Locais(String nomeInterface,Convivio convivio,ArrayList<Convivio> listaC,ArrayList<Local> listaL, Pessoa pessoa){
        this.setPreferredSize(new Dimension(600,400));
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
                    if((Local)combo.getSelectedItem() instanceof Bar){
                        if(((Bar)combo.getSelectedItem()).guestList.size() < ((Bar)combo.getSelectedItem()).getMaxGuestList()){
                            convivio.addGuestListToPessoa(pessoa,(Bar)combo.getSelectedItem());
                            buttonInscrever.setSelected(false);
                        }
                        else{
                            convivio.addLocalToPessoa(pessoa, (Local)combo.getSelectedItem());
                            buttonInscrever.setSelected(false);
                        }
                    }
                    else{
                    convivio.addLocalToPessoa(pessoa, (Local)combo.getSelectedItem());
                    System.out.println("Lista de locais em inscricao_locais: " + pessoa.getLocais());
                    buttonInscrever.setSelected(false);
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
                    for(Local local:listaL){
                        if (local.getClass() == Exposicao.class) {
                            combo.addItem(local);
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
                    for(Local local:listaL){
                        if (local.getClass() == Bar.class) {
                            combo.addItem(local);
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
                    for(Local local:listaL){
                        if (local.getClass() == Jardim.class) {
                            combo.addItem(local);
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
                    for(Local local:listaL){
                        if (local.getClass() == ParqueDesporto.class) {
                            combo.addItem(local);
                        }
                    }
                }
            }
        });
        group.add(Desporto);
        this.add(Desporto);
        
        comboLocalPessoa = new JComboBox(new String[]{}); this.add(comboLocalPessoa);
        buttonLocalInscrito = new JButton("Locais Inscritos"); this.add(buttonLocalInscrito);
        buttonLocalInscrito.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                comboLocalPessoa.removeAllItems();
                for(Local local:pessoa.getLocais()){
                    comboLocalPessoa.addItem(local);
                }
            }
        });
        
        
        comboGuestList = new JComboBox(new String[] {}); this.add(comboGuestList);
        buttonGuestList = new JButton("GuestList do Bar"); this.add(buttonLocalInscrito);
        buttonGuestList.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                comboGuestList.removeAllItems();
                if((Local)combo.getSelectedItem() instanceof Bar){
                    /*for(Pessoa pessoa: combo.getSelectedItem()){
                        comboGuestList.addItem(pessoa);
                    }*/
                }
            }
        });
        
        this.pack();
    }
}
  
class Login extends JFrame{
    
    private final JTextField nome;
    private final JTextField numPessoas;
    private final JPasswordField password;
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JButton buttonLogin;
    private final JButton buttonLimpa;
    private final JButton buttonSai;
    
    private final JComboBox combo;
    private final JComboBox combo2;
    
    Convivio convivio;
    
    
    public Login(ArrayList<Convivio> listaC,ArrayList<Local> listaL,ArrayList<Pessoa> listaP){
        
        this.setPreferredSize(new Dimension(420,300));
        this.setTitle("Login");
        this.setLocation(100,100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        //Lista de convivios
        combo = new JComboBox(listaC.toArray());                
        this.add(combo);
        convivio = (Convivio)combo.getSelectedItem(); //Pelo menos sempre um convivio escolhido
        
        //Label do nome
        label1 = new JLabel("Nome"); this.add(label1);
        nome = new JTextField(); this.add(nome);
        nome.setPreferredSize(new Dimension(60,20));
    
        //Label da password
        label2 = new JLabel("Password"); this.add(label2);
        password = new JPasswordField(); this.add(password);
        password.setPreferredSize(new Dimension(80,20));
        
        //Botao login
        buttonLogin = new JButton("Login");this.add(buttonLogin);
        buttonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                String passwordInput = new String(password.getPassword()); //Recebe pass da caixa
                String nomeInput = nome.getText(); //Recebe nome da caixa
                int checkPessoaExist = 0;
                for(Pessoa pessoa:listaP){
                    if(Objects.equals(nomeInput, pessoa.getNome())){
                        //Nome introduzido existe na lista
                        checkPessoaExist = 1;
                        if (Objects.equals(pessoa.getPassword(), passwordInput)){
                            //Pessoa já está inscrita
                            System.out.println("Pessoa já inscrita em -" + convivio.getNome() + "-.");
                            convivio.addPessoa(pessoa);
                            Inscriçao_Locais Interface = new Inscriçao_Locais(nomeInput,convivio,listaC,listaL, pessoa);
                            
                            //Ordena a lista de locais de Mais iscritos para Menos inscritos
                            Collections.sort(listaL, new LocalComparator());
                            System.out.println(listaL);
                        } 
                        if (Objects.equals(pessoa.getPassword(),null)){
                            //Pessoa ainda não está inscrita
                            System.out.println("Pessoa ainda não inscrita em -" + convivio.getNome() + "-. Inscrita automaticamente.");
                            pessoa.setPassword(passwordInput); //Password da pessoa é agora a introduzida na caixa
                            convivio.addPessoa(pessoa);
                            Inscriçao_Locais Interface = new Inscriçao_Locais(nomeInput,convivio,listaC,listaL, pessoa);
                            
                            //Ordena a lista de locais de Mais iscritos para Menos inscritos
                            Collections.sort(listaL, new LocalComparator());
                            JOptionPane.showMessageDialog(null, "Ainda não se encontra inscrito. Inscrito automaticamente", "Inscrito", JOptionPane.INFORMATION_MESSAGE);
                        }
                        if (!Objects.equals(pessoa.getPassword(),passwordInput)){
                            //Password errada
                            JOptionPane.showMessageDialog(null, "Password Incorreta", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                if(checkPessoaExist == 0){
                    //Não foi encontrada pessoa
                     JOptionPane.showMessageDialog(null, "Não se encontra a pessoa", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if(Objects.equals(nomeInput,"")){
                    //Não foi introduzido nome
                     JOptionPane.showMessageDialog(null, "Insira uma pessoa", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        buttonLimpa = new JButton("Limpa");this.add(buttonLimpa); //Botão para limpar as caixas de texto
        buttonLimpa.addActionListener(new ActionListener(){
        @Override
            public void actionPerformed(ActionEvent event){
                    nome.setText("");
                    password.setText("");           
            }
        });
        buttonSai = new JButton("Sai");this.add(buttonSai); //Botão para voltar à frame inicial
        buttonSai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        
        label3 = new JLabel("Pessoas inscritas no convivio: "); this.add(label3);
        Object[] listP = convivio.listaPessoas.toArray();
        combo2 = new JComboBox(listP);                
        numPessoas = new JTextField(); this.add(numPessoas);
        numPessoas.setText(Integer.toString(convivio.contPessoas)); //Pelo menos sempre um contador
        this.add(combo2);
        
        //Atualiza o convivio, o contador e a lista de pessoas sempre que o utilizador alterar a selecçao de convivio
        combo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                combo2.removeAllItems();
                convivio = (Convivio)combo.getSelectedItem();
                numPessoas.setText(Integer.toString(convivio.contPessoas)); //Atualiza contador
                for(Pessoa pessoa:convivio.listaPessoas){
                    combo2.addItem(pessoa.getNome());
                }
            
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
                Login loginFrame = new Login(listaC, listaL, listaP);
                dispose();
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