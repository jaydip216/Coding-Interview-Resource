package com.designPatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class HeadDepartment implements Department {
    private String name;
    private List<Department> departments;

    public HeadDepartment(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    @Override
    public void printDepartmentName() {
        System.out.println(this.name);
        System.out.println("Child Departments:");
        for (Department department : departments) {
            department.printDepartmentName();
        }
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }
}
