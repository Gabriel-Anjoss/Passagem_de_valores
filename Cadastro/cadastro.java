import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class cadastro extends JFrame {
    JLabel lblTitulo, lblNome, lblMatricula, lblCurso, lblRestricoes;
    JTextField txtNome, txtMatricula;
    JButton btnCadastrar, btnLimpar, btnSair;

    JRadioButton rbSerie1, rbSerie2, rbSerie3, rbCurso1, rbCurso2, rbCurso3;
    ButtonGroup grupoSeries, grupoCursos;

    JComboBox<String> comboTurno;
    String[] periodos = {"Selecione", "Matutino", "Vespertino", "Noturno"};

    JTextArea txtRestricoes;
    JScrollPane scrollRestricoes;
    JPanel painelRestricoes;

    String nome, matricula, turno, curso, serie, restricoes;

    public cadastro() {
        super("Formulário");
        setSize(680, 700);
        setResizable(false);
        setLayout(null);
        Container tela = getContentPane();

        
            ImageIcon icone = new ImageIcon("imgs/nsaonline.png");
            setIconImage(icone.getImage());


        lblTitulo = new JLabel("Dados cadastrais do Aluno");
        lblNome = new JLabel("Nome:");
        lblMatricula = new JLabel("Matrícula:");
        lblCurso = new JLabel("Informe dados do seu Curso:");
        lblRestricoes = new JLabel("Restrições Médicas:");
    
        txtNome = new JTextField(50);
        txtMatricula = new JTextField(5);

        btnCadastrar = new JButton("Apresentar Dados");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");

        btnCadastrar.setMnemonic(KeyEvent.VK_A);
        btnLimpar.setMnemonic(KeyEvent.VK_L);
        btnSair.setMnemonic(KeyEvent.VK_S);

        rbSerie1 = new JRadioButton("1° Série");
        rbSerie2 = new JRadioButton("2° Série");
        rbSerie3 = new JRadioButton("3° Série");

        rbCurso1 = new JRadioButton("Etim");
        rbCurso2 = new JRadioButton("Mtec");
        rbCurso3 = new JRadioButton("Técnico");

        grupoSeries = new ButtonGroup();
        grupoCursos = new ButtonGroup();

        grupoSeries.add(rbSerie1);
        grupoSeries.add(rbSerie2);
        grupoSeries.add(rbSerie3);

        grupoCursos.add(rbCurso1);
        grupoCursos.add(rbCurso2);
        grupoCursos.add(rbCurso3);

        comboTurno = new JComboBox<>(periodos);
        comboTurno.setMaximumRowCount(3);

        txtRestricoes = new JTextArea(10, 20);
        scrollRestricoes = new JScrollPane(txtRestricoes);
        scrollRestricoes.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollRestricoes.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        painelRestricoes = new JPanel();
        painelRestricoes.add(scrollRestricoes);


        btnCadastrar.addActionListener((ActionEvent e) -> {
            if (txtNome.getText().isEmpty() || txtMatricula.getText().isEmpty() || txtRestricoes.getText().isEmpty() ||
                grupoSeries.getSelection() == null || grupoCursos.getSelection() == null || comboTurno.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Campos obrigatórios não preenchidos", JOptionPane.WARNING_MESSAGE);
            } else {
                nome = txtNome.getText();
                matricula = txtMatricula.getText();
                restricoes = txtRestricoes.getText();
                serie = "";
                curso = "";
                turno = comboTurno.getSelectedItem().toString();

                if (rbCurso1.isSelected()) {
                    curso = rbCurso1.getText();
                } else if (rbCurso2.isSelected()) {
                    curso = rbCurso2.getText();
                } else if (rbCurso3.isSelected()) {
                    curso = rbCurso3.getText();
                } else {
                    curso = "Nada Selecionado";
                }

                if (rbSerie1.isSelected()) {
                    serie = rbSerie1.getText();
                } else if (rbSerie2.isSelected()) {
                    serie = rbSerie2.getText();
                } else if (rbSerie3.isSelected()) {
                    serie = rbSerie3.getText();
                } else {
                    serie = "Nada Selecionado";
                }

                Mostrar mostrarDados = new Mostrar(nome, matricula, restricoes, turno, curso, serie);
                mostrarDados.setVisible(true);  
                dispose();
            }
        });


        btnLimpar.addActionListener((ActionEvent e) -> {
            txtNome.setText("");
            txtMatricula.setText("");
            txtRestricoes.setText("");
            grupoSeries.clearSelection();
            grupoCursos.clearSelection();
            comboTurno.setSelectedIndex(0);
        });

    btnSair.addActionListener((ActionEvent e) -> {
    Object[] botoes = {"Sim", "Não"};
    int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que quer sair?", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, botoes, botoes[0]);
    if (resposta == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
});




        lblTitulo.setBounds(215, 10, 500, 30);
        lblTitulo.setFont(new Font("Arial",Font.BOLD,20));

        lblNome.setBounds(50, 50, 100, 20);
        txtNome.setBounds(150, 50, 200, 20);
        lblNome.setFont(new Font("Arial", Font.BOLD, 15));
        
        lblMatricula.setBounds(50, 100, 100, 20);
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 15));

        txtMatricula.setBounds(150, 100, 200, 20);
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 15));

        lblCurso.setBounds(50, 150, 300, 20);
         lblCurso.setFont(new Font("Arial", Font.BOLD, 15));
         
        lblMatricula.setFont(new Font("Arial", Font.BOLD, 15));

        rbCurso1.setBounds(50, 180, 100, 20);
        rbCurso2.setBounds(50, 210, 100, 20);
        rbCurso3.setBounds(50, 240, 100, 20);

        rbSerie1.setBounds(200, 180, 100, 20);
        rbSerie2.setBounds(200, 210, 100, 20);
        rbSerie3.setBounds(200, 240, 100, 20);

        comboTurno.setBounds(50, 270, 150, 20);

        lblRestricoes.setBounds(100, 320, 200, 20);
        painelRestricoes.setBounds(120, 350, 300, 200);
          lblRestricoes.setFont(new Font("Arial", Font.BOLD, 15));

        btnCadastrar.setBounds(120, 600, 180, 30);
        btnSair.setBounds(450, 600, 100, 30);
        btnLimpar.setBounds(320, 600, 100, 30);

        tela.add(lblTitulo);
        tela.add(lblNome);
        tela.add(txtNome);
        tela.add(lblMatricula);
        tela.add(txtMatricula);
        tela.add(lblCurso);
        tela.add(rbCurso1);
        tela.add(rbCurso2);
        tela.add(rbCurso3);
        tela.add(rbSerie1);
        tela.add(rbSerie2);
        tela.add(rbSerie3);
        tela.add(comboTurno);
        tela.add(lblRestricoes);
        tela.add(painelRestricoes);
        tela.add(btnCadastrar);
        tela.add(btnLimpar);
        tela.add(btnSair);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        cadastro app = new cadastro();
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}


