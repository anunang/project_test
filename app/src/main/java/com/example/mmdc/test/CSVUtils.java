/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.mmdc.test;

import java.io.*;

public class CSVUtils {
    private static final String FILE_PATH = "users.csv";

    public static boolean userExists(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts[0].equals(username)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }

    public static boolean validateLogin(String username, String password) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length >= 2 && parts[0].equals(username) && parts[1].equals(password)) {
                reader.close();
                return true;
            }
        }
        reader.close();
        return false;
    }

    public static void registerUser(String username, String password) throws IOException {
        FileWriter writer = new FileWriter(FILE_PATH, true);
        writer.write(username + "," + password + "\n");
        writer.close();
    }
}
