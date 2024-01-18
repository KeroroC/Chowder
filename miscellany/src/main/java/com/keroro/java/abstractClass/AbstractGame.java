package com.keroro.java.abstractClass;

abstract public class AbstractGame {

     private String inner = "123";

     String defaultVariable = "default";

     protected String protectedVariable = "protected";

     public String publicVariable = "public";

     public void printSomething() {
         System.out.println("123");
     }

     abstract void companyName();
}
