//This class has all the information about seat reservations and stores it in files
package com.company;

import java.io.*;//to use FileWriter, BufferedWriter and PrintWriter classes
import java.util.*;//to use Random class

public class Seats  {
    private final int NUMBER_OF_SEATS = 10;//number of seats as an index
    private boolean seats[];
    private int firstSeat;
    private int secondSeat;
    public int choose=0;
    public Random randomNumbers = new Random();

    //to write the flight information in a file
    FileWriter f= new FileWriter("flightinfo.txt",true);
    PrintWriter flightInfo= new PrintWriter(f);

    //constructor
    public Seats()throws IOException{
        //initializing array
        seats = new boolean[ NUMBER_OF_SEATS ];

        //to set all the seats value to false
        for( int counter = 0; counter < seats.length; counter++ ){
            seats[ counter ] = false;

        }//end of loop
    }//end of constructor
    /**
     * This method will take a number from the user to choose between the first
     * or second seat and randomly reserve a seat.
     * Also, if the user chooses first class there will be an extra fee.
     * @param seatClass
     * @return the number of the seat
     * @throws IOException
     */

    public int assignSeats( int seatClass ) throws IOException{

        //write the extra fee in file to use it later in the receipt
        FileWriter fr = new FileWriter("firstClass.txt");//without true to turn off append mode
        PrintWriter pw= new PrintWriter(fr);

        if( seatClass == 1 ){

            for( int counter = 0; counter < seats.length / 2; counter++ ){
                //divide the number of seats length so the first class will have 5 seats

                //generate random number between 1 and 5 representing
                //the number of the seats that are in the first class
                firstSeat = 1 + randomNumbers.nextInt(5);

                //valid loop to check if the seat is already taken or not
                while(seats[ firstSeat - 1 ] == true||firstSeat== 1 + randomNumbers.nextInt(5)) {
                    //generate random number between 1 and 5 representing
                    //the number of the seats that are in the first class
                    firstSeat = 1 + randomNumbers.nextInt(5);
                }//end of loop
                seats[ firstSeat - 1 ] = true;
            }//end of loop

            //to write the extra fee in the "firstClass.txt" file
            pw.println(1000);
            pw.close();
            fr.close();
            choose= firstSeat;

            //to write the flight information in the "flightinfo.txt" file
            flightInfo.println("firstclass set number is:" + choose);
            flightInfo.close();


        }

        else if( seatClass == 2 ){


            for( int counter = 0; counter < seats.length / 2; counter++ ){
                //divide the number of seats length so the second class will have 5 seats

                //generates numbers between 6 and 10 representing
                //the number of the seats that are in the second class
                secondSeat = 6 + randomNumbers.nextInt(5);

                //valid loop to check if the seat is already taken or not
                while(seats[ secondSeat - 1 ] == true||secondSeat== 6 + randomNumbers.nextInt(5)) {
                    //generates numbers between 6 and 10 representing
                    //the number of the seats that are in the second class
                    secondSeat = 6 + randomNumbers.nextInt(5);
                }//end of loop

                seats[ secondSeat - 1 ] = true;

            }//end of loop
            choose= secondSeat;
            //to write the flight information in the "flightinfo.txt" file
            flightInfo.println("second class set number is:" + choose);
            flightInfo.close();

        }
        //return number of the seat
        return choose;

    }//end of the method
}//end of the class