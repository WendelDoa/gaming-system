package SistemaJogos.GUI;

import SistemaJogos.Controllers.CadastrarJogoController;
import SistemaJogos.Controllers.VoltarController;
import SistemaJogos.Sistema.Genero;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class CadastrarJogoGUI extends JFrame {

    SistemaJogos sistema;
    private static JTextField nome = new JTextField();
    private static Genero genero = Genero.TERROR;
    private ButtonGroup grupoBotao = new ButtonGroup();
    private JRadioButton terrorButton = new JRadioButton("Terror");
    private JRadioButton acaoButton = new JRadioButton("Ação");
    private JRadioButton aventuraButton = new JRadioButton("Aventura");
    private JRadioButton fpsButton = new JRadioButton("FPS");
    private JRadioButton rpgButton = new JRadioButton("RPG");
    private JTextField ano = new JTextField();
    private JCheckBox ehGratuitoBox = new JCheckBox();
    private static boolean ehGratuito = false;

    public CadastrarJogoGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Cadastrar jogo");
        setSize(270,400);
        setLocationRelativeTo(null);
        setResizable(false);

        //Panel principal
        JPanel panel  = new JPanel();

        //Linha 1
        JPanel linha1 = new JPanel(new GridLayout(3,1));
        JLabel nomeLabel = new JLabel("Digite o nome:");
        nome.setPreferredSize(new Dimension(200,25));
        JLabel generoLabel = new JLabel("Escolha o gênero:");
        linha1.add(nomeLabel);
        linha1.add(nome);
        linha1.add(generoLabel);
        panel.add(linha1);

        //Linha 2
        JPanel linha2 = new JPanel(new GridLayout(2, 1));
        terrorButton.setSelected(true);
        grupoBotao.add(terrorButton);
        grupoBotao.add(acaoButton);
        grupoBotao.add(aventuraButton);
        grupoBotao.add(fpsButton);
        grupoBotao.add(rpgButton);
        terrorButton.addActionListener((ae) -> {genero = Genero.TERROR;});
        acaoButton.addActionListener((ae) -> {genero = Genero.ACAO;});
        aventuraButton.addActionListener((ae) -> {genero = Genero.AVENTURA;});
        fpsButton.addActionListener((ae) -> {genero = Genero.FPS;});
        rpgButton.addActionListener((ae) -> {genero = Genero.RPG;});
        linha2.add(terrorButton);
        linha2.add(acaoButton);
        linha2.add(aventuraButton);
        linha2.add(fpsButton);
        linha2.add(rpgButton);
        panel.add(linha2);

        //Linha 3
        JPanel linha3 = new JPanel(new GridLayout(2,1));
        ano.setPreferredSize(new Dimension(200,25));
        JLabel anoLabel = new JLabel("Ano de lançamento:");
        linha3.add(anoLabel);
        linha3.add(ano);
        panel.add(linha3);

        //Linha 4
        JPanel linha4 = new JPanel();
        JLabel ehGratuitoLabel = new JLabel("É gratuito?");
        ehGratuitoBox.addActionListener((ae) -> {
            if(ehGratuitoBox.isSelected()) {
                ehGratuito = true;
            } else {
                ehGratuito = false;
            }
        });
        linha4.add(ehGratuitoLabel);
        linha4.add(ehGratuitoBox);
        panel.add(linha4);

        //Linha 5
        JPanel linha5 = new JPanel(new GridLayout(2,1));
        JButton cadastrarBotao = new JButton("Cadastrar");
        cadastrarBotao.setPreferredSize(new Dimension(200,50));
        cadastrarBotao.addActionListener(new CadastrarJogoController(sistema, this));
        JButton voltarBotao = new JButton("Voltar");
        voltarBotao.setPreferredSize(new Dimension(200,50));
        voltarBotao.addActionListener(new VoltarController(sistema, this));
        linha5.add(cadastrarBotao);
        linha5.add(voltarBotao);
        panel.add(linha5);


        getContentPane().add(panel);
        getContentPane().setVisible(true);
    }

    public static String getNome() {
        return nome.getText();
    }

    public static Genero getGenero() {
        return genero;
    }

    public String getAno() {
        return ano.getText();
    }

    public static boolean getEhPago() {
        return ehGratuito;
    }
}
