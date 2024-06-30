package controle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EventosJogador2 extends Thread {

        /*
         * 0 = Pulo
         * 1 = Andar para trás
         * 2 = Agachar
         * 3 = Andar para frente
         * 4 = Soco
         * 5 = Chute
         * 6 = Defender
         */
        private boolean[] direcaoMovimento = {
                        false,
                        false,
                        false,
                        false,
                        false,
                        false,
                        false
        };

        public boolean[] getDirecaoMovimento() {
                return direcaoMovimento;
        }

        public void setDirecaoMovimento(boolean[] direcaoMovimento) {
                this.direcaoMovimento = direcaoMovimento;
        }

        @Override
        public void run() {

                try {
                        while (true) {
                                if (getDirecaoMovimento()[0]) {
                                        pular();
                                        direcaoMovimento[0] = false;
                                        setDirecaoMovimento(direcaoMovimento);

                                } else if (getDirecaoMovimento()[1]) {
                                        if (Controlador.getPlay2().getLocation().x < 860) {
                                                direcaoMovimento[6] = false;
                                                andarB();
                                        }

                                } else if (getDirecaoMovimento()[2]) {
                                        Controlador.getPlay2().agachar();
                                        direcaoMovimento[2] = false;
                                        setDirecaoMovimento(direcaoMovimento);

                                } else if (getDirecaoMovimento()[3]) {
                                        if (Controlador.getPlay2().getLocation().x > 0 && Controlador.getPlay2()
                                                        .getLocation().x > (Controlador.getPlay1().getLocation().x
                                                                        + (Controlador.getPlay1().getWidth() / 2))) {
                                                andarF();
                                        }

                                } else if (getDirecaoMovimento()[4]) {
                                        soco();
                                        direcaoMovimento[4] = false;
                                        setDirecaoMovimento(direcaoMovimento);
                                } else if (getDirecaoMovimento()[5]) {
                                        chute();
                                        direcaoMovimento[5] = false;
                                        setDirecaoMovimento(direcaoMovimento);
                                } else if (getDirecaoMovimento()[6]) {
                                        Controlador.getPlay2().defender();
                                        /*
                                         * direcaoMovimento[6] = false;
                                         * setDirecaoMovimento(direcaoMovimento);
                                         */
                                }

                                Thread.sleep(30);
                        }
                } catch (Exception e) {
                        // TODO: handle exception
                }

        }

        // Método para o personagem andar para frente
        public void andarF() {

                Controlador.getPlay2().andarF();

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x - 5,
                                Controlador.getPlay2().getLocation().y);

        }

        // Método para o personagem andar para trás
        public void andarB() {

                Controlador.getPlay2().andarB();

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x + 5,
                                Controlador.getPlay2().getLocation().y);

        }

        // Método para o personagem pular
        public void pular() {

                Controlador.getPlay2().pulo();

                // sobe
                float vlc = 0; // velocidade

                for (int i = 0; i < 15; i++) {
                        try {
                                vlc += -(2 * 0.33333333333333);
                                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x,
                                                Math.round(Controlador.getPlay2().getLocation().y + vlc));
                                Thread.sleep(10);
                        } catch (Exception e) {
                                // TODO: handle exception
                        }
                }

                // desce
                vlc = 0;

                for (int i = 0; i < 15; i++) {
                        try {
                                vlc += (2 * 0.33333333333333);
                                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x,
                                                Math.round(Controlador.getPlay2().getLocation().y + vlc));
                                Thread.sleep(10);
                        } catch (Exception e) {
                                // TODO: handle exception
                        }
                }

                Controlador.getPlay2().parado();
        }

        // Método para o personagem dar um soco
        public void soco() {

                EventosJogador1 eventosJogador1 = new EventosJogador1();

                Controlador.getPlay2().soco();

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x - 1,
                                Controlador.getPlay2().getLocation().y);

                // Se o jogador 1 não estiver defendendo
                if (eventosJogador1.getDirecaoMovimento()[6] == false) {
                        colision_check(Controlador.getPlay2(), Controlador.getPlay1(),
                                        Controlador.getPersonagemDois().getSoco());
                }

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x + 1,
                                Controlador.getPlay2().getLocation().y);
        }

        // Método para o personagem dar um chute
        public void chute() {

                EventosJogador1 eventosJogador1 = new EventosJogador1();

                Controlador.getPlay2().chute();

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x - 1,
                                Controlador.getPlay2().getLocation().y);

                // Se o jogador 1 não estiver defendendo
                if (eventosJogador1.getDirecaoMovimento()[6] == false) {
                        colision_check(Controlador.getPlay2(), Controlador.getPlay1(),
                                        Controlador.getPersonagemDois().getChute());
                }

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x + 1,
                                Controlador.getPlay2().getLocation().y);

        }

        // Método para quando o personagem sofrer dano
        public void hit() {

                Controlador.getPlay2().hit();

                Controlador.getPlay2().setLocation(Controlador.getPlay2().getLocation().x + 2,
                                Controlador.getPlay2().getLocation().y);
        }

        // Método para checar a colisão
        public boolean colision_check(JLabel LA, JLabel LB, int dano) {

                // coleta as informações do primeiro jogador
                int label_A_x = LA.getX();
                int label_A_y = LA.getY();
                int label_A_h = LA.getHeight();
                int label_A_w = LA.getWidth();

                // coleta as informações do segundo jogador
                int label_B_x = LB.getX();
                int label_B_y = LB.getY();
                int label_B_h = LB.getHeight();
                int label_B_w = LB.getWidth();

                // realiza as verificações para ver se houve colisão
                if (label_A_x < label_B_x + label_B_w &&
                                label_A_x + label_A_w > label_B_x &&
                                label_A_y < label_B_y + label_B_h &&
                                label_A_y + label_A_h > label_B_y) {

                        // reduz a vida do adversário
                        Controlador.getLifeBar1().setSize(Controlador.getLifeBar1().getWidth() - dano,
                                        Controlador.getLifeBar1().getHeight());

                        Controlador.getPlay1().hit();

                        if (Controlador.getLifeBar1().getWidth() <= 0) {
                                Controlador.getPlay1().ko();
                                JOptionPane.showMessageDialog(null, "Jogador 2 venceu!");
                                Controlador.resetaJogo();
                        }
                }

                return true;
        }

}
