public class ExtendableStackWithPointer implements StackInterface {
    private int[] items;
    private int pointer = -1;

    public ExtendableStackWithPointer() {
        this.items = new int[3];
    }

    public int[] toArray() {
        int[] arr = new int[pointer + 1];
        for (int i = 0; i < pointer + 1; i++) {
            arr[i] = this.items[i];
        }
        return arr;
    }

    public int pop() throws EmptyStack {
        int item = this.peek();
        this.pointer = this.pointer - 1;
        return item;
    }

public void clear() {
        this.pointer = -1;
        this.items = new int[3];
}
    public boolean isEmpty() {
        return this.pointer == -1;
    }

    public int getLength() {
        return this.pointer + 1;
    }

    public int search(int item) throws ElementNotFound {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == item) {
                return i;
            }
        }
        throw new ElementNotFound();
    }

    public void push(int item) throws StackOverflow {
        if (this.pointer + 1 > this.items.length - 1) {
            this.items = ArrayOperations.extend(this.items);
        }
        this.pointer = this.pointer + 1;
        this.items[this.pointer] = item;
    }

    public int peek() throws EmptyStack {
        if (this.pointer == -1) {
            throw new EmptyStack();
        } else {
            return this.items[this.pointer];
        }
    }
}
