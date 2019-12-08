public interface StackInterface {
    int peek() throws StackException.EmptyStackException, StackException.EmptyStackException;
    int pop() throws StackException.EmptyStackException, StackException.EmptyStackException;
    void push(int item) throws StackException.StackOverflowException, StackException.StackOverflowException;
    boolean isEmpty();
    int getLength();
    int search(int item) throws StackException.ElementNotFound, StackException.ElementNotFound;
    void clear();
    int[] toArray();

}
