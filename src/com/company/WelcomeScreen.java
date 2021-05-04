package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.Constants.*;

public class WelcomeScreen {
    private JButton selectionSortButton;
    private JButton bubbleSortButton;
    private JButton quickSortButton;
    private JButton insertionSortButton;
    public JPanel panelMain;
    private JButton dnfSortButton;

    public WelcomeScreen() {

        Main main = new Main();
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.runVisualizer(SELECTION_SORT);
            }
        });
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.runVisualizer(BUBBLE_SORT);
            }
        });

        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.runVisualizer(QUICK_SORT);
            }
        });

        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.runVisualizer(INSERTION_SORT);
            }
        });

        dnfSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.runVisualizer(DNF_SORT);
            }
        });

    }
}
