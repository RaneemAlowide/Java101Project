package com.company;

import java.io.*; //to use FileWriter, BufferedWriter and PrintWriter classes
import java.util.*; //to use Scanner,arraylist,arraylist classes

public class Main {
    public static void main( String[] args ) throws IOException{

        final long Max_Id = 999999999;
        final long Min_Id = 100000000;

        // to print out the project header
        System.out.println("");
        System.out.println("       --------------------------------");
        System.out.println("      |    welcome to The traveller    |");
        System.out.println("       --------------------------------");
        System.out.println("                       _\r\n"
                + "                     -=\\`\\\r\n"
                + "                 |\\ _\\\\__\r\n"
                + "               -=\\`\"\"\"\"\"\"\" \"`)\r\n"
                + "                  `~~/ /~`\r\n"
                + "                    -==/ /\r\n"
                + "                      '-'");

        System.out.println("                                     _\r\n"
                + "                                    (  )\r\n"
                + "     _ .                         ( `  ) . )\r\n"
                + "   (  _ )_                      (, _(  ,)_)\r\n"
                + " (_  ( ,)");
        System.out.println("");
        System.out.println("");

        int choice = 1;
        Scanner info = new Scanner(System.in); //scanner object for the user to enter there choice

        //start the do while loop
        do {


            //print out the options for the passenger

            System.out.println("          Choose the required servise:"+"\n"+
                    "\n      1)book a flight          \t2)change a flight time/day"+
                    "\n      3)delete account          \t4)cancel a flight"+
                    "\n      5)print out flight details "+
                    "\n      6)exit");
            System.out.println("     --------------------------------------------------------");

            int choice1= info.nextInt();

            switch(choice1){ //start switch statement

                //case one is for the user to book a flight
                case 1:

                    //to write in file
                    FileWriter f= new FileWriter("flightinfo.txt",true);
                    PrintWriter flightInfo= new PrintWriter(f);
                    flightInfo.println();
                    flightInfo.println();
                    flightInfo.println("New booking!!");
                    flightInfo.println();


                    // creat an object from passenger class
                    Passenger passenger1 = new Passenger();
                    //creat an object from flight to pass the information
                    Flight passengerInfo = new Flight();

                    //ask user to enter fullname
                    System.out.println("Enter your first and last name:");
                    String firstName = info.nextLine();
                    String lastName = info.nextLine();
                    passenger1.setFullName(firstName, lastName);
                    passengerInfo.setFullName(firstName, lastName);

                    //ask user to enter ID number
                    System.out.println("Enter your ID:"+
                            "(reminder: the ID number must contain 9 digits)");
                    long ID = info.nextLong();
                    while(ID>Max_Id||ID<Min_Id) {//while loop (valid loop)
                        System.out.println("invalid input");
                        ID = info.nextLong();
                    }//end while loop

                    passenger1.setID(ID);
                    passengerInfo.setID(ID);

                    //ask user to enter phone number
                    System.out.println("Enter your phone number:" +
                            "(reminder: the phone number must contain 9 digits)" +
                            "\nremider: +966*********");
                    long phone = info.nextInt();
                    while(phone>Max_Id||phone<Min_Id) {//while loop (valid loop)
                        System.out.println("invalid input");
                        phone = info.nextLong();
                    }//end while lopp

                    passenger1.setPhoneNumber(phone);
                    passengerInfo.setPhoneNumber(phone);

                    //ask user to enter age
                    System.out.println("Enter your age");
                    int age = info.nextInt();
                    passenger1.setAge(age);
                    passengerInfo.setAge(age);


                    //create an object from class Seats
                    Seats seatingPlan = new Seats();
                    //creat an object from scanner class
                    Scanner keyboard = new Scanner(System.in);
                    //ask user to enter there choice
                    System.out.println("Enter:" + "1)First Class  or  2)Second class");
                    int action= keyboard.nextInt();

                    while (action>2) {//while loop (valid loop)
                        System.out.println("wrong choice!");
                        //ask user to enter there choice
                        System.out.println("Enter:" + "1)First Class  or  2)Second class");
                        action= keyboard.nextInt();
                    }//end while loop
                    System.out.println( "your seat is "+(seatingPlan.assignSeats(action))); //print seat number


                    System.out.println("Enter:" + "1)Around trip or 2)on-way trip");
                    int theWay= keyboard.nextInt();
                    while (theWay>2) {//while loop (valid loop)
                        System.out.println("wrong choice!");
                        //ask user to enter there choice
                        System.out.println("Enter:" + "1)Around trip or 2)on-way trip");
                        theWay= keyboard.nextInt();
                    }//end while lopp

                    //creat an object from Flight class
                    Flight way=new Flight();
                    way.chooseTheWay(theWay);


                    //ask user to enter year,month,day of flight
                    System.out.println("Enter the year of the flight you want to book");
                    int year = keyboard.nextInt();
                    System.out.println("Enter the month of the flight you want to book");
                    int month = keyboard.nextInt();
                    System.out.println("Enter the day of the flight you want to book");

                    //new object from Flight class with (args) for the date method
                    int day = keyboard.nextInt();
                    Flight date = new Flight(year, month, day);
                    //convert the numbers from int to string
                    System.out.println(date.toString());


                    //use the array list to ask user to choose the time of the flight
                    ArrayList<String> menuTime = new ArrayList<>(Arrays.asList("1) 6:00 AM", "2) 9:00 AM", "3) 12:00 PM ", "4) 3:00 PM"));
                    System.out.println(menuTime);
                    System.out.println();

                    //ask user to enter there choice
                    System.out.println("Enter your choice:");

                    int time = keyboard.nextInt();
                    while (time>4) {//while loop (valid loop)
                        System.out.println("wrong choice!");
                        System.out.println(menuTime);
                        System.out.println();
                        System.out.println("Enter your choice:");
                        time = keyboard.nextInt();
                    }//end while loop

                    //create an object from Flight class for the time method
                    Flight theTime = new Flight();
                    theTime.flightTime(time);

                    //var for the payment
                    double afterTaxOnly = 0.0;
                    double afterTax = 0.0;
                    double afterDiscount = 0.0;
                    double amount = 0.0;

                    int sum=0;
                    int sum2=0;
                    int sum3=0;

                    //creat a file for destenation payment
                    File file=new File("destenation.txt");
                    //creat an object from scanner class for file
                    Scanner scanner=new Scanner (file);

                    while(scanner.hasNext()) { //while loop to read file
                        sum+= scanner.nextInt();
                    }//end while

                    //creat a file for firstclass payment
                    File file2=new File("firstClass.txt");
                    //creat an object from scanner class for file
                    Scanner scanner2=new Scanner (file2);

                    while(scanner2.hasNext()) {//while loop to read file
                        sum2+= scanner2.nextInt();
                    }//end while

                    //creat a file for aroundtrip payment
                    File file3=new File("aroundTrip.txt");
                    //creat an object from scanner class for file
                    Scanner scanner3=new Scanner (file3);

                    while(scanner3.hasNext()) {//while loop to read file
                        sum3+= scanner3.nextInt();
                    }//end while


                    if( (passengerInfo.isMemberShip())==true){ //if statement for membership
                        if (sum3!=0) { //if statement
                            //the price before everything
                            System.out.println("the price before tax and discount: $ "+((sum+sum2)*sum3));
                            System.out.println();
                            afterDiscount=(((sum+sum2)*sum3)-(0.30)*((sum+sum2)*sum3));
                            //the price after the discount
                            System.out.println("the price after the discount: $ "+afterDiscount);
                            System.out.println();
                            //the tax value
                            System.out.println("the value-added tax: %15");
                            System.out.println();

                            //tax*discount
                            afterTax=1.15*afterDiscount;
                            //total amount after tax
                            amount =afterTax;
                        }//end if

                        else {//else

                            //the price before everything
                            System.out.println("the price before tax and discount: $ "+(sum+sum2));
                            System.out.println();
                            afterDiscount=((sum+sum2)-(0.30)*(sum+sum2));
                            //the price after the discount
                            System.out.println("the price after the discount: $ "+afterDiscount);
                            System.out.println();

                            //tax amount
                            System.out.println("the value-added tax: %15");
                            System.out.println();

                            //tax*discount
                            afterTax=1.15*afterDiscount;
                            //total amount after tax
                            amount =afterTax;
                        }

                    } //end if

                    else { //start else

                        if (sum3!=0) {//if statement
                            //the price before everything
                            System.out.println("the price before tax: $ "+((sum+sum2)*sum3));
                            System.out.println();

                            //tax amount
                            System.out.println("the value-added tax: %15");
                            System.out.println();

                            afterTaxOnly=1.15*(((sum+sum2)*sum3));
                            //total amount after tax
                            amount =afterTaxOnly;

                        }//end if
                        else {//else
                            //the price before everything
                            System.out.println("the price before tax: $ "+(sum+sum2));
                            System.out.println();

                            //tax amount
                            System.out.println("the value-added tax: %15");
                            System.out.println();

                            afterTaxOnly=1.15*(sum+sum2);
                            //total amount after tax
                            amount =afterTaxOnly;
                        }//end else

                    }//end else

                    scanner.close();
                    scanner2.close();
                    scanner3.close();

                    //call for passengerInformation to store the passenger info
                    passengerInfo.passengerInformation();

                    //print out amount
                    System.out.println("total amount is: $ "+ amount);
                    System.out.println();
                    System.out.println("your flight has been booked succefully"+
                            "\nthank you for choosing THE TRAVELLER");
                    System.out.println();



                    flightInfo.close();
                    break;  //end first case

                case 2: //start second case tot change flight time or date

                    //ask user to enter choice
                    System.out.println("enter what you need to change:"+
                            "\n1)flight time"+"\n2)flight date");

                    //creat an object from Scanner class
                    Scanner change = new Scanner(System.in);
                    int ch = change.nextInt();
                    while(ch>2) {//while loop (valid loop)
                        System.out.println("wrong choice!");
                        System.out.println("enter what you need to change:"+
                                "\n1)flight time"+"\n2)flight date");
                        ch = change.nextInt();
                    }//end while

                    if (ch==1){ //change time
                        ArrayList<String> menuTime2 = new ArrayList<>(Arrays.asList("1) 6:00 AM", "2) 9:00 AM", "3) 12:00 PM ", "3) 3:00 PM"));
                        System.out.println(menuTime2);
                        System.out.println("Enter your choice:");
                        int time2 = change.nextInt();

                        while (time2>4) {//while loop (valid loop)
                            System.out.println("wrong choice!");
                            System.out.println(menuTime2);
                            System.out.println("");
                            System.out.println("Enter your choice:");
                            time2 = change.nextInt();
                        }//end while

                        //create an object from Flight class for the time method
                        Flight theTime2 = new Flight();
                        theTime2.flightTime(time2);
                        System.out.println("your flight time has been changed");

                    }//end if
                    else if(ch==2){ //else if
                        //ask user to enter the new date for flight
                        System.out.println("Enter the year of the flight you want to book");
                        int year2 = change.nextInt();
                        System.out.println("Enter the month of the flight you want to book");
                        int month2 = change.nextInt();
                        System.out.println("Enter the day of the flight you want to book");

                        //new object from Flight class with for the date method
                        int day2 = change.nextInt();
                        Flight date2 = new Flight(year2, month2, day2);
                        //convert the numbers from integer to string
                        System.out.println(date2.toString());
                    } //end else if
                    break;
                    //end second case

                case 3: //start third case to delete passenger info

                    //create an object from scanner class
                    Scanner enter = new Scanner(System.in);
                    //ask user to enter id
                    System.out.println("please enter your id:");
                    String id = enter.nextLine();
                    //cancel passenger info
                    cancel(id);
                    break;
                    //end third case

                case 4: //start case four to cancel flight

                    cancel("flightinfo");
                    break;
                    //end case four

                case 5: //start case five to print flight info

                    //creat file for flight info
                    File fileRead = new File("flightinfo.txt");

                    //read from file if file exists
                    if(fileRead.exists()) {
                        Scanner inputfile2 = new Scanner(fileRead);
                        while (inputfile2.hasNext()){//while loop to read from file
                            String str = inputfile2.nextLine();
                            System.out.println(str);
                        }//end while
                        inputfile2.close();
                    }//end if
                    else {//start else
                        System.out.println("wronge input please try again");
                        System.out.println("this user did not book a flight yet!");
                    }//end else

                    //creat a printWriter
                    PrintWriter pw= new PrintWriter("flightinfo.txt");
                    pw.print("");

                    pw.close();

                    break;
                    //end case five

                case 6: //start case six to exit project
                    choice = 0;
                    break;
                    //end case six

                default: //default if the user choice is wrong
                    System.out.println("wronge choise please try again!!");
                    System.out.println();
                    choice=1;

            }//end switch

            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++");


        }while(choice != 0); //end do while loop

     }//end main method

    /**
     * this method is for the cancel flight case
     * @param file
     */
    public static void cancel(String file) {

        //creat a file
        File myFile = new File(file+".txt");
        //creat an object from Scanner class
        Scanner enter = new Scanner(System.in);

        if(myFile.exists()) { //if statement tot test if file exists
            String cancelFlight;

            //ask user to enter yes or no
            System.out.println("are you sure you want to cancel it?"+ "(answer with *yes* or *no*)");
            cancelFlight= enter.nextLine();

            if(cancelFlight.toLowerCase().equals("yes")){ //if user enter is equal to yes

                if (myFile.delete()) { //delete file
                    System.out.println("Your request has been fulfilled "+
                            "\nthank you for choosing THE TRAVELLER");
                    System.out.println("___");
                }//end if
            }//end if

            else if (cancelFlight.toLowerCase().equals("no"))//if user enter is equal to no
            {
                System.out.println("thank you for choosing THE TRAVELLER");
                System.out.println("___");
            }//end else if

            else{ //else
                System.out.println("wronge choise please try again");

            }//end else

        }//end if
        else { //else
            System.out.println("wronge input please try again");
            System.out.println("this user did not book a flight yet!");
        }//end else

    }//end cancel method

}