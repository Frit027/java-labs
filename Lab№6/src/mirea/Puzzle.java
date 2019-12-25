package mirea;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.util.Random;

public class Puzzle extends JFrame {
    private String more = "Число меньше";
    private String smaller = "Число больше";
    private String win = "Вы отгадали число!";
    private String lose = "Вы проиграли...";
    private String warning = "Некорректные данные";
    private JLabel label = new JLabel("<html>Добро пожаловать!<br />Угадайте число из диапозона [0;20]</html>");
    private JTextField textField = new JTextField(15);
    private JButton button = new JButton("Угадать");
    private int number;
    private int attempts;

    public Puzzle() {
        super("Puzzle");
        setBounds(500, 200, 400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Random random = new Random(System.currentTimeMillis());
        number = random.nextInt(21);
        attempts = 3;
        System.out.println(number);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        label.setBounds(100, 20, 200, 80);
        label.setFont(new Font("Impact", Font.PLAIN, 20));
        label.setForeground(Color.GREEN);

        button.setBounds(100, 180, 200, 40);
        button.setFont(new Font("Impact", Font.PLAIN, 18));
        button.addActionListener(e -> checkGame());

        textField.setBounds(100, 120, 200, 20);
        textField.setFont(new Font("Century", Font.PLAIN, 15));
        textField.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (getLength() < 11) {
                    super.insertString(offs, str, a);
                }
            }
        });

        panel.add(label);
        panel.add(button);
        panel.add(textField);
        setContentPane(panel);
    }

    private boolean checkNumber(String str) {
        if (str.lastIndexOf('-') > 0)
            return false;

        for (char c : str.toCharArray())
            if ((c < '0' || c > '9') && (c != '-'))
                return false;
        return true;
    }

    private void checkGame() {
        String text = textField.getText();

        if (checkNumber(text)) {
            if (text.equals(Integer.toString(number))) {
                label.setText(win);
                button.setEnabled(false);
            } else {
                attempts--;
                if (attempts == 0) {
                    button.setEnabled(false);
                    label.setText(lose);
                } else {
                    if (Long.parseLong(text) < number)
                        label.setText(smaller);
                    else
                        label.setText(more);
                }
            }
        } else {
            label.setText(warning);
        }
    }
}
