
import java.util.*;
class A {
    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] dbmsBest(int dbmMarks[]) {
        int[] ir = new int[id.length];
        int n = 0;
        for (int k = id.length - 1; k > 0; k--) {

            for (int j = 0; j < k; j++) {
                ir[j] = dbmsMarks[j]; //ASSIGN PRF MARKS TO IR ARRAY.

                if (ir[j] < ir[j + 1]) { //CHECK WHAT IS THE BIG VALUE.
                    int tem = ir[j]; //BIG VALUE ASSIGN TO TEM.
                    ir[j] = ir[j + 1];
                    ir[j + 1] = tem;
                }
            }
        }
        return ir;
    }

    public static int[] prfBest(int prfMarks[], int x) {
        int[] temp = new int[id.length];
        int n = 0;
        for (int k = id.length - 1; k > 0; k--) {
            for (int j = 0; j < k; j++) {
                temp[j] = prfMarks[j]; //ASSIGN PRF MARKS TO TEMP ARRAY.

                if (temp[j] < temp[j + 1]) { //CHECK WHAT IS THE BIG VALUE.
                    int tem = temp[j]; //BIG VALUE ASSIGN TO TEM.
                    temp[j] = temp[j + 1];
                    temp[j + 1] = tem;
                }
            }
        }
        return temp;
    }

    public static int findDuplicate(String temp) {
        for (int i = 0; i < 100; i++) {
            if (temp.equals(id[i])) { //FIND DUPLICATE.
                return i;
            }
        }
        return -1;
    }

    public static int[] findTotal(int[] prfMarks, int[] dbmsMarks) {
        int[] total = new int[id.length];
        for (int i = 0; i < id.length; i++) {
            total[i] = prfMarks[i] + dbmsMarks[i]; //GET TOTAL.
        }
        return total;

    }

    public static int findIndex(int tot[], int x) {
        int[] ar = new int[tot.length]; //MAKE ARRAY ar AND ITS LENGTH IS tot ARRAY.
        int n = 0;
        for (int i = ar.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                ar[j] = tot[j]; //TOT ARRAY VALUE ASSIGN TO AR ARRAY.
                if (ar[j] < ar[j + 1]) { //CHECK WHAT VALUE IS BIG.
                    int temp = ar[j]; //BIG VALUE ASSIGN TO TEMP.
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
        for (int k = 0; k < tot.length - 1; k++) {
            if (ar[k] == tot[x]) {
                return k + 1;// VALUES ARA SAME AND SECOND VALUE RANK +1.
            }
        }
        return n;//This is fake return
    }

    public static void printBestInDbms(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks, int[] newDbms) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                    BEST IN DATABASE MANAGEMENT SYSTEM                                      |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();

        System.out.println("+------+------------+-------------+-----------+");
        System.out.print("|ID    ");
        System.out.print("| Name       ");
        System.out.print("| DBMS.marks  ");
        System.out.println("|PF.marks   |");
        System.out.println("+------+------------+-------------+-----------+");
        for (int i = 0; i < id.length - 1; i++) {
            while (id[i] != null) {
                String temp = id[i];
                int x = findDuplicate(temp);
                if (dbmsMarks[x] == 0 && prfMarks[x] == 0) {
                    continue;
                } else {
                    newDbms = dbmsBest(dbmsMarks);
                    System.out.print("|" + id[x] +"     ");
                    System.out.print("|" + name[x] +"          ");
                    System.out.print("|   " + newDbms[x] +"        ");
                    System.out.println("|" + prfMarks[x] +"         |");

                    break;
                }
            }
        }
        System.out.println("+------+------------+-------------+-----------+");
        System.out.print("Do you want to go back to main menu ? (Y/N):");

        String reply = scanner.next();
        if (reply.equals("Y") || reply.equals("y")) {
            clearConsole();
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println("|                                    BEST IN DATABASE MANAGEMENT SYSTEM                                      |");
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println();
        } else {
            clearConsole();
            homePage();
        }
    }

    public static void printBestInPrf(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks, int[] newarray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                    BEST IN PROGRAMMING FUNDAMENTALS                                        |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();

        System.out.println("+---------+-------------+-----------+--------------+");
        System.out.print("| ID      ");
        System.out.print("| Name        ");
        System.out.print("| PF.marks  ");
        System.out.println("|  DBMS.marks  |");
        System.out.println("+---------+-------------+-----------+--------------+");


        for (int i = 0; i < id.length - 1; i++) {
            while (id[i] != null) {//This is for stop null element in array
                String temp = id[i];
                int x = findDuplicate(temp);
                if (prfMarks[x] == 0 && dbmsMarks[x] == 0) {
                    continue;
                } else {
                    newarray = prfBest(prfMarks, x);
                    System.out.print("| " + id[x]+"       ");
                    System.out.print("| " + name[x]+"          ");
                    System.out.print("| " + newarray[x]+"        ");
                    System.out.println("| " + dbmsMarks[x]+"           |");
                    break;
                }
            }
        }
        System.out.println("+---------+-------------+-----------+--------------+");
        System.out.print("Do you want to go back to main menu ? (Y/N):");
        String reply = scanner.next();
        if (reply.equals("Y") || reply.equals("y")) {
            clearConsole();
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println("|                                    BEST IN PROGRAMMING FUNDAMENTALS                                        |");
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println();
        } else {
            clearConsole();
            homePage();
        }
    }

    public static void printStudentRanks(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                       PRINT STUDENT RANKS                                                  |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();

        int count = 0;
        System.out.println("+---------------+---------------+---------------+---------------+------------+");
        System.out.print("|Rank           ");
        System.out.print("|ID             ");
        System.out.print("|Name           ");
        System.out.print("|Total          ");
        System.out.println("|Avg.marks   |");
        System.out.println("+---------------+---------------+---------------+---------------+------------+");

        int c = 1;

        for (int i = 0; i < id.length - 1; i++) {
            while (id[i] != null) { //This is for stop null element in array
                String temp = id[i];
                int x = findDuplicate(temp);
                tot = findTotal(prfMarks, dbmsMarks);
                double avg = tot[x] / 2;
                int index = findIndex(tot, x);
                System.out.print("|" + index);
                System.out.print("\t\t|" + id[i] + "\t");
                System.out.print("\t|" + name[i] + "\t");
                System.out.print("\t|" + tot[x] + "\t");
                System.out.println("\t|" + avg + "        |");
                break;
            }
        }
        System.out.println("+---------------+---------------+---------------+---------------+------------+");
        System.out.print("Do you want to go back to main menu ? (Y/N):");
        String reply = scanner.next();
        if (reply.equals("Y") || reply.equals("y")) {
            clearConsole();
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println("|                                       PRINT STUDENT RANKS                                                  |");
            System.out.println("______________________________________________________________________________________________________________");
            System.out.println();
        } else {
            clearConsole();
            homePage();
        }
    }

    public static void printStudentDetail(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                        PRINT STUDENT DETAILS                                               |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        for (int i = 0; i < id.length - 1; i++) {
            System.out.print("Enter Student Id : ");
            String temp = scanner.next();
            int x = findDuplicate(temp); //SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE.
            if (x != -1) {
                System.out.println("Student Name  : " + name[x]);
                System.out.println();
                if (prfMarks[x] == 0 & dbmsMarks[x] == 0) { // MARKS WILL BE 0 THEN PRINT YET TO BE ADDED.
                    System.out.print("Marks yet to be added");
                    System.out.println();
                    System.out.print("\nThis student's marks yet to be added.\n Do you want to search the marks of another student ? (Y/N):");
                    String reply = scanner.next();
                    if (reply.equals("Y") || reply.equals("y")) {
                        clearConsole();
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println("|                                        PRINT STUDENT DETAILS                                               |");
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println();
                        continue;
                    } else {
                        clearConsole();
                        homePage();
                    }
                } else {
                    System.out.println(" +-----------------------------------+--------------------+");
                    System.out.println(" | Programming Fundamental Marks     |    "+ prfMarks[x]+"              |");
                    System.out.println(" | Database Management System Marks  |    "+ dbmsMarks[x]+"              |");
                    tot = findTotal(prfMarks, dbmsMarks);
                    double avg = tot[x] / 2;
                    System.out.println(" | total                             |    "+ tot[x]+"             |");
                    System.out.println(" | Avg.marks                         |    "+ avg+"            |");
                    int index = findIndex(tot, x);

                    String one[] = { " ", " First", " Second", " Third", " Fourth", " Fifth", " Sixth", " Seventh", " Eighth", " Nineth", " Ten",
                            " Eleven", " Twelve", " Thirteen", " Fourteen", "Fifteen", " Sixteen", " Seventeen", " Eighteen",
                            " Nineteen" };
                    String ten[] = { " ", " ", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", "Seventy", " Eighty", " Ninety" };

                    if (index > 19){
                        System.out.println(" | Rank                              |    "+"("+ index+ten[index / 10] + " " + one[index % 10]+")"+"               |");
                    }else{
                        System.out.println(" | Rank                              |    "+ index+"  ("+one[index]+")"+"       |");
                    }
                    System.out.println(" +-----------------------------------+--------------------+");
                    System.out.println();
                    System.out.print("Do you want to search the marks of another student ? (Y/N):");
                    String reply = scanner.next();
                    if (reply.equals("Y") || reply.equals("y")) {
                        clearConsole();
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println("|                                        PRINT STUDENT DETAILS                                               |");
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println();
                        continue;
                    } else {
                        clearConsole();
                        homePage();
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do You Want to search again (Y/N)\t:");
                String reply = scanner.next();
                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                        PRINT STUDENT DETAILS                                               |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();
                }
            }
        }
    }

    public static void deleteStudent(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                             DELETE STUDENT                                                 |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.print("Enter Student Id : ");
            String temp = scanner.next();
            int x = findDuplicate(temp);//SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE.
            if (x != -1) {
                System.out.println();
                id[x] = null;
                name[x] = null;
                prfMarks[x] = 0;
                dbmsMarks[x] = 0;
                System.out.print("Student has been deleted successfully\nDo you want to delete another student ?(Y/N)");
                String reply = scanner.next();
                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();

                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                             DELETE STUDENT                                                 |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();
                }
            } else {
                System.out.print("Invalid Student ID. Do You Want to search again (Y/N)\t:");
                String reply = scanner.next();
                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();

                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                             DELETE STUDENT                                                 |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();
                }
            }
        }
    }

    public static void updateMarks(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                               UPDATE MARKS                                                 |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        for (int i = 0; i < id.length - 1; i++) {
            System.out.print("Enter Student Id : ");
            String temp = scanner.next();
            int x = findDuplicate(temp); //SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE.
            if (x != -1) { //IF NAME IS ADD AND ITS CHANGED.
                System.out.println("Student Name  : " + name[x]);
                System.out.println();
                if (prfMarks[x] == 0 & dbmsMarks[x] == 0) { //PRFMARKS AND DBMSMARKS EQUAL TO 0.
                    System.out.print("\nThis student's marks yet to be added.\n Do you want to update the marks of another student ? (Y/N)\t:");
                    String reply = scanner.next();
                    if (reply.equals("Y") || reply.equals("y")) {
                        clearConsole();
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println("|                                               UPDATE MARKS                                                 |");
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println();
                        continue;
                    } else {
                        clearConsole();
                        homePage();
                    }

                } else {
                    System.out.println("Programming Fundamental Marks : " + prfMarks[x]);
                    System.out.println("Database Management System Marks : " + dbmsMarks[x]);
                    System.out.println();
                    boolean p = true;
                    while (p) { //PRF MARKS CHECK CORRECT.
                        System.out.println();
                        System.out.print("Enter New Programming Fundamental Marks :  ");
                        prfMarks[x] = scanner.nextInt();

                        if (prfMarks[x] > 100 || prfMarks[x] < 0) {
                            System.out.print("Invalid marks please enter correct marks ");
                            System.out.println();
                            p = true;
                        } else {
                            p = false;

                            boolean d = true;
                            while (d) { //DBMS MARKS CHECK CORRECT.
                                System.out.print("Enter new Database Management System Marks : ");
                                dbmsMarks[x] = scanner.nextInt();

                                if (dbmsMarks[x] > 100 || dbmsMarks[x] < 0) {
                                    System.out.print("Invalid marks please enter correct marks ");
                                    System.out.println();
                                    d = true;
                                } else {
                                    d = false;
                                }
                            }
                        }
                    }

                    System.out.print("Mark have been updated successfully.\n Do you want to update marks for another student ? (Y/N)\t:");
                    String want1 = scanner.nextLine();
                    String reply = scanner.next();
                    if (reply.equals("Y") || reply.equals("y")) {
                        clearConsole();
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println("|                                               UPDATE MARKS                                                 |");
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println();
                        continue;
                    } else {
                        clearConsole();
                        homePage();
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do You Want to search again (Y/N)\t:");
                String reply = scanner.next();
                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                               UPDATE MARKS                                                 |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();
                }
            }
        }
    }

    public static void updateDetails(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                       UPDATE STUDENT DETAILS                                               |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        for (int i = 0; i < id.length - 1; i++) {
            System.out.print("Enter Student Id : ");
            String temp = scanner.next();
            int x = findDuplicate(temp); //SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE.
            if (x != -1) { //IF NAME IS ADD AND ITS CHANGED.
                System.out.println("Student Name: " + name[x]);
                System.out.print("Enter new student name : ");
                name[x] = scanner.next(); //ADD NEW NAME TO THAT INDEX.
                System.out.print("Student detail has been updated successfully.\nDid you want to update another student detail?(Y/N)");
                String reply = scanner.next();
                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                       UPDATE STUDENT DETAILS                                               |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();
                }
            } else {
                System.out.print("Invalid Student Id. Do You Want To Search Again ?(Y/N)\t:");
                String reply = scanner.next();
                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                       UPDATE STUDENT DETAILS                                               |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();

                }
            }
        }
    }

    public static void addMarks(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                               ADD MARKS                                                    |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();

        for (int i = 0; i < id.length - 1; i++) {
            System.out.print("Enter Student Id : ");
            String temp = scanner.next();
            int x = findDuplicate(temp); //SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE.

            if (x == -1) {
                System.out.print("Invalid Student Id. Do You Want To Search Again ?(Y/N)\t:");
                String reply = scanner.next();

                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();

                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                               ADD MARKS                                                    |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();

                }

            } else {
                System.out.println("Student Name: " + name[x]);
                if (prfMarks[x] != 0) { // WE ADD MARKS HAVE NOT BEEN 0 THEN PRINT MARKS ALREADY ADDED.
                    System.out.println("This Student's marks have been already added.\nIf you want to update the marks,please use [4] update marks option \n");
                    System.out.print("Do you want to add marks for another Student ? (Y/N)\t");
                    String reply = scanner.next();

                    if (reply.equals("Y") || reply.equals("y")) {
                        clearConsole();

                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println("|                                               ADD MARKS                                                    |");
                        System.out.println("______________________________________________________________________________________________________________");
                        System.out.println();
                        continue;
                    } else {
                        clearConsole();
                        homePage();

                    }
                }
                boolean c = true;
                while (c) {
                    System.out.println();
                    System.out.print("Enter Programming Fundamental Marks : ");
                    prfMarks[i] = scanner.nextInt();

                    if (prfMarks[i] > 100 || prfMarks[i] < 0) { // MARKS HAVE BEEN UNDER 100 AND UPPER THAN 0.
                        System.out.print("Invalid marks please enter correct marks ");
                        System.out.println();

                        c = true;

                    } else {
                        c = false;

                        boolean a = true;
                        while (a) {
                            System.out.print("Enter Database Management System Marks :  ");
                            dbmsMarks[i] = scanner.nextInt();

                            if (dbmsMarks[i] > 100 || dbmsMarks[i] < 0) { // MARKS HAVE BEEN UNDER 100 AND UPPER THAN 0.
                                System.out.print("Invalid marks please enter correct marks ");
                                System.out.println();

                                a = true;

                            } else {
                                a = false;

                            }
                        }
                    }
                }

                System.out.print("Mark have been added. Do you want to add marks for another student? (Y/N)\t");
                String reply = scanner.next();

                if (reply.equals("Y") || reply.equals("y")) {
                    clearConsole();

                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println("|                                               ADD MARKS                                                    |");
                    System.out.println("______________________________________________________________________________________________________________");
                    System.out.println();
                    continue;
                } else {
                    clearConsole();
                    homePage();

                }

            }
        }
    }

    public static void addNewStudentWithMark(String[] id, String[] name, int[] prfMarks, int[] dbmsMarks) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                     ADD NEW STUDENT WITH MARKS                                             |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        for (int i = 0; i < id.length - 1; i++) {
            System.out.print("Enter Student Id : ");
            String temp = scanner.next();
            int x = findDuplicate(temp); //SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE.
            if (x == -1) { // IF ID IS NOT DUPLICATE.
                id[i] = temp;
                System.out.print("Enter Student Name : ");
                name[i] = scanner.next();

                boolean p = true;
                while (p) {
                    System.out.println();
                    System.out.print("Enter Programming Fundamental Marks : ");
                    prfMarks[i] = scanner.nextInt();
                    if (prfMarks[i] > 100 || prfMarks[i] < 0) { // MARKS HAVE BEEN UNDER 100 AND UPPER THAN 0.
                        System.out.print("Invalid marks please enter correct marks ");
                        System.out.println();
                        p = true;
                    } else {
                        p = false;

                        boolean d = true;
                        while (d) {
                            System.out.print("Enter Database Management System Marks :  ");
                            dbmsMarks[i] = scanner.nextInt();
                            if (dbmsMarks[i] > 100 || dbmsMarks[i] < 0) { // MARKS HAVE BEEN UNDER 100 AND UPPER THAN 0.
                                System.out.print("Invalid marks please enter correct marks ");
                                System.out.println();
                                d = true;
                            } else {
                                d = false;
                            }
                        }
                        System.out.print("Student has added been successfully. Do you want to added a new student(Y/N ): ");
                        String reply = scanner.next();
                        if (reply.equals("Y") || reply.equals("y")) {
                            clearConsole();
                            System.out.println("______________________________________________________________________________________________________________");
                            System.out.println("|                                     ADD NEW STUDENT WITH MARKS                                             |");
                            System.out.println("______________________________________________________________________________________________________________");
                            System.out.println();
                            continue;
                        } else {
                            clearConsole();
                            homePage();
                        }
                    }
                }
            } else {
                System.out.println("The Student ID Already Exists");
            }
        }
    }

    public static String[] addNewStudent(String[] id, String[] name) {
        Scanner scanner = new Scanner(System.in);
        String[] newArray = new String[id.length + 1];
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                                            ADD NEW STUDENT                                                 |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        while (true) {
            int count = 0;
            for (int i = 0; i < id.length - 1; i++) {
                System.out.print("Enter Student Id : ");
                String temp = scanner.next();
                if (id.length == count) {
                    newArray[i] = id[i];//INCREASE LENGTH INDEX AS ARRAY ID.

                } else {
                    int x = findDuplicate(temp);//SEND TO THE findDuplicate METHOD FOR CHECK DUPLICATE
                    count++;

                    if (x == -1) {  // IF ID IS NOT DUPLICATE.
                        id[i] = temp;
                        System.out.print("Enter Student Name : ");
                        name[i] = scanner.next();
                        System.out.print("Student has added been successfully. Do you want to added a new student(Y/N ): ");
                        String reply = scanner.next();
                        if (reply.equals("Y") || reply.equals("y")) {
                            clearConsole();

                            System.out.println("______________________________________________________________________________________________________________");
                            System.out.println("|                                            ADD NEW STUDENT                                                 |");
                            System.out.println("______________________________________________________________________________________________________________");
                            System.out.println();
                            continue;
                        } else {
                            clearConsole();
                            homePage();
                        }
                    } else { // ID IS DUPLICATE AND PRINT THIS.
                        System.out.println("The Student ID Already Exists");
                    }
                }
            }
            count++;
            id = newArray; // ASSIGN NEWARRAY VALUE FOR ARRAY ID.
            return id;
        }
    }
    static String[] id = new String[100];
    static String[] name = new String[id.length];
    static int[] prfMarks = new int[id.length];
    static int[] dbmsMarks = new int[id.length];
    static int[] tot = new int[id.length];
    static int[] newarray = new int[id.length];
    static int[] newDbms = new int[id.length];

    public static void homePage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println("|                               WELCOME TO GDSE MARKS MANAGEMENT SYSTEM                                      |");
        System.out.println("______________________________________________________________________________________________________________");
        System.out.println();
        System.out.print("[1] Add New Student                  ");
        System.out.println("\t\t\t[2] Add New Student With Marks");
        System.out.print("[3] Add Marks                        ");
        System.out.println("\t\t\t[4] Update Student Details");
        System.out.print("[5] Update Marks                     ");
        System.out.println("\t\t\t[6] Delete Student");
        System.out.print("[7] Print Student Details            ");
        System.out.println("\t\t\t[8] Print Student Ranks");
        System.out.print("[9] Best in programming Fundamentals");
        System.out.println("\t\t\t[10] Best in Database Management Systems");
        System.out.println();
        System.out.print("Enter and option to continue > ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                clearConsole();
                id = addNewStudent(id, name);
                break;
            case 2:
                clearConsole();
                addNewStudentWithMark(id, name, prfMarks, dbmsMarks);
                break;
            case 3:
                clearConsole();
                addMarks(id, name, prfMarks, dbmsMarks);
                break;
            case 4:
                clearConsole();
                updateDetails(id, name, prfMarks, dbmsMarks);
                break;
            case 5:
                clearConsole();
                updateMarks(id, name, prfMarks, dbmsMarks);
                break;
            case 6:
                clearConsole();
                deleteStudent(id, name, prfMarks, dbmsMarks);
                break;
            case 7:
                clearConsole();
                printStudentDetail(id, name, prfMarks, dbmsMarks);
                break;
            case 8:
                clearConsole();
                printStudentRanks(id, name, prfMarks, dbmsMarks);
                break;
            case 9:
                clearConsole();
                printBestInPrf(id, name, prfMarks, dbmsMarks, newarray);
                break;
            case 10:
                clearConsole();
                printBestInDbms(id, name, prfMarks, dbmsMarks, newarray);
                break;
        }
    }

    public static void main(String[] args) {
        homePage();
    }
}
