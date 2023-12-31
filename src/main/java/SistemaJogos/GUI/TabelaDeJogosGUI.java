package SistemaJogos.GUI;

import SistemaJogos.Sistema.ModeloTabelaTodosOsJogos;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.*;

public class TabelaDeJogosGUI extends JFrame {

    SistemaJogos sistema;

    public TabelaDeJogosGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Tabela de jogos");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        JTable tabelaJogos = new JTable(new ModeloTabelaTodosOsJogos(sistema));
        JScrollPane scrollPane = new JScrollPane(tabelaJogos);
        add(scrollPane, BorderLayout.CENTER);
    }

}