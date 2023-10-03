package SistemaJogos.GUI;

import SistemaJogos.Controllers.*;
import SistemaJogos.Sistema.SistemaJogos;
import SistemaJogos.Sistema.Usuario;

import javax.swing.*;
import java.awt.*;

public class HomeUsuarioGUI extends JFrame {
    ImageIcon heartImg = new ImageIcon("./src/images/heart.png");
    ImageIcon gamepadImg = new ImageIcon("./src/images/gamepad.png");
    Usuario usuario;
    SistemaJogos sistema;
    JMenuBar barraDeMenu = new JMenuBar();

    public HomeUsuarioGUI(SistemaJogos sistema, Usuario usuario) {
        this.sistema = sistema;
        this.usuario = usuario;
        setTitle("Pagina Principal");
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);


        JButton botaoMeusJogos = new JButton("Meus jogos");
        JLabel labelHeart = new JLabel(heartImg, JLabel.CENTER);
        botaoMeusJogos.addActionListener(new SistemaMeusJogosController(sistema, this));

        JLabel labelGamepad = new JLabel(gamepadImg, JLabel.CENTER);
        JButton botaoJogos = new JButton("Jogos");
        botaoJogos.addActionListener((ae) -> {
                    TabelaDeJogosGUI tabelaDeJogosGUI = new TabelaDeJogosGUI(sistema);
                    tabelaDeJogosGUI.setVisible(true);
        });

        JMenu menuPerfil = new JMenu("Perfil");
        JMenuItem menuAdicionarJogoFavorito = new JMenuItem("Adicionar jogo favorito");
        menuPerfil.add(menuAdicionarJogoFavorito);
        menuAdicionarJogoFavorito.addActionListener((ae) -> {
            int idAdicionar = Integer.parseInt((JOptionPane.showInputDialog(this,"Qual é o id do jogo?")));
        });
        JMenuItem menuRemoverJogoFavorito = new JMenuItem("Remover jogo favorito");
        menuPerfil.add(menuRemoverJogoFavorito);
        menuRemoverJogoFavorito.addActionListener((ae) -> {
            int idRemover = Integer.parseInt((JOptionPane.showInputDialog(this,"Qual é o id do jogo?")));
        });

        JMenu menuInformacoes = new JMenu("Informações");
        JMenuItem menuConta = new JMenuItem("Conta");
        menuInformacoes.add(menuConta);
        menuConta.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Nome: Matricula:");
        });
        JMenuItem menuSobre = new JMenuItem("Sobre");
        menuInformacoes.add(menuSobre);
        menuSobre.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Sobre o projeto...");
        });

        JMenuItem menuSairBotao = new JMenuItem("Sair");
        menuSairBotao.setMaximumSize(new Dimension(35,50));
        menuSairBotao.addActionListener((ae) -> {
            int cond = JOptionPane.showConfirmDialog(null,"Tem certeza?", "Sair", JOptionPane.YES_NO_OPTION);
            if (cond == JOptionPane.YES_OPTION) {
                SistemaGUI sistemaGUI = new SistemaGUI(sistema);
                sistemaGUI.setVisible(true);
                dispose();
            }
        });

        getContentPane().setLayout(new GridLayout(2,1));
        getContentPane().add(botaoMeusJogos);
        getContentPane().add(labelHeart);
        getContentPane().add(botaoJogos);
        getContentPane().add(labelGamepad);


        barraDeMenu.add(menuPerfil);
        barraDeMenu.add(menuInformacoes);
        barraDeMenu.add(menuSairBotao);
        setJMenuBar(barraDeMenu);
    }

}
