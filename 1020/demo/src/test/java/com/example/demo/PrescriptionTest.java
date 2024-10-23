package com.example.demo;

import com.example.demo.entity.Prescription;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrescriptionTest {

    /**
     * Clear each text file
     */
    void clear() {
        try {
            FileWriter fileWriter = new FileWriter("presc.txt");
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
            fileWriter = new FileWriter("remark.txt");
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ArrayList<String> getFileContent(String fileName) {
        ArrayList<String> contents = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                contents.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return contents;
    }

    /**
     * string length or null check, contains lastName、address etc
     */
    @Test
    void testAddPrescriptionStrlen() {
        clear();
        Prescription failPres = new Prescription("John", "Tr", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(false, failPres.addPrescription());
        Prescription failPres2 = new Prescription(null, "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(false, failPres2.addPrescription());
        Prescription failPres3 = new Prescription("John", "Trump", "123 Main St.", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(false, failPres3.addPrescription());
        Prescription failPres4 = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. S");
        assertEquals(false, failPres4.addPrescription());
        Prescription pres = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(true, pres.addPrescription());
    }

    /**
     * Check the file and content of the file
     */
    @Test
    void testAddPrescriptionFile() {
        clear();
        Prescription successPres = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 0.2f, new Date(), "Dr. Smith Biden");
        assertEquals(true, successPres.addPrescription());
        Prescription successPres2 = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Biden");
        assertEquals(true, successPres2.addPrescription());

        ArrayList<String> fileContent = getFileContent("presc.txt");
        assertEquals(2, fileContent.size());
    }

    /**
     * Check the range of each number like sphere、cylinder、axis
     */
    @Test
    void testAddPrescriptionNumber() {
        clear();
        //cylinder>4
        Prescription failPres = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 10f, new Date(), "Dr. Smith Patric");
        assertEquals(false, failPres.addPrescription());
        //cylinder<4
        Prescription failPres2 = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, -10f, new Date(), "Dr. Smith Patric");
        assertEquals(false, failPres2.addPrescription());
        //cylinder==4
        Prescription successPres2 = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 4f, new Date(), "Dr. Smith Patric");
        assertEquals(true, successPres2.addPrescription());
        //axis==0
        Prescription successPres3 = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 0f, 0.2f, new Date(), "Dr. Smith Patric");
        assertEquals(true, successPres3.addPrescription());
        //sphere==20
        Prescription successPres4 = new Prescription("John", "Trump", "123 Main St., Main District, London", 20f, 2f, 0.2f, new Date(), "Dr. Smith Patric");
        assertEquals(true, successPres4.addPrescription());
        //sphere==-20
        Prescription successPres5 = new Prescription("John", "Trump", "123 Main St., Main District, London", -20f, 2f, 0.2f, new Date(), "Dr. Smith Patric");
        assertEquals(true, successPres5.addPrescription());
        //date format
        ArrayList<String> fileContent = getFileContent("presc.txt");
        for (String line : fileContent) {
            String[] strs = line.split("#");
            assertEquals(true, strs[6].matches("\\d{2}/\\d{2}/\\d{2}"));
        }
    }

    /**
     * Number limit check for remarks
     */
    @Test
    void testAddRemarkLimit() {
        clear();
        Prescription pres = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(true, pres.addRemark("client", "Test is great."));
        assertEquals(true, pres.addRemark("client", "Test is quite great."));
        assertEquals(false, pres.addRemark("client", "I like that place."));
    }

    /**
     * Check for length of the content and the letter of the content
     */
    @Test
    void testAddRemarkContent() {
        clear();
        Prescription pres = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(false, pres.addRemark("client", "test is great."));
        assertEquals(false, pres.addRemark("client", "Test is quite great. Could you give me a chance?"));
    }

    /**
     * Check the type of the remark and the file content number
     */
    @Test
    void testAddRemarkType() {
        clear();
        Prescription pres = new Prescription("John", "Trump", "123 Main St., Main District, London", 1.5f, 2f, 3f, new Date(), "Dr. Smith Patric");
        assertEquals(false, pres.addRemark("doctor", "Test is great."));
        assertEquals(false, pres.addRemark(null, "Hahaha~~~ Test is great."));
        assertEquals(true, pres.addRemark("client", "Hey, test is great."));
        ArrayList<String> fileContent = getFileContent("remark.txt");
        assertEquals(1, fileContent.size());
    }

}
