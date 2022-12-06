package ru.croc.school.task16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Task16 {

    public static void main(String[] args) {
        List<Driver> allDrivers = new ArrayList<>();

        try (Scanner s = new Scanner(new FileReader("src\\ru\\croc\\school\\task16\\drivers.txt"))) {
            while (s.hasNextLine()) {
                String[] driverInf = s.nextLine().split(",");
                Set<String> setOtherThings = new HashSet<>();
                for (int i = 4; i < driverInf.length; i++) {
                    setOtherThings.add(driverInf[i]);
                }
                allDrivers.add(new Driver(driverInf[0], Double.parseDouble(driverInf[1]),
                        Double.parseDouble(driverInf[2]), driverInf[3], setOtherThings));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Enter your information: ");
        Scanner input = new Scanner(System.in);
        String[] stringCoords = input.nextLine().split(", ");
        Double[] coords = {Double.parseDouble(stringCoords[0]), Double.parseDouble(stringCoords[1])};
        String comfortClass = input.nextLine();
        Set<String> otherThings = new HashSet<>();
        for (String thing : input.nextLine().split(", ")) {
            otherThings.add(thing);
        }

        Comparator<Driver> myComparator = (Driver d1, Driver d2)->
                Double.compare(d1.distance(coords[0], coords[1]), d2.distance(coords[0], coords[1]));

        Collections.sort(allDrivers, myComparator);

        for (Driver driver : allDrivers) {
            if (driver.getComfortClass().equals(comfortClass)) {
                boolean fl = true;
                for (String thing : otherThings) {
                    if (!driver.getOtherThings().contains(thing))
                        fl = false;
                        break;
                }
                if (fl) {
                    System.out.println(driver.getName());
                    break;
                }
            }
        }
    }
}
