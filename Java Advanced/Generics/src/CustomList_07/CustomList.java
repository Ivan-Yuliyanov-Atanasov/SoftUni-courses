package CustomList_07;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomList <T extends Comparable<T>> implements Iterable<T>{
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<T>();
    }
    public void addElement(T element){
        this.data.add(element);
    }
    public T removeElement(int index){
        return this.data.remove(index);
    }
    public boolean containsElement(T element){
        return this.data.contains(element);
    }
    public void swapElements(int firstIndex, int secondIndex){
        T helpElement = this.data.get(firstIndex);
        this.data.set(firstIndex,this.data.get(secondIndex));
        this.data.set(secondIndex,helpElement);
    }
    public int countGreaterThan(T element){
        return (int) this.data.stream().filter(e-> e.compareTo(element) > 0).count();
    }
    public T getMax(){
        return this.data.stream().max(Comparable::compareTo).get();
    }
    public T getMin(){
        return this.data.stream().min(Comparable::compareTo).get();
    }
    public int getSize(){
        return this.data.size();
    }
    public T getElement(int index){
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
