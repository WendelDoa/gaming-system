package SistemaJogos.Sistema;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ConfirmacaoSaidaWindowAdapter extends WindowAdapter {

    public void windowClosing(WindowEvent event) {
        int respota = JOptionPane.showConfirmDialog(null, "Tem certeza que dejsa sair?\nTodas as " +
                "alterações serão perdidas!!!","Confirmar saída?", JOptionPane.YES_NO_OPTION);
        if(respota == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
