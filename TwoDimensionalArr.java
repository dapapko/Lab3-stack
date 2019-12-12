public class TwoDimensionalArr {
    public static int count(int[][] arr) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                len++;
            }
        }
        return len;
    }
public static void printSorted(int[][] arr) {
        long before = System.nanoTime();
        for(int k=0;k<arr.length;k++) {
            insertSort(arr[k]);
           ArrayOperations.printArr(arr[k]);
            System.out.println();
        }
    long after = System.nanoTime();
    System.out.println("Sorting took " + (after - before) + " nanoseconds");
}
    public static void reverse(int[] arr) {
        int tmp;
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            tmp = arr[len - i - 1];
            arr[len - i - 1] = arr[i];
            arr[i] = tmp;
        }
    }
    public static void printDescSorted(int[][] arr) {
        long before = System.nanoTime();
        for(int k=0;k<arr.length;k++) {
            insertSort(arr[k]);
            reverse(arr[k]);
            ArrayOperations.printArr(arr[k]);
            System.out.println();
        }
        long after = System.nanoTime();
        System.out.println("Sorting took " + (after - before) + " nanoseconds");
    }
public static void printTwoDimArr(int[][] arr) {
        for(int i=0;i< arr.length;i++) {
            for (int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
} 
    public static void printIndexes(int[][] arr, int item) {
        int len = count(arr);
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == item) {
                    counter++;
                    System.out.println(Integer.toString(i) + "  -  " + Integer.toString(j));
                }
            }
        }
        if(counter == 1) {
            System.out.println("There is only one element with such value");
        }
    }
    public static void insertSort(int[] arr) {
        int tmp = 0;
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            while (k > 0 && arr[k - 1] > arr[k]) {
                tmp = arr[k - 1];
                arr[k - 1] = arr[k];
                arr[k] = tmp;
                k--;
            }
        }
    }
    public static int[][] appendTo(int[][] arr, int[] item) {
        int[][] newarr = new int[arr.length + 1][];
        for (int k = 0; k < arr.length; k++) {
            newarr[k] = arr[k];
        }
        newarr[arr.length] = item;
        return newarr;
    }

public static int[][] random2dArr(int length, int lengthOfSubarr, int module) {
        int[][] twodim = new int[length][];
        for(int i=0;i<length;i++) {
            int[] arr;
            if (module == 0) {
                arr = ArrayOperations.getRandomArray(lengthOfSubarr);
            } else {
                arr = ArrayOperations.restrictedRandomArr(module, lengthOfSubarr);
            }
            twodim[i] = arr;
        }
        return twodim;
}
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int getMin(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
 

    public static int[] minusOneDimension(int[][] arr) {
        int[] oneDimArr = new int[0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               oneDimArr = ArrayOperations.appendToArr(oneDimArr, arr[i][j]);
            }
        }
       return oneDimArr;
    }

    public static int globalMax(int[][] arr) {
        int[] oneDimArr = minusOneDimension(arr);
        int max = getMax(oneDimArr);
        return max;
    }
    public static int globalMin(int[][] arr) {
        int[] oneDimArr = minusOneDimension(arr);
        int min = getMin(oneDimArr);
        return min;
    }

}