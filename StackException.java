public class StackException {
    public static class EmptyStackException extends Exception {
        public EmptyStackException() {
            super("Trying to get smth from empty stack");
        }
    }
    public static class ElementNotFound extends Exception {
        public ElementNotFound() {
            super("Element was not found in the stack");
        }
    }
    public static class StackOverflowException extends Exception {
        public StackOverflowException () {
            super("Stack overflow. You should delete some elements from the stack.");
        }
    }
}
