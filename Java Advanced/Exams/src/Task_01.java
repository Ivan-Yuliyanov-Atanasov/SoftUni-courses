import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> queueIngredients = new ArrayDeque<>();
        ArrayDeque<Integer> stackFreshLevels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(queueIngredients::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(stackFreshLevels::push);
        int pearSour = 0;
        int theHarvest = 0;
        int appleHinny = 0;
        int highFashion = 0;

        while (!stackFreshLevels.isEmpty() && !queueIngredients.isEmpty()) {
            int currentIngredient = queueIngredients.peek();
            int currentFreshnessLevel = stackFreshLevels.peek();
            if (currentIngredient == 0) {


                queueIngredients.poll();

            } else {
                int total = currentFreshnessLevel * currentIngredient;
                if (total == 150 || total == 250 || total == 300 || total == 400) {
                    switch (total) {
                        case 150:
                            pearSour++;
                            break;
                        case 250:
                            theHarvest++;
                            break;
                        case 300:
                            appleHinny++;
                            break;
                        case 400:
                            highFashion++;
                            break;

                    }
                    queueIngredients.poll();
                    stackFreshLevels.pop();

                } else {
                    stackFreshLevels.pop();
                    queueIngredients.offer(currentIngredient + 5);
                    queueIngredients.poll();

                }

            }


        }
        if (pearSour >= 1 && theHarvest >= 1 && appleHinny >= 1 && highFashion >= 1) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!queueIngredients.isEmpty()) {
            int sum = 0;
            int size = queueIngredients.size();
            for (int i = 0; i < size; i++) {
                sum += queueIngredients.poll();
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        if (appleHinny != 0) {
            System.out.println("# Apple Hinny --> " + appleHinny);
        }
        if (highFashion != 0) {
            System.out.println("# High Fashion --> " + highFashion);
        }
        if (pearSour != 0) {
            System.out.println("# Pear Sour --> " + pearSour);
        }
        if (theHarvest != 0) {
            System.out.println("# The Harvest --> " + theHarvest);
        }


    }
}
