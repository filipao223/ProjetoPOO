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

/**
 * 
 * @author João Montenegro
 * @author João Mendes
 */
class Inscriçao_Locais extends JFrame{
    private final JCheckBox buttonInscrever;
    private final JCheckBox buttonDesinscrever;
    private final JButton buttonSai;
    private final JButton buttonLocalInscrito;
    private final JButton buttonGuestList;
    private final JButton buttonReceita;
    private final JRadioButton Exposições;
    private final JRadioButton Bares;
    private final JRadioButton Jardins;
    private final JRadioButton Desporto;
    private final JComboBox combo;
    private final JComboBox comboLocalPessoa;
    private final JComboBox comboGuestList;
    
    int enterGuestList = 0;
    boolean checkAddToGuestList = false;
    
    /**
     * Construtor da frame que vai permitir ao utilizador inscrever-se e desincrever-se em locais, guest
     * lists, ver receita e ver lista de locais inscritos.
     * @param convivio  Convivio escolhido
     * @param listaL    Lista de locais
     * @param pessoa    Utilizador
     */
    public Inscriçao_Locais(Convivio convivio, ArrayList<Local> listaL, Pessoa pessoa){
        this.setPreferredSize(new Dimension(800,350));
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
                    //Ordena a lista de locais de Mais iscritos para Menos inscritos
                    Collections.sort(listaL, new LocalComparator());
                    if((Local)combo.getSelectedItem() instanceof Bar){
                        //Verifica lotação do bar
                        if(((Local)combo.getSelectedItem()).getNInscritos() < ((Local)combo.getSelectedItem()).getLotacao()){
                            
                            //Verifica se há espaço na guest list
                            if(((Bar)combo.getSelectedItem()).getGuestList().size() < ((Bar)combo.getSelectedItem()).getMaxGuestList()){
                            //Ainda há espaço
                            convivio.addPessoaToGuestList(pessoa,(Bar)combo.getSelectedItem());
                            buttonInscrever.setSelected(false);
                            }
                            if(((Bar)combo.getSelectedItem()).getGuestList().size() >= ((Bar)combo.getSelectedItem()).getMaxGuestList() && pessoa.getTipo().equals("Boemio")){
                                //Já não há espaço, mas a pessoa é do tipo boémio, verifica agora se pode remover alguem
                                checkAddToGuestList = false;
                                for(Pessoa remPessoa: ((Bar)combo.getSelectedItem()).getGuestList()){
                                    if (!remPessoa.getTipo().equals("Boemio")){
                                        ((Bar)combo.getSelectedItem()).removeFromGuestList(remPessoa);
                                        convivio.addPessoaToGuestList(pessoa,(Bar)combo.getSelectedItem());
                                        checkAddToGuestList = true; //Flag que indica se foi adicionado à guest list ou não
                                    }
                                }

                                if(checkAddToGuestList){
                                    System.out.println("Adicionado à guest list.");
                                    JOptionPane.showMessageDialog(null, "Adicionado à guest list.", "Adicionado", JOptionPane.INFORMATION_MESSAGE);
                                }
                                else{
                                    System.out.println("Não foi possivel adicionar à guest list.");
                                    JOptionPane.showMessageDialog(null, "Não foi possivel adicionar à guest list.", "Não adicionado", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }
                            
                            convivio.addLocalToPessoa(pessoa, (Local)combo.getSelectedItem());
                            buttonInscrever.setSelected(false);

                        } //Fim if da lotação
                        else{
                            System.out.println("Máximo lotação do bar atingido!");
                            JOptionPane.showMessageDialog(null, "Máximo lotação do bar atingido, não inscrito.", "Máximo lotação", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } //Fim if se for Bar
                    else{
                        convivio.addLocalToPessoa(pessoa, (Local)combo.getSelectedItem());
                        System.out.println("Lista de locais em inscricao_locais: " + pessoa.getLocais());
                        buttonInscrever.setSelected(false);
                    }
                    Collections.sort(listaL, new LocalComparator());
                }
            }
        });
        
        buttonDesinscrever = new JCheckBox("Desinscrever");this.add(buttonDesinscrever);
        buttonDesinscrever.addActionListener(new ActionListener(){
            @Override //Vai remover a pessoa da lista de locais
            public void actionPerformed(ActionEvent event){
                if(buttonDesinscrever.isSelected()){
                    if((Local)comboLocalPessoa.getSelectedItem() instanceof Bar){
                        if(((Bar)comboLocalPessoa.getSelectedItem()).getGuestList().contains(pessoa)) ((Bar)comboLocalPessoa.getSelectedItem()).removeFromGuestList(pessoa);
                    }
                    
                    convivio.removeLocalFromPessoa(pessoa, (Local)comboLocalPessoa.getSelectedItem());
                    buttonDesinscrever.setSelected(false);
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
        combo = new JComboBox(new String[]{});
                        
        this.add(combo);
        
        ButtonGroup group = new ButtonGroup();
        Exposições = new JRadioButton("Exposições",true);
        Exposições.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                if (Exposições.isSelected()){
                    buttonGuestList.setVisible(false);
                    comboGuestList.setVisible(false); //Esconde o botao e lista da guestList
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
                    buttonGuestList.setVisible(true);
                    comboGuestList.setVisible(true); //Mostra o botao e lista da guestList
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
                    buttonGuestList.setVisible(false);
                    comboGuestList.setVisible(false); //Esconde o botao e lista da guestList
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
                    buttonGuestList.setVisible(false);
                    comboGuestList.setVisible(false); //Esconde o botao e lista da guestList
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
                System.out.println(pessoa.getLocais());
                System.out.println(((Local)combo.getSelectedItem()).getPessoas());
                for(Local local:pessoa.getLocais()){
                    comboLocalPessoa.addItem(local);
                }
            }
        });
        
        
        comboGuestList = new JComboBox(new String[] {}); this.add(comboGuestList);
        buttonGuestList = new JButton("GuestList do Bar"); this.add(buttonGuestList);
        buttonGuestList.setVisible(false);
        buttonGuestList.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                comboGuestList.removeAllItems();
                if((Local)combo.getSelectedItem() instanceof Bar){
                    for(Pessoa pessoa: ((Local)combo.getSelectedItem()).getGuestList()){
                        comboGuestList.addItem(pessoa.getDescricao());
                    }
                }
            }
        });
        
        buttonReceita = new JButton("Receita Prevista");this.add(buttonReceita);
        buttonReceita.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                int receita = 0;
                for(Local local: convivio.getLocais()){
                    if (local instanceof Bar || local instanceof Exposicao){
                        for(Pessoa pessoa: local.getPessoas()){
                            if(pessoa instanceof Aluno){
                                receita = (int)(receita + local.getCusto()*0.90);
                            }
                            else{
                                receita = (int)(receita + local.getCusto());
                            }
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Receita aproximadamente de "+ receita, "Receita Prevista", JOptionPane.INFORMATION_MESSAGE);
            }         
        });
        
        this.pack();
    }
}

/**
 * 
 * @author João Montenegro
 * @author João Mendes
 */
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
    
    /**
     * Construtor da frame Login, que vai ter a lista de convivios, o numero e a lista
     * de pessoas inscritas no convivio escolhido e as caixas de nome e password.
     * @param listaC    Lista de convivios
     * @param listaL    Lista de locais
     * @param listaP    Lista de pessoas
     */
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
                            Inscriçao_Locais Interface = new Inscriçao_Locais(convivio,listaL, pessoa);
                            
                            //Ordena a lista de locais de Mais iscritos para Menos inscritos
                            Collections.sort(listaL, new LocalComparator());
                            System.out.println(listaL);
                        } 
                        if (Objects.equals(pessoa.getPassword(),null)){
                            //Pessoa ainda não está inscrita
                            System.out.println("Pessoa ainda não inscrita em -" + convivio.getNome() + "-. Inscrita automaticamente.");
                            pessoa.setPassword(passwordInput); //Password da pessoa é agora a introduzida na caixa
                            convivio.addPessoa(pessoa);
                            Inscriçao_Locais Interface = new Inscriçao_Locais(convivio,listaL, pessoa);
                            
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
        Object[] listP = convivio.getPessoas().toArray();
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
                for(Pessoa pessoa:convivio.getPessoas()){
                    combo2.addItem(pessoa.getNome());
                }
            
            }
        });
        
        this.pack();
    }
}

/**
 * 
 * @author João Montenegro
 * @author João Mendes
 */
class Inicial extends JFrame{
        
    private final JButton buttonLogin;
    private final JButton buttonSai;
        
    /**
     * Construtor da frame Inicial que contem a opção de entrar na frame Login e sair.
     * Esta frame é destruída depois de entrar na frame Login.
     * @param listaC    Lista de convivios
     * @param listaL    Lista de locais
     * @param listaP    Lista de pessoas
     */
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