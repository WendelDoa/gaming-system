package SistemaJogos.Controllers;

import SistemaJogos.Sistema.Jogo;
import SistemaJogos.Sistema.SistemaJogos;

import java.util.Collection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaMeusJogosController implements ActionListener {

    SistemaJogos sistema;
    private JFrame janelaPrincipal;

    public SistemaMeusJogosController(SistemaJogos sistema, JFrame janelaMeusJogos) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaMeusJogos;
    }

    public void actionPerformed(ActionEvent e) {
        //Collection<Jogo> meusJogosFavoritos = sistema.meusJogosFavoritos();
        JOptionPane.showMessageDialog(janelaPrincipal, "Falta implementar...");
    }

}
