import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    private JFrame frame = new JFrame("Grid of Buttons");
    private JPanel mainPanel = new JPanel();
    private JLabel dialogue = new JLabel("Welcome!!!");
    private JPanel buttonPanel = new JPanel();
    private JButton[] buttons = new JButton[9];
    private JButton newGame = new JButton("New Game");
    private String[] xOx = {"X", "O"};

    public TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        mainPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(3, 3, 5, 5));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton("-");
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
        }

        dialogue.setHorizontalAlignment(SwingConstants.CENTER);
        dialogue.setBackground(Color.GRAY);
        dialogue.setFont(new Font("Arial", Font.BOLD, 20));

        newGame.setEnabled(false);
        ActionListener forNewGame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                firstPlayer();
                for (JButton button : buttons) {
                    button.setText("-");
                    button.setEnabled(true);
                }
            }
        };

        newGame.addActionListener(forNewGame);

        mainPanel.add(dialogue, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(newGame, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        firstPlayer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                markField(buttons[i]);
                buttons[i].setEnabled(false);
                switchPlayer();
                checkWin(buttons[i].getText());
                checkDraw();
            }

        }
    }

    public void firstPlayer () {
        int rand = (int) (Math.random() * xOx.length);
        dialogue.setText(xOx[rand] + " Plays");
    }
    public void switchPlayer() {
        if (dialogue.getText().equals("X Plays")) {
            dialogue.setText("O Plays");
        }
        else if (dialogue.getText().equals("O Plays")) {
            dialogue.setText("X Plays");
        }
    }
    public void markField(JButton button) {
        if (dialogue.getText().equals("X Plays")) {
            button.setText("X");
        }
        else if (dialogue.getText().equals("O Plays")) {
            button.setText("O");
        }
    }
    public void checkWin (String str) {
        if (buttons[0].getText().equals(str)
                && buttons[1].getText().equals(str)
                && buttons[2].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            newGame.setEnabled(true);
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[0].getText().equals(str)
                && buttons[3].getText().equals(str)
                && buttons[6].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[0].getText().equals(str)
                && buttons[4].getText().equals(str)
                && buttons[8].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[1].getText().equals(str)
                && buttons[4].getText().equals(str)
                && buttons[7].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[2].getText().equals(str)
                && buttons[5].getText().equals(str)
                && buttons[8].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[3].getText().equals(str)
                && buttons[4].getText().equals(str)
                && buttons[5].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[2].getText().equals(str)
                && buttons[4].getText().equals(str)
                && buttons[6].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
        if (buttons[6].getText().equals(str)
                && buttons[7].getText().equals(str)
                && buttons[8].getText().equals(str)) {
            dialogue.setText(str + " Player wins");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
                newGame.setEnabled(true);
            }
        }
    }
    public void checkDraw() {
        int buttonsClicked = 0;
        for (JButton button : buttons) {
            if (button.getText().equals("X") || button.getText().equals("O")) {
                buttonsClicked++;
            }
        }
        if (buttonsClicked == 9
                && (dialogue.getText().equals("X Plays")
                || dialogue.getText().equals("O Plays"))) {
            dialogue.setText("It's a draw");
            for (JButton button : buttons) {
                button.setEnabled(false);
                newGame.setEnabled(true);
            }
        }

    }
}