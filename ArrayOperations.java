import java.util.Arrays;

// можно было бы создать вложенный статический класс, но я решил
// вынести эти операции в отдельный статический класс, поскольку они могут пригодиться в дальнейшем.
public class ArrayOperations {
    public static int[] deleteLastElementFromArray(int[] arr) {
        int[] newarr = new int[arr.length - 1];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }
    public static String[] deleteLastStringFromArray(String[] arr) {
        String[] newarr = new String[arr.length - 1];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static int[] appendToArray(int[] arr, int item) throws StackOverflowError {
        if (arr.length + 1 > Integer.MAX_VALUE - 2) {
            throw new StackOverflowError();
        }
        int[] newarr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = item;
        return newarr;
    }

    public static int[] appendToIntegerArray(int[] arr, int item)  {
        if (arr.length + 1 > Integer.MAX_VALUE - 2) {
            throw new StackOverflowError();
        }
        int[] newarr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = item;
        return newarr;
    }
    public static int[] appendToArr(int[] arr, int item) {
        int[] newarr = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = item;
        return newarr;
    }
    public static boolean In(int[]a, int item) {
        for (int i=0; i<a.length;i++) {
            if (a[i] == item) {return true;}
        }
        return false;
    }
    public static int[] deleteFromArrayByValue(int[] arr, int value) {
        int[] newarr = new int[0];
        for(int i=0;i<arr.length;i++) {
            if (arr[i] != value) {
               newarr = appendToArr(newarr, arr[i]);
            }
        }
        return newarr;
    }
    public static void printArr(int[] a) {
        for (int i =0; i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
    }
public  static int[] difference(int[]a, int[]b) {
        int[] newarr = new int[0];
        for(int i=0;i<a.length;i++) {
            if  (!In(b, a[i])) {
                newarr = appendToArr(newarr, a[i]);
            }
        }
        Arrays.sort(newarr);
        return newarr;
}
    public static String[] appendStringToArray(String[] arr, String item) throws StackOverflowError {
        if (arr.length + 1 > Integer.MAX_VALUE - 2) {
            throw new StackOverflowError();
        }
        String[] newarr = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        newarr[arr.length] = item;
        return newarr;
    }
    public static int[] extend(int[] arr) {
        int delta = arr.length/2 +1;
        int[] newarr = new int[arr.length+delta];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static String[] extendString(String[] arr) {
        int delta = arr.length/2 +1;
        String[] newarr = new String[arr.length+delta];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }
    public static char[] extendChar(char[] arr) {
        int delta = arr.length/2 +1;
        char[] newarr = new char[arr.length+delta];
        for (int i = 0; i < arr.length; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }
    public static int[] copy(int[] arr) {
        int[] copy = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            copy[i] = arr[i];
        }
        return copy;
    }
}
