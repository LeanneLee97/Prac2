//package com.yourdomain.employeemgr;

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class Receiver {
    private List<Employee> employees = new ArrayList<>();

    public void loadFromCsv(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] cols = line.split(",");
                employees.add(new Employee(cols[0], cols[1], cols[2]));
            }
        }
    }

    public void saveToCsv(Path path) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Employee e : employees) {
                writer.write(String.join(",", e.getData1(), e.getData2(), e.getData3()));
                writer.newLine();
            }
        }
    }

    public void add(Employee e) {
        employees.add(e);
    }

    public void update(int index, Employee newEmp) {
        employees.set(index - 1, newEmp);
    }

    public Employee delete(int index) {
        return employees.remove(index - 1);
    }

    public void delete(Employee e) {
        employees.remove(e);
    }

    public void listAll() {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            System.out.printf("%d: %s, %s, %s%n", i + 1, e.getData1(), e.getData2(), e.getData3());
        }
    }
}
