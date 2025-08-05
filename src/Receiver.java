//package com.yourdomain.employeemgr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Receiver {
    private final List<Employee> employees = new ArrayList<>();
    private List<String> data;
    public void storeToFile(Path path) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Employee e : employees) {
                writer.write(e.toString());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(Path path) throws IOException {
        employees.clear();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    Employee e = Employee.fromString(line);
                    employees.add(e);
                } catch (IllegalArgumentException ex) {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        }
    }

    public void add(Employee e) {
        employees.add(e);
    }

    public void update(int index, Employee newEmp) {
        if (index >= 1 && index <= employees.size()) {
            employees.set(index - 1, newEmp);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public Employee delete(int index) {
        if (index >= 1 && index <= employees.size()) {
            return employees.remove(index - 1);
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }
    public void remove(Employee employee) {
        employees.remove(employee);
    }
    public void listAll() {
        System.out.println("Employee list:");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }


}
