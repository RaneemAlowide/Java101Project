/*
 * This class has all the information about destinations such as
 * if its domestic or international and store it in files
 */
package com.company;

import java.io.*;//to use FileWriter, BufferedWriter and PrintWriter classes
import java.util.*;//to use ArrayList, Arrays and Scanner


public class Destenation {

    public final int DOMISTIC=1;
    public final int INTERNATIONAL=2;
    private ArrayList<String> domisticCity;
    private ArrayList<String> internationalCity;
    private boolean city1;
    private boolean city2;
    private boolean city3;
    private boolean city4;
    private String choose;

    //to write the flight information in a file
    private FileWriter f= new FileWriter("flightinfo.txt",true);
    private PrintWriter flightInfo= new PrintWriter(f);

    //constructor
    public Destenation()throws IOException{

        //set the values of the following variables to false
        city1=false;
        city2=false;
        city3=false;
        city4=false;

        //set the values of the choose to null
        choose=null;
    }

    /**
     * This method is for choosing if the trip is domestic or international flight
     * @param place
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void assignPlace(int place) throws IOException {

        //write the price of certain place in file to use it later in the receipt
        FileWriter fw=new FileWriter("destenation.txt");//without true to turn off append mode
        PrintWriter pw= new PrintWriter(fw);
        flightInfo.print("your flight will be from, to:");

        if(place==DOMISTIC) {
            System.out.println("choose from where to where");

            for(int count=1;count<3;count++) {//replay it twice to choose two places from and to where
                domisticCity= new ArrayList<>(Arrays.asList("Jeddah","Yanbu","Al Riyadh","Makkah"));
                System.out.println(domisticCity);


                do {

                    Scanner keyboard=new Scanner(System.in);
                    int index= keyboard.nextInt();
                    //read from the user there choice

                    switch(index-1) {
                        case 0:
                            if (city1==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=domisticCity.get(0);
                            city1=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(360);
                            pw.close();
                            fw.close();
                            //to write the flight information in the "flightinfo.txt" file
                            flightInfo.print(" " + choose);

                            break;
                        case 1:
                            if (city2==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=domisticCity.get(1);
                            city2=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(460);
                            pw.close();
                            fw.close();
                            //to write the flight information in the "flightinfo.txt" file
                            flightInfo.print(" " + choose);
                            break;
                        case 2:
                            if (city3==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=domisticCity.get(2);
                            city3=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(100);
                            pw.close();
                            fw.close();
                            //to write the flight information in the "flightinfo.txt" file
                            flightInfo.print(" " + choose);
                            break;

                        case 3:
                            if (city4==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=domisticCity.get(3);
                            city4=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(200);
                            pw.close();
                            fw.close();
                            //to write the flight information in the "flightinfo.txt" file
                            flightInfo.print(" " + choose);
                            break;
                        default:
                            System.out.println("wrong choice");
                            break;
                    }
                }while(choose==null);//to make sure its not null


                System.out.println(choose);


            }
            flightInfo.print("\n");
            flightInfo.close();
        }
        if(place==INTERNATIONAL) {
            System.out.println("choose from where to where");

            for(int count=1;count<3;count++) {//replay it twice to choose two places from and to where
                internationalCity= new ArrayList<>(Arrays.asList("Dubai","kuwait","Egypt","Lebanon"));
                System.out.println(internationalCity);
                String choose = null;
                do {
                    Scanner keyboard=new Scanner(System.in);
                    int index= keyboard.nextInt();
                    //read from the user there choice

                    switch(index-1) {
                        case 0:
                            if (city1==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=internationalCity.get(0);
                            city1=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(2400);
                            pw.close();
                            fw.close();

                            flightInfo.print(" " + choose);
                            break;
                        case 1:
                            if (city2==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=internationalCity.get(1);
                            city2=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(4300);
                            pw.close();
                            fw.close();

                            flightInfo.print(" " + choose);
                            break;
                        case 2:
                            if (city3==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=internationalCity.get(2);
                            city3=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(3000);
                            pw.close();
                            fw.close();

                            //to write the flight information in the "flightinfo.txt" file
                            flightInfo.print(" " + choose);
                            break;
                        case 3:
                            if (city4==true) {//validation
                                System.out.println("can not choose the same city you are in");
                                count=1;//to restart the loop
                            }
                            choose=internationalCity.get(3);
                            city4=true;//change it to true so the user can not choose the same city
                            //to write the flight information in the "destenation.txt" file
                            pw.println(2000);
                            pw.close();
                            fw.close();

                            //to write the flight information in the "flightinfo.txt" file
                            flightInfo.print(" " + choose);
                            break;
                        default:
                            System.out.println("wrong choice");
                            break;
                    }
                }while(choose==null);//to make sure its not null


                System.out.println(choose);


            }
            flightInfo.print("\n");
            flightInfo.close();
        }


    }

}