package com.codecool.view;

import com.codecool.model.DataContainer;
import com.codecool.model.User;

import java.io.*;
import java.util.List;

public class UserFileHandler {
    private String filePath = "com/codecool/resources/users.csv";
    private DataContainer dataContainer;

    public UserFileHandler() {
        dataContainer = DataContainer.getInstance();
    }

    public void loadUsers() {

    }

    public void saveUsers() {

        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
            writeUsersToFile(dataContainer.getManagers(), writer);
            writeUsersToFile(dataContainer.getMentors(), writer);
            writeUsersToFile(dataContainer.getStudents(), writer);
            writeUsersToFile(dataContainer.getRegularEmployees(), writer);

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
        result += user.getType() + ",";
        result += user.getName() + ",";
        result += user.getSurname() + ",";
        result += user.getEmail();

        return result;
    }
}
