package com.company.Algorithms;

import com.company.ISortAlgorithm;
import com.company.SortArray;

public class QuickSort implements ISortAlgorithm {
    SortArray array;
    int n;
    private static final int DELAY = 20;
    public boolean cmp(int idx1, int idx2){
        return array.getVal(idx1)<=array.getVal(idx2);
    }

    @Override
    public void runSort(SortArray array) {
        this.array = array;
        n = array.getLength();

        quickSortHelper(array, 0, n-1);
    }

    int partition(SortArray array, int s, int e){

        int i=s-1; // divider
        int pivot = e;

        // On the left side of the divider there are smaller elements and on the right side there
        // are larger elements
        for(int j=s; j<e; j++){
            // If I find an element that is less than the pivot then that must be included
            // in the smaller region
            if(array.getVal(j)<=array.getVal(pivot)){
                array.swap(++i, j, DELAY);
            }
        }

        array.swap(++i, pivot, DELAY);
        return i;
    }

    private void quickSortHelper(SortArray array, int s, int e){

        if(s>=e) return;

        int p = partition(array, s, e);

        quickSortHelper(array, s, p-1);
        quickSortHelper(array, p+1, e);
    }
}