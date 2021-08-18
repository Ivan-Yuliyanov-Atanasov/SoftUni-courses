import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> list1 = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(scan.nextLine().split("\\s+")).
                map(Integer::parseInt).
                collect(Collectors.toList());
        List<Integer> listToPrint = new ArrayList<>();
        int sizeList1 = list1.size();
        int sizeList2 = list2.size();

        if (sizeList1 == sizeList2){
            for (int i = 0; i < sizeList1; i++) {
                listToPrint.add(list1.get(i));
                listToPrint.add(list2.get(i));

            }
        } else if (sizeList1 > sizeList2){
            int diff = sizeList1 - sizeList2;
            for (int i = 0; i < sizeList2; i++) {
                listToPrint.add(list1.get(i));
                listToPrint.add(list2.get(i));
        }
            for (int i = sizeList1 - diff; i < sizeList1; i++) {
                listToPrint.add(list1.get(i));
            }

            } else {
            int diff = sizeList2 - sizeList1;
            for (int i = 0; i < sizeList1; i++) {
                listToPrint.add(list1.get(i));
                listToPrint.add(list2.get(i));
            }
            for (int i = sizeList2 - diff; i < sizeList2; i++) {
                listToPrint.add(list2.get(i));
            }
        }
        for (Integer integer : listToPrint) {
            System.out.print(integer + " ");

        }
    }

}
