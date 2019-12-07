public class ExtendableStack {
    private int[] items;

    public ExtendableStack() {
        this.items = new int[0];
    }

    public int pop() throws EmptyStackException {
            int item = this.peek();
            delFromArray();
            return item;
    }

    private void delFromArray() {
        int[] newarr = new int[this.items.length - 1];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = this.items[i];
        }
        this.items = newarr;
    }

    public void push(int item) {
        int len = this.items.length;
        int[] newarr = new int[len + 1];
        for (int i = 0; i < len; i++) {
            newarr[i] = this.items[i];
        }
        newarr[len] = item;
        this.items = newarr;
    }

    public int peek() throws EmptyStackException {
        if (this.items.length == 0) {
            throw new EmptyStackException();
        } else {
            return this.items[this.items.length - 1];
        }
    }
}

