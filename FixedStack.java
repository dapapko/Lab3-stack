
public class FixedStack implements StackInterface {
    private int[] items;
    private int pointer;

    public FixedStack(int stackSize) {
        this.items = new int[stackSize];
        this.pointer = -1;
    }

    public void clear() {
        this.pointer = -1;
    }
    public int[] toArray()  {
        int[] stackArr = new int[pointer+1];
        for(int i=0; i<this.pointer+1;i++) {
            stackArr[i] = this.items[i];
        }
        return stackArr;
    }
public int search(int item) throws StackException.ElementNotFound {
        int pos = -1;
        for(int i=0; i < this.pointer;i++) {
            if (this.items[i] == item) {
                pos = i;
                return pos;
            }
        }
       throw new StackException.ElementNotFound();
}
    public int pop() throws StackException.EmptyStackException {
        if (this.pointer == -1) {
            throw new StackException.EmptyStackException();
        }
        int item = this.peek();
        this.items[this.pointer] = 0;
        this.pointer = this.pointer - 1;
        return item;
    }
    public int getLength() {return this.pointer+1;}

    public void push(int item) throws StackException.StackOverflowException {
        try {
            this.pointer = this.pointer + 1;
            this.items[this.pointer] = item;
        } catch (ArrayIndexOutOfBoundsException exc) {
            this.pointer = this.pointer - 1;
            throw new StackException.StackOverflowException();
        }
    }

    public int peek() throws StackException.EmptyStackException {
        if (this.pointer == -1) {
            throw new StackException.EmptyStackException();
        }
        return this.items[this.pointer];
    }
    public boolean isEmpty(){
        return this.getLength() == 0;
    }
}
