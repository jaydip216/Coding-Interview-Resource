package com.designPatterns.composite;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Department itDepartment = new ITDepartment("IT Department");
        Department adminDepartment = new AdminDepartment("Admin Department");
        HeadDepartment headDepartment = new HeadDepartment("Head Department");
        headDepartment.addDepartment(adminDepartment);
        headDepartment.addDepartment(itDepartment);
        headDepartment.printDepartmentName();
    }
}
