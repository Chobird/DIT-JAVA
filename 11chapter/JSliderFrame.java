import java.awt.*;
import javax.swing.*;

public class JSliderFrame extends JFrame {
    private JSlider slider = new JSlider(100, 200, 150);
    private JLabel label = new JLabel("        ");

    public JSliderFrame() {
        super("JSlider Practice Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(slider);
        c.add(label);

        slider.setMajorTickSpacing(20);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setOpaque(true);
        label.setBackground(Color.GREEN);
        label.setText(Integer.toString(slider.getValue()));

        slider.addChangeListener(e -> {
            JSlider s = (JSlider) e.getSource();
            label.setText(Integer.toString(s.getValue()));
        });

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JSliderFrame();
    }
}
