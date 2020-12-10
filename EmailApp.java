import java.util.Scanner;

import java.security.SecureRandom;

public class EmailApp{

    public static void main(String[] args){

        Email emailApp = new Email("Muhammad Humaidi", "Mohd Zaidi");

        emailApp.showMenu();

    }

}

class Email{

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String department;
    private int mailboxCapacity = 100;
    private String alternateEmail;

    Email(String fname, String lname){

        this.firstName = fname;
        this.lastName = lname;

    }

    void generateRandomPassword(){

        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        this.password = sb.toString();

    }

    void setDepartment(String department){

        this.department = department;

    }

    void setPassword(String newPassword){

        this.password = newPassword;

    }

    void setAlternateEmail(String nickName){

        this.alternateEmail = nickName.toLowerCase().replaceAll("\s+", "") + "@" + department + ".obmen.com";

    }

    void setEmail(String firstName, String lastName, String department){

        this.email = firstName.toLowerCase().replaceAll("\s+", "") + 
        "." + lastName.toLowerCase().replaceAll("\s+", "") + 
        "@" + department.toLowerCase() + 
        ".obmen.com";

    }

    public String getPassword(){

        return password;

    }

    public String getFullName(){

        return firstName + " " + lastName;

    }

    public String getDepartment(){

        return department;

    }

    public int getMailboxCapacity(){

        return mailboxCapacity;

    }

    public String getAlternateEmail(){

        return alternateEmail;

    }

    public String getEmail(){

        return email;

    }

    void showMenu(){

        char option = '\0';

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome " + firstName + " " + lastName + "\n");

        generateRandomPassword();

        System.out.println("Your current password is " + getPassword() + "\n");

        System.out.println("A. Set Department");

        System.out.println("B. Set Password");

        System.out.println("C. Set Alternate Email");

        System.out.println("D. Set Email");

        System.out.println("E. Show User Details");

        System.out.println("F. Exit");


        do {

            System.out.println("--------------------------------------------------------------------");
            System.out.println("Enter an option:");
            System.out.println("--------------------------------------------------------------------");

            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){

                case 'A':

                System.out.println("----------------------------------------------------------------");
                System.out.println("What is your department?");
                System.out.println("----------------------------------------------------------------");

                String userDepartment = scanner.next();

                setDepartment(userDepartment);

                System.out.println("Department has been set!");

                break;



                case 'B':

                System.out.println("----------------------------------------------------------------");

                System.out.println("What would you like your password to be?");

                System.out.println("----------------------------------------------------------------");

                String userPassword = scanner.next();

                setPassword(userPassword);

                System.out.println("Password has been set!");

                break;




                case 'C':

                System.out.println("----------------------------------------------------------------");

                System.out.println("Enter a nickname");

                System.out.println("----------------------------------------------------------------");

                String userNickname = scanner.next();

                setAlternateEmail(userNickname);

                System.out.println("Your alternate email has been set!");

                break;




                case 'D':

                System.out.println("----------------------------------------------------------------");

                System.out.println("Processing...");

                System.out.println("----------------------------------------------------------------");

                setEmail(firstName, lastName, department);

                System.out.println("Email has been set!");

                break;




                case 'E':

                System.out.println("----------------------------------------------------------------");

                System.out.println("Full Name: " + getFullName());

                System.out.println("Email: " + getEmail());

                System.out.println("Department: " + getDepartment());

                System.out.println("Password: " + getPassword());

                System.out.println("Alternative Email: " + getAlternateEmail());

                System.out.println("Mailbox Capcity: " + getMailboxCapacity() + " GB");

                System.out.println("----------------------------------------------------------------");

                break;



                case 'F':

                System.out.println("Be sure to log back in when working!\n");

                break;



                default:

                System.out.println("That's not an option");


            }

        } while (option != 'F');


    }


}