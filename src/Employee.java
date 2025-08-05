//package com.yourdomain.employeemgr;

import java.util.Objects;

public class Employee {
    private final String data1;
    private final String data2;
    private final String data3;

    public Employee(String data1, String data2, String data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    public String getData1() { return data1; }
    public String getData2() { return data2; }
    public String getData3() { return data3; }

    public String toCsv() {
        return String.join(",", data1, data2, data3);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", data1, data2, data3);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee other = (Employee) o;
        return Objects.equals(data1, other.data1) &&
                Objects.equals(data2, other.data2) &&
                Objects.equals(data3, other.data3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data1, data2, data3);
    }
}
