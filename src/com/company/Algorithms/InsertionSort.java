package com.company.Algorithms;

import com.company.ISortAlgorithm;
import com.company.SortArray;

public class InsertionSort implements ISortAlgorithm {
    private static final int DELAY = 30;
    SortArray array;

    public boolean cmp(int idx1, int idx2){
        return array.getVal(idx1)<=array.getVal(idx2);
    }

    @Override
    public void runSort(SortArray array) {
        this.array = array;
        int n = array.getLength();

        for(int i=1; i<n; i++){
            int j=i-1;
            int curr = array.getVal(i);
            while(j>=0 && array.getVal(j)>curr){
                array.setVal(j+1, array.getVal(j), DELAY);
                j--;
            }
            array.setVal(j+1, curr, DELAY);
        }

    }
}
