package com.codecool.view;

import com.codecool.model.DataContainer;
import com.codecool.model.Student;
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

        if (information[type].equals("manager")) {
            dataContainer.addManager(
                    information[logIn],
                    information[password],
                    information[name],
                    information[surName],
                    information[eMail]);
        } else if (information[type].equals("mentor")){
            dataContainer.addStudent(
                    information[logIn],
                    information[password],
                    information[name],
                    information[surName],
                    information[eMail]);

        }else if (information[type].equals("student")){
            dataContainer.addStudent(
                    information[logIn],
                    information[password],
                    information[name],
                    information[surName],
                    information[eMail]);

        } else {
                dataContainer.addRegularEmployee(
                        information[logIn],
                        information[password],
                        information[name],
                        information[surName],
                        information[eMail]);

            }
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
