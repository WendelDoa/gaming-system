package SistemaJogos.Sistema;

import java.io.Serializable;
import java.util.Objects;

public class Jogo implements Serializable {//Torna o objeto serializável, para salvar...

    private int id;
    private String nome;
    private Genero genero;
    private String ano;
    private boolean ehGratuito;

    public Jogo(int id, String nome, Genero genero, String ano, boolean ehGratuito) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.ehGratuito = ehGratuito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean getEhGratuito() {
        return ehGratuito;
    }

    public void setEhGratuito(boolean ehGratuito) {
        this.ehGratuito = ehGratuito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return ano == jogo.ano && ehGratuito == jogo.ehGratuito && Objects.equals(id, jogo.id) && Objects.equals(nome, jogo.nome) && genero == jogo.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, genero, ano, ehGratuito);
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", genero=" + genero +
                ", ano='" + ano + '\'' +
                ", ehGratuito=" + ehGratuito +
                '}';
    }
}
