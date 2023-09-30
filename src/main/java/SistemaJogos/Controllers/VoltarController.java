package SistemaJogos.Controllers;

import SistemaJogos.GUI.SistemaGUI;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VoltarController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaPrincipalVoltar;

    public VoltarController(SistemaJogos sistema, JFrame janelaPrincipalVoltar) {
        this.sistema = sistema;
        this.janelaPrincipalVoltar = janelaPrincipalVoltar;
    }

    public void actionPerformed(ActionEvent e) {
        SistemaGUI sistemaGUI = new SistemaGUI(sistema);
        sistemaGUI.setVisible(true);
        janelaPrincipalVoltar.dispose();
    }
}
