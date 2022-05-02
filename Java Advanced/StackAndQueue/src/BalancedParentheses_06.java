import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        char [] parentheses = input.toCharArray();
        boolean isBalanced = true;
        if(input.length() % 2 == 1){
            isBalanced = false;
        }
        if(parentheses[0] == ')' || parentheses[0] == '}' || parentheses[0] == ']') {
            isBalanced = false;
        }
        ArrayDeque <Character> firstStack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = parentheses[i];
            if(currentSymbol == '(' || currentSymbol == '{' || currentSymbol == '['){
                firstStack.push(currentSymbol);
            } else {
                if(firstStack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                char char1 = firstStack.pop();
                if((char1 == '(' && currentSymbol != ')') || (char1 == '[' && currentSymbol != ']') || (char1 == '{' && currentSymbol != '}')) {
                    isBalanced = false;
                    break;
                }
            }
        }

        if(isBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
