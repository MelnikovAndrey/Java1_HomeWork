package XOgame;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_POS_X;
    private static final int WINDOW_POS_Y;
    private static final int WINDOW_HEIGHT;
    private static final int WINDOW_WIDTH;

    static {
        WINDOW_POS_X = 1300;
        WINDOW_POS_Y = 200;
        WINDOW_HEIGHT = 555;
        WINDOW_WIDTH = 507;
    }

    StartNewGameWindow startNewGameWindow;
    BattleMap battleField;

    public GameWindow() {
        setTitle("Игра Крестики-Нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(1, 2));
        JButton btnNewGame = new JButton("Новая игра!");
        panel.add(btnNewGame);
        JButton btnExit = new JButton("Выход!");
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);

        startNewGameWindow = new StartNewGameWindow(this);
        battleField = new BattleMap();

        add(battleField, BorderLayout.CENTER);

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        btnNewGame.addActionListener(e -> {
            startNewGameWindow.setVisible(true);
        });

        setVisible(true);
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
//        System.out.printf("mode %d fieldSize %d fieldSizeY %d winLength %d\n" +
//                "", mode, fieldSizeX, fieldSizeY, winLength);
        battleField.startNewGame(mode, fieldSizeX, fieldSizeY, winLength);
    }
}
