package SistemaJogos.GUI;

import SistemaJogos.Controllers.DeletarJogoController;
import SistemaJogos.Controllers.VoltarController;
import SistemaJogos.Sistema.ConfirmacaoSaidaWindowAdapter;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class DeletarJogoGUI extends JFrame {

    private SistemaJogos sistema;
    private static JTextField idJogo = new JTextField();

    public DeletarJogoGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        idJogo.setPreferredSize(new Dimension(200,25));
        setTitle("Deletar jogo");
        setSize(300, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        JLabel idJogoLabel = new JLabel("Digite o id do jogo:");
        JButton deletarBotao = new JButton("Deletar");
        deletarBotao.setPreferredSize(new Dimension(200,50));
        deletarBotao.addActionListener(new DeletarJogoController(sistema, this));
        JButton voltarBotao = new JButton("Voltar");
        voltarBotao.setPreferredSize(new Dimension(200,50));
        voltarBotao.addActionListener(new VoltarController(sistema, this));
        panel.add(idJogoLabel);
        panel.add(idJogo);
        panel.add(deletarBotao);
        panel.add(voltarBotao);
        add(panel);
        setVisible(true);
        addWindowListener(new ConfirmacaoSaidaWindowAdapter());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static String getIdJogo() {
        return idJogo.getText();
    }
}
