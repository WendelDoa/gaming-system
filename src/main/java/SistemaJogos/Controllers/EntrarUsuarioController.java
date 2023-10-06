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
            String usuarioNome = sistema.buscarUsuario(matricula).getNome();
            JOptionPane.showMessageDialog(janelaEntrar, "Seja bem vindo "+ usuarioNome);
            HomeUsuarioGUI homeUsuarioGUI = new HomeUsuarioGUI(sistema, matricula, usuarioNome);
            homeUsuarioGUI.setVisible(true);
            janelaEntrar.dispose();
        } catch (UsuarioInexistenteException exception) {
            JOptionPane.showMessageDialog(janelaEntrar, exception.getMessage());
        }
    }
}
