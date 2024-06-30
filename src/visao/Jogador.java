package visao;

//mport java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Jogador extends JLabel {

    private String spriteParado;
    private String spriteAndarF;
    private String spriteAndarB;
    private String spritePulo;
    private String spriteSoco;
    private String spriteChute;
    private String spriteDefender;
    private String spriteHit;
    private String spriteAgachar;
    private String spriteKO;
    private String spriteVitoria;

    public Jogador(String nome, String player) {

        spriteParado = "src/imagens/" + player + "/" + nome + "/Parado/" + nome + "Parado_" + player + ".gif";
        spriteAndarF = "src/imagens/" + player + "/" + nome + "/AndandoFrente/" + nome + "Andando_" + player + ".gif";
        spriteAndarB = "src/imagens/" + player + "/" + nome + "/AndandoParaTrás/" + nome + "ParaTras_" + player
                + ".gif";
        spritePulo = "src/imagens/" + player + "/" + nome + "/Pulo/" + nome + "Pulo_" + player + ".gif";
        spriteSoco = "src/imagens/" + player + "/" + nome + "/Soco/" + nome + "SocoMedium_" + player + ".gif";
        spriteChute = "src/imagens/" + player + "/" + nome + "/Chute/" + nome + "ChuteLow_" + player + ".gif";
        spriteDefender = "src/imagens/" + player + "/" + nome + "/Defender/" + nome + "Defender_" + player + ".gif";
        spriteHit = "src/imagens/" + player + "/" + nome + "/Hit/" + nome + "Hit_" + player + ".gif";
        spriteAgachar = "src/imagens/" + player + "/" + nome + "/Agachar/" + nome + "Agachar_" + player + ".gif";
        spriteKO = "src/imagens/" + player + "/" + nome + "/K.O/" + nome + "KO_" + player + ".gif";
        spriteVitoria = "src/imagens/" + player + "/" + nome + "/Vitória/" + nome + "Vitoria_" + player + ".gif";

    }

    public void parado() {
        this.setIcon(new ImageIcon(spriteParado));
    }

    public void andarF() {
        this.setIcon(new ImageIcon(spriteAndarF));
    }

    public void andarB() {
        this.setIcon(new ImageIcon(spriteAndarB));
    }

    public void pulo() {
        this.setIcon(new ImageIcon(spritePulo));
    }

    public void soco() {
        this.setIcon(new ImageIcon(spriteSoco));
    }

    public void chute() {
        this.setIcon(new ImageIcon(spriteChute));
    }

    public void defender() {
        this.setIcon(new ImageIcon(spriteDefender));
    }

    public void hit() {
        this.setIcon(new ImageIcon(spriteHit));
    }

    public void agachar() {
        this.setIcon(new ImageIcon(spriteAgachar));
    }

    public void ko() {
        this.setIcon(new ImageIcon(spriteKO));
    }

    public void vitoria() {
        this.setIcon(new ImageIcon(spriteVitoria));
    }

    // --------------------------------------------

    public String getSpriteParado() {
        return spriteParado;
    }

    public String getSpriteAndarF() {
        return spriteAndarF;
    }

    public String getSpriteAndarB() {
        return spriteAndarB;
    }

    public String getSpritePulo() {
        return spritePulo;
    }

    public String getSpriteSoco() {
        return spriteSoco;
    }

    public String getSpriteChute() {
        return spriteChute;
    }

    public String getSpriteDefender() {
        return spriteDefender;
    }

    public String getSpriteHit() {
        return spriteHit;
    }

    public String getSpriteAgachar() {
        return spriteAgachar;
    }

    public String getSpriteKO() {
        return spriteKO;
    }

    public String getSpriteVitoria() {
        return spriteVitoria;
    }

}
