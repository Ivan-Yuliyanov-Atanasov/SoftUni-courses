package GenericBox_01;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Comparable<T>>{
    List<T> data;

    public Box() {
        this.data = new ArrayList<T>();
    }
    public void addData(T element){
        this.data.add(element);
    }
    public T getElement(int index){
        return this.data.get(index);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <this.data.size(); i++) {
            sb.append(String.format("%s: %s",getElement(i).getClass().getName(),getElement(i)));
            sb.append(System.lineSeparator());
        }
       return sb.toString();
    }

    public void swapElements(int firstIndex, int secondIndex){
        T helpElement = this.data.get(firstIndex);
        this.data.set(firstIndex,this.data.get(secondIndex));
        this.data.set(secondIndex,helpElement);
    }
    public int countGreaterThan(T element){
        return (int) this.data.stream().filter(e-> e.compareTo(element) > 0).count();
    }
}
