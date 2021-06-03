import java.util.Scanner;

public class DaysOfTheWeek_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int day = Integer.parseInt(scan.nextLine());
        String [] daysOfTheWeek = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String dayToPrint = "";
        switch (day){
            case 1: dayToPrint = daysOfTheWeek [0];
                    break;
            case 2: dayToPrint = daysOfTheWeek [1];
                break;
            case 3: dayToPrint = daysOfTheWeek [2];
                break;
            case 4: dayToPrint = daysOfTheWeek [3];
                break;
            case 5: dayToPrint = daysOfTheWeek [4];
                break;
            case 6: dayToPrint = daysOfTheWeek [5];
                break;
            case 7: dayToPrint = daysOfTheWeek [6];
                break;
            default: dayToPrint = "Invalid day!";
                break;


        }
        System.out.println(dayToPrint);

    }
}
