package mirea;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Panel extends JPanel {
    private static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    private BufferedImage image;
    private Graphics2D g;

    private Back back = new Back();
    private Wreath wreath = new Wreath();

    public Panel() {
        super();
        setFocusable(true);
        requestFocus();

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();
        Timer timer = new Timer(30, e -> {
            gameRender();
            gameDraw();
        });
        timer.start();
    }

    private void gameRender() {
        back.draw(g);
        wreath.draw(g);
    }

    private void gameDraw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image,0,0,null);
        g2.dispose();
    }

}
