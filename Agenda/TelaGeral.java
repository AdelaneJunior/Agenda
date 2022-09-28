import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TelaGeral extends JFrame implements ActionListener{

    JPanel entradaDados;
    JPanel atributos;
    JPanel anotacao;
    JPanel botoesAcao;
    JPanel botoesNavega;
    JPanel interacao;
    JPanel tabela;
    JPanel baixo;
    
    JTextField jtcodigo;
    JTextField jtnome;
    JTextField jtendereco;
    JTextField jttelefone;

    JButton btAcaoAlterar;
    JButton btAcaoConsultar;
    JButton btAcaoExcluir;
    JButton btAacaoInserir;
    JButton btAcaoLimpar;
    JButton btNavegaAnt;
    JButton btNavegaProx;
    JButton btNavegaFim;

    ModeloTabela modelo;
    JTable tabel;
    
    JTextArea jtanotacao;

    RegistroDados arquivo = new RegistroDados();
    Dados dados;

    int j =0;

    public TelaGeral(){
       
        montaTabela();
        montarInteracao();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("North", new JLabel( new ImageIcon("agen.jpg"), JLabel.CENTER));
        getContentPane().add("West", interacao);
        getContentPane().add("East",tabela);

      
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(891,590);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    public void montarInteracao(){

        interacao = new JPanel();
        interacao.setLayout(new BorderLayout());

        montarEntradaDados();
        montarBotaoAcao();

        interacao.add("West", entradaDados);
        interacao.add("South", botoesAcao);
        interacao.setPreferredSize(new Dimension(465, 200));

    }

    public void montarEntradaDados(){
        entradaDados = new JPanel();
        entradaDados.setLayout(new BorderLayout());

        montarAtributos();
        montarAreaAnotacao();
        montarBotaoNavegacao();

        entradaDados.setPreferredSize(new Dimension(465, 200));

        entradaDados.add("West", atributos);
        entradaDados.add("East", anotacao);
        entradaDados.add("South", botoesNavega);

    }

    public void montarAtributos(){

        atributos = new JPanel();
        atributos.setLayout(new BoxLayout(atributos, BoxLayout.Y_AXIS));

        JPanel jpcodigoborder = new JPanel();
        jpcodigoborder.setLayout(new BorderLayout());

        JPanel jpcodigoflow = new JPanel();
        jpcodigoflow.setLayout(new FlowLayout());

        jtcodigo = new JTextField(10);


        jpcodigoflow.add(new JLabel("CÓDIGO"));
        jpcodigoflow.add(jtcodigo);


        JPanel jpnomeborder = new JPanel();
        jpnomeborder.setLayout(new BorderLayout());

        JPanel jpnomeflow = new JPanel();
        jpnomeflow.setLayout(new FlowLayout());

        jtnome =  new JTextField(10);

        jpnomeflow.add(new JLabel("NOME"));
        jpnomeflow.add(jtnome);


        JPanel jpenderecoborder = new JPanel();
        jpenderecoborder.setLayout(new BorderLayout());

        JPanel jpenderecoflow = new JPanel();
        jpenderecoflow.setLayout(new FlowLayout());

        jtendereco =  new JTextField(10);
        
        jpenderecoflow.add(new JLabel("ENDEREÇO"));
        jpenderecoflow.add(jtendereco);


        JPanel jptelefoneborder = new JPanel();
        jptelefoneborder.setLayout(new BorderLayout());

        JPanel jptelefoneflow = new JPanel();
        jptelefoneflow.setLayout(new FlowLayout());

        jttelefone = new JTextField(10);

        jptelefoneflow.add(new JLabel("TELEFONE"));
        jptelefoneflow.add(jttelefone);
        

        jpcodigoborder.add(jpcodigoflow);
        jpnomeborder.add(jpnomeflow); 
        jpenderecoborder.add(jpenderecoflow);
        jptelefoneborder.add(jptelefoneflow);


        atributos.setPreferredSize(new Dimension(190,10));
        atributos.add(jpcodigoborder);
        atributos.add(jpnomeborder);
        atributos.add(jpenderecoborder);
        atributos.add(jptelefoneborder);

    }

    public void montarAreaAnotacao(){
        
        anotacao = new JPanel();
        anotacao.setLayout(new BoxLayout(anotacao, BoxLayout.Y_AXIS));
        anotacao.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(), BorderFactory.createEmptyBorder(5,0,0,5)));
        anotacao.getBorder();

        jtanotacao = new JTextArea();
        jtanotacao.setBackground(Color.white);
        jtanotacao.setForeground(Color.black);
        jtanotacao.setLineWrap(true);

        JScrollPane jsanotacao = new JScrollPane(jtanotacao);
        jsanotacao.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsanotacao.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jsanotacao.setPreferredSize(new Dimension(75,0 ));



        anotacao.add(new JLabel("                        ANOTAÇÃO"));
        anotacao.add(jsanotacao);
        anotacao.setPreferredSize(new Dimension(265,100));

    }

    public void montarBotaoNavegacao(){

        botoesNavega = new JPanel();
        botoesNavega.setLayout(new BorderLayout());

        JPanel jpbotaoNavegaborder = new JPanel();
        jpbotaoNavegaborder.setLayout(new BorderLayout());

        JPanel jpbotaoNavegaflow = new JPanel();
        jpbotaoNavegaflow.setLayout(new FlowLayout());

        btNavegaAnt = new JButton("ANTERIOR");
        btNavegaProx = new JButton("PRÓXIMO");
        btNavegaFim = new JButton("FIM NAVEGAÇÃO");
        
        btNavegaAnt.addActionListener(this);
        btNavegaFim.addActionListener(this);
        btNavegaProx.addActionListener(this);

        btNavegaAnt.setEnabled(false);
        btNavegaProx.setEnabled(false);
        btNavegaFim.setEnabled(false);

        jpbotaoNavegaflow.add(btNavegaAnt);
        jpbotaoNavegaflow.add(btNavegaProx);
        jpbotaoNavegaflow.add(btNavegaFim);

        jpbotaoNavegaborder.add(jpbotaoNavegaflow);

        botoesNavega.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(), BorderFactory.createEmptyBorder(5,0,5,0)));
        botoesNavega.getBorder();
        botoesNavega.add(jpbotaoNavegaborder);

    }

    public void montarBotaoAcao(){

        botoesAcao = new JPanel();
        botoesAcao.setLayout(new BorderLayout());
        botoesAcao.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createCompoundBorder(), BorderFactory.createEmptyBorder(0,0,2,0)));
        botoesAcao.getBorder();
        btAacaoInserir = new JButton("INSERIR");
        btAcaoConsultar = new JButton("CONSULTAR");
        btAcaoAlterar = new JButton("ALTERAR");
        btAcaoExcluir = new JButton("EXCLUIR");
        btAcaoLimpar = new JButton("LIMPAR");

        btAacaoInserir.addActionListener(this);
        btAcaoAlterar.addActionListener(this);
        btAcaoConsultar.addActionListener(this);
        btAcaoExcluir.addActionListener(this);
        btAcaoLimpar.addActionListener(this);



        JPanel jpbotaoAcaoborder = new JPanel();
        jpbotaoAcaoborder.setLayout(new BorderLayout());

        JPanel jpbotaoAcaoflow = new JPanel();
        jpbotaoAcaoflow.setLayout(new FlowLayout());

        jpbotaoAcaoflow.add(btAacaoInserir);
        jpbotaoAcaoflow.add(btAcaoConsultar);
        jpbotaoAcaoflow.add(btAcaoAlterar);
        jpbotaoAcaoflow.add(btAcaoExcluir);
        jpbotaoAcaoflow.add(btAcaoLimpar);

        jpbotaoAcaoborder.add(jpbotaoAcaoflow);

        JScrollPane jsbotaoAcao  = new JScrollPane(jpbotaoAcaoborder);
      
        
        botoesAcao.add(jsbotaoAcao);
        botoesAcao.setPreferredSize(new Dimension(450, 43));
    }
    
    public  void montaTabela(){
        
        tabela = new JPanel();
        tabela.setLayout(new BoxLayout(tabela, BoxLayout.Y_AXIS));
        tabela.setPreferredSize(new Dimension(415, 0));

        JPanel jptabelaborder = new JPanel();
        jptabelaborder.setLayout(new BorderLayout());

        JPanel jptabelaflow = new JPanel();
        jptabelaflow.setLayout(new FlowLayout());

        modelo = new ModeloTabela();
        modelo.ler();

        tabel = new JTable(modelo);
        tabel.setGridColor(Color.DARK_GRAY);
        tabel.setSelectionBackground(Color.blue);
        tabel.setSelectionForeground(Color.white);
        tabel.setBackground(Color.white);
        tabel.setPreferredSize(new Dimension(405,307));


        JScrollPane jstabela = new JScrollPane(tabel);
        jstabela.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jstabela.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jstabela.setPreferredSize(new Dimension(405,307));
        jptabelaflow.add(jstabela);
        jptabelaborder.add("Center",jptabelaflow);

        tabela.add(jptabelaborder);
    }

    public void actionPerformed(ActionEvent acao)
    {
        if(acao.getSource() == btAacaoInserir){

            arquivo = new RegistroDados();
            
            String cod = arquivo.geracod(modelo.getRowCount()+1);



            arquivo.gravar(cod,jtnome.getText(),jtendereco.getText(), jttelefone.getText(), jtanotacao.getText());

            jtcodigo.setText("");
            jtnome.setText("");
            jtendereco.setText("");
            jttelefone.setText("");
            jtanotacao.setText("");

            modelo.ler();
        } 
        if(acao.getSource() == btAcaoExcluir){
            
            arquivo = new RegistroDados();
            arquivo.excluir(jtcodigo.getText());
            modelo.ler();

            jtcodigo.setText("");
            jtnome.setText("");
            jtanotacao.setText("");
            jtendereco.setText("");
            jttelefone.setText("");
            
        }
        if(acao.getSource() == btAcaoAlterar){

            String cod = (jtcodigo.getText());
            String nom = (jtnome.getText());
            String end = (jtendereco.getText());
            String tel = (jttelefone.getText());
            String anot = (jtanotacao.getText());

            if(cod.isEmpty()||nom.isEmpty()||anot.isEmpty()||tel.isEmpty()||end.isEmpty()){

            }else{
                arquivo.altera(cod,nom,end,tel,anot);
                modelo.ler();

                jtcodigo.setText("");
                jtnome.setText("");
                jtanotacao.setText("");
                jtendereco.setText("");
                jttelefone.setText("");
            }
        }
        if(acao.getSource() == btAcaoConsultar){

            if(jtnome.getText().isEmpty() && jtcodigo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Para realizar a consulta informar codigo ou nome");
            }

            if((jtnome.getText().isEmpty())==false && (jtcodigo.getText().isEmpty())==false){
            
                JOptionPane.showMessageDialog(null,"Para realizar a consulta informar somente codigo ou nome");
            }
        
            if((jtcodigo.getText().isEmpty())==false && jtnome.getText().isEmpty()){
                
                String[] resultado =arquivo.consultacod(jtcodigo.getText());
                if(resultado == null){
                    
                }else{
                    jtcodigo.setText("");
                    jtnome.setText("");
                    jtanotacao.setText("");
                    jtendereco.setText("");
                    jttelefone.setText("");
                    jtcodigo.setText(resultado[0]);
                    jtnome.setText(resultado[1]);
                    jtendereco.setText(resultado[2]);
                    jttelefone.setText(resultado[3]);
                    jtanotacao.setText(resultado[4]);
                }
            }
            if((jtnome.getText().isEmpty())==false && jtcodigo.getText().isEmpty()){
               
                String [][]resultado = arquivo.consultanome(jtnome.getText(),modelo);
                if(resultado==null){

                }else{
                    jtcodigo.setText("");
                    jtnome.setText("");
                    jtanotacao.setText("");
                    jtendereco.setText("");
                    jttelefone.setText("");

                    jtcodigo.setText(resultado[0][0]);
                    jtnome.setText(resultado[0][1]);
                    jtendereco.setText(resultado[0][2]);
                    jttelefone.setText(resultado[0][3]);
                    jtanotacao.setText(resultado[0][4]);


                    if(resultado[1][0]!=null){
                        btNavegaProx.setEnabled(true);
                    }
                }
            } 
            

        }
        if(acao.getSource()==btNavegaProx){
            
            btNavegaFim.setEnabled(true);
            String [][] resultado = arquivo.consultanome(jtnome.getText(), modelo);
            
            j++;
            jtcodigo.setText(resultado[j][0]);
            jtnome.setText(resultado[j][1]);
            jtendereco.setText(resultado[j][2]);
            jttelefone.setText(resultado[j][3]);
            jtanotacao.setText(resultado[j][4]);

            if(resultado[j+1]==null || resultado[j+1][1]==null){
                btNavegaProx.setEnabled(false);
            }
            if(resultado[j-1]!=null){
                btNavegaAnt.setEnabled(true);
            }
        }
        if(acao.getSource()==btNavegaAnt){

            j--;           
            String [][] resultado = arquivo.consultanome(jtnome.getText(), modelo);
            
            jtcodigo.setText(resultado[j][0]);
            jtnome.setText(resultado[j][1]);
            jtendereco.setText(resultado[j][2]);
            jttelefone.setText(resultado[j][3]);
            jtanotacao.setText(resultado[j][4]);

            if(j==0){
                btNavegaAnt.setEnabled(false);
            }
            if(resultado[j+1]!=null){
                btNavegaProx.setEnabled(true);
            }
        }
        
        if(acao.getSource()==btNavegaFim){
            j=1;
            btNavegaAnt.setEnabled(false);
            btNavegaFim.setEnabled(false);
            btNavegaProx.setEnabled(false);

            jtcodigo.setText("");
            jtnome.setText("");
            jtanotacao.setText("");
            jtendereco.setText("");
            jttelefone.setText("");
        }


        if(acao.getSource() == btAcaoLimpar){;
           
            jtcodigo.setText("");
            jtnome.setText("");
            jtanotacao.setText("");
            jtendereco.setText("");
            jttelefone.setText("");

        }
    }
}