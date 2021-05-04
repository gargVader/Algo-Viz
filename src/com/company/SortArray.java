package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.company.Constants.*;
import static com.company.Utils.*;

/**
 * Canvas where the sortable array is drawn
 */
public class SortArray extends JPanel {

    // Stores bar values
    private int[] array;
    // Stores bar color values
    private int[] barColor;

    private Graphics2D graphics;

    // Constructor
    SortArray(boolean isDNF) {
        graphics = (Graphics2D) getGraphics();
        array = new int[NUM_BARS];
        barColor = new int[NUM_BARS];


        for (int i = 0; i < NUM_BARS; i++) {
            array[i] = i + 1;
            barColor[i] = 0;
        }

        if (isDNF) {
//            Map<Integer, Integer> freq = new HashMap();
            int x = NUM_BARS / 3;
            int curr = 0;
            for (int i = 0; i < NUM_BARS; i++) {
                int y = curr / x;
                if (y == 0) array[i] = DNF_VAL_0;
                else if (y == 1) array[i] = DNF_VAL_1;
                else array[i] = DNF_VAL_2;
                curr++;
//                freq.put(array[i], (freq.get(array[i]))+1);
            }

//            System.out.println(freq.get(array[DNF_VAL_0]));
//            System.out.println(freq.get(array[DNF_VAL_1]));
//            System.out.println(freq.get(array[DNF_VAL_2]));

        }


        shuffleArray(array);

        setBackground(BACKGROUND_COLOR);
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        super.paintComponent(g);

        for (int i = 0; i < NUM_BARS; i++) {
            int height = getHeight(i);
            int x_cord = getXCord(i);
            int y_cord = getYCord(i);
            Color c = getColor(i);

            graphics2D.setColor(c);
            graphics2D.fillRect(x_cord, y_cord, BAR_WIDTH, height);

            if (barColor[i] > 0) barColor[i] -= 10;

        }

    }

    private int getXCord(int idx) {
        return idx + (BAR_WIDTH - 1) * idx;
    }

    private int getYCord(int idx) {
        return WIN_HEIGHT - getHeight(idx);
    }

    private int getHeight(int idx) {
        return array[idx] * 2;
    }

    private Color getColor(int idx) {
        int val = barColor[idx] * 2;
        return new Color(255, 255 - val, 255 - val);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(WIN_WIDTH, WIN_HEIGHT);
    }

    public int getLength() {
        return array.length;
    }

    public int getVal(int idx) {
        return array[idx];
    }

    public void setVal(int idx, int val, int milliseconds) {
        array[idx] = val;
        barColor[idx] = 100;
        sleepFor(milliseconds);
        repaint();
    }

    public void swap(int idx1, int idx2, int milliseconds) {
        int temp = array[idx1];
        array[idx1] = array[idx2];
        array[idx2] = temp;

        barColor[idx1] = 100;
        barColor[idx2] = 100;

        repaint();
        sleepFor(milliseconds);
    }

    public void print() {
        for (int x : array) {
            System.out.println(x + " ");
        }
        System.out.println("\n");
    }


}
