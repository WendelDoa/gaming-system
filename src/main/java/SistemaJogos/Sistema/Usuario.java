package SistemaJogos.Sistema;

import java.io.Serializable;
import java.util.*;

public class Usuario implements Serializable {//Torna o objeto serializável, para salvar...

    private String nome;
    private String matricula;
    private Map<Integer, Jogo> jogosFavoritos;

    public Usuario(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.jogosFavoritos = new LinkedHashMap<>();//Linked mantém a ordem de inserção do Map
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

    public Map<Integer, Jogo> getJogosFavoritos() {
        return jogosFavoritos;
    }

    public void adicionarJogoFavorito(Jogo jogo) {
        jogosFavoritos.put(jogo.getId(), jogo);
    }

    public void removerJogoFavorito(Jogo jogo) {
        jogosFavoritos.remove(jogo.getId(), jogo);
    }
}
