public interface Stack {
    public int peek() throws EmptyStackException;
    public int pop() throws EmptyStackException;
    public void push(int item) throws StackOverflowException;
}
