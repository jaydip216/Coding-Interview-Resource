package com.designPatterns.interpreter;

public class Application {
    public static void main(String[] args) {
        Expression isJava = new TerminalExpression("Java");
        Expression isJavaEE = new TerminalExpression("JavaEE");

        Expression javaAndJavaEE = new AndExpression(isJava, isJavaEE);

        Expression isJavaOrJavaEE = new OrExpression(isJava, isJavaEE);

        System.out.println("Does Java is JavaEE? " + javaAndJavaEE.interpret("Java"));
        System.out.println("Does Java is JavaEE? " + javaAndJavaEE.interpret("JavaEE"));
        System.out.println("Does Java is JavaEE? " + javaAndJavaEE.interpret("JavaEE Java"));

        System.out.println("Does Java is JavaEE? " + isJavaOrJavaEE.interpret("Java"));
        System.out.println("Does Java is JavaEE? " + isJavaOrJavaEE.interpret("JavaEE"));
        System.out.println("Does Java is JavaEE? " + isJavaOrJavaEE.interpret("JavaEE Java"));
    }
}
