package SistemaJogos.GUI;

import SistemaJogos.Controllers.*;
import SistemaJogos.Sistema.SistemaJogos;
import SistemaJogos.Sistema.Usuario;

import javax.swing.*;
import java.awt.*;

public class HomeUsuarioGUI extends JFrame {
    //ImageIcon boloImg = new ImageIcon("");
    Usuario usuario;
    SistemaJogos sistema;
    JMenuBar barraDeMenu = new JMenuBar();

    public HomeUsuarioGUI(SistemaJogos sistema, Usuario usuario) {
        this.sistema = sistema;
        this.usuario = usuario;
        setTitle("Pagina Principal");
        setSize(800,800);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel labelMeusJogos = new JLabel("Meus jogos");
        JButton botaoMeusJogos = new JButton("Meus jogos");
        botaoMeusJogos.addActionListener(new SistemaMeusJogosController(sistema, this));

        JLabel labelJogos = new JLabel("Jogos");
        JButton botaoJogos = new JButton("Jogos");
        //botaoJogos.addActionListener(new SistemaJogosController(sistema, this));
        add(labelMeusJogos);
        add(labelJogos);
        add(botaoJogos);

        JMenu menuPerfil = new JMenu("Perfil");
        JMenuItem menuAdicionarJogoFavorito = new JMenuItem("Adicionar jogo favorito");
        menuPerfil.add(menuAdicionarJogoFavorito);
        menuAdicionarJogoFavorito.addActionListener((ae) -> {
            int id = Integer.parseInt((JOptionPane.showInputDialog(this,"Qual é o id do jogo?")));
        });
        JMenuItem menuRemoverJogoFavorito = new JMenu("Remover jogo favorito");
        menuPerfil.add(menuRemoverJogoFavorito);
        menuRemoverJogoFavorito.addActionListener((ae) -> {
            int id = Integer.parseInt((JOptionPane.showInputDialog(this,"Qual é o id do jogo?")));
        });
        JMenu menuInformacaoes = new JMenu("Informações");
        menuInformacaoes.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Nome: Matricula:");
        });
        JMenu menuSair = new JMenu("Sair");
        menuSair.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(this, "Usuário deslogado!");
        });

        barraDeMenu.add(menuPerfil);
        barraDeMenu.add(menuInformacaoes);
        barraDeMenu.add(menuSair);
        setJMenuBar(barraDeMenu);
    }

}
