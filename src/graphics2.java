import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.lang.model.util.ElementScanner6;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Rectangle;

public class graphics2 extends JPanel {
    public int i;

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (i = 1; i < 50; i++) {
            g2.drawRoundRect(100, 50, 100, 100, 500, 75);
            g2.rotate(2, 120, 120);
            if (i % 2 == 0)
                g2.setColor(Color.BLACK);
            else if (i % 3 == 0)
                g2.setColor(Color.blue);
            else if (i % 5 == 0)
                g2.setColor(Color.GREEN);
            else if (i % 7 == 0)
                g2.setColor(Color.red);

        }

    }

}
