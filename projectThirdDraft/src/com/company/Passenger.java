//this class has all information about the passenger such as name age id number and more
package com.company;

import java.util.Scanner; //to use Scanner class

public class Passenger {

    private String firstName;
    private String lastName;
    private int age;
    private long passengerID;
    private long phoneNumber;
    public static boolean memberShip;
    public static String stateOfTheMemberShip;

    //constructor
    public Passenger() {
        memberShip=false;
        stateOfTheMemberShip="not a member";
    }//end constructor

    public Passenger(boolean memberShip){ //constructor with parameters
        this.memberShip=memberShip;

    } // end constructor


    /**
     * this method sets the passengers full name
     * @param firstName
     * @param lastName
     */
    public void setFullName(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;

    }

    /**
     * this method sets the passenger id
     * @param iD
     */
    public void setID(long iD){

        this.passengerID = iD;

    }

    /**
     * this method sets the passenger phone number
     * @param phone
     */
    public void setPhoneNumber(long phone){
        //enter the last 9 numbers massage
        this.phoneNumber=phone;

    }

    /**
     * this method sets the passenger age
     * @param age
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * this is a getter method for full name
     * @return the passenger first and last name
     */
    public String  getFullName(){
        return firstName+" "+lastName;
    }

    /**
     * this is a getter method for phone number
     * @return the passenger phone number
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * this is a getter method for age
     * @return the passenger age
     */
    public int getAge() {
        return age;
    }

    /**
     * this is a getter method for ID number
     * @return the passenger id
     */
    public long getID() {
        return passengerID;
    }

    /**
     * this is a method that checks if the passenger is a member of the traveler membership or not
     * @return the membership status (member or not member)
     */
    public static boolean isMemberShip(){

        System.out.println("are you a member or not?" + "\n1) yes , 2) no");
        Scanner info = new Scanner(System.in); //scanner object
        int member =  info.nextInt();

        while(member>3) { //while loop
            System.out.println("Wrong choice!");
            member =  info.nextInt();
        } // end while loop

        if(member==1){ //if statement to check if passengers is member or not
            System.out.println("please enter year of memberShip");
            int yearOfMemberShip= info.nextInt();

            if (yearOfMemberShip >= 2015 && yearOfMemberShip <= 2023) { //if statement to check the membership year
                System.out.println("you will get a membership discount!!");
                System.out.println("");
                memberShip=true;
                stateOfTheMemberShip="a member";
            } else {
                System.out.println("your member ship is invalid");
                System.out.println("");
            } //end if

        } //end if

        else if (member==2){ //else if statement
            System.out.println("you will not get a discount");
            System.out.println("");

        } //end else if statement

        return memberShip;

    } //end of isMemberShip method


    /**
     * this is a toString method that will take the passengers id and will convert it to
     * a string then will and .txt to name the passenger information file
     * @return
     */
    public String toString() {
        return this.passengerID+".txt";
    }

} //end of class