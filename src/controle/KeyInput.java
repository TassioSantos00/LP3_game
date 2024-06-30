package controle;

import java.awt.event.*;

public class KeyInput implements KeyListener {

    private EventosJogador1 eventosJogador1;
    private EventosJogador2 eventosJogador2;

    /*
     * 0 = Pulo
     * 1 = Andar para trás
     * 2 = Agachar
     * 3 = Andar para frente
     * 4 = Soco
     * 5 = Chute
     * 6 = Defender
     */
    private boolean[] direcaoMovimentoPlayer01 = {
            false,
            false,
            false,
            false,
            false,
            false,
            false
    };

    private boolean[] direcaoMovimentoPlayer02 = {
            false,
            false,
            false,
            false,
            false,
            false,
            false
    };

    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        switch (e.getKeyCode()) {
            // Jogador 1
            case KeyEvent.VK_W:
                direcaoMovimentoPlayer01[0] = false;
                // eventosJogador1.getDirecaoMovimento()[0] = false;
                break;
            case KeyEvent.VK_A:
                direcaoMovimentoPlayer01[1] = false;
                // eventosJogador1.getDirecaoMovimento()[1] = false;
                Controlador.getPlay1().parado();
                break;
            case KeyEvent.VK_S:
                direcaoMovimentoPlayer01[2] = false;
                // eventosJogador1.getDirecaoMovimento()[2] = false;
                break;
            case KeyEvent.VK_D:
                direcaoMovimentoPlayer01[3] = false;
                // eventosJogador1.getDirecaoMovimento()[3] = false;
                Controlador.getPlay1().parado();
                break;
            case KeyEvent.VK_E:
                direcaoMovimentoPlayer01[4] = true;
                // eventosJogador1.getDirecaoMovimento()[4] = true;
                break;
            case KeyEvent.VK_F:
                direcaoMovimentoPlayer01[5] = true;
                // eventosJogador1.getDirecaoMovimento()[5] = true;
                break;
            case KeyEvent.VK_Q:
                direcaoMovimentoPlayer01[6] = false;
                // eventosJogador1.getDirecaoMovimento()[6] = false;
                Controlador.getPlay1().parado();
                break;

            // Jogador 2
            case KeyEvent.VK_UP:
                direcaoMovimentoPlayer02[0] = false;
                // eventosJogador2.getDirecaoMovimento()[0] = false;
                break;
            case KeyEvent.VK_LEFT:
                direcaoMovimentoPlayer02[1] = false;
                // eventosJogador2.getDirecaoMovimento()[1] = false;
                Controlador.getPlay2().parado();
                break;
            case KeyEvent.VK_DOWN:
                direcaoMovimentoPlayer02[2] = false;
                // eventosJogador2.getDirecaoMovimento()[2] = false;
                break;
            case KeyEvent.VK_RIGHT:
                direcaoMovimentoPlayer02[3] = false;
                // eventosJogador2.getDirecaoMovimento()[3] = false;
                Controlador.getPlay2().parado();
                break;
            case KeyEvent.VK_NUMPAD1:
                direcaoMovimentoPlayer02[4] = true;
                // eventosJogador2.getDirecaoMovimento()[4] = true;
                break;
            case KeyEvent.VK_NUMPAD2:
                direcaoMovimentoPlayer02[5] = true;
                // eventosJogador2.getDirecaoMovimento()[5] = true;
                break;
            case KeyEvent.VK_NUMPAD0:
                direcaoMovimentoPlayer02[6] = false;
                // eventosJogador2.getDirecaoMovimento()[6] = false;
                Controlador.getPlay2().parado();
                break;

            default:
                break;
        }

        getEventosJogador1().setDirecaoMovimento(direcaoMovimentoPlayer01);
        getEventosJogador2().setDirecaoMovimento(direcaoMovimentoPlayer02);

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            // Jogador 1
            case KeyEvent.VK_W:
                direcaoMovimentoPlayer01[0] = true;
                // eventosJogador1.getDirecaoMovimento()[0] = true;
                break;
            case KeyEvent.VK_A:
                direcaoMovimentoPlayer01[1] = true;
                // eventosJogador1.getDirecaoMovimento()[1] = true;
                break;
            case KeyEvent.VK_S:
                direcaoMovimentoPlayer01[2] = true;
                // eventosJogador1.getDirecaoMovimento()[2] = true;
                break;
            case KeyEvent.VK_D:
                direcaoMovimentoPlayer01[3] = true;
                // eventosJogador1.getDirecaoMovimento()[3] = true;
                break;
            case KeyEvent.VK_Q:
                direcaoMovimentoPlayer01[6] = true;
                // eventosJogador1.getDirecaoMovimento()[6] = true;
                break;

            // Jogador 2
            case KeyEvent.VK_UP:
                direcaoMovimentoPlayer02[0] = true;
                // eventosJogador2.getDirecaoMovimento()[0] = true;
                break;
            case KeyEvent.VK_RIGHT:
                direcaoMovimentoPlayer02[1] = true;
                // eventosJogador2.getDirecaoMovimento()[1] = true;
                break;
            case KeyEvent.VK_DOWN:
                direcaoMovimentoPlayer02[2] = true;
                // eventosJogador2.getDirecaoMovimento()[2] = true;
                break;
            case KeyEvent.VK_LEFT:
                direcaoMovimentoPlayer02[3] = true;
                // eventosJogador2.getDirecaoMovimento()[3] = true;
                break;
            case KeyEvent.VK_NUMPAD0:
                direcaoMovimentoPlayer02[6] = true;
                // eventosJogador2.getDirecaoMovimento()[6] = true;
                break;

            default:
                break;

        }

        getEventosJogador1().setDirecaoMovimento(direcaoMovimentoPlayer01);
        getEventosJogador2().setDirecaoMovimento(direcaoMovimentoPlayer02);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public EventosJogador1 getEventosJogador1() {
        if (eventosJogador1 == null) {
            eventosJogador1 = new EventosJogador1();
        }
        return eventosJogador1;
    }

    public void setEventosJogador1(EventosJogador1 eventosJogador1) {
        this.eventosJogador1 = eventosJogador1;
    }

    public EventosJogador2 getEventosJogador2() {
        if (eventosJogador2 == null) {
            eventosJogador2 = new EventosJogador2();
        }
        return eventosJogador2;
    }

    public void setEventosJogador2(EventosJogador2 eventosJogador2) {
        this.eventosJogador2 = eventosJogador2;
    }

    public void runThreads() {

        synchronized (this) {
            getEventosJogador1().start();
            getEventosJogador2().start();
        }

    }

}
