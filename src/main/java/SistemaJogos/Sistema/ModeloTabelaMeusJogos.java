package SistemaJogos.Sistema;

import javax.swing.table.AbstractTableModel;

public class ModeloTabelaMeusJogos extends AbstractTableModel {

    private String[] colunas = {"Id", "Nome", "Gênero", "Ano", "Gratuito"};
    private SistemaJogos sistema;
    private String matricula;

    public ModeloTabelaMeusJogos(SistemaJogos sistema, String matricula) {
        this.sistema = sistema;
        this.matricula = matricula;
    }

    @Override
    public int getRowCount() {
        return sistema.meusJogosFavoritos(matricula).size();
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
        Jogo jogo = sistema.meusJogosFavoritos(matricula).get(rowIndex + 1); // IDs começam em 1

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