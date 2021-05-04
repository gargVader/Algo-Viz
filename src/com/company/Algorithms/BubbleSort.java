package com.company.Algorithms;

import com.company.ISortAlgorithm;
import com.company.SortArray;

public class BubbleSort implements ISortAlgorithm {
    private static final int DELAY = 10;
    SortArray array;

    public boolean cmp(int idx1, int idx2){
        return array.getVal(idx1)<=array.getVal(idx2);
    }

    @Override
    public void runSort(SortArray array) {
        this.array = array;
        int n = array.getLength();
        for(int j=n-1; j>=0; j--){
            for(int i=1; i<=j; i++){
                if(!cmp(i-1,i)){
                    array.swap(i-1, i, DELAY);
                }
            }
        }
    }
}
