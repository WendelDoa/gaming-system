package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.UsuarioJaExisteException;
import SistemaJogos.GUI.CadastrarGUI;
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
            String nome = ((CadastrarGUI) janelaCadastrarUsuario).getNome();
            String matricula = ((CadastrarGUI) janelaCadastrarUsuario).getMatricula();
            sistema.cadastrarUsuario(nome, matricula);
            JOptionPane.showMessageDialog(janelaCadastrarUsuario, "Usuário de nome: "+nome+" e matricula: "+matricula+" castrado com sucesso!");
        } catch (UsuarioJaExisteException exception) {
            JOptionPane.showMessageDialog(janelaCadastrarUsuario, exception.getMessage());
        }
    }
}
