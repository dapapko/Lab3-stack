public class ExtendableStack {
private int[] items;

    public ExtendableStack() {
        this.items = new int[0];
    }
    public int pop() {
        int item = this.peek();
        delFromArray();
        return item;
    }
    private void delFromArray() {
        int[] newarr = new int[this.items.length-1];
        for(int i=0; i< newarr.length;i++) {
            newarr[i] = this.items[i];
        }
        this.items = newarr;
    }
    public void push(int item) {
        int[] newarr = new int[this.items.length+1];
        for(int i=0; i< this.items.length;i++) {
            newarr[i] = this.items[i];
        }
        newarr[this.items.length] = item;
        this.items = newarr;
    }
    public int peek() {
        return this.items[this.items.length-1];
    }

}
