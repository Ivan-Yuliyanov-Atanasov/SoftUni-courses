package CustomList_07;

public class Sorter {
    public static <T extends Comparable<T>> void sort(CustomList <T> customList){
        int size = customList.getSize();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if(customList.getElement(j).compareTo(customList.getElement(j + 1)) > 0){
                    customList.swapElements(j, j+1);
                }
            }


        }
    }
}
