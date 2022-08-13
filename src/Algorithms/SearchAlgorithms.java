package Algorithms;

import java.util.List;

public class SearchAlgorithms<T extends Comparable<T>>
{
    public int binarySearch(List<T> list, int l, int r, T x)
    {
        if (r>=l)
        {
            int mid = l + (r - l)/2;

            // If the element is present at the
            // middle itself
            if (list.get(mid).compareTo(x) == 0)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (list.get(mid).compareTo(x)>0)
                return binarySearch(list , l, mid-1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(list, mid+1, r, x);
        }

        // We reach here when element is not present
        //  in array
        return -1;
    }

}
