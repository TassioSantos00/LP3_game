package visao;

import javax.swing.*;

import controle.Controlador;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaLuta extends JPanel {

    BufferedImage imagemFundo;

    public TelaLuta() {

        this.setVisible(true);
        this.setSize(1000, 400);
        this.setLayout(null);

        try {
            this.imagemFundo = ImageIO.read(new File("src//imagens/ufc.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.add(Controlador.getLifeBar1());
        this.add(Controlador.getLifeBar2());

        this.add(Controlador.getPlay1());
        this.add(Controlador.getPlay2());

        this.repaint();
    }

    // método para colocar a imagem de fundo
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagemFundo.getScaledInstance(1000, 400, 0), 0, 0, null);
    }
}
