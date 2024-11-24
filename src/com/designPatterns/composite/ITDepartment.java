package com.designPatterns.composite;

public class ITDepartment implements Department {
    private String name;

    public ITDepartment(String name) {
        this.name = name;
    }

    @Override
    public void printDepartmentName() {
        System.out.println(this.name);
    }
}
