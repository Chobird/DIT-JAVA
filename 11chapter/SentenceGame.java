import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.Vector;

public class SentenceGame extends JFrame {
    private Vector<String> words;
    private String sentence = "You are the dancing queen";
    private JPanel centerPanel;
    private JLabel resultLabel;
    private int currentWordIndex = 0;

    public SentenceGame() {
        setTitle("문장 완성 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel northPanel = new JPanel();
        JLabel instructions = new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~");
        JButton newTextButton = new JButton("New Text");
        newTextButton.addActionListener(e -> initializeGame());
        northPanel.add(instructions);
        northPanel.add(newTextButton);
        add(northPanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.WHITE);
        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        resultLabel = new JLabel(">>");
        southPanel.add(resultLabel);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
        initializeGame();
    }

    private void initializeGame() {
        centerPanel.removeAll();
        currentWordIndex = 0;
        resultLabel.setText(">>");

        words = new Vector<>();
        String[] wordArray = sentence.split(" ");
        Collections.addAll(words, wordArray);
        Collections.shuffle(words);

        for (String word : words) {
            JLabel wordLabel = new JLabel(word);
            wordLabel.setBounds(
                    50 + (int) (Math.random() * 400),
                    50 + (int) (Math.random() * 200),
                    word.length() * 10 + 20,
                    30
            );
            wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
            wordLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    handleWordClick(wordLabel);
                }
            });
            centerPanel.add(wordLabel);
        }

        centerPanel.revalidate();
        centerPanel.repaint();
    }

    private void handleWordClick(JLabel wordLabel) {
        String clickedWord = wordLabel.getText();
        if (clickedWord.equals(sentence.split(" ")[currentWordIndex])) {
            wordLabel.setEnabled(false);
            wordLabel.setForeground(Color.LIGHT_GRAY);
            currentWordIndex++;
            updateResultLabel();
        }
    }

    private void updateResultLabel() {
        StringBuilder completedSentence = new StringBuilder(">> ");
        for (int i = 0; i < currentWordIndex; i++) {
            completedSentence.append(sentence.split(" ")[i]).append(" ");
        }
        resultLabel.setText(completedSentence.toString().trim());

        if (currentWordIndex == sentence.split(" ").length) {
            resultLabel.setText(resultLabel.getText() + " >> 성공!");
        }
    }

    public static void main(String[] args) {
        new SentenceGame();
    }
}
