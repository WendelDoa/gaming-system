package SistemaJogos;

import java.util.ArrayList;
import java.util.Collection;

public class Usuario {

    private String nome;
    private String matricula;
    private Collection<Jogo> jogosFavoritos;

    public Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.jogosFavoritos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Collection<Jogo> getJogosFavoritos() {
        return jogosFavoritos;
    }

    public void adicionarJogoFavorito(Jogo jogo) {
        jogosFavoritos.add(jogo);
    }

    public void removerJogoFavorito(Jogo jogo) {
        jogosFavoritos.remove(jogo);
    }
}
