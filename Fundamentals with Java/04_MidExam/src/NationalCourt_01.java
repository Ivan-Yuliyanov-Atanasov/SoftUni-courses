import java.util.Scanner;

public class NationalCourt_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int kpd1 = Integer.parseInt(scan.nextLine());
        int kpd2 = Integer.parseInt(scan.nextLine());
        int kpd3 = Integer.parseInt(scan.nextLine());
        int studentsQuestions = Integer.parseInt(scan.nextLine());
        int sum_kpd = kpd1 + kpd3 + kpd2;
        int counter = 0;
        while (studentsQuestions > 0){
            if(counter != 0 && counter % 4 ==0){
                counter++;
                continue;
            }
            counter ++;
            studentsQuestions -= sum_kpd;
            if(studentsQuestions <= 0 && counter % 4 == 0){
                counter++;
                break;
            }

        }
        System.out.printf("Time needed: %dh.",counter);
    }
}
