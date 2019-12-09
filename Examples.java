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
            int result = reversePolishNotationCalculator("23+4*");
            System.out.println("Result: " + result);
            int last = st1.peek();
            System.out.println(last);
        } catch (StackOverflow | EmptyStack ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static boolean In(char[] arr, char item) {
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == item) {
                return true;
            }
        }
        return false;
    }
    public static int reversePolishNotationCalculator(String expression) throws StackOverflow, EmptyStack {
        int counter =0;
        char[] operators = new char[]{'+', '-', '*', '/'};
        ExtendableStackWithPointer stack = new ExtendableStackWithPointer();
        char[] expArray = expression.toCharArray();
        for(int i=0; i< expArray.length;i++){
            if (!In(operators, expArray[i] )) {
                int number = Character.getNumericValue(expArray[i]);
                stack.push(number);
                counter++;
            } else {
                int res = 0;
                if(expArray[i] == '+') {
                    for(int k=0;k<counter;k++) {
                        res += stack.pop();
                    }
                    stack.push(res);
                    counter =0;
                } else if (expArray[i] == '-') {
                    for(int k=0;k<counter;k++) {
                        res -= stack.pop();
                    }
                    stack.push(res);
                    counter =0;
                }  else if (expArray[i] == '*') {
                    res = stack.pop();
                    for(int k=0;k<counter;k++) {
                        res *= stack.pop();
                    }
                    stack.push(res);
                    counter =0;
                }  else if (expArray[i] == '/') {
                    res = stack.pop();
                    for(int k=0;k<counter;k++) {
                        res /= stack.pop();
                    }
                    stack.push(res);
                    counter =0;
                }

            }
        }
        return stack.pop();
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