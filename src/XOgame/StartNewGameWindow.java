package XOgame;

import javax.swing.*;
import java.awt.*;

public class StartNewGameWindow extends JFrame {
    private final GameWindow gameWindow;

    private static final int WINDOW_POS_X;
    private static final int WINDOW_POS_Y;
    private static final int WINDOW_HEIGHT;
    private static final int WINDOW_WIDTH;
    private static int MIN_WIN_LINE;
    private static int MIN_FIELD_SIZE;
    private static int MAX_FIELD_SIZE;

    private JRadioButton jrbHumVsAi;
    private JRadioButton jrbHumVsHum;
    private ButtonGroup gameMode;

    private JSlider slFieldSize;
    private JSlider slWinLine;

    private static final String STR_FIELD_SIZE = "Размер игрового поля: ";
    private static final String STR_WIN_LENGTH = "Победная линия до: ";

    static {
        WINDOW_POS_X = 1350;
        WINDOW_POS_Y = 250;
        WINDOW_HEIGHT = 455;
        WINDOW_WIDTH = 407;

        MIN_WIN_LINE = 3;
        MIN_FIELD_SIZE = 3;
        MAX_FIELD_SIZE = 10;
    }

    public StartNewGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setTitle("Настройка сложности");
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setLayout(new GridLayout(10, 1));
        setResizable(false);

        //радиобаттоны, группа кнопок и описание
        jrbHumVsAi = new JRadioButton("Человек VS Компьютер", true);
        jrbHumVsHum = new JRadioButton("Человек VS Человек");
        gameMode = new ButtonGroup();
        gameMode.add(jrbHumVsAi);
        gameMode.add(jrbHumVsHum);
        // добавление радиобаттонов на окно
        add(new JLabel("Выбор режима игры: "));
        add(jrbHumVsAi);
        add(jrbHumVsHum);

        // слайдеры
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinLine = new JSlider(MIN_WIN_LINE, MIN_WIN_LINE, MIN_WIN_LINE);

        //метки на слайдере игровое поле
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setPaintTicks(true);

        //метки на слайдере победная линия
        slWinLine.setMajorTickSpacing(1);
        slWinLine.setPaintLabels(true);
        slWinLine.setPaintTicks(true);

        //надписи над слайдером поля
        add(new JLabel("Игровое поле!"));
        JLabel jlFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(jlFieldSize);
        add(slFieldSize);

        //надписи на слайдере победная линия
        JLabel jlWinLength = new JLabel(STR_WIN_LENGTH + MIN_WIN_LINE);
        add(new JLabel("Победная линия!"));
        add(jlWinLength);
        add(slWinLine);
        //получение знач. длинны поля и ограничение побед линии
        slFieldSize.addChangeListener(e -> {
            int currentFieldSize = slFieldSize.getValue();
            jlFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
            slWinLine.setMaximum(currentFieldSize);
        });
        // получаем значение побед линии
        slWinLine.addChangeListener(e -> {
            jlWinLength.setText(STR_WIN_LENGTH + slWinLine.getValue());
        });

        JButton jbStartNewGame = new JButton("Начать игру?");
        add(jbStartNewGame);
        // действия при нажатии кнопки в настройках
        jbStartNewGame.addActionListener(e -> {
            int gameMode;
            if (jrbHumVsAi.isSelected()) {
                gameMode = BattleMap.H_Vs_A;
            } else gameMode = BattleMap.H_Vs_H;

            int fieldSize = slFieldSize.getValue();
            int winLength = slWinLine.getValue();
            // начало новой игры
            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = winLength;
            Logic.initMap();
            Logic.gameOver = false;

            gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);
            setVisible(false);
        });

        setVisible(false);
    }
}
