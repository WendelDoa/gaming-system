package SistemaJogos.GUI;

import SistemaJogos.Controllers.DeletarUsuarioController;
import SistemaJogos.Controllers.VoltarController;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class DeletarUsuarioGUI extends JFrame {

    static JTextField matricula = new JTextField();
    SistemaJogos sistema;

    public DeletarUsuarioGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Deletar Usuário");
        setSize(300,300);
        setLocationRelativeTo(null);
        setResizable(false);
        JPanel panel = new JPanel();
        matricula.setPreferredSize(new Dimension(200,25));
        JLabel label = new JLabel("Insira sua matrícula:");
        JButton deletarUsuario = new JButton("Deletar");
        deletarUsuario.setPreferredSize(new Dimension(200,50));
        deletarUsuario.addActionListener(new DeletarUsuarioController(sistema, this));
        JButton voltar = new JButton("Voltar");
        voltar.addActionListener(new VoltarController(sistema, this));
        voltar.setPreferredSize(new Dimension(200,50));
        panel.add(label);
        panel.add(matricula);
        panel.add(deletarUsuario);
        panel.add(voltar);
        add(panel);
        setVisible(true);
    }

    public static String getMatricula() {
        return matricula.getText();
    }
}
