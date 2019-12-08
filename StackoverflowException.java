public class StackOverflowException extends Exception {
        public StackOverflowException () {
            super("Stack overflow. You should delete some elements from the stack.");
        }
    }
