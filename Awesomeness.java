package com.company.Awesomeness;
import java.util.Scanner;
public class Awesomeness {
    public static void main(String[] args) {
        System.out.println("What is your name?");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Hello " + name);
        System.out.println("What is your age?");
        int age = scan.nextInt();
        //if(age != int){
            System.out.println("Please enter a number: ");
        //}
        //else {
            System.out.println("Your age is: " + age);
            System.out.println("Rate your level of awesomeness from 1 to 10.");
            int awesomeness = scan.nextInt();
            scan.close();
            System.out.println("Your level of awesomeness is: " + awesomeness);
            double salary = Math.pow(((age * age) / (awesomeness)), 2) * 52;
            System.out.println("Your salary is: " + salary + ".");
        //}
    }
}