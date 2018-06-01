package com.codecool.model;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class UserFileHandler {
    private String filePath = "src/main/java/resources/users.csv";
    private DataContainer dataContainer;

    public UserFileHandler() {
        dataContainer = DataContainer.getInstance();
    }

    public void loadUsers() {
        String line;
        String separator = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            while ((line = br.readLine()) != null) {
                String[] information = line.split(separator);
                addUser(information);
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private void addUser(String[] information) {
        int logIn = 0;
        int password = 1;
        int type = 2;
        int name = 3;
        int surName = 4;
        int eMail = 5;

            dataContainer.addStudent(
                    information[logIn],
                    information[password],
                    information[name],
                    information[surName],
                    information[eMail]);

    }

    public void saveUsers() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {

            writeUsersToFile(Arrays.asList(dataContainer.getStudents()), writer);

        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    private void writeUsersToFile(List<User> usersList, Writer writer) throws IOException{
        for (User user: usersList) {
            writer.write(prepareRecord(user));
        }
    }
    private String prepareRecord(User user) {
        String result = "";

        result += user.getLogIn() + ",";
        result += user.getPassword() + ",";
        result += user.getRole() + ",";
        result += user.getName() + ",";
        result += user.getSurname() + ",";
        result += user.getEmail() + "\n";

        return result;
    }
}
