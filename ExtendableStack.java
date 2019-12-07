public class ExtendableStack implements StackInterface {
    private int[] items;

    public ExtendableStack() {
        this.items = new int[0];
    }
    public int[] toArray() {
        return this.items;
    }
    public int pop() throws EmptyStackException {
            int item = this.top();
            delFromArray();
            return item;
    }
    public void clear(){
        this.items = new int[0];
    }
    public boolean isEmpty(){
        return this.items.length == 0;
    }
    public int getLength(){return this.items.length;}
    public int search(int item) {
        int pos = -1;
        for(int i=0; i < this.items.length;i++) {
            if (this.items[i] == item) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    private void delFromArray() {
        int[] newarr = new int[this.items.length - 1];
        for (int i = 0; i < newarr.length; i++) {
            newarr[i] = this.items[i];
        }
        this.items = newarr;
    }

    public void push(int item) throws StackOverflowException {
        if (this.items.length +1 > Integer.MAX_VALUE - 2) {
            throw new StackOverflowException();
        }
        int[] newarr = new int[this.items.length + 1];
        for (int i = 0; i < this.items.length; i++) {
            newarr[i] = this.items[i];
        }
        newarr[this.items.length] = item;
        this.items = newarr;
    }

    public int top() throws EmptyStackException {
        if (this.items.length == 0) {
            throw new EmptyStackException();
        } else {
            return this.items[this.items.length - 1];
        }
    }
}