package controle;

import visao.FrameInicial;
import visao.FrameLuta;
import visao.FrameSelePersonagem;
import visao.Jogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import modelo.Personagem;

public class Controlador implements ActionListener {

    public static FrameInicial frameInicial;
    public static FrameLuta frameLuta;
    public static FrameSelePersonagem frameSelePersonagem;
    private static Jogador play1;
    private static Jogador play2;
    private static Personagem personagemUm;
    private static Personagem personagemDois;
    private static BufferedImage lifeBarIcon;
    private static JLabel lifeBar1;
    private static JLabel lifeBar2;
    private static int clique = 0;

    public Controlador() {

        frameInicial = new FrameInicial();

        frameInicial.getTelaInicial().getBotaoJogar().addActionListener(this);
        frameInicial.getTelaInicial().getBotaoSair().addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frameInicial.getTelaInicial().getBotaoJogar()) {
            frameSelePersonagem = new FrameSelePersonagem();

            // Jogador seleciona o personagem Ryu
            frameSelePersonagem.getTelaSelePersonagem().getBotaoRyu().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (clique == 0) {
                        personagemUm = new Personagem(300, 20, 30, "Ryu");
                    } else {
                        personagemDois = new Personagem(300, 20, 30, "Ryu");
                        frameLuta = new FrameLuta();
                        // frameLuta.addKeyListener(keyInput);
                    }
                    clique++;
                }
            });

            // Jogador seleciona o personagem Blanka
            frameSelePersonagem.getTelaSelePersonagem().getBotaoBlanka().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (clique == 0) {
                        personagemUm = new Personagem(300, 20, 30, "Blanka");
                    } else {
                        personagemDois = new Personagem(300, 20, 30, "Blanka");
                        frameLuta = new FrameLuta();
                        // frameLuta.addKeyListener(keyInput);
                    }
                    clique++;
                }
            });

            // Jogador seleciona o personagem Zangief
            frameSelePersonagem.getTelaSelePersonagem().getBotaoZangief().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (clique == 0) {
                        personagemUm = new Personagem(300, 20, 30, "Zangief");
                    } else {
                        personagemDois = new Personagem(300, 20, 30, "Zangief");
                        frameLuta = new FrameLuta();
                        // frameLuta.addKeyListener(keyInput);
                    }
                    clique++;
                }
            });

        } else if (e.getSource() == frameInicial.getTelaInicial().getBotaoSair()) {
            // Encerra o progrma ao apertar o botão sair
            frameInicial.dispatchEvent(new WindowEvent(frameInicial, WindowEvent.WINDOW_CLOSING));
        }
    }

    public static BufferedImage getLifeBarIcon() {
        if (lifeBarIcon == null) {
            lifeBarIcon = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            try {
                lifeBarIcon = ImageIO.read(new File("src//imagens/LifeBarIcon.png"));
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return lifeBarIcon;
    }

    public static JLabel getLifeBar1() {
        if (lifeBar1 == null) {
            lifeBar1 = new JLabel();
            lifeBar1.setVisible(true);
            lifeBar1.setIcon(new ImageIcon(getLifeBarIcon()));
            lifeBar1.setBounds(0, 5, getPersonagemUm().getVida(), 40);
        }
        return lifeBar1;
    }

    public static void setLifeBar1(JLabel lifeBar1) {
        Controlador.lifeBar1 = lifeBar1;
    }

    public static JLabel getLifeBar2() {
        if (lifeBar2 == null) {
            lifeBar2 = new JLabel();
            lifeBar2.setVisible(true);
            lifeBar2.setIcon(new ImageIcon(getLifeBarIcon()));
            lifeBar2.setBounds(690, 5, getPersonagemDois().getVida(), 40);
        }
        return lifeBar2;
    }

    public static void setLifeBar2(JLabel lifeBar2) {
        Controlador.lifeBar2 = lifeBar2;
    }

    public static Jogador getPlay1() {
        if (play1 == null) {
            play1 = new Jogador(personagemUm.getNome(), "P1");
            play1.parado();
            play1.setBounds(0, 210, 170, 170);
        }
        return play1;
    }

    public static void setPlay1(Jogador play1) {
        Controlador.play1 = play1;
    }

    public static Jogador getPlay2() {
        if (play2 == null) {
            play2 = new Jogador(personagemDois.getNome(), "P2");
            play2.parado();
            play2.setBounds(860, 210, 170, 170);
        }
        return play2;
    }

    public static void setPlay2(Jogador play2) {
        Controlador.play2 = play2;
    }

    public static Personagem getPersonagemUm() {
        return personagemUm;
    }

    public static Personagem getPersonagemDois() {
        return personagemDois;
    }

    public static void setClique(int clique) {
        Controlador.clique = clique;
    }

    public static void resetaJogo() {
        frameInicial.dispose();
        frameSelePersonagem.dispose();
        frameLuta.dispose();
        Controlador.setClique(0);
        Controlador.setPlay1(null);
        Controlador.setPlay2(null);
        Controlador.setLifeBar1(null);
        Controlador.setLifeBar2(null);
        Controlador controlador = new Controlador();
    }

    public static void main(String[] args) {
        new Controlador();
    }
}
