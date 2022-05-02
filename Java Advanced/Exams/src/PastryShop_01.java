import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class PastryShop_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();
        int [] liquids = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [] ingredients = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < liquids.length; i++) {

                liquidsQueue.offer(liquids[i]);

        }
        for (int i = 0; i < ingredients.length; i++) {

                ingredientsStack.push(ingredients[i]);

        }
        int biscuits = 0;
        int cakes = 0;
        int pastries = 0;
        int pies = 0;
        while(!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currentLiquid = liquidsQueue.peek();
            int currentIngredient = ingredientsStack.peek();
            int sum = currentIngredient + currentLiquid;
            switch (sum){
                case 25:
                    biscuits++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 50:
                    cakes++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75:
                    pastries++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100:
                    pies++;
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    ingredientsStack.push(ingredientsStack.pop() + 3);
                    break;
            }
        }
        if(biscuits != 0 && cakes != 0 && pastries != 0 && pies != 0){
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if(liquidsQueue.isEmpty()){
            System.out.println("Liquids left: none");
        } else {
            System.out.println("Liquids left: " + liquidsQueue.toString().replace("[","").replace("]",""));
        }
        if(ingredientsStack.isEmpty()){
            System.out.println("Ingredients left: none");
        } else {
            System.out.println("Ingredients left: " + ingredientsStack.toString().replace("[","").replace("]",""));
        }
        System.out.println("Biscuit: " + biscuits);
        System.out.println("Cake: " + cakes);
        System.out.println("Pie: " + pies);
        System.out.println("Pastry: " + pastries);

    }
}
