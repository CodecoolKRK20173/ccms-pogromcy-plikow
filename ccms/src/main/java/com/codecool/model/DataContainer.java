package com.codecool.model;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

public class DataContainer {

    private List<Assignment> assignments;
    private static DataContainer instance;

    private DataContainer() {
        this.assignments = new ArrayList<Assignment>();
    }

    public static DataContainer getInstance() {
        if (instance == null) {
            instance = new DataContainer();
        }
        return instance;
    }


    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void createAssignment(String description) {
        Assignment assignment = new Assignment(description);
        assignments.add(assignment);
    }


}
