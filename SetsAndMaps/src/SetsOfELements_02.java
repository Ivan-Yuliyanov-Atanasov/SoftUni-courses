import java.util.*;

public class SetsOfELements_02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] num = Arrays.stream((scan.nextLine().split(" "))).mapToInt(Integer::parseInt).toArray();
        int m = num[0];
        int n = num[1];
        Set<String> firstSet = new LinkedHashSet<>();
        Set<String> secondSet = new LinkedHashSet<>();
        addToTheSet(firstSet,m,scan);
        addToTheSet(secondSet,n,scan);
        for (String set1 : firstSet) {
            for (String set2 : secondSet) {
                if(set1.equals(set2)){
                    System.out.print(set1 + " ");
                }
            }

        }
    }

    private static void addToTheSet(Set<String> firstSet, int m, Scanner scan) {
        for (int i = 0; i < m; i++) {
            firstSet.add(scan.nextLine());
        }
    }
}

