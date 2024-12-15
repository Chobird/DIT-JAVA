import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Openchallenge13 extends JFrame {
    private JPanel gameArea = new GamePanel("A", "X", 'x', 150);

    public Openchallenge13() {
        setTitle("Monster Chase Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(gameArea);
        setSize(350, 350);
        setVisible(true);
        gameArea.setFocusable(true);
        gameArea.requestFocus();
    }

    class GamePanel extends JPanel {
        private String playerChar;
        private String monsterChar;
        private char exitKey;
        private long monsterSpeed;
        private JLabel player;
        private JLabel monster;
        private final int MOVE_UNIT = 10;

        public GamePanel(String playerChar, String monsterChar, char exitKey, long monsterSpeed) {
            this.playerChar = playerChar;
            this.monsterChar = monsterChar;
            this.exitKey = exitKey;
            this.monsterSpeed = monsterSpeed;

            player = new JLabel(playerChar);
            monster = new JLabel(monsterChar);

            setLayout(null);
            addKeyListener(new PlayerKeyListener());

            player.setLocation(40, 40);
            player.setSize(20, 20);
            player.setForeground(Color.BLUE);
            add(player);

            monster.setLocation(220, 20);
            monster.setSize(20, 20);
            monster.setForeground(Color.RED);
            add(monster);

            MonsterChaseThread chaseThread = new MonsterChaseThread(monster, player, monsterSpeed);
            chaseThread.start();

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    requestFocus();
                }
            });
        }

        class PlayerKeyListener extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == exitKey) {
                    System.exit(0);
                }

                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        player.setLocation(player.getX(), player.getY() - MOVE_UNIT);
                        break;
                    case KeyEvent.VK_DOWN:
                        player.setLocation(player.getX(), player.getY() + MOVE_UNIT);
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setLocation(player.getX() - MOVE_UNIT, player.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setLocation(player.getX() + MOVE_UNIT, player.getY());
                        break;
                }
                player.getParent().repaint();
            }
        }
    }

    class MonsterChaseThread extends Thread {
        private JLabel chaser;
        private JLabel target;
        private long delay;
        private final int STEP = 5;

        public MonsterChaseThread(JLabel chaser, JLabel target, long delay) {
            this.chaser = chaser;
            this.target = target;
            this.delay = delay;
        }

        @Override
        public void run() {
            while (true) {
                int x = chaser.getX();
                int y = chaser.getY();

                if (target.getX() < chaser.getX())
                    x -= STEP;
                else
                    x += STEP;

                if (target.getY() < chaser.getY())
                    y -= STEP;
                else
                    y += STEP;

                chaser.setLocation(x, y);
                chaser.getParent().repaint();

                try {
                    sleep(delay);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Openchallenge13();
    }
}
