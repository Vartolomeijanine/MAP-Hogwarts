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
        Set<String> uniqueStudents = new HashSet<>(); // Eliminating students that show up more than once
        for (Log entry : logEntries) {
            if (entry.getHouse() == House.GRYFFINDOR) {
                uniqueStudents.add(entry.getStudentName());
            }
        }
        List<String> sortedStudents = new ArrayList<>(uniqueStudents);
        Collections.sort(sortedStudents);

        return sortedStudents;
    }




}
