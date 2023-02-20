package ru.geekbrains.lesson3;

import java.util.Comparator;

public class StudentAgeComparator implements Comparator<Student> {

    private SortType sortType;

    public StudentAgeComparator(SortType sortType){
        this.sortType = sortType;
    }

    @Override
    public int compare(Student o1, Student o2) {
        return sortType ==
                SortType.Ascending ? Integer.compare(o1.getAge(), o2.getAge()) : Integer.compare(o2.getAge(), o1.getAge());
    }
}
