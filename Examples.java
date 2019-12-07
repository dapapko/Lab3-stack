public class Examples {
    public static void main(String[] args) {
        try {
            ExtendableStack st1 = new ExtendableStack();
            st1.push(10);
            st1.push(20);
            st1.push(30);
            st1.push(40);
            st1.push(50);
            st1.push(60);
            st1.pop();
            st1.pop();
            st1.pop();
            StackWithPointer st2 = new StackWithPointer(3);
            try {
                st2.push(10);
                st2.push(20);
                st2.push(30);
                st2.push(40);
            } catch(StackOverflowException exc) {
                System.out.println(exc.getMessage());
            }
            st2.pop();
            st2.pop();
            System.out.println(st2.peek());
        } catch (EmptyStackException exc) {
            System.out.println(exc.getMessage());
        }
    }

}
