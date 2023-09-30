package SistemaJogos;

import SistemaJogos.GUI.SistemaGUI;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main {
    public static void main(String[] args) {
        SistemaJogos sistema = new SistemaJogos();
        JFrame janela = new SistemaGUI(sistema);
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }
}
