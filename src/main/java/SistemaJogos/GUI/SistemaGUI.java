package SistemaJogos.GUI;

import SistemaJogos.Sistema.ConfirmacaoSaidaWindowAdapter;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SistemaGUI extends JFrame {

    private SistemaJogos sistema;
    private static boolean mensagemInicial = false;
    JFrame janelaSistemaGUI = new JFrame();

    public SistemaGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Sistema de Jogos");
        setSize(500, 500);
        //Comando para Centralizar a janela ao meio da tela.
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        GridLayout gridLayout = new GridLayout(6, 1);
        setLayout(gridLayout);
        //Função para fazer a execução após a aparição da janela.
        SwingUtilities.invokeLater(() -> {
            if(!mensagemInicial) {
                JOptionPane.showMessageDialog(this,
                        "Olá, bem vindo ao programa de jogos!\nCriado por: Wendel Soares\n Rio tinto - UFPB");
                mensagemInicial = true;
            }
        });
        addButton("Entrar", e -> entrar());
        addButton("Cadastrar Usuário", e -> cadastrarUsuario());
        addButton("Deletar usuário", e -> deletarUsuario());
        addButton("Cadastrar jogo", e -> cadastrarJogo());
        addButton("Deletar jogo", e -> deletarJogo());
        addButton("Salvar e sair", e -> salvarESair());

        addWindowListener(new ConfirmacaoSaidaWindowAdapter());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void addButton(String label, ActionListener actionListener) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        add(button);
    }

    private void entrar() {
        EntrarGUI entrarGUI = new EntrarGUI(sistema);
        entrarGUI.setVisible(true);
        dispose();
    }

    private void cadastrarUsuario() {
        CadastrarUsuarioGUI cadastrarGUI = new CadastrarUsuarioGUI(sistema);
        cadastrarGUI.setVisible(true);
        dispose();
    }

    private void deletarUsuario() {
        DeletarUsuarioGUI deletarUsuarioGUI = new DeletarUsuarioGUI(sistema);
        deletarUsuarioGUI.setVisible(true);
        dispose();
    }

    private void cadastrarJogo() {
        CadastrarJogoGUI cadastrarJogoGUI = new CadastrarJogoGUI(sistema);
        cadastrarJogoGUI.setVisible(true);
        dispose();
    }

    private void deletarJogo() {
        DeletarJogoGUI deletarJogoGUI = new DeletarJogoGUI(sistema);
        deletarJogoGUI.setVisible(true);
        dispose();
    }

    private void salvarESair() {
        sistema.salvarDados();
        System.exit(0);
    }
}
