public class Examples {
    public static void main(String[] args) {
        ExtendableStackWithPointer st1 = new ExtendableStackWithPointer();
        try {
            st1.push(10);
            st1.push(20);
            st1.push(30);
            st1.push(40);
            st1.push(50);
            st1.pop();
            int last = st1.peek();
            System.out.println(last);
        } catch (StackOverflow | EmptyStack ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static char[] stringToListOfChars(String str) {
        char[] expList = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            expList[i] = str.charAt(i);
        }
        return expList;
    }


    public static boolean bracketsValidation(String expression) {
        char[] strList = expression.toCharArray();
        ExtendableStack stack = new ExtendableStack();
        try {
            for (int j = 0; j < strList.length; j++) {
                if (strList[j] == '(') {
                    stack.push(7);
                } else if (strList[j] == ')') {
                    stack.pop();
                }
            }
        } catch (EmptyStack | StackOverflow exc) {
            return false;
        }
        return stack.isEmpty();
    }
}