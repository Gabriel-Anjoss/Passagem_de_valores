
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mostrar extends JFrame {
    JLabel txtTitulo,txtNome, txtMatricula,txtRestricao,txtTurno,txtCurso,txtSerie;
    JLabel nomee,matriculaa,restricaoo,turnoo,cursoo,seriee;
    JButton voltar,sair;
    
    public Mostrar(String nome, String matricula, String restricao, String Turno,String Curso, String Serie ){
        super("Dados Cadastrados");
        setSize(600,500);
        setResizable(false);
        setLayout(null);
        Container tela = getContentPane();
        
        
            ImageIcon icone = new ImageIcon("imgs/nsaonline.png");
            setIconImage(icone.getImage());


        txtTitulo = new JLabel("Os Dados Cadastrados foram:");
        txtNome = new JLabel("Nome:");
        txtMatricula = new JLabel("Matrícula:");
        txtRestricao = new JLabel("Restrição Médica:");
        txtTurno = new JLabel("Turno:");
        txtCurso = new JLabel("Curso:");
        txtSerie = new JLabel("Serie:");
        
        nomee = new JLabel(nome);
        matriculaa = new JLabel(matricula);
        restricaoo = new JLabel(restricao);
        turnoo = new JLabel(Turno);
        cursoo= new JLabel(Curso);
        seriee = new JLabel(Serie);
        
        voltar = new JButton("Voltar");
        sair = new JButton("Sair");
                
        
        
        
        
        
       txtTitulo.setBounds(150,10,500,30);
       txtTitulo.setFont(new Font("Arial",Font.BOLD,20));
            
       txtNome.setBounds(50,50,100,10);
       nomee.setBounds(100,50,1000,10);
            txtNome.setFont(new Font("Arial",Font.BOLD,15));

       txtMatricula.setBounds(50,100,100,10);
       matriculaa.setBounds(120,100,100,10);
            txtMatricula.setFont(new Font("Arial",Font.BOLD,15));

       txtRestricao.setBounds(50,150,200,10);
       restricaoo.setBounds(180,150,10000,10);
       txtRestricao.setFont(new Font("Arial",Font.BOLD,15));

       txtTurno.setBounds(50,200,100,10);
       turnoo.setBounds(100,200,150,10);
       txtTurno.setFont(new Font("Arial",Font.BOLD,15));
       
       
       txtCurso.setBounds(50,250,100,10);
       cursoo.setBounds(100,250,150,10);     
        txtCurso.setFont(new Font("Arial",Font.BOLD,15));

       txtSerie.setBounds(50,300,100,10);
       seriee.setBounds(100,300,150,10);
        txtSerie.setFont(new Font("Arial",Font.BOLD,15));
        
        voltar.setBounds(200,400,100,20);
        sair.setBounds(300,400,100,20);
        
        
        voltar.addActionListener((ActionEvent e) -> {
                 cadastro app = new cadastro();
                 app.setVisible(true);
                 dispose();
            });
        
       sair.addActionListener((ActionEvent e) -> {
    Object[] botoes = {"Sim", "Não"};
    int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que quer sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
    if (resposta == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    });
        
        
        
        
        
        tela.add(txtTitulo);
        tela.add(txtNome);
        tela.add(txtMatricula);
        tela.add(txtRestricao);
        tela.add(txtTurno);
        tela.add(txtCurso);
        tela.add(txtSerie);
        
        tela.add(nomee);
        tela.add(matriculaa);
        tela.add(restricaoo);
        tela.add(turnoo);
        tela.add(cursoo);
        tela.add(seriee);
        
        tela.add(voltar);
        tela.add(sair);
        
        
        setLocationRelativeTo(null);
            setVisible(true);
        
    }
    
    
   
}