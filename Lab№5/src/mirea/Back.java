package mirea;

import javax.swing.*;
import java.awt.*;

public class Back {
    private Image img = new ImageIcon("images/space.jpg").getImage();

    public void draw(Graphics2D g) {
        g.drawImage(img, 0, 0, null);
    }
}
