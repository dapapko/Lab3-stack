public interface StackInterface {
    int top() throws EmptyStackException;
    int pop() throws EmptyStackException;
    void push(int item) throws StackOverflowException;
    boolean isEmpty();
}
