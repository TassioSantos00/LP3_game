package visao;

import javax.swing.JFrame;

public class FrameInicial extends JFrame {

    TelaInicial telaInicial;

    public FrameInicial() {

        super("Jogo de Luta");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);

        this.getTelaInicial();

        this.repaint();
    }

    public TelaInicial getTelaInicial() {
        if (telaInicial == null) {
            telaInicial = new TelaInicial();
            this.add(telaInicial);
        }
        return telaInicial;
    }

}
