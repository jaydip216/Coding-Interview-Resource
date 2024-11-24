package com.designPatterns.composite;

public class AdminDepartment implements Department {
    private String name;

    public AdminDepartment(String name) {
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(this.name);
    }
}
