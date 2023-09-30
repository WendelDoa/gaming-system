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

    public SistemaMeusJogosController(SistemaJogos sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    public void actionPerformed(ActionEvent e) {
        //Collection<Jogo> meusJogosFavoritos = sistema.meusJogosFavoritos();
        JOptionPane.showMessageDialog(janelaPrincipal, "Eu acho que ta certo!");
    }

}
