package SistemaJogos.GUI;

import SistemaJogos.Controllers.EntrarUsuarioController;
import SistemaJogos.Controllers.VoltarController;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class EntrarGUI extends JFrame {

    JTextField matricula = new JTextField();
    SistemaJogos sistema;

    public EntrarGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Entrar");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Insira sua matrícula de usuário");
        matricula.setPreferredSize(new Dimension(200,25));
        JButton entrarBotao = new JButton("Entrar");
        entrarBotao.addActionListener(new EntrarUsuarioController(sistema, this));
        entrarBotao.setPreferredSize(new Dimension(200,50));
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new VoltarController(sistema, this));
        voltar.setPreferredSize(new Dimension(200,50));
        panel.add(label);
        panel.add(matricula);
        panel.add(entrarBotao);
        panel.add(voltar);
        add(panel);
        setVisible(true);
    }

    public String getMatricula() {
        return matricula.getText();
    }
}
