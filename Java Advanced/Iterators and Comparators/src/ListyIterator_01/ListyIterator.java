package ListyIterator_01;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String>{
    List<String> list;
    int index;

    public ListyIterator(List<String> list) {
        this.list = list;
        if(list.isEmpty()){
            index = -1;
        } else {
            index = 0;
        }
    }
    public boolean hasNext(){
        return index < list.size() - 1;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index;
            @Override
            public boolean hasNext() {
                return this.index < list.size() - 1;
            }

            @Override
            public String next() {
                return list.get(index++);
            }
        };
    }

    public void move(){
        if(hasNext()){
            index ++;
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public void Print(){
        System.out.println(list.get(index));
    }
    public void PrintAll(){
        for (String s : list) {
            System.out.print(s + " ");

        }
        System.out.println();
    }
}
