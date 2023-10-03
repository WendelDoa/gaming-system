package SistemaJogos.Sistema;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaTodosOsJogos extends AbstractTableModel {

    String[] colunas = {"Id", "Nome", "Gênero", "Ano", "Gratuito"};
    SistemaJogos sistema;

    public ModeloTabelaTodosOsJogos(SistemaJogos sistema) {
        this.sistema = sistema;
    }

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