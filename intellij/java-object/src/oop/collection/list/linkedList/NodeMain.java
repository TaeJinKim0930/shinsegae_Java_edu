package oop.collection.list.linkedList;

public class NodeMain {
    public static void main(String[] args) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);

        // Connecting node2 to node1
        node1.next = node2;
        // initializing node1 as head of node
        Node<Integer> head = node1;
    }
}
