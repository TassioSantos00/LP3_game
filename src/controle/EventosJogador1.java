package controle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class EventosJogador1 extends Thread {

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
                                        if (Controlador.getPlay1().getLocation().x > 0) {
                                                andarB();
                                        }

                                } else if (getDirecaoMovimento()[2]) {
                                        Controlador.getPlay1().agachar();
                                        direcaoMovimento[2] = false;
                                        setDirecaoMovimento(direcaoMovimento);

                                } else if (getDirecaoMovimento()[3]) {
                                        if (Controlador.getPlay1().getLocation().x < 860 && Controlador.getPlay1()
                                                        .getLocation().x < (Controlador.getPlay2().getLocation().x
                                                                        - (Controlador.getPlay2().getWidth() / 2))) {
                                                andarF();
                                        }

                                } else if (getDirecaoMovimento()[4]) {
                                        soco();
                                        direcaoMovimento[4] = false;
                                        setDirecaoMovimento(direcaoMovimento);
                                } else if (getDirecaoMovimento()[5]) {
                                        direcaoMovimento[6] = false;
                                        chute();
                                        direcaoMovimento[5] = false;
                                        setDirecaoMovimento(direcaoMovimento);
                                } else if (getDirecaoMovimento()[6]) {
                                        Controlador.getPlay1().defender();
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

                Controlador.getPlay1().andarF();

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x + 5,
                                Controlador.getPlay1().getLocation().y);

        }

        // Método para o personagem andar para trás
        public void andarB() {

                Controlador.getPlay1().andarB();

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x - 5,
                                Controlador.getPlay1().getLocation().y);

        }

        // Método para o personagem pular
        public void pular() {

                Controlador.getPlay1().pulo();

                // sobe
                float vlc = 0; // velocidade

                for (int i = 0; i < 15; i++) {
                        try {
                                vlc += -(2 * 0.33333333333333);
                                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x,
                                                Math.round(Controlador.getPlay1().getLocation().y + vlc));
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
                                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x,
                                                Math.round(Controlador.getPlay1().getLocation().y + vlc));
                                Thread.sleep(10);
                        } catch (Exception e) {
                                // TODO: handle exception
                        }
                }

                Controlador.getPlay1().parado();
        }

        // Método para o personagem dar um soco
        public void soco() {

                EventosJogador2 eventosJogador2 = new EventosJogador2();

                Controlador.getPlay1().soco();

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x + 2,
                                Controlador.getPlay1().getLocation().y);

                // Se o jogador 2 não estiver defendendo
                if (eventosJogador2.getDirecaoMovimento()[6] == false) {
                        colision_check(Controlador.getPlay1(), Controlador.getPlay2(),
                                        Controlador.getPersonagemUm().getSoco());
                }

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x - 2,
                                Controlador.getPlay1().getLocation().y);
        }

        // Método para o personagem dar um chute
        public void chute() {

                EventosJogador2 eventosJogador2 = new EventosJogador2();

                Controlador.getPlay1().chute();

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x + 2,
                                Controlador.getPlay1().getLocation().y);

                // Se o jogador 2 não estiver defendendo
                if (eventosJogador2.getDirecaoMovimento()[6] == false) {
                        colision_check(Controlador.getPlay1(), Controlador.getPlay2(),
                                        Controlador.getPersonagemUm().getChute());

                }

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x - 2,
                                Controlador.getPlay1().getLocation().y);
        }

        // Método para quando o personagem sofrer dano
        public void hit() {

                Controlador.getPlay1().hit();

                Controlador.getPlay1().setLocation(Controlador.getPlay1().getLocation().x - 2,
                                Controlador.getPlay1().getLocation().y);
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
                        Controlador.getLifeBar2().setSize(Controlador.getLifeBar2().getWidth() - dano,
                                        Controlador.getLifeBar2().getHeight());

                        Controlador.getPlay2().hit();

                        if (Controlador.getLifeBar2().getWidth() <= 0) {
                                Controlador.getPlay2().ko();
                                JOptionPane.showMessageDialog(null, "Jogador 1 venceu!");
                                Controlador.resetaJogo();
                        }
                }

                return true;
        }

}