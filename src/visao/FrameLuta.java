package visao;

import javax.swing.JFrame;

import controle.KeyInput;

public class FrameLuta extends JFrame {

    TelaLuta telaLuta;
    KeyInput keyInput = new KeyInput();

    public FrameLuta() {

        super("Luta");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 400);
        this.setLocationRelativeTo(null);

        this.getTelaLuta();

        this.addKeyListener(keyInput);
        keyInput.runThreads();

        this.repaint();
    }

    public TelaLuta getTelaLuta() {
        if (telaLuta == null) {
            telaLuta = new TelaLuta();
            this.add(telaLuta);
        }
        return telaLuta;
    }

}
