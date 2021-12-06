package com.github.zipcodewilmington;

public class Node<E extends Comparable<E>>
        implements Comparable<Node<E>> {
    E key;
    Node<E> next;
    String value;
    public Node(E key, Node<E> next){
        this.next = next;
        this.key = key;
        this.value = "";
    }
    public Node(E key, String value, Node<E> next){
        this.key = key;
        this.next = next;
        this.value = value;
    }
    public String getValue(){
        return this.value;
    }
    public E getKey(){return this.key;}

    @Override
    public int compareTo(Node<E> other) {
        if(!((this.getKey()).compareTo(other.getKey()) == 0)){
            return (this.key).compareTo(other.getKey());
        }
        return (this.value).compareTo(other.getValue());
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return this.key.equals(node.getKey());
    }
    @Override
    public String toString(){
        return this.key.toString() + " " + this.value;
    }

    public Node<E> getNext() {
        return this.next;
    }
}