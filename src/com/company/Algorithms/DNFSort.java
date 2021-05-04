package com.company.Algorithms;

import com.company.ISortAlgorithm;
import com.company.SortArray;

import static com.company.Constants.*;

public class DNFSort implements ISortAlgorithm {
    private static final int DELAY = 100;
    SortArray array;

    public boolean cmp(int idx1, int idx2) {
        return array.getVal(idx1) <= array.getVal(idx2);
    }

    @Override
    public void runSort(SortArray array) {
        this.array = array;
        int n = array.getLength();


        int low = 0, mid = 0, high = n - 1;

        while (mid < high) {

            if (array.getVal(mid) == DNF_VAL_1) {
                mid++;
            }

            if (array.getVal(mid) == DNF_VAL_0) {
                array.swap(mid, low, DELAY);
                low++;
                mid++;
            }

            if (array.getVal(mid) == DNF_VAL_2) {
                array.swap(mid, high, DELAY);
                high--;
            }
        }
    }
}
