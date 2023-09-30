package SistemaJogos.Sistema;

import java.util.Objects;

public class Jogo {

    private int id;
    private String nome;
    private Genero genero;
    private int ano;
    private boolean ehPago;

    public Jogo(int id, String nome, Genero genero, int ano, boolean ehPago) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.ano = ano;
        this.ehPago = ehPago;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isEhPago() {
        return ehPago;
    }

    public void setEhPago(boolean ehPago) {
        this.ehPago = ehPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return ano == jogo.ano && ehPago == jogo.ehPago && Objects.equals(id, jogo.id) && Objects.equals(nome, jogo.nome) && genero == jogo.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, genero, ano, ehPago);
    }
}
