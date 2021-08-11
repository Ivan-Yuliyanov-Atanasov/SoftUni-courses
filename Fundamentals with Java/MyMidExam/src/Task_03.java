import java.util.*;
import java.util.stream.Collectors;

public class Task_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> products = Arrays.stream(scan.nextLine().split("\\|")).collect(Collectors.toList());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Shop!")){

            String [] tokens = inputLine.split("%");
            String command = tokens[0];
            String product = tokens [1];
            switch (command){
                case "Remove":
                    if(!products.contains(product)){
                        System.out.printf("Product %s isn't in the list.%n",product);
                    }
                    products.remove(product);
                    break;
                case "Add":
                    if(products.contains(product)){
                        System.out.println("The product is already in the list. ");
                    } else {
                        products.add(product);
                    }
                    break;
                case "Important":
                        products.remove(product);
                        products.add(0,product);

                    break;
                case "Swap":
                    String secondProduct = tokens [2];
                    if(!products.contains(product)){
                        System.out.printf("Product %s missing!%n",product);
                    } else if (!products.contains(secondProduct)){
                        System.out.printf("Product %s missing!%n",secondProduct);
                    } else {
                        int indexFirstProduct = products.indexOf(product);
                        int indexSecondProduct = products.indexOf(secondProduct);
                        products.set(indexFirstProduct,secondProduct);
                        products.set(indexSecondProduct,product);
                    }
                    break;
                case "Reversed":
                    Collections.reverse(products);
                    break;

            }
            inputLine = scan.nextLine();

        }

        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s%n",i+1,products.get(i));

        }
    }
}
