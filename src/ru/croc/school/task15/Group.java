package ru.croc.school.task15;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Collections;

public class Group {

    private int floorAge;
    private int ceilAge;
    List<Person> listOfPersons;

    Group(int floorAge, int ceilAge, List<Person> listOfPersons) {
        this.floorAge = floorAge;
        this.ceilAge = ceilAge;
        this.listOfPersons = new ArrayList<>(listOfPersons);
    }

    public int getCeilAge() {
        return ceilAge;
    }

    public int getFloorAge() {
        return floorAge;
    }

    public void sort(){
        Collections.sort(this.listOfPersons, new PersonComparator());
    }

    @Override
    public String toString() {
        String answer = "" + this.floorAge;
        if (this.floorAge != this.ceilAge)
            answer += "-" + this.ceilAge;
        answer += ": ";
        for (int i = 0; i < this.listOfPersons.size(); i++) {
            answer += this.listOfPersons.get(i);
            if (i != this.listOfPersons.size() - 1)
                answer += ", ";
        }
        return answer;
    }
}
