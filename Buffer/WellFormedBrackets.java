// import java.util.*;

// public class WellFormedBrackets {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String inp = sc.nextLine();
//         sc.close();
        
//         System.out.print(minInsertions(inp));
//     }

//     public static int minInsertions(String s) {
//         Stack<Character> stack = new Stack<>();
//         int minSteps = 0;

//         for(char ch:s.toCharArray()){
//             if(ch =='['){
//                 stack.push(ch);
//             }
//             else{ //ch ==']'
//                 if(!stack.isEmpty() && stack.peek() ==']')// the stack is '[',']'
//                 {
//                     stack.clear();
//                 }
//                 else if(!stack.isEmpty() && stack.peek() =='['){ // stack is '['
//                     stack.push(ch);                    
//                 }
//                 else{ // stack is empty && curr char is ']'
//                     stack.push('[');
//                     minSteps++;
//                 }
//             }
//         }
//         while(!stack.isEmpty()) // stack has '['x
//         {
//             minSteps+=2;
//             stack.pop();
//         }


//         return minSteps;

//     }
// }

import java.util.*;

public class WellFormedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        sc.close();
        
        System.out.print(minInsertions(inp));
    }

    public static int minInsertions(String s) {
        int minSteps = 0;  
        int openCount = 0; 
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '[') {
                openCount++; 
            } else { // ch == ']'
                if (i + 1 < s.length() && s.charAt(i + 1) == ']') {
                    i++;
                } else {
                    minSteps++;
                }

                if (openCount > 0) {
                    openCount--; 
                } else {
                    minSteps++;
                }
            }

            i++;
        }

        minSteps += openCount * 2;

        return minSteps;
    }
}
