import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;

public class Example {
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(() -> {
            CustomSliderConfig customSliderConfig = new CustomSliderConfig();
            customSliderConfig.color = Color.ORANGE;
            CustomSliderConfig customSliderConfig2 = new CustomSliderConfig();
            customSliderConfig2.color = Color.BLUE;
            JPanel content = new JPanel(new GridBagLayout());
            content.setPreferredSize(new Dimension(500, 100));
            JSlider slider = new JSlider() {
                @Override
                public void updateUI() {
                    setUI(new CustomSliderUI(this, customSliderConfig));
                }
            };
            JSlider slider2 = new JSlider() {
                @Override
                public void updateUI() {
                    setUI(new CustomSliderUI(this, customSliderConfig2));
                }
            };
            content.add(slider);
            content.add(slider2);

            JFrame frame = new JFrame();
            frame.setContentPane(content);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
