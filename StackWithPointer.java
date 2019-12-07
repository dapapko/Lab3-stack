public class StackWithPointer {
    private int[] items;
    private int pointer;

    public StackWithPointer(int stackSize) {
        this.items = new int[stackSize];
        this.pointer = -1;
    }

    public Integer pop() throws EmptyStackException {
        if (this.pointer == -1) {
            throw new EmptyStackException();
        }
        int item = this.peek();
        this.items[this.pointer] = 0;
        this.pointer = this.pointer - 1;
        return item;
    }

    public void push(int item) throws StackOverflowException {
        try {
            this.pointer = this.pointer + 1;
            this.items[this.pointer] = item;
        } catch (ArrayIndexOutOfBoundsException exc) {
            this.pointer = this.pointer - 1;
            throw new StackOverflowException();
        }
    }

    public int peek() throws EmptyStackException {
        if (this.pointer == -1) {
            throw new EmptyStackException();
        }
        return this.items[this.pointer];
    }
}
