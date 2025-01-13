package controller;

import model.*;
import java.util.*;


/**
 * The Controller manages the application logic.
 */
public class HogwartsController {
    private final List<Log> logEntries;

    public HogwartsController(List<Log> logEntries) {
        this.logEntries = logEntries;
    }

    //b
    /**
     * Returns all the students whose names begin with a specified letter.
     */
    public List<String> getStudentsByLetter(char letter) {
        Set<String> uniqueStudents = new HashSet<>(); // Eliminating students that show up more than once
        for (Log entry : logEntries) {
            String studentName = entry.getStudentName();
            if (studentName.startsWith(String.valueOf(letter))) {
                uniqueStudents.add(studentName);
            }
        }
        return new ArrayList<>(uniqueStudents); // Converting to List, printStudents needs a List parameter
    }

    //c
    /**
     * Returns all the Gryffindor in alphabetical order.
     */
    public List<String> getGryffindorStudents() {
        Set<String> uniqueStudents = new HashSet<>();
        for (Log entry : logEntries) {
            if (entry.getHouse() == House.GRYFFINDOR) {
                uniqueStudents.add(entry.getStudentName());
            }
        }
        List<String> sortedStudents = new ArrayList<>(uniqueStudents);
        Collections.sort(sortedStudents);

        return sortedStudents;
    }

    //d
    /**
     * Calculates the house scores and sorts them in descending order.
     */
    public Map<House, Integer> getHouseResults() {
        Map<House, Integer> houseScores = new HashMap<>();

        // 1. Calculate the scores for each house
        for (Log entry : logEntries) {
            House house = entry.getHouse();
            int points = entry.getPoints();

            if (houseScores.containsKey(house)) {
                houseScores.put(house, houseScores.get(house) + points);
            } else {
                houseScores.put(house, points);
            }
        }

    // 2. Sort the houses manually by finding the highest score
        Map<House, Integer> sortedHouseScores = new HashMap<>();

        while (!houseScores.isEmpty()) {
            House topHouse = null;

            for (House house : houseScores.keySet()) {
                if (topHouse == null || houseScores.get(house) > houseScores.get(topHouse)) {
                    topHouse = house;
                }
            }
            //sortedHouseScores.put(topHouse, houseScores.get(topHouse));
            System.out.println(topHouse + "#" + houseScores.get(topHouse));
            houseScores.remove(topHouse);
        }

        return sortedHouseScores;
    }
}
