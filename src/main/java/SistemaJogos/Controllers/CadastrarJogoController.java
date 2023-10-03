package SistemaJogos.Controllers;

import SistemaJogos.GUI.CadastrarJogoGUI;
import SistemaJogos.Sistema.Genero;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarJogoController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaCadastrarJogo;

    public CadastrarJogoController(SistemaJogos sistema, JFrame janelaPrincipalCadastrarJogo) {
        this.sistema = sistema;
        this.janelaCadastrarJogo = janelaPrincipalCadastrarJogo;
    }

    public void actionPerformed(ActionEvent e) {
        String nome = (CadastrarJogoGUI.getNome());
        String ano = ((CadastrarJogoGUI) janelaCadastrarJogo).getAno();
        Genero genero = (CadastrarJogoGUI.getGenero());
        boolean ehGratuito = (CadastrarJogoGUI.getEhPago());
        sistema.cadastrarJogo(nome, genero, ano, ehGratuito);
        JOptionPane.showMessageDialog(janelaCadastrarJogo,"Jogo cadastrado com sucesso, visite a lista de jogos!");
    }
}
