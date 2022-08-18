/*
Sandilya Parimi
October 15th 2022
This program is meant to get the user's full name and graduation year to give an
output of their first name, their initials, the length of their name, the number of
year(s) they will graduate in, and their student id.
*/
import java.util.Scanner;
public class NameGames {
    public static void main(String args[]) {
        //Enter the full name of the student
        System.out.print("Enter full name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        //Enter the graduation year of the student
        System.out.print("Enter graduation year: ");
        int gradYear = scan.nextInt();
        System.out.println("                                                ");
        String firstName = getFirstName(name);
        String lastName = getLastName(name);
        System.out.println("Greetings, " + firstName + ", your initials are " +
                getInitials(name) + ".");
        System.out.println("Your last name is " + lastName.length() + " letters long.");
        int getYearsUntilGrad = getYearsUntilGrad(gradYear);
        System.out.println("You will graduate in " + getYearsUntilGrad + " " +
                makeYearPluralOrSingular(getYearsUntilGrad) + ".");
        System.out.println("Your student ID is " + getStudentID(firstName,
                lastName, gradYear) + ".");
    }
    /*
    This method returns the firstName from the name parametre.
    */
    public static String getFirstName(String name){
        String pos = " ";
        int index = name.indexOf(pos);
        String firstName = name.substring(0,index);
        return firstName;
    }
    /*
    This method returns the lastName from the name parametre.
    */
    public static String getLastName(String name) {
        String pos = " ";
        int index = name.lastIndexOf(pos);
        String lastName = name.substring(index+1);
        return lastName;
    }
    /*
    This method gets the years until graduation from the user by subtracting the
currentYear from the gradYear.
    */
    public static int getYearsUntilGrad(Integer gradYear) {
        Integer currentYear = 2021;
        int newGradYear = gradYear - currentYear;
        return newGradYear;
    }
    /*
    This method gets the initials of the user with the name variable.
    */
    public static String getInitials(String name) {
        //use the full name
        //0,1 is the index of first initial of first name
        String pos = " ";
        int index = name.indexOf(pos);
        int index1 = name.lastIndexOf(pos);
        String initials = name.substring(0, 1) + name.substring(index+1, index+2) +
                name.substring(index1+1, index1+2);
        return initials.toUpperCase();
    }
    /*
    This method constructs the student id from the firstName, lastName , and the
gradYear as follows.
       a. First 4 letters from lastName
       b. First 3 letters from firstName
       c. last 2 digits of gradYear
       eg: Sandilya S Parimi's student id is  parisan25 (with 2025 as gradYear)
    */
    public static String getStudentID(String firstName, String lastName, int
            gradYear) {
        String firstFourLettersFromLastName = lastName.substring(0, 4);
        String firstThreeLettersFromFirstName = firstName.substring(0, 3);
        int lastTwoDigitsFromGradYear = gradYear % 100;
        String studentID = "\"" +firstFourLettersFromLastName +
                firstThreeLettersFromFirstName + lastTwoDigitsFromGradYear +"\"";
        return studentID.toLowerCase();
    }
    /*
    This method is going to make the word year plural when there is more than one
year to graduate for the student and keep it singular if they have one year left to
graduate from.
    */
    public static String makeYearPluralOrSingular(int numOfYearToGraduate) {
        if(numOfYearToGraduate > 1)  {
            return "years";
        }
        else {
            return "year";
        }
    }
}