public class ExtendableStack implements StackInterface {
    private int[] items;

    public ExtendableStack() {
        this.items = new int[0];
    }
    public int[] toArray() {
        return this.items;
    }

    public int pop() throws StackException.EmptyStackException {
            int item = this.peek();
            this.items = ArrayOperations.deleteLastElementFromArray(this.items);
            return item;
    }
    public void clear(){
        this.items = new int[0];
    }
    public boolean isEmpty(){
        return this.getLength() == 0;
    }
    public int getLength(){return this.items.length;}
    public int search(int item) throws StackException.ElementNotFound {
        int pos = -1;
        for(int i=0; i < this.items.length;i++) {
            if (this.items[i] == item) {
                pos = i;
                return pos;
            }
        }
        throw new StackException.ElementNotFound();
    }

    public void push(int item) throws StackException.StackOverflowException {
       this.items = ArrayOperations.appendToArray(this.items, item);
    }

    public int peek() throws StackException.EmptyStackException {
        if (this.items.length == 0) {
            throw new StackException.EmptyStackException();
        } else {
            return this.items[this.items.length - 1];
        }
    }
}