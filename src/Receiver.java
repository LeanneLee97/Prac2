//package com.yourdomain.employeemgr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Receiver {
    private final List<Employee> employees = new ArrayList<>();
    public void loadFromCsv(Path filePath) throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length >= 3) {
                Employee employee = new Employee(data[0], data[1], data[2]);
                employees.add(employee);
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

    public void listAll() {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            System.out.printf("%d: %s, %s, %s%n", i + 1, e.getData1(), e.getData2(), e.getData3());
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}
