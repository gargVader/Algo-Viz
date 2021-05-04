package com.company.Algorithms;

import com.company.ISortAlgorithm;
import com.company.SortArray;
import com.company.Utils;

public class SelectionSort implements ISortAlgorithm {

    SortArray array;
    private static final int DELAY = 120;

    public boolean cmp(int idx1, int idx2){
        return array.getVal(idx1)<=array.getVal(idx2);
    }

    @Override
    public void runSort(SortArray array) {
        this.array = array;
        int n = array.getLength();
        // Loop through the array
        for(int i=0; i<n; i++){
            int minIdx = i;
            for(int j=i+1; j<n; j++){
                if(array.getVal(j)<array.getVal(minIdx)){
                    minIdx = j;
                }
            }

            array.swap(i, minIdx, DELAY);
        }



    }

}
