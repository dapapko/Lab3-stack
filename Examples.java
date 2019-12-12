import java.util.Random;

public class Examples {
public static int pointer = -1;
public static int[] items = new int[20];
public static void push(int item) {
if (pointer +1 == items.length-1) {
    items = ArrayOperations.extend(items);
};
    pointer++;
    items[pointer] = item;
}

public static int peek() {
if (pointer == -1) {
    System.out.println("Error");
    return -1;
}
return items[pointer];
}
public static int pop() {
int item = peek();
pointer--;
return item;
}
    public static void main(String[] args) {
    int length, sublength, module;
    String sortingType;
    if (args.length  == 4) {
        length = Integer.parseInt(args[0]);
        sublength = Integer.parseInt(args[1]);
        module = Integer.parseInt(args[2]);
        sortingType = args[3];
    } else {
        length = 5;
        sublength = 7;
        module = 20;
        sortingType = "asc";
    }
        int[][] twoDimArray = TwoDimensionalArr.random2dArr(length, sublength, module);
        int max = TwoDimensionalArr.globalMax(twoDimArray);
        int min = TwoDimensionalArr.globalMin(twoDimArray);
        System.out.println("Two dimensional array");
        TwoDimensionalArr.printTwoDimArr(twoDimArray);
        System.out.println("Maximum:");
        System.out.println(max);
        System.out.println("Indexes:");
        TwoDimensionalArr.printIndexes(twoDimArray, max);
        System.out.println("Minimum:");
        System.out.println(min);
        System.out.println("Indexes:");
        TwoDimensionalArr.printIndexes(twoDimArray, min);
        System.out.println("Sorting: ");
        if(sortingType.equals("both")) {
            System.out.println("Ascending sorted: ");
            TwoDimensionalArr.printSorted(twoDimArray);
            System.out.println("Descending sorted: ");
            TwoDimensionalArr.printSorted(twoDimArray);
        } else if (sortingType.equals("desc")) {
            System.out.println("Descending sorted: ");
            TwoDimensionalArr.printSorted(twoDimArray);
        } else {
            System.out.println("Ascending sorted: ");
            TwoDimensionalArr.printSorted(twoDimArray);
        }
    }

    public static void main2(String[] args) {
        if (args.length == 0) {
            System.out.println("You should pass one of the arguments first: randperm, oneloop, randarrperm");
            return;
        }
        if (args[0].equals("randperm")) {
            Permutations.randperm();
        } else if (args[0].equals("oneloop")) {
            Permutations.oneloop();
        } else if (args[0].equals("randarrperm")) {
            int length = 0;
            int loops = 0;
            if (args.length == 3 ) {
                length = Integer.parseInt(args[1]);
                loops = Integer.parseInt(args[2]);
            } else {
                length =7;
                loops = 3;
            }
            Permutations.randarrperm(length, loops);
        } else {
            System.out.println("You should pass one of the arguments first: randperm, oneloop, randarrperm");
        }
    }
public static void main3 (String[] args) {
        int push, pop, stackQuantity;
        if(args.length == 3) {
            pop = Integer.parseInt(args[0]);
            push = Integer.parseInt(args[1]);
            stackQuantity = Integer.parseInt(args[2]);
        } else {
            pop = 20;
            push = 30;
            stackQuantity = 5;
        }
        Permutations.stackSequence(pop,push,stackQuantity);
}
public static void main5(String[] args) {
    push(5);
    System.out.println(peek());
}

}