package SistemaJogos.GUI;

import SistemaJogos.Sistema.Jogo;
import SistemaJogos.Sistema.ModeloTabela;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class TabelaDeJogosGUI extends JFrame {

    SistemaJogos sistema;

    public TabelaDeJogosGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Tabela de jogos");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);
        JTable tabelaJogos = new JTable(new ModeloTabela(sistema));
        JScrollPane scrollPane = new JScrollPane(tabelaJogos);
        add(scrollPane, BorderLayout.CENTER);
    }

}