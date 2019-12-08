public class Examples {
    public static void main(String[] args) {
       FixedStack st1 = new FixedStack(2);
       FixedStack st2 = new FixedStack(2);
       try {
           st1.push(10);
           st1.push(20);
           st2.push(30);
           st2.push(40);
           System.out.println(st1.search(60));
       } catch (StackOverflowException | ElementNotFound ex) {
           System.out.println(ex.getMessage());
       }
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
    }  catch (EmptyStackException | StackOverflowException exc) {
        return false;
    }
    return stack.isEmpty();
    }
}