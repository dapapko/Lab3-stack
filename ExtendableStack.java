public class ExtendableStack implements StackInterface {
    private int[] items;

    public ExtendableStack() {
        this.items = new int[0];
    }

    public int[] toArray() {
        return this.items;
    }

    public int pop() throws EmptyStack {
        int item = this.peek();
        this.items = ArrayOperations.deleteLastElementFromArray(this.items);
        return item;
    }

public void clear() { this.items = new int[0]; }

    public boolean isEmpty() {
        return this.getLength() == 0;
    }

    public int getLength() {
        return this.items.length;
    }

    public int search(int item) throws ElementNotFound {
        int pos = -1;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == item) {
                pos = i;
                return pos;
            }
        }
        throw new ElementNotFound();
    }

    public void push(int item) throws StackOverflow {
        this.items = ArrayOperations.appendToArray(this.items, item);
    }

    public int peek() throws EmptyStack {
        if (this.items.length == 0) {
            throw new EmptyStack();
        } else {
            return this.items[this.items.length - 1];
        }
    }
}