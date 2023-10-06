package SistemaJogos.GUI;

import SistemaJogos.Controllers.*;
import SistemaJogos.Exceptions.JogoInexistenteException;
import SistemaJogos.Exceptions.JogoJaAtribuidoException;
import SistemaJogos.Exceptions.JogoNaoAtribuidoException;
import SistemaJogos.Sistema.ConfirmacaoSaidaWindowAdapter;
import SistemaJogos.Sistema.Jogo;
import SistemaJogos.Sistema.SistemaJogos;
import SistemaJogos.Sistema.Usuario;

import javax.swing.*;
import java.awt.*;

public class HomeUsuarioGUI extends JFrame {
    ImageIcon heartImg = new ImageIcon("./src/images/heart.png");
    ImageIcon gamepadImg = new ImageIcon("./src/images/gamepad.png");
    String matricula;
    String usuarioNome;
    SistemaJogos sistema;
    JMenuBar barraDeMenu = new JMenuBar();

    public HomeUsuarioGUI(SistemaJogos sistema, String matricula, String usuarioNome) {
        this.sistema = sistema;
        this.matricula = matricula;
        this.usuarioNome = usuarioNome;
        setTitle("Pagina Principal");
        setSize(600,600);
        setLocationRelativeTo(null);
        setResizable(false);


        JButton botaoMeusJogos = new JButton("Meus jogos");
        JLabel labelHeart = new JLabel(heartImg, JLabel.CENTER);
        botaoMeusJogos.addActionListener((ae) -> {
            TabelaMeusJogosGUI tabelaMeusJogosGUI = new TabelaMeusJogosGUI(sistema, matricula);
            tabelaMeusJogosGUI.setVisible(true);
        });

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
            try {
                sistema.adicionarJogoFavoritoDoUsuario(idAdicionar, matricula);
                JOptionPane.showMessageDialog(this,"Jogo " + sistema.buscarJogo(idAdicionar).getNome() + " adicionado com sucesso!");
            } catch (JogoJaAtribuidoException e) {
                JOptionPane.showMessageDialog(this,"Jogo já está nos favoritos!");
            } catch (JogoInexistenteException e) {
                JOptionPane.showMessageDialog(this,"Nenhum jogo corresponde ao id digitado!");
            }

        });
        JMenuItem menuRemoverJogoFavorito = new JMenuItem("Remover jogo favorito");
        menuPerfil.add(menuRemoverJogoFavorito);
        menuRemoverJogoFavorito.addActionListener((ae) -> {
            int idRemover = Integer.parseInt((JOptionPane.showInputDialog(this,"Qual é o id do jogo?")));
            try {
                sistema.removerJogoFavoritoDoUsuario(idRemover, matricula);
                JOptionPane.showMessageDialog(this,"Jogo " + sistema.buscarJogo(idRemover).getNome() + " removido com sucesso!");

            } catch (JogoNaoAtribuidoException e) {
                JOptionPane.showMessageDialog(this, "Jogo não está atribuído ao usuário!");
            } catch (JogoInexistenteException e) {
                JOptionPane.showMessageDialog(this,"Nenhum jogo corresponde ao id digitado!");
            }
        });

        JMenu menuInformacoes = new JMenu("Informações");
        JMenuItem menuConta = new JMenuItem("Conta");
        menuInformacoes.add(menuConta);
        menuConta.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Nome: " + usuarioNome + "\nMatricula: " + matricula);
        });
        JMenuItem menuSobre = new JMenuItem("Sobre");
        menuInformacoes.add(menuSobre);
        menuSobre.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Projeto criado por:\nWendel Soares Sampaio\nCiências da computação - POO\nUFPB - Rio Tinto\n 2023");
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

        addWindowListener(new ConfirmacaoSaidaWindowAdapter());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}
