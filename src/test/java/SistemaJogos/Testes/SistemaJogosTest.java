package SistemaJogos.Testes;

import SistemaJogos.Exceptions.*;
import SistemaJogos.Persistencia.GravadorDeDados;
import SistemaJogos.Sistema.SistemaJogos;
import org.junit.jupiter.api.Test;

import java.io.File;

import static SistemaJogos.Sistema.Genero.ACAO;
import static org.junit.jupiter.api.Assertions.*;

public class SistemaJogosTest {

    @Test
    public void testaCadastro() throws UsuarioJaExisteException, JogoJaAtribuidoException,
            JogoInexistenteException, JogoNaoAtribuidoException, UsuarioInexistenteException {
        SistemaJogos sistema = new SistemaJogos();
        assertEquals(0, sistema.buscaTodosOsJogos().size());
        sistema.cadastrarUsuario("Wendel", "200000");
        sistema.cadastrarJogo("Jogo1", ACAO, "2001", true);
        assertTrue(sistema.buscaTodosOsJogos().containsKey(1));
        sistema.adicionarJogoFavoritoDoUsuario(1,"200000");
        sistema.removerJogoFavoritoDoUsuario(1, "200000");
        assertTrue(sistema.meusJogosFavoritos("200000").isEmpty());
        sistema.deletarJogo(1);
        sistema.deletarUsuario("200000");
    }

    @Test
    public void testaGravacao() throws UsuarioJaExisteException {
        File f = new File(GravadorDeDados.ARQUIVOS_JOGOS);
        if (f.exists()) {
            f.delete();
        }
        SistemaJogos sistema = new SistemaJogos();
        sistema.salvarDados();
        assertTrue(f.exists());
        f.delete();
    }
}
