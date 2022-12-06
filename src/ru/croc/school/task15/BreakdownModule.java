package ru.croc.school.task15;

import java.util.*;

public class BreakdownModule {

    private BreakdownModule(){}

    public static void breakdown() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the boundaries of the age groups: ");
        List<Group> allGroups = new ArrayList<>();
        {
            String[] stringBoundariesOfTheAgeGroups = input.nextLine().split(" ");
            Integer[] intBoundariesOfTheAgeGroups = new Integer[stringBoundariesOfTheAgeGroups.length];
            for (int i = 0; i < intBoundariesOfTheAgeGroups.length; i++) {
                intBoundariesOfTheAgeGroups[i] = Integer.parseInt(stringBoundariesOfTheAgeGroups[i]);
            }
            Arrays.sort(intBoundariesOfTheAgeGroups, Collections.reverseOrder());
            int floor;
            int ceil = 123;
            for (Integer boundery : intBoundariesOfTheAgeGroups) {
                floor = boundery + 1;
                Group currentGroup = new Group(Math.min(Math.max(0, floor), 123),
                        Math.min(Math.max(0, ceil), 123), new ArrayList<>());
                allGroups.add(currentGroup);
                ceil = Math.min(Math.max(0, floor), 123) - 1;
            }
            floor = 0;
            Group currentGroup = new Group(Math.min(Math.max(0, floor), 123),
                    Math.min(Math.max(0, ceil), 123), new ArrayList<>());
            allGroups.add(currentGroup);
        }
        System.out.print("Enter person and END in the end: ");
        while (true) {
            String[] currentPair = input.nextLine().split(",");
            if (currentPair[0].equals("END"))
                break;
            Person currentPerson = new Person(currentPair[0], Integer.parseInt(currentPair[1]));
            for (Group group : allGroups) {
                if (group.getFloorAge() <= currentPerson.getAge() &&
                    currentPerson.getAge() <= group.getCeilAge()) {
                    group.listOfPersons.add(currentPerson);
                }
            }
        }

        for (Group group : allGroups) {
            group.sort();
            if (group.listOfPersons.size() != 0) {
                System.out.println(group);
            }
        }

    }
}
