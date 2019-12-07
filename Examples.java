public class Examples {
    public static void main(String[] args) {
        String exp = "(8+7)+(9*4)";
        boolean isValid = bracketsValidation(exp);
        if (isValid) {
            System.out.println("Valid");
        } else {System.out.println("Invalid"); }
    }
public static char[] stringToListOfChars(String str) {
    char[] expList = new char[str.length()];
    for(int i=0; i< str.length();i++) {
        expList[i] = str.charAt(i);
    }
    return expList;
}
public static boolean bracketsValidation(String expression){
      char[] strList = expression.toCharArray();
      ExtendableStack stack = new ExtendableStack();
    try {
      for(int j=0; j< strList.length;j++) {
          if(strList[j] == '(') {
              stack.push(7);
          } else if (strList[j] == ')' ) {
                  stack.pop();
              }
      }
    }  catch (EmptyStackException | StackOverflowException exc) { return false; }
    try { stack.peek(); } catch (EmptyStackException exc) { return true; }
    return false;
    }
}