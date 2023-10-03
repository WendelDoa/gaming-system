package SistemaJogos.GUI;

import SistemaJogos.Sistema.ModeloTabelaMeusJogos;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class TabelaMeusJogosGUI extends JFrame {

    private SistemaJogos sistema;
    private String matricula;

    public TabelaMeusJogosGUI(SistemaJogos sistema, String matricula) {
        this.sistema = sistema;
        this.matricula = matricula;
        setTitle("Tabela de jogos");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        JTable tabelaJogos = new JTable(new ModeloTabelaMeusJogos(sistema, matricula));
        JScrollPane scrollPane = new JScrollPane(tabelaJogos);
        add(scrollPane, BorderLayout.CENTER);
    }
}
