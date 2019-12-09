public interface StackInterface {
    int peek() throws EmptyStack;
    int pop() throws EmptyStack;
    void push(int item) throws StackOverflow;
    boolean isEmpty();
    int getLength();
    int search(int item) throws  ElementNotFound;
    int[] toArray();
    void clear();

}
