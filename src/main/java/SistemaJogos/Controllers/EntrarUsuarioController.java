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
    private JFrame janelaEntrar;

    public EntrarUsuarioController(SistemaJogos sistema, JFrame janelaEntrar) {
        this.sistema = sistema;
        this.janelaEntrar = janelaEntrar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String matricula = ((EntrarGUI) janelaEntrar).getMatricula();
            Usuario usuario = sistema.buscarUsuario(matricula);
            JOptionPane.showMessageDialog(janelaEntrar, "Seja bem vindo "+ usuario.getNome());
            HomeUsuarioGUI homeUsuarioGUI = new HomeUsuarioGUI(sistema, usuario);
            homeUsuarioGUI.setVisible(true);
            janelaEntrar.dispose();
        } catch (UsuarioInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaEntrar, exception.getMessage());
        }
    }
}
