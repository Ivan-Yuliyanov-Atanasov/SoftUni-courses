package StackIterator_03;



import java.util.Iterator;


public class Stack<Integer>implements Iterable<Integer>{
    private Node <Integer> top;

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Stack.Node <Integer> currentTop = top;
            @Override
            public boolean hasNext() {
                return currentTop != null;
            }

            @Override
            public Integer next() {
                int currentValue = currentTop.element;
                currentTop = currentTop.prev;

                return (Integer) java.lang.Integer.valueOf(currentValue);

            }
        };
    }



    private static class Node<Integer>{
        int element;
        Node <Integer>prev;
    }

    public Stack(){
        this.top = null;

    }
    public void push(int element){
        Node <Integer> node = new Node<>();
        node.element = element;
        node.prev = this.top;
        this.top = node;

    }
    public int pop() throws Exception{
        if(this.top == null){

            throw new Exception();
        } else {
            Node <Integer> currentNode = this.top;
            this.top = currentNode.prev;
            return currentNode.element;
        }

    }

}
