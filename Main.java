import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        String FilePat = "";
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t\t\tBANK MANAGEMENT SYSTEM");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t===========================================================");
            System.out.println("\t\t\t\tPress 1 For user Login");
            System.out.println("\t\t\t\tPress 2 For Staff");
            System.out.println("\t\t\t\tPress 3 Exit");
            System.out.print("\t\t\t\tEnter your Choice : ");
            int choice = 3;
            if (sc.hasNextInt()) {

                choice = sc.nextInt();
            }
            else if(sc.hasNextLine()){
                System.out.println("\t\t\t\tWrong Input Enter Correct Choice");
                try {
                    System.in.read();
                } catch (Exception e) {

                }

            }

            loop: {
                if (choice == 1) {
                    boolean bool = true;
                    while (bool) {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        L1: {System.out.println("\t\t===========================================================");
                        System.out.println("\t\t===========================================================");
                        System.out.println("\t\t\t\t\tADMIN || USER");
                        System.out.println("\t\t===========================================================");
                        System.out.println("\t\t===========================================================");
                        System.out.println("\t\t\t\tPress 1 To Create New Account");
                        System.out.println("\t\t\t\tPress 2 To Search Account");
                        System.out.println("\t\t\t\tPress 3 To Edit Information");
                        System.out.println("\t\t\t\tPress 4 Go Back to Main Menu");
                        System.out.print("\t\t\t\tEnter Your Choice : ");
                        
                        int choice2 = 4;

                        if (sc.hasNextInt()) {

                            choice2 = sc.nextInt();
                        }
                        

                        if (choice2 == 1) {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            System.out.println("\t\t\t\t Create User Account...!");
                            System.out.print("\t\t\t\tEnter Your Name : ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            if (!name.matches("^[a-zA-Z\\s]*$")) {
                                System.out.println("\t\t\t\tName must be an Character");
                                System.out.println("\t\t\t\tEnter To return");
                                try {
                                    System.in.read();
                                } catch (Exception e) {
                                }
                                break L1;
                            }
                            System.out.print("\t\t\t\tEnter Your CNIC number : ");
                            String cnic = sc.nextLine();
                            if (cnic.matches("[a-zA-Z]+")) {
                                System.out.println("\t\t\t\tCNIC Must be Numbers!");
                                System.out.print("\t\t\t\tPress Enter to Continue");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            } else if (isValidateCNIC(cnic)) {
                                // System.out.println();

                            } else {
                                System.out.println("\t\t\t\tCNIC Must be 13 Digit only and must start with 3 and 4");
                                System.out.print("\t\t\t\tPress Enter To return!");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }
                            long cni = Long.parseLong(cnic);

                            // *********************************************************
                            Console console = System.console();
                            if (console == null) {
                                System.out.println("\t\t\t\tCouldn't get Console instance");
                                System.exit(0);
                            }

                            char[] passwordArr = console.readPassword("\t\t\t\tEnter Your Password!");
                            String passwor = new String(passwordArr);
                            if (passwor.matches("[a-zA-Z]+")) {
                                System.out.println("\t\t\t\tPassword Number Should be Digits!");
                                System.out.print("\t\t\t\tPress Enter to Continue");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }

                            Integer passcode = Integer.parseInt(passwor);

                            System.out.print("\t\t\t\tEnter Phone Number : ");
                            String number = sc.nextLine();

                            if (number.matches("[a-zA-Z]+")) {
                                System.out.println("\t\t\t\tPhone Number Should be Digits!");
                                System.out.print("\t\t\t\tPress Enter to Continue");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            } else if (isValidMobileNo(number)) {
                            } else {
                                System.out.print("\t\t\t\t\tNumber should be 11 digits");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }

                            long numbe = Long.parseLong(number);

                            // *********************************************************

                            System.out.print("\t\t\t\tEnter Your Gender (Male/Female) : ");
                            String gender = sc.nextLine();
                            if (!gender.matches("^[a-zA-Z\\s]*$")) {
                                System.out.println("\t\t\t\tEnter Data in Character");
                                System.out.print("\t\t\t\tPress Enter To Return");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }else if(!gender.matches("male|female")){
                                System.out.println("You didn't enter correct input");
                                try {
                                    System.in.read();
                                } catch (Exception e) {
                                    //TODO: handle exception
                                }
                                break L1;
                            }

                            System.out.print("\t\t\t\tEnter Your Account Type (Current/Saving) : ");
                            String AccType = sc.nextLine();
                            if (!AccType.matches("^[a-zA-Z\\s]*$")) {
                                System.out.println("\t\t\t\tEnter Data in Character");
                                System.out.print("\t\t\t\tPress Enter To Return");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }
                            else if(!AccType.matches("current|saving")){
                                System.out.println("You didn't enter correct input");
                                try {
                                    System.in.read();
                                } catch (Exception e) {
                                    //TODO: handle exception
                                }
                                break L1;
                            }

                            System.out.print("\t\t\t\tEnter Your Account ID (Must be Unique & only 4 digits) : ");
                            String accID = sc.nextLine();
                            File file1 = new File(FilePat + accID + ".txt");
                            if (file1.exists()) {
                                System.out.print("\t\t\t\tAccount Already Exist!");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }
                            if (accID.matches("[a-zA-Z]")) {
                                System.out.println("\t\t\t\tEnter Data in Digits");
                                System.out.print("\t\t\t\tPress Enter To Return");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }

                            long AccID = Long.parseLong(accID);

                            System.out.print("\t\t\t\tEnter Your address : ");
                            String address = sc.nextLine();
                            if (!address.matches("[a-zA-Z]+")) {
                                System.out.println("\t\t\t\tAddress Must be Characters!");
                                System.out.print("\t\t\t\tPress Enter to return");
                                try {
                                    System.in.read();
                                } catch (Exception e) {

                                }
                                break L1;
                            }

                            file.insert(name, cni, passcode, numbe, gender, AccID, AccType, address);
                            try {
                                file.message();
                               
                            } catch (Exception e) {

                            }
                            new file(name, cni, passcode, numbe, gender, AccType, AccID, address, FilePat);
                            file.delete();
                             System.out.print("\t\t\t\tPress Enter To Go To User Menu...!");
                                System.in.read();

                        } else if (choice2 == 2) {

                            System.out.print("\t\t\t\tEnter your Account id : ");
                            sc.nextLine();
                            String acount = sc.nextLine();
                            if (acount.matches("[a-zA-Z]+")) {
                                System.out.println("\t\t\t\tID must be uniquie digits!");
                                System.out.print("\t\t\t\tPress Enter to return");
                                try {
                                } catch (Exception e) {
                                    System.out.println("Data are Not Present!");
                                    System.in.read();
                                    break L1;
                                }
                            }
                            // long acc = Long.parseLong(acount);
                            File file = new File(FilePat + acount + ".txt");
                            if (file.exists()) {
                                Scanner dataReader = new Scanner(file);
                                String lMoeny = dataReader.nextLine();
                                Integer Login_moeny = Integer.parseInt(lMoeny);
                                String Login_name = dataReader.nextLine();
                                String Lcnic = dataReader.nextLine();
                                long Login_cnic = Long.parseLong(Lcnic);

                                String Password = dataReader.nextLine();
                                Integer password = Integer.parseInt(lMoeny);

                                String Phone_No = dataReader.nextLine();
                                long Mobile_No = Long.parseLong(Phone_No);

                                String Login_gender = dataReader.nextLine();
                                String Login_account = dataReader.nextLine();
                                String login_ID = dataReader.nextLine();
                                Integer Login_id = Integer.parseInt(login_ID);
                                String login_addres = dataReader.nextLine();
                                
                                    System.out.println("\t\t\t\t==============================");
                                    System.out.println("\t\t\t\t==============================");
                                    System.out.println("\t\t\t\tMoney: " + Login_moeny);
                                    System.out.println("\t\t\t\tName: " + Login_name);
                                    System.out.println("\t\t\t\tCNIC: " + Login_cnic);
                                    System.out.println("\t\t\t\tPassword: " + Password);
                                    System.out.println("\t\t\t\tPhone Number: " + Mobile_No);
                                    System.out.println("\t\t\t\tGender: " + Login_gender);
                                    System.out.println("\t\t\t\tAccount: " + Login_account);
                                    System.out.println("\t\t\t\tAccount ID: " + Login_id);
                                    System.out.println("\t\t\t\tAddress: " + login_addres);
                               
                                
                                    System.out.println("\t\t\t\t\tPress Enter To Continue!");
                                try {
                                   System.in.read(); 
                                } catch (Exception e) {
                                    //TODO: handle exception
                                }

                                dataReader.close();
                                break loop;
                            }
                            else{
                                try {
                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println();
                                    System.out.println("\t\t\t\tData are Not Present!");
                                    System.out.print("\t\t\t\tPress Enter to Go to Main Menu");
                                    // break L1;
                                    System.in.read();
                                    break L1;
                                } catch (Exception e) {
                                }

                            }
                        } else if(choice2 == 3) {
                            System.out.print("\t\t\t\tEnter Your Account ID : ");
                            int marzi = sc.nextInt();
                            File file = new File(FilePat + marzi + ".txt");
                            if (file.exists()) {

                            } else {
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.println("\t\t\t\tThis Account is not in our record!");
                                // break L1;

                                try {
                                    System.out.print("\t\t\t\tData are Not Present!");
                                    System.in.read();
                                    break L1;
                                } catch (Exception e) {
                                   
                                }

                            }
                            boolean bol = true;
                            while (bol) {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.println("\t\t\t\tWhat you want to change");
                                System.out.println("\t\t\t\t1.Name");
                                System.out.println("\t\t\t\t2.CNIC");
                                System.out.println("\t\t\t\t3.Password");
                                System.out.println("\t\t\t\t4.Number");
                                System.out.println("\t\t\t\t5.Address");
                                System.out.println("\t\t\t\t6.Exit");
                                System.out.print("\t\t\t\tEnter Your Choice : ");
                                int choice3 = sc.nextInt();

                                if (choice3 == 1) {
                                    Scanner dataReader = new Scanner(file);
                                    String lMoeny = dataReader.nextLine();
                                    Integer Login_moeny = Integer.parseInt(lMoeny);
                                    String Login_name = dataReader.nextLine();
                                    String Lcnic = dataReader.nextLine();
                                    long Login_cnic = Long.parseLong(Lcnic);

                                    String Password = dataReader.nextLine();
                                    Integer password = Integer.parseInt(lMoeny);

                                    String Phone_No = dataReader.nextLine();
                                    long Mobile_No = Long.parseLong(Phone_No);

                                    String Login_gender = dataReader.nextLine();
                                    String Login_account = dataReader.nextLine();
                                    String login_ID = dataReader.nextLine();
                                    Integer Login_id = Integer.parseInt(login_ID);
                                    String login_addres = dataReader.nextLine();

                                    System.out.print("\t\t\t\tEnter Your Name : ");
                                    sc.nextLine();
                                    String name1 = sc.nextLine();

                                    File file4 = new File(FilePat + marzi + ".txt");
                                    if (file4.exists()) {

                                        if (!name1.matches("^[a-zA-Z\\s]*$")) {
                                            System.out.println("\t\t\t\tName must be an Character");
                                            System.out.println("\t\t\t\tEnter To return");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {

                                            }
                                            break loop;
                                        }

                                        modifyFile(FilePat + marzi + ".txt", Login_name, name1);
                                    }
                                } else if (choice3 == 2) {
                                    Scanner dataReader = new Scanner(file);
                                    String lMoeny = dataReader.nextLine();
                                    Integer Login_moeny = Integer.parseInt(lMoeny);
                                    String Login_name = dataReader.nextLine();
                                    String Lcnic = dataReader.nextLine();
                                    long Login_cnic = Long.parseLong(Lcnic);

                                    String Password = dataReader.nextLine();
                                    Integer password = Integer.parseInt(lMoeny);

                                    String Phone_No = dataReader.nextLine();
                                    long Mobile_No = Long.parseLong(Phone_No);

                                    String Login_gender = dataReader.nextLine();
                                    String Login_account = dataReader.nextLine();
                                    String login_ID = dataReader.nextLine();
                                    Integer Login_id = Integer.parseInt(login_ID);
                                    String login_addres = dataReader.nextLine();
                                    System.out.print("\t\t\t\tEnter Your CNIC number : ");
                                    sc.nextLine();
                                    String cn = sc.nextLine();
                                    if (cn.matches("[a-zA-Z]+")) {
                                        System.out.println("\t\t\t\tCNIC Must be Numbers!");
                                        System.out.print("\t\t\t\tPress Enter to Continue");
                                        try {
                                            System.in.read();
                                        } catch (Exception e) {

                                        }
                                        break loop;
                                    } else if (isValidateCNIC(cn)) {
                                        System.out.println();

                                    } else {
                                        System.out.println(
                                                "\t\t\t\tCNIC Must be 13 Digit only and must start with 3");
                                        System.out.print("Press Enter To return!");
                                        try {
                                            System.in.read();
                                        } catch (Exception e) {

                                        }
                                        break L1;
                                    }
                                    // long cni = Long.parseLong(cn);
                                    modifyFile(FilePat + marzi + ".txt", Lcnic, cn);
                                }

                                // **************************************
                                else if (choice3 == 3) {
                                    File f1 = new File(FilePat + marzi + ".txt");
                                    try (Scanner dataReader1 = new Scanner(f1)) {
                                        
                                        String lMoeny = dataReader1.nextLine();
                                        Integer Login_moeny = Integer.parseInt(lMoeny);
                                        String Login_name = dataReader1.nextLine();
                                        String Lcnic = dataReader1.nextLine();
                                        long Login_cnic = Long.parseLong(Lcnic);
                                        String Password = dataReader1.nextLine();
                                        Integer password = Integer.parseInt(lMoeny);
                                        String Phone_No = dataReader1.nextLine();
                                        long Mobile_No = Long.parseLong(Phone_No);
                                        String Login_gender = dataReader1.nextLine();
                                        String Login_account = dataReader1.nextLine();
                                        String login_ID = dataReader1.nextLine();
                                        Integer Login_id = Integer.parseInt(login_ID);
                                        String login_addres = dataReader1.nextLine();
                                        Console con = System.console();
                                        if (con == null) {
                                            System.out.println("\t\t\t\t\tCouldn't get Console instance");
                                            System.exit(0);
                                        }

                                        char[] passwordArr = con.readPassword("\t\t\t\tEnter Your new Password!");
                                        String passwor = new String(passwordArr);

                                        modifyFile(FilePat + marzi + ".txt", Password, passwor);
                                        System.out.println("\t\t\t\tPassword is Successfully changed!");
                                        Integer passcode = Integer.parseInt(passwor);
                                        Stack s1 = new Stack();

                                        try {

                                            s1.Push(passcode);

                                            FileWriter f8 = new FileWriter(FilePat + marzi + ".txt", true);
                                            System.out.println("\t\t\t\tChanged Password!");
                                            SimpleDateFormat formatter = new SimpleDateFormat(
                                                    "dd/MM/yyyy HH:mm:ss");
                                            Date date = new Date();
                                            f8.write("\t\t\t\tNew Password is : " + passcode + " :: "
                                                    + formatter.format(date)
                                                    + " :: Changed!" + "\n");

                                            f8.close();
                                            // Stack s1 = new Stack();
                                            // s1.display();

                                            System.out.print("\n\t\t\t\tPress enter to continue");
                                            try {
                                                System.in.read();
                                                break L1;
                                            } catch (Exception e) {
                                            }

                                        } catch (Exception e) {

                                        }

                                    }
                                }
                                // **************************************

                                else if (choice3 == 4) {
                                    Scanner dataReader = new Scanner(file);
                                    String lMoeny = dataReader.nextLine();
                                    Integer Login_moeny = Integer.parseInt(lMoeny);
                                    String Login_name = dataReader.nextLine();
                                    String Lcnic = dataReader.nextLine();
                                    long Login_cnic = Long.parseLong(Lcnic);

                                    String Password = dataReader.nextLine();
                                    Integer password = Integer.parseInt(lMoeny);

                                    String Phone_No = dataReader.nextLine();
                                    long Mobile_No = Long.parseLong(Phone_No);

                                    String Login_gender = dataReader.nextLine();
                                    String Login_account = dataReader.nextLine();
                                    String login_ID = dataReader.nextLine();
                                    Integer Login_id = Integer.parseInt(login_ID);
                                    String login_addres = dataReader.nextLine();

                                    System.out.print("\t\t\t\tEnter Your New Phone Number : ");
                                    // Scanner scan = new Scanner(Syetem.in);
                                    sc.nextLine();
                                    String name1 = sc.nextLine();

                                    File file4 = new File(FilePat + marzi + ".txt");
                                    if (file4.exists()) {

                                        if (name1.matches("^[a-zA-Z\\s]*$")) {
                                            System.out.println("\t\t\t\tnumber should be in digits");
                                            System.out.println("\t\t\t\tEnter To return");
                                            try {
                                                System.in.read();
                                            } catch (Exception e) {

                                            }
                                            break L1;
                                        }

                                        modifyFile(FilePat + marzi + ".txt", Phone_No, name1);
                                    }
                                }

                                // **************************************

                                else if (choice3 == 5) {
                                    Scanner dataReader = new Scanner(file);
                                    String lMoeny = dataReader.nextLine();
                                    Integer Login_moeny = Integer.parseInt(lMoeny);
                                    String Login_name = dataReader.nextLine();
                                    String Lcnic = dataReader.nextLine();
                                    long Login_cnic = Long.parseLong(Lcnic);

                                    String Password = dataReader.nextLine();
                                    Integer password = Integer.parseInt(lMoeny);

                                    String Phone_No = dataReader.nextLine();
                                    long Mobile_No = Long.parseLong(Phone_No);

                                    String Login_gender = dataReader.nextLine();
                                    String Login_account = dataReader.nextLine();
                                    String login_ID = dataReader.nextLine();
                                    Integer Login_id = Integer.parseInt(login_ID);
                                    String login_addres = dataReader.nextLine();
                                    System.out.print("\t\t\t\tEnter Your address : ");
                                    sc.nextLine();

                                    String add = sc.nextLine();
                                    if (!add.matches("[a-zA-Z]+")) {
                                        System.out.println("\t\t\t\tAddress Must be Characters!");
                                        System.out.print("\t\t\t\tPress Enter to return");
                                        try {
                                            System.in.read();
                                        } catch (Exception e) {
                                        }
                                        break L1;

                                    }
                                    modifyFile(FilePat + marzi + ".txt", login_addres, add);
                                } else if (choice3 == 6) {
                                    try {
                                        System.out.print("\t\t\t\tPress Enter To Go to Main Menu");
                                        System.in.read();
                                    } catch (Exception e) {
                                    }
                                    break L1;

                                } else
                                    try {
                                        System.out.println("\t\t\t\tYou Entered Invalid Input...!");
                                        System.in.read();
                                    } catch (Exception e) {
                                    }
                                bol = false;
                                break L1;
                            }

                        } else if (choice2 == 4) {
                            break loop;
                        } else {
                            try {
                       new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.println("\t\t\t\t*******Invalid Input*******");
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.print("\t\t\t\tPress Enter! For For Go To Main Menu...");

                                System.in.read();
                                break L1;
                            } catch (Exception e) {
                                // TODO: handle exception
                            }
                        }

                        bool = false;
                    }

                    // end label loop

                    // while ka end

                    // ********************* Staff Menu ******************
                }
                } else if (choice == 2) {
                    

                    
                    // Scanner scany = new Scanner(System.in);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("\t\t===========================================================");
                    System.out.println("\t\t===========================================================");
                    System.out.println("\t\t\t\t\tADMIN || USER");
                    System.out.println("\t\t===========================================================");
                    System.out.println("\t\t===========================================================");
                    System.out.println("\t\t\t\t1.Check Account Info");
                    System.out.println("\t\t\t\t2.Deposit Money");
                    System.out.println("\t\t\t\t3.With Draw Money");
                    System.out.println("\t\t\t\t4.REturn to main menu");
                    System.out.print("\t\t\t\tEnter Your Choice : ");
                    int ask = 4;
                    if(sc.hasNextInt()){
                        ask = sc.nextInt();
                    }
                    
                    L2:{
                    if (ask == 1) {

                        System.out.print("\t\t\t\tEnter your Account Id : ");
                        sc.nextLine();
                        String acounty = sc.nextLine();
                        if (acounty.matches("[a-zA-Z]+")) {
                            System.out.println("\t\t\t\tID must be uniquie digits!");
                            System.out.print("\t\t\t\tPress Enter to return");
                            try {
                                System.in.read();
                            } catch (Exception e) {

                            }
                            break L2;
                        }
                        // long acc = Long.parseLong(acount);
                        File file = new File(FilePat + acounty + ".txt");
                        if (file.exists()) {
                            Scanner dataReader = new Scanner(file);
                            String lMoeny = dataReader.nextLine();
                            Integer Login_moeny = Integer.parseInt(lMoeny);
                            String Login_name = dataReader.nextLine();
                            String Lcnic = dataReader.nextLine();
                            long Login_cnic = Long.parseLong(Lcnic);

                            String Password = dataReader.nextLine();
                            Integer password = Integer.parseInt(lMoeny);

                            String Phone_No = dataReader.nextLine();
                            long Mobile_No = Long.parseLong(Phone_No);

                            String Login_gender = dataReader.nextLine();
                            String Login_account = dataReader.nextLine();
                            String login_ID = dataReader.nextLine();
                            Integer Login_id = Integer.parseInt(login_ID);
                            String login_addres = dataReader.nextLine();

                            System.out.println("\t\t\t\tMoney: " + Login_moeny);
                            System.out.println("\t\t\t\tName: " + Login_name);
                            System.out.println("\t\t\t\tCNIC: " + Login_cnic);
                            System.out.println("\t\t\t\tPassword: " + Password);
                            System.out.println("\t\t\t\tPhone Number: " + Mobile_No);
                            System.out.println("\t\t\t\tGender: " + Login_gender);
                            System.out.println("\t\t\t\tAccount: " + Login_account);
                            System.out.println("\t\t\t\tAccount ID: " + Login_id);
                            System.out.println("\t\t\t\tAddress: " + login_addres);
                            dataReader.close();
                            try {
                                System.out.println("\t\t\t\tPress Enter to Go to Main Menu");
                                System.in.read();
                            } catch (Exception e) {
                            }
                        }else{
                            try {
                                System.out.println("\t\t\t\tInvalid Account ID or ID are Not Matched...!");
                                System.out.print("\t\t\t\tPress Enter To Go Back");
                                System.in.read();
                            } catch (Exception e) {
                            }
                            break L2;
                        }
                        

                        // ***** Deposite *****
                    } else if (ask == 2) {
                        System.out.print("\t\t\t\tEnter your Account ID : ");
                        int acn = sc.nextInt();
                        System.out.print("\t\t\t\t\tEnter Amount to Deposit(Limit : 50,000) : ");
                        int amount = sc.nextInt();
                        // Validation
                        if (amount < 0 || amount > 50000) {
                            System.out.println("\t\t\t\t\tEnter correct amount !");
                            System.out.print("\n\t\t\t\t\tPress enter to continue");
                            try {
                                System.in.read();
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                File file12 = new File(FilePat + acn + ".txt");
                                Scanner dataReader = new Scanner(file12);

                                String lMoeny = dataReader.nextLine();
                                Integer Login_moeny = Integer.parseInt(lMoeny);
                                String Login_name = dataReader.nextLine();
                                String Lcnic = dataReader.nextLine();
                                long Login_cnic = Long.parseLong(Lcnic);

                                String Password = dataReader.nextLine();
                                Integer password = Integer.parseInt(lMoeny);

                                String Phone_No = dataReader.nextLine();
                                long Mobile_No = Long.parseLong(Phone_No);

                                String Login_gender = dataReader.nextLine();
                                String Login_account = dataReader.nextLine();
                                String login_ID = dataReader.nextLine();
                                Integer Login_id = Integer.parseInt(login_ID);
                                String login_addres = dataReader.nextLine();
                                // Open file, Replace original amount with updated with time also
                                FileWriter f0 = new FileWriter(FilePat + acn + ".txt", true);
                                String old_money = Integer.toString(Login_moeny);
                                Login_moeny += amount;
                                int temp = amount;
                                String to_be_deposited = Integer.toString(Login_moeny);
                                modifyFile(FilePat + acn
                                        + ".txt", old_money, to_be_deposited);

                                SimpleDateFormat formatter = new SimpleDateFormat(
                                        "dd/MM/yyyy HH:mm:ss");
                                Date date = new Date();
                                f0.write("\t\t\t\t\tRs.(+" + temp + ") :: " + formatter.format(date)
                                        + " :: Self Deposit " + "\n");

                                System.out.println("\t\t\t\t\tRs. " + temp + " Deposited !");

                                System.out.print("\n\t\t\t\t\tPress enter to continue");
                                try {
                                    System.in.read();
                                } catch (Exception e) {
                                }

                                f0.close();
                            } catch (IOException e) {
                                System.out.println("\t\t\t\t\tUser Data not found !");
                                e.printStackTrace();
                            }
                        }

                        // **** WithDraw Amount ****
                    } else if (ask == 3) {

                        System.out.print("\t\t\t\tEnter your Account ID : ");
                        int acnd = sc.nextInt();
                        File file3 = new File(FilePat + acnd + ".txt");
                        Scanner dataReader89 = new Scanner(file3);
                        String lMoeny = dataReader89.nextLine();
                        Integer Login_moeny = Integer.parseInt(lMoeny);
                        String Login_name = dataReader89.nextLine();
                        String Lcnic = dataReader89.nextLine();
                        long Login_cnic = Long.parseLong(Lcnic);

                        String Password = dataReader89.nextLine();
                        Integer password = Integer.parseInt(lMoeny);

                        String Phone_No = dataReader89.nextLine();
                        long Mobile_No = Long.parseLong(Phone_No);

                        String Login_gender = dataReader89.nextLine();
                        String Login_account = dataReader89.nextLine();
                        String login_ID = dataReader89.nextLine();
                        Integer Login_id = Integer.parseInt(login_ID);
                        String login_addres = dataReader89.nextLine();
                        System.out.print(
                                "\t\t\t\t\tEnter Amount to Withdraw : (Limit : 0 to " + Login_moeny + ") : ");
                        int amount_withdraw = sc.nextInt();
                        // Validation
                        if (amount_withdraw < 0 || amount_withdraw > Login_moeny) {
                            System.out.println("\t\t\t\t\tEnter correct amount !");
                            System.out.print("\n\t\t\t\t\tPress enter to continue");
                            try {
                                System.in.read();
                            } catch (Exception e) {
                            }
                        } else {
                            try {

                                FileWriter f0 = new FileWriter(FilePat + acnd + ".txt", true);
                                String old_money = Integer.toString(Login_moeny);
                                Login_moeny -= amount_withdraw;
                                int temp1 = amount_withdraw;
                                String to_be_withdrawed = Integer.toString(Login_moeny);
                                modifyFile(FilePat + acnd + ".txt", old_money,
                                        to_be_withdrawed);

                                SimpleDateFormat formatter = new SimpleDateFormat(
                                        "dd/MM/yyyy HH:mm:ss");
                                Date date = new Date();
                                f0.write("\t\t\t\t\tRs.(-" + temp1 + ") :: " + formatter.format(date)
                                        + " :: Self Withdraw" + "\n");

                                System.out.println("\t\t\t\t\tRs. " + temp1 + " Withdrawed !");

                                System.out.print("\n\t\t\t\t\tPress enter to continue");
                                try {
                                    System.in.read();
                                    break L2;
                                } catch (Exception e) {
                                }

                                f0.close();
                            } catch (IOException e) {
                                System.out.println("\t\t\t\t\tUser Data not found !");
                                e.printStackTrace();
                            }
                        }

                    } else {
                        break loop;
                    }
                }
                } else if (choice == 3) {
                    System.out.println("\n\t\t\t\t\t***** Thank you for using Bank Services *****");
                    
                   
                } else {
                   
                        System.out.println();
                        System.out.println();
                        System.out.println("\t\t\t\t*******Invalid Input*******");
                        System.out.println();
                        System.out.println();
                        System.out.print("\t\t\t\tPress Enter! For For Go To Main Menu...");
                        try {
                        System.in.read();
                        
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    break loop;
                    

                }
                sc.close();
                b = false;

            }
        }
    }

    static void modifyFile(String filePath, String oldString, String newString) {
        // File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        // FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            // Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();

                line = reader.readLine();
            }
            // Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceFirst(oldString, newString);

            // Rewriting the input text file with newContent
            new FileWriter(filePath, false).close();
            FileWriter writer = new FileWriter(filePath);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Closing the resources
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isValidMobileNo(String str) {

        // (0/91): number starts with (0/92)
        // [3]: starting of the number may only contain a digit 3
        // [0-9]: then contains digits 0 to 9
        Pattern ptrn = Pattern.compile("(0|92)?[3][0-9]{9}");

        Matcher match = ptrn.matcher(str);

        return (match.find() && match.group().equals(str));
    }

    public static boolean isValidateCNIC(String str) {

     
        Pattern ptrn = Pattern.compile("[3][0-9]{12}");

        Matcher match = ptrn.matcher(str);

        return (match.find() && match.group().equals(str));
    }

}
