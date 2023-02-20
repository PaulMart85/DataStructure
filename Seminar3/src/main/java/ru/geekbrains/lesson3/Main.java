package ru.geekbrains.lesson3;

public class Main {

    public static void main(String[] args) {
        LinkedList<Student> linkedList = new LinkedList<>();
        linkedList.addLast(new Student("Student5", 19));
        linkedList.addLast(new Student("Student4", 18));
        linkedList.addLast(new Student("Student2", 22));
        linkedList.addLast(new Student("Student3", 24));
        linkedList.addLast(new Student("Student1", 26));

        printList(linkedList);

        linkedList.directSort(new StudentAgeComparator(SortType.Ascending));
        printList(linkedList);
        linkedList.directSort(new StudentAgeComparator(SortType.Descending));
        printList(linkedList);
        linkedList.revert();
        printList(linkedList);
    }

    public  static <T> void printList(LinkedList<T> list){
        LinkedList.Node node = list.getHead();
        System.out.println();
        while (node != null){
            System.out.println(node.getValue());
            node = node.getNext();
        }
        System.out.println();
    }

}
