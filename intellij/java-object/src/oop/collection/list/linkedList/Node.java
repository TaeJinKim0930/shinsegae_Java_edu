package oop.collection.list.linkedList;

/**
 * 데이터가 저장되는 VO 객체
 */
public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }
}
