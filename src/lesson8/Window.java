package lesson8;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Window extends JFrame {

    private final ImageIcon imageX = new ImageIcon("src/lesson8/x.jpg");
    private final ImageIcon imageO = new ImageIcon("src/lesson8/o.jpg");
    private final ImageIcon imageEmpty = new ImageIcon("src/lesson8/empty.jpg");
    public static Random rand = new Random();
    public static char[][] map = new char[3][3];
    int xC = -1;
    int yC = -1;

    public Window(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(500, 400);
        setSize(300, 300);
        setResizable(false);
        JPanel panel = new JPanel(new GridLayout(3, 3));
        JButton[][] buttons = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setIcon(imageEmpty);
                JButton copy = buttons[i][j];
                panel.add(buttons[i][j]);
                copy.addActionListener(action -> {
                    JButton selectedBtn = (JButton) action.getSource();
                    for (int row = 0; row < buttons.length; row++) {
                        for (int col = 0; col < buttons[row].length; col++) {
                            if (buttons[row][col] == selectedBtn) {
                                xC = row;
                                yC = col;
                            }
                        }
                    }
                    copy.setIcon(imageX);
                    System.out.println("X = " + xC + "Y = " + yC);
                    copy.setEnabled(false);
                    copy.setDisabledIcon(imageX);
                    if(checkWin(3,'H', xC, yC)){
                        endGame("Победил человек");
                        return;
                    } else if(isMapFull(buttons)){
                        endGame("Ничья");
                        return;
                    } else {
                        movePC(buttons, copy);
                    }
                });
            }
        }
        add(panel);
        setVisible(true);
    }


    private void movePC(JButton[][] buttons, JButton copy) {
        if(isMapFull(buttons)){
            endGame("Ничья");
        }
        int x;
        int y;
        do{
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (!isValidCoordinates(x, y, buttons));
        buttons[x][y].setIcon(imageO);
        buttons[x][y].setEnabled(false);
        buttons[x][y].setDisabledIcon(imageO);
        if(checkWin(3,'C', x, y)){
            endGame("Победил компьютер");
        }
    }

    private static boolean isMapFull(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(buttons[i][j].isEnabled()){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidCoordinates(int x, int y, JButton[][] buttons) {
        if(x < 0 || x >= 3 || y < 0 || y >= 3){
            return false;
        }
        return buttons[x][y].isEnabled();
    }

    private void endGame(String title){
        JFrame alert = new JFrame(title);
        map = new char[3][3];
        alert.setLocation(500, 400);
        alert.setSize(300, 100);
        JPanel alertPanel = new JPanel(new FlowLayout());
        JButton newGame = new JButton("new game");
        newGame.addActionListener(a -> {
            this.dispose();
            new Window();
            alert.dispose();
        });
        JButton close = new JButton("close");
        close.addActionListener(a -> {
            dispose();
            alert.dispose();
        });
        alertPanel.add(newGame);
        alertPanel.add(close);
        alert.add(alertPanel);
        alert.setResizable(false);
        alert.setVisible(true);
    }

    private static boolean checkWin(int size, char whoseMove, int x, int y) {
        int countRow = 0;
        int countColumn = 0;
        int countFirstDiagonal = 0;
        int countSecondDiagonal = 0;
        map[x][y] = whoseMove;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == whoseMove){
                    countRow++;
                }
                if(map[j][i] == whoseMove){
                    countColumn++;
                }
            }

            if(countRow == size){
                return true;
            } else {
                countRow = 0;
            }

            if(countColumn == size){
                return true;
            } else {
                countColumn = 0;
            }

            if(map[i][i] == whoseMove){
                countFirstDiagonal++;
            }

            if(map[size - 1 - i][i] == whoseMove){
                countSecondDiagonal++;
            }
        }
        if(countFirstDiagonal == size){
            return true;
        }
        if(countSecondDiagonal == size){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        new Window();
    }
}
