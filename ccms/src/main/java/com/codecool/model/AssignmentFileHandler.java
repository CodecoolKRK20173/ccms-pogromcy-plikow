package com.codecool.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentFileHandler {
    private String filePath = "src/main/java/resources/assignments.csv";
    private DataContainer dataContainer;

    public AssignmentFileHandler() {
        dataContainer = DataContainer.getInstance();
    }

    public void loadAssignments() {
        String line;
        String separator = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                addAssignment(line.split(separator));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private void addAssignment(String[] data) {
        int login = 0;
        int description = 1;

        if (data[login].equals("none")) {
            dataContainer.createAssignment(data[description]);
        } else {
            addAssignmentToStudent(data);
        }
    }

    private void addAssignmentToStudent(String[] data) {
        int login = 0;

        Student student = (Student) dataContainer.getStudent(data[login]);
        Assignment assignment = createNewAssignment(data);

        student.addAssignment(assignment);
    }

    private Assignment createNewAssignment(String[] data) {
        int login = 0;
        int description = 1;
        int solution = 2;
        int grade = 3;

        Assignment assignment = new Assignment(data[description]);
        assignment.setLogin(data[login]);

        if (!data[solution].equals("none")) {
            assignment.markDown();
            assignment.setSolution(data[solution]);
        }

        if (!data[grade].equals("none")) {
            assignment.setGrade(Integer.parseInt(data[grade]));
        }
        return assignment;
    }

    public void saveAssignments() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
            List<Assignment> assignments = collectAllAssignments();
            writer.write(assignmentsToString(assignments));

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private String assignmentsToString(List<Assignment> assignments) {
        StringBuilder result = new StringBuilder();
        String format = "%s,%s,%s,%d\n";

        for (Assignment assignment: assignments) {
            result.append(String.format(format, assignment.getLogin(),
                                                assignment.getDescription(),
                                                assignment.getSolution(),
                                                assignment.getGrade()));
        }
        return result.toString();
    }

    private List<Assignment> collectAllAssignments() {
        List<Assignment> result = new ArrayList<>(dataContainer.getAssignments());

        for (User user: dataContainer.getStudents()) {
            Student student = (Student) user;
            result.addAll(student.getAssigments());
        }
        return result;
    }
}
