package com.codecool.model;

import java.io.*;
import java.util.List;
import java.util.Map;

public class UserFileHandler {
    private String userFilePath = "src/main/java/resources/users.csv";
    private String saltFilePath = "src/main/java/resources/salt.csv";
    private DataContainer dataContainer;

    public UserFileHandler() {
        dataContainer = DataContainer.getInstance();
    }

    public void loadUsers() {
        String line;
        String separator = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(userFilePath));

            while ((line = br.readLine()) != null) {
                String[] information = line.split(separator);
                addUser(information);
            }
        } catch (IOException e) {
            System.out.println("users.csv: File not found");
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
            dataContainer.addMentor(
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
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userFilePath)))) {

            writeUsersToFile(dataContainer.getManagers(), writer);
            writeUsersToFile(dataContainer.getMentors(), writer);
            writeUsersToFile(dataContainer.getStudents(), writer);
            writeUsersToFile(dataContainer.getRegularEmployees(), writer);

        } catch (IOException e) {
            System.out.println("users.csv: File not found");
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

    public void saveSaltMap() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saltFilePath)))) {
            writer.write(getSaltMapAsString());
        } catch (IOException e) {
            System.out.println("salt.csv: File not found");
        }
    }

    private String getSaltMapAsString() {
        StringBuilder sB = new StringBuilder();

        for (Map.Entry<String, byte[]> entry: dataContainer.getSaltMap().entrySet()) {
            sB.append(String.format("%s,%s\n", entry.getKey(), entry.getValue()));
        }
        sB.deleteCharAt(sB.length() - 1);
        return sB.toString();
    }

    public void loadSaltMap() {        String line;
        String separator = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(saltFilePath));

            while ((line = br.readLine()) != null) {
                String[] information = line.split(separator);
                dataContainer.addSalt(information[0], information[1].getBytes());
            }
        } catch (IOException e) {
            System.out.println("salt.csv: File not found");
        }
    }
}
