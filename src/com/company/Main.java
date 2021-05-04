package com.company;

import com.company.Algorithms.*;

import javax.swing.*;

import java.awt.*;

import static com.company.Constants.*;

/**
 * Main class for sort visualise GUI
 */
public class Main {

    private static SortArray sortArray;
    private static JFrame frame;

    public static void main(String[] args) {
//        runVisualizer();
        JFrame frame = new JFrame("Algo Viz");
        frame.setSize(new Dimension(WIN_WIDTH, WIN_HEIGHT));
        frame.setContentPane(new WelcomeScreen().panelMain);
        frame.pack();
        frame.setVisible(true);
    }

    private static void initSortArray(boolean isDNF){
        sortArray = new SortArray(isDNF);
        frame.add(sortArray);
        sortArray.repaint();

        frame.pack();
        frame.setVisible(true);
    }

    public static void runVisualizer(int SORTING_ALGORITHM) {
        frame = new JFrame();
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(Constants.WIN_WIDTH, Constants.WIN_HEIGHT);

        // TODO: Improve code logic
        //  2. Improve UI
        //  3. Add delay button
        //  4. Add screens
        //  5. Pathfinding Viz
        //  6. DNF Sort bug
        //  7. Add more algos
        //  8. Show number of swaps during simulation

        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                switch (SORTING_ALGORITHM) {

                    case SELECTION_SORT:
                        frame.setTitle("Selection Sort");
                        initSortArray(false);
                        new SelectionSort().runSort(sortArray);
                        break;
                    case BUBBLE_SORT:
                        frame.setTitle("Bubble Sort");
                        initSortArray(false);
                        new BubbleSort().runSort(sortArray);
                        break;
                    case INSERTION_SORT:
                        frame.setTitle("Insertion Sort");
                        initSortArray(false);
                        new InsertionSort().runSort(sortArray);
                        break;
                    case QUICK_SORT:
                        frame.setTitle("Quick Sort");
                        initSortArray(false);
                        new QuickSort().runSort(sortArray);
                        break;
                    case DNF_SORT:
                        frame.setTitle("DNF Sort");
                        initSortArray(true);
                        new DNFSort().runSort(sortArray);
                        break;
                }
                return null;
            }

            @Override
            protected void done() {
//                frame.dispose();
                super.done();
            }
        };

        swingWorker.execute();

//        new SelectionSort().runSort(sortArray);
    }


}
