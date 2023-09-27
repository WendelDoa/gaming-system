package SistemaJogos;

import SistemaJogos.Exceptions.*;

import java.util.*;

public class SistemaJogos {

    private Map<Integer, Jogo> jogos;
    private Map<String, Usuario> usuarios;
    private int idContador = 1;

    public SistemaJogos() {
        this.jogos = new HashMap<>();
        this.usuarios = new HashMap<>();
    }

    public void cadastrarJogo(int idContador, String nome, Genero genero, int ano, boolean ehGratuito)
            throws jogoJaExisteException {
        if (jogos.containsKey(idContador)) {
            throw new jogoJaExisteException("Jogo já existe!");
        }
        Jogo jogo = new Jogo(idContador, nome, genero, ano, ehGratuito);
        jogos.put(idContador, jogo);
        idContador++;
    }

    public void cadastrarUsuario(String nome, String matricula) throws usuarioJaExisteException {
        if (usuarios.containsKey(matricula)) {
            throw new usuarioJaExisteException("Usuário já cadastrado");
        }
        Usuario usuario = new Usuario(nome, matricula);
        usuarios.put(matricula, usuario);
    }

    public void adicionarJogoFavoritoDoUsuario(int idJogo, String matriculaUsuario)
            throws jogoInexistenteException, jogoJaAdicionadoException {
        if (!jogos.containsKey(idJogo)) {
            throw new jogoInexistenteException("O id passado, não corresponde a nenhum jogo!");
        }
        Jogo jogoFavorito = null;
        for (Jogo jogo : jogos.values()) {
            if (jogo.getId() == idJogo) {
                jogoFavorito = jogo;
            }
        }
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getMatricula().equals(matriculaUsuario)) {
                if (usuario.getJogosFavoritos().contains(jogoFavorito)) {
                    throw new jogoJaAdicionadoException("O jogo já está cadastrado neste usuário");
                } else {
                    usuario.adicionarJogoFavorito(jogoFavorito);
                }
            }
        }
    }

    public void removerJogoFavoritoDoUsuario(int idJogo, String matriculaUsuario)
            throws jogoInexistenteException, jogoNaoAtribuidoException {
        if (!jogos.containsKey(idJogo)) {
            throw new jogoInexistenteException("O id passado, não corresponde a nenhum jogo!");
        }
        Jogo jogoFavorito = null;
        for (Jogo jogo : jogos.values()) {
            if (jogo.getId() == idJogo) {
                jogoFavorito = jogo;
            }
        }
        for (Usuario usuario : usuarios.values()) {
            if (usuario.getMatricula().equals(matriculaUsuario)) {
                if(!usuario.getJogosFavoritos().contains(jogoFavorito)) {
                    throw new jogoNaoAtribuidoException("O jogo não está atribuido ao usuário!");
                } else {
                    usuario.removerJogoFavorito(jogoFavorito);
                }
            }
        }
    }
}