import java.util.EmptyStackException;
import java.util.Random;

class Permutations {
    public static int index(int[] arr, int item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static int[] shuffle(int[] arr) {
        Random rand = new Random();
        int[] shuffled = new int[0];
        while (arr.length > 1) {
            int index = rand.nextInt(arr.length - 1);
            int item = arr[index];
            shuffled = ArrayOperations.appendToArr(shuffled, item);
            arr = ArrayOperations.deleteFromArrayByValue(arr, item);
        }
        shuffled = ArrayOperations.appendToArr(shuffled, arr[0]);
        return shuffled;
    }
public static boolean checkIndexes(int[] permutation) {
    int check = permutation[0];
    int memberCheck = permutation[0];
    for (int j = 0; j < permutation.length; j++) {
        if (permutation[j] != check) {
            return true;
        }
    }
    return false;
}
public static boolean checkMembers(int[] permutation, int[] array) {
    int memberCheck = permutation[0];
    for(int k=0;k<array.length;k++) {
        if (array[k] != memberCheck) {
            return true;
        }
    }
    return false;
}
    public static boolean countOrNot(int[] permutation, int[] array) {
        return checkIndexes(permutation) && checkMembers(permutation, array);
    }

    public static void indexesToMembers(int[] array, int[] indexes) {
        for (int i = 0; i < indexes.length; i++) {
            System.out.print(array[indexes[i]] + " ");
        }
        System.out.println();
    }



    public static int[] getLoop(int[] sequence, int[] permutation) {
        int[] loop = new int[0];
        int index1 = index(permutation, sequence[0]);
        loop = ArrayOperations.appendToArr(loop, sequence[0]);
        loop = ArrayOperations.appendToArr(loop, index1);
        int src = index1;
        while (true) {
            if (loop[0] == loop[loop.length - 1]) {
                return loop;
            }
            int index = index(permutation, src);
            loop = ArrayOperations.appendToArr(loop, index);
            src = index;
        }
    }

    public static int countLoops(int[] sequence, int[] permutation, int[] array) {
        int loopCounter = 0;
        while (sequence.length > 1) {
            int[] loop = getLoop(sequence, permutation);
            sequence = ArrayOperations.difference(sequence, loop);
            if (countOrNot(loop, array)) {
                loopCounter++;
            }
        }
        return loopCounter;
    }

    public static void printLoops(int[] sequence, int[] permutation, int[] array) {
        int counter = 0;
        while (sequence.length > 1) {
            int[] loop = getLoop(sequence, permutation);
            sequence = ArrayOperations.difference(sequence, loop);
            if (countOrNot(loop, array)) {
                indexesToMembers(array, loop);
                counter++;
            }
        }
        System.out.println("Loops count: " + counter);
    }

    public static void generatePermutationWithOneLoop(int[] sequence, int[] array) {
        while (true) {
            int[] sequenceCopy = shuffle(sequence);
            int counter = countLoops(sequence, sequenceCopy, array);
            if (counter == 1) {
                System.out.println("Initial sequence:");
                ArrayOperations.printArr(array);
                System.out.println();
                System.out.println("Permutation:");
                indexesToMembers(array, sequenceCopy);
                System.out.println();
                System.out.println("Loop:");
                int[] loop = getLoop(sequence, sequenceCopy);
                indexesToMembers(array, loop);
                System.out.println();
                break;
            }
        }
    }

    public static void countAndPrintLoops(int[] array, int[] permutation) {
        int[] sequence = new int[array.length];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = i;
        }
        printLoops(sequence, permutation, array);
    }

    public static void permutationWithGivenNumberOfLoops(int[] array, int loops) {
        int[] sequence = getArrayOfIndexes(array);
        int[] sequenceCopy = ArrayOperations.copy(sequence);
        while (true) {
            sequenceCopy = shuffle(sequenceCopy);
            int loopsCount = countLoops(sequence, sequenceCopy, array);
            if (loopsCount == loops) {
                System.out.println("Permutation: ");
                indexesToMembers(array, sequenceCopy);
                System.out.println("Loops: ");
                printLoops(sequence, sequenceCopy, array);
                break;
            }
            sequenceCopy = sequence;
        }
    }

    public static int[] getArrayOfIndexes(int[] arr) {
        int[] indexes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indexes[i] = i;
        }
        return indexes;
    }

    public static void randomSequenceFromStack() {
        ExtendableStackWithPointer stack = new ExtendableStackWithPointer();
        ExtendableStackWithPointer insertions = new ExtendableStackWithPointer();
        ExtendableStackWithPointer popped = new ExtendableStackWithPointer();
        Random rand = new Random();
        int len = rand.nextInt(25) + 5;
        try {
            for (int i = 0; i < len; i++) {
                boolean choice = rand.nextBoolean();
                if (choice) {
                    int item = rand.nextInt();
                    stack.push(item);
                    insertions.push(item);
                } else {
                    int element = stack.pop();
                    popped.push(element);
                }
            }
        } catch (EmptyStackException ex) {
            System.out.println("Error. You've tried to get something from empty stack");
        } finally {
            System.out.print("Popped elements: ");
            ArrayOperations.printArr(popped.toArray());
            System.out.println();
            System.out.print("Insertions: ");
            ArrayOperations.printArr(insertions.toArray());
        }
    }

    public static void stackSequence(int pop, int push, int stackQuantity) {
        Random rand = new Random();
        for (int i = 0; i < stackQuantity; i++) {
            ExtendableStackWithPointer stack = new ExtendableStackWithPointer();
            ExtendableStackWithPointer insertions = new ExtendableStackWithPointer();
            ExtendableStackWithPointer popped = new ExtendableStackWithPointer();
            for (int j = 0; j < push; j++) {
                int item = rand.nextInt();
                stack.push(item);
                insertions.push(item);
            }
            try {
                for (int k = 0; k < pop; k++) {
                    int item = stack.pop();
                    popped.push(item);
                }

            } catch (EmptyStackException exc) {
                System.out.println("You've tried to get something from empty stack!");
                return;
            }
            System.out.print("Popped elements: ");
            ArrayOperations.printArr(popped.toArray());
            System.out.println();
            System.out.print("Inserted elements: ");

            ArrayOperations.printArr(insertions.toArray());
            System.out.println();
            System.out.println();
        }
    }

    public static void randperm() {
        int[] arr = new int[]{7, 8, 9, 10, 11, 12, 16};
        System.out.println("Initial sequence");
        ArrayOperations.printArr(arr);
        int[] sequence = getArrayOfIndexes(arr);
        int[] shuffled = shuffle(sequence);
        System.out.println();
        System.out.println("Permutation:");
        indexesToMembers(arr, shuffled);
        System.out.println();
        System.out.println("Loops:  ");
        printLoops(sequence, shuffled, arr);
    }

    public static void oneloop() {
        int[] arr = new int[]{7, 8, 9, 10, 11, 12, 16};
        int[] sequence = getArrayOfIndexes(arr);
        generatePermutationWithOneLoop(sequence, arr);
    }

    public static void randarrperm(int length, int loops) {
        if (length < 2) {
            System.out.println("Length must be more than 1");
            return;
        }
        int[] arr = ArrayOperations.getRandomArray(length);
        System.out.println("Initial sequence:");
        ArrayOperations.printArr(arr);
        System.out.println();
        permutationWithGivenNumberOfLoops(arr, loops);
    }
}