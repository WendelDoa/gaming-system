package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.JogoInexistenteException;
import SistemaJogos.GUI.DeletarJogoGUI;
import SistemaJogos.Sistema.Jogo;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class DeletarJogoController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaDeletarJogo;

    public DeletarJogoController(SistemaJogos sistema, JFrame janelaDeletarJogo) {
        this.sistema = sistema;
        this.janelaDeletarJogo = janelaDeletarJogo;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            String idJogo = (DeletarJogoGUI.getIdJogo());
            int idJogoNumero = Integer.parseInt(idJogo);
            sistema.deletarJogo(idJogoNumero);
            JOptionPane.showMessageDialog(janelaDeletarJogo, "Jogo deletado com sucesso!");
        } catch (JogoInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaDeletarJogo, exception.getMessage());
        }
    }
}
