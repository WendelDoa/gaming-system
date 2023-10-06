package SistemaJogos;

import SistemaJogos.GUI.SistemaGUI;
import SistemaJogos.Sistema.ConfirmacaoSaidaWindowAdapter;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SistemaJogos sistema = new SistemaJogos();
        JFrame janela = new SistemaGUI(sistema);
        janela.setVisible(true);
    }
}
