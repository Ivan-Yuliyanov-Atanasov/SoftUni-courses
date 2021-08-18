import java.util.Scanner;

public class WorldTour_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder tour = new StringBuilder(scan.nextLine());
        String inputLine = scan.nextLine();
        while (!inputLine.equals("Travel")){
            String [] tokens = inputLine.split(":");
            String command = tokens[0];
            switch (command){
                case "Add Stop":
                    int indexToInsert = Integer.parseInt(tokens[1]);
                    String stopToAdd = tokens[2];
                    if(indexToInsert >= 0 && indexToInsert <= tour.length()){
                        tour.insert(indexToInsert,stopToAdd);

                    }
                    System.out.println(tour.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if((startIndex >= 0 && startIndex < tour.length()) && (endIndex >= 0 && endIndex < tour.length())){
                        tour.delete(startIndex,endIndex + 1);

                    }
                    System.out.println(tour.toString());
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if(tour.toString().contains(oldString)){
                        String changed = tour.toString().replace(oldString,newString);
                        tour.setLength(0);
                        tour.append(changed);

                    }
                    System.out.println(tour.toString());

                    break;

            }
            inputLine = scan.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s",tour.toString());
    }
}
