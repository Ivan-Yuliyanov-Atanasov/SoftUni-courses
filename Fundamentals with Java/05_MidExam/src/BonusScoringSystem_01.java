import java.util.Scanner;

public class BonusScoringSystem_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int students = Integer.parseInt(scan.nextLine());
        int lectures = Integer.parseInt(scan.nextLine());
        int initialBonus = Integer.parseInt(scan.nextLine());
        double maxBonus = 0;
        int countAttendances = 0;
        for (int i = 0; i < students; i++) {
            int attendances = Integer.parseInt(scan.nextLine());
            double currentStudentBonus = (1.0 * attendances / lectures) * (5 + initialBonus);
            if(currentStudentBonus > maxBonus){
                maxBonus = currentStudentBonus;
                countAttendances = attendances;
            }

        }
        System.out.printf("Max Bonus: %.0f.%n",Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.",countAttendances);

    }
}
