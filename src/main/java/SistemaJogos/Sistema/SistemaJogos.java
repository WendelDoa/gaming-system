package SistemaJogos.Sistema;

import SistemaJogos.Exceptions.*;
import SistemaJogos.Persistencia.GravadorDeDados;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class SistemaJogos {

    private Map<Integer, Jogo> jogos;
    private Map<String, Usuario> usuarios;
    private int idContador = 1;
    private GravadorDeDados gravador = new GravadorDeDados();

    public SistemaJogos() {
        this.jogos = new HashMap<>();
        this.usuarios = new HashMap<>();
        recuperaDados();
    }

    public void recuperaDados() {
        try {
            this.usuarios = this.gravador.recuperarUsuarios();
            this.jogos = this.gravador.recuperarJogos();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void salvarDados() {
        try {
            this.gravador.salvarUsuarios(this.usuarios);
            this.gravador.salvarJogos(this.jogos);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public void cadastrarJogo(String nome, Genero genero, String ano, boolean ehGratuito) {
        Jogo jogo = new Jogo(idContador, nome, genero, ano, ehGratuito);
        jogos.put(idContador, jogo);
        idContador++;
    }

    public void cadastrarUsuario(String nome, String matricula) throws UsuarioJaExisteException {
        for(Usuario usuario : usuarios.values()) {
            if(usuario.getMatricula().equals(matricula)){
                throw new UsuarioJaExisteException("Usuário já cadastrado");
            }
        }
        Usuario usuario = new Usuario(nome, matricula);
        usuarios.put(matricula, usuario);
    }

    public void adicionarJogoFavoritoDoUsuario(int idJogo, String matriculaUsuario)
            throws JogoInexistenteException, JogoJaAtribuidoException {
        if (!jogos.containsKey(idJogo)) {
            throw new JogoInexistenteException("Nenhum jogo corresponde ao id digitado!");
        }
        Jogo jogoFavorito = null;
        for (Jogo jogo : jogos.values()) {
            if (jogo.getId() == idJogo) {
                jogoFavorito = jogo;
            }
        }
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getMatricula().equals(matriculaUsuario)) {
                if (usuario.getJogosFavoritos().containsValue(jogoFavorito)) {
                    throw new JogoJaAtribuidoException("O jogo já está cadastrado neste usuário");
                } else {
                    usuario.adicionarJogoFavorito(jogoFavorito);
                }
            }
        }
    }

    public void removerJogoFavoritoDoUsuario(int idJogo, String matriculaUsuario)
            throws JogoInexistenteException, JogoNaoAtribuidoException {
        if (!jogos.containsKey(idJogo)) {
            throw new JogoInexistenteException("Nenhum jogo corresponde ao id digitado!");
        }
        Jogo jogoFavorito = null;
        for (Jogo jogo : jogos.values()) {
            if (jogo.getId() == idJogo) {
                jogoFavorito = jogo;
            }
        }
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getMatricula().equals(matriculaUsuario)) {
                if(!usuario.getJogosFavoritos().containsValue(jogoFavorito)) {
                    throw new JogoNaoAtribuidoException("O jogo não está atribuido ao usuário!");
                } else {
                    usuario.removerJogoFavorito(jogoFavorito);
                }
            }
        }
    }

    public void deletarUsuario(String matricula)
            throws UsuarioInexistenteException {
        if(!usuarios.containsKey(matricula)) {
            throw new UsuarioInexistenteException("Usuário não encontrado!");
        } else {
           usuarios.remove(matricula);
        }
    }

    public void deletarJogo(int idJogo) throws JogoInexistenteException {
        if(!jogos.containsKey(idJogo)) {
            throw new JogoInexistenteException("Nenhum jogo corresponde ao id digitado!");
        } else {
            jogos.remove(idJogo);
            idContador--;
            for (Jogo jogo : jogos.values()) {
                if(jogo.getId() > idJogo) {
                    jogo.setId(jogo.getId()-1);
                }
            }
            Map<Integer, Jogo> jogosAtualizados = new HashMap<>();

            //Para testes
            for (Jogo jogo : jogos.values()) {
                jogosAtualizados.put(jogo.getId(), jogo);
            }
            jogos = jogosAtualizados;

            for(Usuario usuario : this.usuarios.values()) {
                usuario.getJogosFavoritos().remove(idJogo);
            }
        }
    }

    public Map<Integer, Jogo> meusJogosFavoritos(String matricula) {
        for(Usuario usuario : usuarios.values()) {
            if(usuario.getMatricula().equals(matricula)) {
                return usuario.getJogosFavoritos();
            }
        }
        return null;
    }

    public Usuario buscarUsuario(String matricula) throws UsuarioInexistenteException {
        for (Usuario usuario : usuarios.values()) {
            if(usuario.getMatricula().equals(matricula))
                return usuario;
        }
        throw new UsuarioInexistenteException("Usuário não encontrado!");
    }

    public Map<Integer, Jogo> buscaTodosOsJogos() {
        return jogos;
    }

    public Jogo buscarJogo(int idJogo) throws JogoInexistenteException {
        if(jogos.get(idJogo) != null) {
            return jogos.get(idJogo);
        } else {
            throw new JogoInexistenteException("Nenhum jogo corresponde ao id digitado!");
        }
    }
}