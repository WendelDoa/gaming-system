package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.UsuarioInexistenteException;
import SistemaJogos.GUI.EntrarGUI;
import SistemaJogos.GUI.HomeUsuarioGUI;
import SistemaJogos.Sistema.SistemaJogos;
import SistemaJogos.Sistema.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EntrarUsuarioController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaPrincipalEntrar;

    public EntrarUsuarioController(SistemaJogos sistema, JFrame janelaPrincipalEntrar) {
        this.sistema = sistema;
        this.janelaPrincipalEntrar = janelaPrincipalEntrar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String matricula = ((EntrarGUI) janelaPrincipalEntrar).getMatricula();
            Usuario usuario = sistema.buscarUsuario(matricula);
            JOptionPane.showMessageDialog(janelaPrincipalEntrar, "Seja bem vindo "+ usuario.getNome());
            HomeUsuarioGUI homeUsuarioGUI = new HomeUsuarioGUI(sistema, usuario);
            homeUsuarioGUI.setVisible(true);
            janelaPrincipalEntrar.dispose();
        } catch (UsuarioInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaPrincipalEntrar, exception.getMessage());
        }
    }
}
