package XOgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {

    public static int H_Vs_A = 0;
    public static int H_Vs_H = 1;

    int fieldSizeX;
    int fieldSizeY;
    int winLength;

    int cellWidth;
    int cellHeight;

    boolean isInitialized = false;

    public BattleMap() {
        setBackground(Color.gray);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {
        if (isInitialized == false) {
            return;
        }
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        //горизонтальные линии поля
        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeight;
            Graphics2D graphics2D = (Graphics2D)g;
            BasicStroke pen1 = new BasicStroke(5);
            graphics2D.setStroke(pen1);
            g.drawLine(0, y, panelWidth, y);

        }
        //вертикальные линии поля
        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            Graphics2D graphics2D = (Graphics2D)g;
            BasicStroke pen1 = new BasicStroke(5);
            graphics2D.setStroke(pen1);
            g.drawLine(x, 0, x, panelHeight);
        }
        //рисование крестиков и ноликов
        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g,j,i);
                }
                if(Logic.map[i][j] == Logic.DOT_O){
                    drawO(g,j,i);
                }
            }
        }
    }

    public void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        System.out.printf("mode %d fieldSize %d fieldSizeY %d winLength %d\n" +
                "", mode, fieldSizeX, fieldSizeY, winLength);

        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLength = winLength;

        isInitialized = true;
        repaint();
    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

//        System.out.println(cellX+" "+cellY);

        if (!Logic.gameOver) {
            Logic.setHumanYX(cellX, cellY);
        }
//        System.out.println(Logic.winnerGame);
        repaint();
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        Graphics2D graphics2D = (Graphics2D)g;
        BasicStroke pen1 = new BasicStroke(5);
        graphics2D.setStroke(pen1);
        g.setColor(new Color(24, 113, 255));
        g.drawLine(cellX * cellWidth, cellY * cellHeight, (cellX+1)*cellWidth, (cellY+1)*cellHeight);
        g.drawLine(cellX * cellWidth, (cellY+1) * cellHeight, (cellX+1)*cellWidth, cellY*cellHeight);
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        Graphics2D graphics2D = (Graphics2D)g;
        BasicStroke pen1 = new BasicStroke(5);
        graphics2D.setStroke(pen1);
        g.setColor(new Color(5, 255, 21));
        g.drawOval(cellX * cellWidth, cellY * cellHeight, cellWidth, cellHeight);
    }
}
