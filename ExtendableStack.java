public class ExtendableStack implements StackInterface {
    private int[] items;
    private int pointer = -1;

    public ExtendableStack(int size) {
        this.items = new int[size];
    }
    public int[] toArray() {
        return this.items;
    }

    public int pop() throws EmptyStackException {
            int item = this.peek();
            this.pointer = this.pointer -1;
            return item;
    }
    public void clear(){
        this.pointer = -1;
    }
    public boolean isEmpty(){
        return this.pointer == -1;
    }
    public int getLength(){return this.items.length;}
    public int search(int item) throws ElementNotFound {
        for(int i=0; i < this.items.length;i++) {
            if (this.items[i] == item) {
                return i;
            }
        }
        throw new ElementNotFound();
    }

    public void push(int item) throws StackOverflowException {
       this.pointer = this.pointer+1;
       if(this.pointer+1 > this.items.length - 1) {
       this.items = ArrayOperations.extend(this.item, this.item.length+2);
    }

    public int peek() throws EmptyStackException {
        if (this.pointer == -1) {
            throw new EmptyStackException();
        } else {
            return this.items[this.pointer];
        }
    }
}
