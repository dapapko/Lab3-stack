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

    public static int[] appendToArray(int[] arr, int item) throws StackOverflow {
        if (arr.length + 1 > Integer.MAX_VALUE - 2) {
            throw new StackOverflow();
        }
        int[] newarr = new int[arr.length + 1];
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
}
