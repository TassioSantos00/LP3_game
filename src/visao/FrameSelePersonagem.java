package visao;

import javax.swing.JFrame;

public class FrameSelePersonagem extends JFrame {

    TelaSelePersonagem telaSelePersonagem;

    public FrameSelePersonagem() {

        super("Seleção de Personagem");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 400);
        this.setLocationRelativeTo(null);

        this.getTelaSelePersonagem();

        this.repaint();
    }

    public TelaSelePersonagem getTelaSelePersonagem() {
        if (telaSelePersonagem == null) {
            telaSelePersonagem = new TelaSelePersonagem();
            this.add(telaSelePersonagem);
        }
        return telaSelePersonagem;
    }

}
