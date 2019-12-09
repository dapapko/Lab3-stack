public class FixedStack implements StackInterface {
    private int[] items;
    private int pointer;
    private int capacity;

    public FixedStack(int stackSize) {
        this.items = new int[stackSize];
        this.pointer = -1;
        this.capacity = stackSize;
    }

    public void clear() {
        this.pointer = -1;
        this.items = new int[capacity];
    }

    public int[] toArray() {
        int[] stackArr = new int[pointer + 1];
        for (int i = 0; i < this.pointer + 1; i++) {
            stackArr[i] = this.items[i];
        }
        return stackArr;
    }

    public int search(int item) throws ElementNotFound {
        for (int i = 0; i < this.pointer; i++) {
            if (this.items[i] == item) {
                return i;
            }
        }
        throw new ElementNotFound();
    }

    public int pop() throws EmptyStack {
        if (this.pointer == -1) {
            throw new EmptyStack();
        }
        int item = this.peek();
        this.items[this.pointer] = 0;
        this.pointer = this.pointer - 1;
        return item;
    }

    public int getLength() {
        return this.pointer + 1;
    }

    public void push(int item) throws StackOverflow {
        try {
            this.pointer = this.pointer + 1;
            this.items[this.pointer] = item;
        } catch (ArrayIndexOutOfBoundsException exc) {
            this.pointer = this.pointer - 1;
            throw new StackOverflow();
        }
    }

    public int peek() throws EmptyStack {
        if (this.pointer == -1) {
            throw new EmptyStack();
        }
        return this.items[this.pointer];
    }

    public boolean isEmpty() {
        return this.getLength() == 0;
    }
}