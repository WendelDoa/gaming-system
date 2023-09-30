package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.UsuarioInexistenteException;
import SistemaJogos.GUI.DeletarUsuarioGUI;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletarUsuarioController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaPrincipalDeletarUsuario;

    public DeletarUsuarioController(SistemaJogos sistema, JFrame janelaPrincipalDeletarUsuario) {
        this.sistema = sistema;
        this.janelaPrincipalDeletarUsuario = janelaPrincipalDeletarUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            sistema.deletarUsuario(DeletarUsuarioGUI.getMatricula());
            JOptionPane.showMessageDialog(janelaPrincipalDeletarUsuario,"Usuário deletado com sucesso!");
        } catch (UsuarioInexistenteException e) {
            JOptionPane.showMessageDialog(janelaPrincipalDeletarUsuario,"Usuário não encontrado!");
        }
    }
}
