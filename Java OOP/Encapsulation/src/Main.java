import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width , height);
            System.out.printf("Surface area - %.02f%n",box.calculateSurfaceArea());
            System.out.printf("Lateral surface area - %.02f%n",box.calculateLateralSurfaceArea());
            System.out.printf("Volume - %.02f%n",box.calculateVolume());
        } catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
