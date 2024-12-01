import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DragApp extends JFrame {
    public DragApp() {
        setTitle("블록 생성 및 드래그 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') {
                    createBlock(c);
                }
            }
        });

        c.setFocusable(true);
        c.requestFocus();

        setSize(400, 400);
        setVisible(true);
    }

    private void createBlock(Container c) {
        Random random = new Random();
        JLabel block = new JLabel();
        block.setOpaque(true);
        block.setBackground(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        block.setBounds(100 + random.nextInt(200), 100 + random.nextInt(200), 80, 80);

        block.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                block.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                block.setCursor(Cursor.getDefaultCursor());
            }
        });

        block.addMouseMotionListener(new MouseMotionAdapter() {
            private Point prevPt;

            @Override
            public void mouseDragged(MouseEvent e) {
                if (prevPt == null) {
                    prevPt = e.getPoint();
                }
                Point currentPt = e.getPoint();
                int dx = currentPt.x - prevPt.x;
                int dy = currentPt.y - prevPt.y;
                block.setLocation(block.getX() + dx, block.getY() + dy);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                prevPt = null;
            }
        });

        c.add(block);
        c.revalidate();
        c.repaint();
    }

    public static void main(String[] args) {
        new DragApp();
    }
}
