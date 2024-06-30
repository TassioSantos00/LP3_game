package visao;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaInicial extends JPanel {

    BufferedImage imagemFundo;
    JButton botaoJogar;
    JButton botaoSair;

    public TelaInicial() {

        this.setVisible(true);
        this.setSize(1000, 700);
        this.setLayout(null);

        try {
            this.imagemFundo = ImageIO.read(new File("src//imagens/sf.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.getBotaoJogar();
        this.getBotaoSair();

    }

    // método para colocar a imagem de fundo
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagemFundo.getScaledInstance(1000, 700, 0), 0, 0, null);
    }

    public JButton getBotaoJogar() {

        if (botaoJogar == null) {
            botaoJogar = new JButton("JOGAR");
            botaoJogar.setVisible(true);
            botaoJogar.setBounds(420, 400, 150, 30);
            this.add(botaoJogar);
        }
        return botaoJogar;
    }

    public JButton getBotaoSair() {

        if (botaoSair == null) {
            botaoSair = new JButton("SAIR");
            botaoSair.setVisible(true);
            botaoSair.setBounds(420, 450, 150, 30);
            this.add(botaoSair);
        }
        return botaoSair;
    }

}
