package SistemaJogos.GUI;

import SistemaJogos.Controllers.CadastrarUsuarioController;
import SistemaJogos.Controllers.VoltarController;
import SistemaJogos.Sistema.ConfirmacaoSaidaWindowAdapter;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class CadastrarUsuarioGUI extends JFrame {

    JTextField matricula = new JTextField();
    JTextField nome = new JTextField();
    SistemaJogos sistema;

    public CadastrarUsuarioGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Cadastrar Usuário");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Insira sua matrícula de usuário");
        matricula.setPreferredSize(new Dimension(200,25));
        JLabel label2 = new JLabel("Insira seu nome de usuário");
        nome.setPreferredSize(new Dimension(200,25));
        JButton cadastrarBotao = new JButton("Cadastrar");
        cadastrarBotao.addActionListener(new CadastrarUsuarioController(sistema, this));
        cadastrarBotao.setPreferredSize(new Dimension(200,50));
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new VoltarController(sistema, this));
        voltar.setPreferredSize(new Dimension(200,50));
        panel.add(label);
        panel.add(matricula);
        panel.add(label2);
        panel.add(nome);
        panel.add(cadastrarBotao);
        panel.add(voltar);
        add(panel);
        setVisible(true);
        addWindowListener(new ConfirmacaoSaidaWindowAdapter());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public String getNome() {
        return nome.getText();
    }

    public String getMatricula() {
        return matricula.getText();
    }
}
