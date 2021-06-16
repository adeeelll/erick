/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.erick;

import com.opencsv.CSVWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author arslan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void writeDataLineByLine(String filePath) {
        File file = new File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            Random rand = new Random();
            String[] arr = {"M", "F"};
            Random random = new Random();
            int select = random.nextInt(arr.length);
            // adding header to csv
            // create a List which contains String array
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"Id", "LastName", "First Name", "Gender", "Dob", "Address"});
            for (int i = 0; i < 100; i++) {
                int id = rand.nextInt(2000 - 1000 + 1) + 1000;
                int dob = rand.nextInt(2010 - 1950 + 1) + 1950;

                data.add(new String[]{Integer.toString(id), "Last Name", "First Name", arr[select], Integer.toString(dob), "Address"});
            }
            writer.writeAll(data);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void copyFile() throws IOException {
        File copied = new File("locationb/file.csv");
        File original = new File("locationa/file.csv");
        try (
                InputStream in = new BufferedInputStream(
                        new FileInputStream(original));
                OutputStream out = new BufferedOutputStream(
                        new FileOutputStream(copied))) {

            byte[] buffer = new byte[1024];
            int lengthRead;
            while ((lengthRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, lengthRead);
                out.flush();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        writeDataLineByLine("locationa/file.csv");
        copyFile();
        System.out.println("hello");
    }

}
