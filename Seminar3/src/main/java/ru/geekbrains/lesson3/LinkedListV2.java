package ru.geekbrains.lesson3;

public class LinkedListV2<T> {

    private NodeV2 head;
    private NodeV2 tail;

    public NodeV2 getHead() {
        return head;
    }

    public NodeV2 getTail() {
        return tail;
    }

    /**
     * Узел
     */
    class NodeV2{

        private T value;
        private NodeV2 next;
        private NodeV2 prev;

        public void setNext(NodeV2 next) {
            this.next = next;
        }

        public void setPrev(NodeV2 prev) {
            this.prev = prev;
        }

        public NodeV2 getPrev() {
            return prev;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public NodeV2 getNext() {
            return next;
        }

        public NodeV2(T value) {
            this.value = value;
        }
    }

    public void addFirst(T value){
        NodeV2 node = new NodeV2(value);
        if (head != null){
            node.setNext(head);
            head.setPrev(node);
            //head = node;
        }
        else {
            tail = node;
            //head = node;
        }
        head = node;
    }

    public void removeFirst(){
        if (head != null && head.getNext() != null){
            head.getNext().setPrev(null);
            head = head.getNext();
            //head.setPrev(null);
        }
        else {
            head = null;
            tail = null;
        }
    }


}
