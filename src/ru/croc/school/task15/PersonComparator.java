package ru.croc.school.task15;
import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person p1, Person p2){
        if (Integer.compare(p1.getAge(), p2.getAge()) == 0) {
            return p1.getFullName().compareTo(p2.getFullName());
        }
        return -Integer.compare(p1.getAge(), p2.getAge());
    }
}
