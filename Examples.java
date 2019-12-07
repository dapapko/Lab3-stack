public class Examples {
    public static void main(String[] args) {
        ExtendableStack st1 = new ExtendableStack();
        st1.push(10);
        st1.push(20);
        st1.push(30);
        int last = st1.pop();
        System.out.println(st1.peek());
        System.out.println(last);
        StackWithPointer st2 = new StackWithPointer(5);
        st2.push(10);
        st2.push(20);
        st2.push(30);
        st2.push(40);
        st2.push(50);
        st2.push(60);
        System.out.println(st2.peek());
    }
}
