package com.devx.array;

/**
 * @author I348618
 * @since 6/1/2021
 */
public class FindPivotSortedRotatedArray {
    int findPivot(int[] arr, int low, int high) {
        while(high>=low) {
            if(low == high)
                return low;
            int mid = low + (high-low)/2;
            if(mid < high && arr[mid] > arr[mid+1])
                return mid;
            else if(low < mid && arr[mid-1] > arr[mid])
                return mid-1;
            else if(arr[low] >= arr[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotSortedRotatedArray f = new FindPivotSortedRotatedArray();
        System.out.println(f.findPivot(new int[]{1}, 0 , 0) == 0);
        System.out.println(f.findPivot(new int[]{}, 0 , -1) == -1);
        System.out.println(f.findPivot(new int[]{4, 5, 1, 2, 3}, 0 , 4) == 1);
        System.out.println(f.findPivot(new int[]{4, 5, 6, 7, 8, 0, 1, 2, 3}, 0 , 8) == 4);
        System.out.println(f.findPivot(new int[]{5, 1, 2, 3}, 0 , 3) == 0);
        System.out.println(f.findPivot(new int[]{1, 2, 3}, 0 , 2) == 2);
    }
}
