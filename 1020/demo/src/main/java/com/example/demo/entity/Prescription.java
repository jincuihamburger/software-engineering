package com.example.demo.entity;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Prescription {
    private String prescID;
    private String firstName;
    private String lastName;

    private String address;

    private float sphere;

    private float axis;

    private float cylinder;

    private Date examinationDate;

    private String optometrist;

    private ArrayList<Remark> postRemarks = new ArrayList<>();

    private String prescFilePath = "presc.txt";

    private String remarkFilePath = "remark.txt";

    private String[] remarkTypes = {"client", "Optometrist"};

    public Prescription(String firstName, String lastName, String address, float sphere, float axis, float cylinder, Date examinationDate, String optometrist) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.sphere = sphere;
        this.axis = axis;
        this.cylinder = cylinder;
        this.examinationDate = examinationDate;
        this.optometrist = optometrist;
    }

    public boolean addPrescription() {
        if (firstName == null || firstName.length() < 4 || firstName.length() > 15) return false;
        if (lastName == null || lastName.length() < 4 || lastName.length() > 15) return false;
        if (address == null || address.length() < 20) return false;
        if (sphere < -20.0f || sphere > 20.0f) return false;
        if (axis < 0.0f || axis > 180.0f) return false;
        if (cylinder < -4.0f || cylinder > 4.0f) return false;
        if (optometrist == null || optometrist.length() < 8 || optometrist.length() > 25) return false;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");

        String formattedDate = formatter.format(examinationDate);

        StringBuilder content = new StringBuilder();
        content.append(firstName).append("#")
                .append(lastName).append("#")
                .append(address).append("#")
                .append(sphere).append("#")
                .append(axis).append("#")
                .append(cylinder).append("#")
                .append(formattedDate).append("#")
                .append(optometrist).append("\n");

        try (FileWriter writer = new FileWriter(prescFilePath, true)) {
            writer.write(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean addRemark(String type, String content) {
        if (postRemarks.size() == 2) return false;
        Remark possible = new Remark(type, content);
        if (!isValid(possible)) return false;

        postRemarks.add(possible);
        try (FileWriter writer = new FileWriter(remarkFilePath, true)) {
            writer.write(content.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean isValid(Remark remark) {
        if (remark.getContent() == null || remark.getContent().length() < 6 || remark.getContent().length() > 20)
            return false;
        if (!Character.isUpperCase(remark.getContent().charAt(0))) return false;
        for (String t : remarkTypes)
            if (t.equals(remark.getType()))
                return true;
        return false;
    }
}
