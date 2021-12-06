package com.github.zipcodewilmington;
public class SinglyLinkedList{
    //always add thing to end
    Node<String> head; //head is the top of the straight
    Node<String> tail;//tail is the exposed node
    int size = 0;
    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public SinglyLinkedList(Node<String> head){
        if(head == null){
            System.out.println("null head");
        }
        else if(head.next == null) {
            this.head = head;
            size++;
            this.tail = head;
        }
        else{
            addMultipleNodes(head);
            this.head = head;
        }
    }
    public Node<String> getHead(){
        return this.head;
    }
    public Node<String> getTail(){ //this is the end of the sequence
        return this.tail;
    }
    private void addMultipleNodes(Node<String> newbies){ //add to tailV //double check indices
        Node<String> temp = newbies;
        if(tail != null){
            tail.next = newbies;
        }
        else if(head == null) {
            head = newbies;
        }
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        this.tail = temp;
        size++;
    }
    public Node<String> getNode(Node<String> newbie){
        if(newbie == null) {
            return null;
        }
        else{
            Node<String> temp = this.head;
            while(temp != null){
                if(temp.equals(newbie)){
                    return temp;
                }
                temp = temp.next;
            }
            return null;
        }
    }
    public void addNode(Node<String> newbie){ //add to tailV
        if(newbie == null) {
            System.out.println("parameter is null");
        }
        else if(newbie.next == null) {
            if (tail == null) {
                head = newbie;
            } else {
                tail.next = newbie;
            }
            this.tail = newbie;
            size++;
        }
        else {
            this.addMultipleNodes(newbie);
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int getSize(){
        return size;
    }
    public Node<String> removeNode(Node<String> nodeToRemove){
        Node<String> curr = this.head;
        Node<String> prev = curr;
        if(new SinglyLinkedList(nodeToRemove).equals(this) && nodeToRemove.next == null){
            System.out.println("full list removal");
            tail = null;
            head = null;
            size = 0;
            return curr;
        }
        while(!curr.equals(nodeToRemove)){
            prev = curr;
            curr = curr.next;
        }
        if(curr.equals(this.head)) {//try adding this in solitaire
            //size++;
            this.head = curr.next;
        }
        else{
            prev.next = curr.next;
        }
        size--;
        curr.next = null;
        return curr;
    }
    public boolean contains(Node<String> nodeToFind){
        if(nodeToFind == null){
            return false;
        }
        Node<String> curr = this.head;
        while(!curr.equals(nodeToFind) && curr.next != null){
            curr = curr.next;
        }
        if(curr.equals(nodeToFind)){
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinglyLinkedList olist = (SinglyLinkedList) o;
        if (olist.size != this.size) return false;
        Node<String> tempt = this.head; //temp this
        Node<?> tempo = olist.head; //temp olist
        while(tempt.next != null){
            if(!tempt.value.equals(tempo.value)){
                return false;
            }
            tempt = tempt.next;
            tempo = tempo.next;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            return "";
        }
        Node<String> temp = this.head;
        while(temp != null){
            sb.append(temp);
            temp = temp.next;
            sb.append(",");
        }
        return sb.toString();
    }

}

