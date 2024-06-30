package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaSelePersonagem extends JPanel {

    BufferedImage imagemFundo;
    JButton botaoRyu;
    JButton botaoBlanka;
    JButton botaoZangief;
    JLabel labelTitulo;

    public TelaSelePersonagem() {

        this.setVisible(true);
        this.setSize(1000, 400);
        this.setLayout(null);

        try {
            this.imagemFundo = ImageIO.read(new File("src//imagens/ufc.jpg"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.getLabelTitulo();

        this.getBotaoRyu();
        this.getBotaoBlanka();
        this.getBotaoZangief();
    }

    // método para colocar a imagem de fundo
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imagemFundo.getScaledInstance(1000, 400, 0), 0, 0, null);
    }

    public JButton getBotaoRyu() {
        if (botaoRyu == null) {
            botaoRyu = new JButton("Ryu");
            botaoRyu.setVisible(true);
            botaoRyu.setBounds(200, 200, 90, 100);
            botaoRyu.setVerticalTextPosition(SwingConstants.BOTTOM);
            botaoRyu.setHorizontalTextPosition(SwingConstants.CENTER);
            botaoRyu.setRolloverSelectedIcon(null);
            botaoRyu.setFocusPainted(false);
            botaoRyu.setRolloverEnabled(false);
            // Caminho do ícone
            String iconPath = "src/imagens/P1/Ryu/Parado/RyuParado01_P1.png";

            // Carregar o ícone do arquivo especificado
            try {
                File file = new File(iconPath);
                if (file.exists()) {
                    ImageIcon icon = new ImageIcon(ImageIO.read(file));
                    Image scaledImage = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                    botaoRyu.setIcon(new ImageIcon(scaledImage));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.add(botaoRyu);
        }
        return botaoRyu;
    }

    public JButton getBotaoBlanka() {
        if (botaoBlanka == null) {
            botaoBlanka = new JButton("Blanka");
            botaoBlanka.setVisible(true);
            botaoBlanka.setBounds(450, 200, 90, 100);
            botaoBlanka.setVerticalTextPosition(SwingConstants.BOTTOM);
            botaoBlanka.setHorizontalTextPosition(SwingConstants.CENTER);
            botaoBlanka.setRolloverSelectedIcon(null);
            botaoBlanka.setFocusPainted(false);
            botaoBlanka.setRolloverEnabled(false);
            // Caminho do ícone
            String iconPath = "src/imagens/P1/Blanka/Parado/BlankaParado01_P1.png";

            // Carregar o ícone do arquivo especificado
            try {
                File file = new File(iconPath);
                if (file.exists()) {
                    ImageIcon icon = new ImageIcon(ImageIO.read(file));
                    Image scaledImage = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                    botaoBlanka.setIcon(new ImageIcon(scaledImage));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.add(botaoBlanka);
        }
        return botaoBlanka;
    }

    public JButton getBotaoZangief() {
        if (botaoZangief == null) {
            botaoZangief = new JButton("Zangief");
            botaoZangief.setVisible(true);
            botaoZangief.setBounds(700, 200, 90, 100);
            botaoZangief.setVerticalTextPosition(SwingConstants.BOTTOM);
            botaoZangief.setHorizontalTextPosition(SwingConstants.CENTER);
            botaoZangief.setRolloverSelectedIcon(null);
            botaoZangief.setFocusPainted(false);
            botaoZangief.setRolloverEnabled(false);
            // Caminho do ícone
            String iconPath = "src/imagens/P2/Zangief/Parado/ZangiefParado01_P2.png";

            // Carregar o ícone do arquivo especificado
            try {
                File file = new File(iconPath);
                if (file.exists()) {
                    ImageIcon icon = new ImageIcon(ImageIO.read(file));
                    Image scaledImage = icon.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                    botaoZangief.setIcon(new ImageIcon(scaledImage));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.add(botaoZangief);
        }
        return botaoZangief;
    }

    public JLabel getLabelTitulo() {
        if (labelTitulo == null) {
            labelTitulo = new JLabel("SELECIONE OS PERSONAGENS");
            labelTitulo.setVisible(true);
            labelTitulo.setBounds(250, 50, 550, 100);
            labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
            labelTitulo.setForeground(Color.WHITE);
            this.add(labelTitulo);
        }
        return labelTitulo;
    }

}
