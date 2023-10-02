package SistemaJogos.GUI;

import SistemaJogos.Sistema.Jogo;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class TabelaDeJogosGUI extends JFrame {

    SistemaJogos sistema;

    public TabelaDeJogosGUI(SistemaJogos sistema) {
        this.sistema = sistema;
        setTitle("Tabela de jogos");
        setSize(500,500);
        setLocationRelativeTo(null);
        setResizable(false);

        JTable tabelaJogos = new JTable(new ModeloTabela());
        JScrollPane scrollPane = new JScrollPane(tabelaJogos);
        add(scrollPane, BorderLayout.CENTER);
    }

    private class ModeloTabela extends AbstractTableModel {
        String[] colunas = {"Id", "Nome", "Gênero", "Ano", "Gratuito"};

        @Override
        public int getRowCount() {
            return sistema.buscaTodosOsJogos().size();
        }

        @Override
        public int getColumnCount() {
            return colunas.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return colunas[columnIndex];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Jogo jogo = sistema.buscaTodosOsJogos().get(rowIndex + 1); // IDs começam em 1

            return switch (columnIndex) {
                case 0 -> jogo.getId();
                case 1 -> jogo.getNome();
                case 2 -> jogo.getGenero();
                case 3 -> jogo.getAno();
                case 4 -> jogo.getEhGratuito() ? "Sim" : "Não";
                default -> null;
            };
        }
    }
}
