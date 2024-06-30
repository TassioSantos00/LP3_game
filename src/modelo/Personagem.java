package modelo;

public class Personagem {

    private int vida;
    private int soco;
    private int chute;
    private String nome;

    public Personagem(int vida, int soco, int chute, String nome) {
        this.vida = vida;
        this.soco = soco;
        this.chute = chute;
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getSoco() {
        return soco;
    }

    public void setSoco(int soco) {
        this.soco = soco;
    }

    public int getChute() {
        return chute;
    }

    public void setChute(int chute) {
        this.chute = chute;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}