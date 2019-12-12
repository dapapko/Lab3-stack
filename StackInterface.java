import java.util.EmptyStackException;

public interface StackInterface {
    int peek() throws EmptyStackException;
    int pop() throws EmptyStackException;
    void push(int item) throws StackOverflowError;
    boolean isEmpty();
    int getLength();
    int search(int item) throws  ElementNotFound;
    int[] toArray();
    void clear();

}
