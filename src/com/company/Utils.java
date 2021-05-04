package com.company;

import java.util.Random;
import static com.company.Constants.*;

public class Utils {

    public static void shuffleArray(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public static void sleepFor(long milliseconds) {
        long nanoseconds = milliseconds*1000000;
        long timeElapsed;
        final long startTime = System.nanoTime();
        do {
            timeElapsed = System.nanoTime() - startTime;
        } while (timeElapsed < nanoseconds);
    }

    public static void sleepFor() {
        sleepFor(DEFAULT_MILLISECONDS_DELAY);
    }

}