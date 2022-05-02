package Froggy_04;

import java.util.Iterator;

public class Lake implements Iterable<Integer>{
    int [] lake;

    public Lake(int[] lake) {
        this.lake = lake;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
    public class  Frog implements Iterator <Integer>{
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < lake.length;
        }

        @Override
        public Integer next() {
            int number = lake[index];
            this.index += 2;
            if(this.index >= lake.length && this.index % 2 == 0){
                this.index = 1;
            }

            return number;
        }
    }
}
