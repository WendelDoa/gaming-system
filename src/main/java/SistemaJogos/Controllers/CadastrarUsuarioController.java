package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.UsuarioJaExisteException;
import SistemaJogos.GUI.CadastrarUsuarioGUI;
import SistemaJogos.Sistema.SistemaJogos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarUsuarioController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaCadastrarUsuario;

    public CadastrarUsuarioController(SistemaJogos sistema, JFrame janelaPrincipalCadastrar) {
        this.sistema = sistema;
        this.janelaCadastrarUsuario = janelaPrincipalCadastrar;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String nome = ((CadastrarUsuarioGUI) janelaCadastrarUsuario).getNome();
            String matricula = ((CadastrarUsuarioGUI) janelaCadastrarUsuario).getMatricula();
            sistema.cadastrarUsuario(nome, matricula);
            JOptionPane.showMessageDialog(janelaCadastrarUsuario, "Cadastro concluído!\nUsuário: " + nome + "\nMatricula: " + matricula);
        } catch (UsuarioJaExisteException exception) {
            JOptionPane.showMessageDialog(janelaCadastrarUsuario, exception.getMessage());
        }
    }
}
