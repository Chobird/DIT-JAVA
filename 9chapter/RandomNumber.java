import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomNumber extends JFrame {
    public RandomNumber() {
        setTitle("랜덤 번호 출력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // WEST 영역: GridLayout으로 10개의 버튼 배치
        JPanel westPanel = new JPanel(new GridLayout(10, 1));
        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(new NumberButtonListener(i));
            westPanel.add(button);
        }
        add(westPanel, BorderLayout.WEST);

        // CENTER 영역: 랜덤 번호를 JLabel로 출력
        JPanel centerPanel = new JPanel(null);
        centerPanel.setBackground(Color.WHITE);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // ActionListener 클래스
    private class NumberButtonListener implements ActionListener {
        private final int number;

        public NumberButtonListener(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Random random = new Random();
            int x = 50 + random.nextInt(151); // X 좌표: 50 ~ 200
            int y = 50 + random.nextInt(151); // Y 좌표: 50 ~ 200

            JLabel label = new JLabel(String.valueOf(number));
            label.setBounds(x, y, 20, 20); // 위치와 크기 설정

            JPanel centerPanel = (JPanel) getContentPane().getComponent(1); // CENTER 영역
            centerPanel.add(label);
            centerPanel.revalidate();
            centerPanel.repaint();
        }
    }

    public static void main(String[] args) {
        new RandomNumber();
    }
}
