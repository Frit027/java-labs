package mirea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Wreath {
    private int iAnim;
    private String str;
    private ArrayList<String> list = new ArrayList<>();

    public Wreath(){
        iAnim = 0;
        timer.start();

        for(int i = 0; i <= 15; i++)
            list.add("images/" + i + ".png");
    }

    private Timer timer = new Timer(30, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(iAnim >= list.size()) {
                iAnim = 0;
                timer.start();
            }

            str = list.get(iAnim);
            iAnim++;
        }
    });

    public void draw(Graphics2D g) {
        g.drawImage(new ImageIcon(str).getImage(), 130, 100, null);
    }
}
