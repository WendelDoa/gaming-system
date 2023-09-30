package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.UsuarioJaExisteException;
import SistemaJogos.GUI.CadastrarGUI;
import SistemaJogos.GUI.SistemaGUI;
import SistemaJogos.Sistema.SistemaJogos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuarioController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaPrincipalCadastrar;

    public CadastrarUsuarioController(SistemaJogos sistema, JFrame janelaPrincipalCadastrar) {
        this.sistema = sistema;
        this.janelaPrincipalCadastrar = janelaPrincipalCadastrar;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String nome = ((CadastrarGUI) janelaPrincipalCadastrar).getNome();
            String matricula = ((CadastrarGUI) janelaPrincipalCadastrar).getMatricula();
            sistema.cadastrarUsuario(nome, matricula);
            JOptionPane.showMessageDialog(janelaPrincipalCadastrar, "Usuário de nome: "+nome+" e matricula: "+matricula+" castrado com sucesso!");
        } catch (UsuarioJaExisteException exception) {
            JOptionPane.showMessageDialog(janelaPrincipalCadastrar, exception.getMessage());
        }
    }
}
