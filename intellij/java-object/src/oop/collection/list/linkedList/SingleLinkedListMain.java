package oop.collection.list.linkedList;

public class SingleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();

        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        /**
         * output
         * [data(1) | next] - [data(2) | next] - [data(3) | next] - [ | Null]
         */
    }
}
