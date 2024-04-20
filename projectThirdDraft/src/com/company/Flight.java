/*
 * This class has all the information about booking a flight such as if its around or one way.
 * Also, the date and the time of the flight and stores it in files
*/
package com.company;

import java.io.*;//to use FileWriter, BufferedWriter and PrintWriter classes
import java.util.*;//to use Scanner class

public class Flight extends Passenger{
    public Destenation placeOne;//aggregation
    public Destenation placeTwo;//aggregation
    private final int AROUND=1;
    private final int ONE_WAY=2;
    private int month;
    private int day;
    private int year;
    private boolean roundTrip;

    //to write the flight information in a file
    private FileWriter f= new FileWriter("flightinfo.txt",true);
    private PrintWriter flightInfo= new PrintWriter(f);

    //constructor
    public Flight()throws IOException{

        //set the value of roundTrip to false
        roundTrip=false;
    }//end of constructor

    //constructor with parameters
    public Flight(int year,int month,int day) throws IOException{

        //using this keyword because the attributes and parameters have the same name
        this.year=year;
        this.month=month;
        this.day=day;

        //valid loop
        while (this.year!=2022||this.month>13||this.day>29) {
            System.out.println("can not find a flight in this date");
            Scanner keyboard= new Scanner(System.in);

            System.out.println("enter the year of the flight you want to book");
            this.year= keyboard.nextInt();

            System.out.println("enter the month of the flight you want to book");
            this.month= keyboard.nextInt();

            System.out.println("enter the day of the flight you want to book");
            this.day= keyboard.nextInt();


        }//end of loop
    }//end of constructor

    /**
     * This method is for write the passenger information
     *  into a file named by the passenger ID
     * @throws IOException
     */
    public void passengerInformation() throws IOException{//inharatins


        FileWriter fw=new FileWriter(super.toString(),true);
        PrintWriter pw=new PrintWriter(fw);
        pw.println("Name: "+super.getFullName());
        pw.println("Age: "+super.getAge());
        pw.println("ID number: "+super.getID());
        pw.println("Phone number: "+super.getPhoneNumber());
        pw.println("The state of the membership: "+super.stateOfTheMemberShip);
        pw.close();
        fw.close();

    }

    /**
     * This method is for choosing if the trip is round trip or just one way
     * @param way
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void chooseTheWay (int way) throws IOException  {

        //to double the price by writing in file and use it later in the receipt
        FileWriter fw = new FileWriter("aroundTrip.txt");//without true to turn off append mode
        PrintWriter pw= new PrintWriter(fw);


        if(way==AROUND) {

            //to write 2 in "aroundTrip.txt" file
            pw.println(2);
            pw.close();
            fw.close();

            System.out.println("Please type 1 for Domistic and 2 for international flight.");
            Scanner keyboard= new Scanner(System.in);
            int action2= keyboard.nextInt();

            while (action2>3) {//valid loop

                System.out.println("wrong choice!");
                action2= keyboard.nextInt();
            }//end of loop

            if (action2==1) {

                System.out.println("first trip;");
                Destenation placeOne=new Destenation();//aggregation
                placeOne.assignPlace(action2);


                System.out.println("second trip;");
                Destenation placeTwo=new Destenation();//aggregation
                placeTwo.assignPlace(action2);

                roundTrip=true;//to check it later in flightTime method
            }
            if (action2==2) {

                System.out.println("first trip;");
                Destenation placeOne=new Destenation();//aggregation
                placeOne.assignPlace(action2);

                System.out.println("second trip;");
                Destenation placeTwo=new Destenation();//aggregation
                placeTwo.assignPlace(action2);

                roundTrip=true;//to check it later in flightTime method
            }//end of if condition

            //to write the flight information in the "flightinfo.txt" file
            flightInfo.println("around trip");
            flightInfo.close();

        }//end of if condition
        if(way==ONE_WAY) {

            //because its one-way there is no need to double the price
            pw.close();
            fw.close();

            System.out.println("Please type 1 for Domistic and 2 for international flight.");
            Scanner keyboard= new Scanner(System.in);
            int action2= keyboard.nextInt();

            while (action2>3) {//valid loop
                System.out.println("wrong choice!");
                action2= keyboard.nextInt();
            }//end of loop

            Destenation placeOne=new Destenation();//aggregation
            placeOne.assignPlace(action2);

            //to write the flight information in the "flightinfo.txt" file
            flightInfo.println("one way trip");
            flightInfo.close();
        }//end of if condition

    }//end of method

    /**
     * This method is for choosing the flight time
     * @param index
     * @throws IOException
     */
    public void flightTime(int index) throws IOException {

        String choice=null;
        /*
         * to make the user choose the time of the flight
         * twice because its round trip
         */
        if(roundTrip==true) {

            for(int count=1;count<3;count++) {

                switch(index-1) {
                    case 0:
                        choice="6 AM";
                        break;
                    case 1:
                        choice="9 AM";
                        break;
                    case 2:
                        choice="12 PM";
                        break;
                    case 3:
                        choice="3 AM";
                        break;
                    default:
                        System.out.println("wrong choice");
                        count=1;
                        break;
                }//end of switch
                System.out.println(choice);

                //to write the flight information in the "flightinfo.txt" file
                flightInfo.println("flight time is: " + choice);
                flightInfo.close();
            }//end of loop
        }//end of if condition

        else {

            switch(index-1) {
                case 0:
                    choice="6 AM";
                    break;
                case 1:
                    choice="9 AM";
                    break;
                case 2:
                    choice="12 PM";
                    break;
                case 3:
                    choice="3 AM";
                    break;
                default:
                    System.out.println("wrong choice");
                    break;
            }//end switch

            System.out.println("your flight will be at "+choice);

            //to write the flight information in the "flightinfo.txt" file
            flightInfo.println("flight time is: " + choice);
            flightInfo.close();
        }//end of else

    }//end of method

    /**
     * toString method to return line of strings that contain the date of the flight
     */
    public String toString() {

        //to write the flight information in the "flightinfo.txt" file
        flightInfo.println("flight time is: " + this.year+" / "+this.month+" / "+this.day);
        flightInfo.close();

        return "the date of your flight will be "+this.year+" / "+this.month+" / "+this.day;

    }//end of method

}//end of class