package Algorithms;

import java.util.List;

/**
 * class that handles sorting algorithms
 * @param <T> class type in which the sorting algorithms will be applied
 */
public class SortingAlgorithms<T extends Comparable<T>>  {
    /**
     * quick sort algorithm
     * @param list list to be sorted
     * @param startIndex starting index
     * @param endIndex ending index
     */
    public void quicksort(List<T> list, int startIndex, int endIndex)
    {
        // verify that the start and end index have not overlapped
        if (startIndex < endIndex)
        {
            // calculate the pivotIndex
            int pivotIndex = partition(list, startIndex, endIndex);
            // sort the left sub-array
            quicksort(list, startIndex, pivotIndex);
            // sort the right sub-array
            quicksort(list, pivotIndex + 1, endIndex);
        }
    }

    /**
     * method that handles the partition of the search space to lookup
     * @param list list of elements
     * @param startIndex starting index
     * @param endIndex ending index
     * @return the pivot from which the quicksort algorithm is going to work
     */
    private int partition(List<T> list, int startIndex, int endIndex)
    {
        int pivotIndex = (startIndex + endIndex) / 2;
        T pivotValue = list.get(pivotIndex);
        startIndex--;
        endIndex++;

        while (true)
        {
            // start at the FIRST index of the sub-array and increment
            // FORWARD until we find a value that is > pivotValue
            do startIndex++; while (list.get(startIndex).compareTo(pivotValue) < 0) ;

            // start at the LAST index of the sub-array and increment
            // BACKWARD until we find a value that is < pivotValue
            do endIndex--; while (list.get(endIndex).compareTo(pivotValue) > 0) ;

            if (startIndex >= endIndex) return endIndex;

            // swap values at the startIndex and endIndex
            T temp = list.get(startIndex);
            list.set(startIndex,list.get(endIndex));
            list.set(endIndex,temp);
        }
    }
}
