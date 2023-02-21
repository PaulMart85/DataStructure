package ru.geekbrains.lesson4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

//        Employee employee1 = new Employee("Employee1", 30);
//        Employee employee2 = new Employee("Employee1", 31);
//
//       // int[] arr = new int[2000000000];
//
//        System.out.println(employee1.hashCode());
//        System.out.println(employee2.hashCode());
//        List<Employee> list = new ArrayList<>();
//        list.add(new Employee("Name", 30));
//        list.add(new Employee("Name", 30));
//
//        HashMap<String, Employee> hashMap = new HashMap();
//        Employee e1 = hashMap.put("abc", new Employee("Employee1", 30));
//        Employee e2 = hashMap.put("abcd", new Employee("Employee12", 35));
//        Employee e3 = hashMap.put("abc", new Employee("Employee3", 40));
//        Employee e5 = hashMap.put("abcde", new Employee("Employee4", 45));
//
//        Employee e6 = hashMap.remove("abc");
//        Employee e7 = hashMap.remove("abc");
//
//        Employee e8 = hashMap.get("abc");
//        Employee e9 = hashMap.get("abcde");

        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("added");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

class Employee{

    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
