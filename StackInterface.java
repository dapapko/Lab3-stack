public interface StackInterface {
    int peek() throws EmptyStackException;
    int pop() throws EmptyStackException;
    void push(int item) throws StackOverflowException;
    boolean isEmpty();
    int getLength();
    int search(int item) throws ElementNotFound;
    void clear();
    int[] toArray();

}
