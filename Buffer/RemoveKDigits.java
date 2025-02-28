/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
input =1432219
3
output =1219

num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

 import java.util.*;

 public class RemoveKDigits{
     public static void main (String[] args) {
         Scanner sc = new Scanner(System.in);
         String input = sc.nextLine();
         int k = sc.nextInt();

         sc.close();
         
         System.out.println(removeKdigits(input,k));
     }
     public static String removeKdigits(String s , int k){
         if(s.length() == k) return "0";
         Stack<Character> stack = new Stack<>();
         
         for(char digit:s.toCharArray()){
             while(!stack.isEmpty() && k>0 && stack.peek() >digit){
                 stack.pop();
                 k--;
             }
             stack.push(digit);
         }
         
         while(k>0){
             stack.pop();
             k--;
         }
         
         StringBuilder result = new StringBuilder();
         
         while(!stack.isEmpty()){
             result.append(stack.pop());
         }
         result.reverse();
         
         while(result.length()>1 && result.charAt(0) == '0'){
             result.deleteCharAt(0);
         }
         
         return result.length() ==0? "0":result.toString();
         
         }
     
 }
