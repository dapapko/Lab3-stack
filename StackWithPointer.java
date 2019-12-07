public class StackWithPointer {
    private int[] items;
    private int pointer;
    public StackWithPointer(int stackSize) {
        this.items = new int[stackSize];
        this.pointer = -1;
    }
    public int pop() {
        int item = this.peek();
        this.items[this.pointer] = 0;
        this.pointer = this.pointer -1;
        return item;
    }
    public void push(int item) {
       try {
           this.pointer = this.pointer+1;
           this.items[this.pointer] = item;
       } catch (ArrayIndexOutOfBoundsException exc) {
           System.out.println("Item's limit is exceeded. Last element was rewrited!");
           this.pointer = this.pointer -1;
           this.items[this.pointer] = item;
       }
    }

    public int peek() {
        return this.items[this.pointer];
    }
}
