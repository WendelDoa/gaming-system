package SistemaJogos.Controllers;

import SistemaJogos.Exceptions.UsuarioInexistenteException;
import SistemaJogos.GUI.DeletarUsuarioGUI;
import SistemaJogos.Sistema.ConfirmacaoSaidaWindowAdapter;
import SistemaJogos.Sistema.SistemaJogos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletarUsuarioController implements ActionListener {

    private SistemaJogos sistema;
    private JFrame janelaDeletarUsuario;

    public DeletarUsuarioController(SistemaJogos sistema, JFrame janelaDeletarUsuario) {
        this.sistema = sistema;
        this.janelaDeletarUsuario = janelaDeletarUsuario;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String matricula = (DeletarUsuarioGUI.getMatricula());
            String nomeUsuario = sistema.buscarUsuario(matricula).getNome();
            sistema.deletarUsuario(matricula);
            JOptionPane.showMessageDialog(janelaDeletarUsuario,"Usuário " + nomeUsuario + " deletado com sucesso!");
        } catch (UsuarioInexistenteException e) {
            JOptionPane.showMessageDialog(janelaDeletarUsuario,"Usuário não encontrado!");
        }
    }
}
