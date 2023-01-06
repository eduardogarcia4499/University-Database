import java.sql.*;
import java.util.Scanner;

public class ConnectionToDbServerInsertAndDisplay {

        public static void main (String[]args){

            Connection conn = null;

            try {
                conn =
                        DriverManager.getConnection("jdbc:mysql://66.99.14.31:3306/FL22CS315_skylarkooyenga?serverTimezone=UTC&" +
                                "user=skylarkooyenga&password=skooyengafl22");

                Statement stmt = conn.createStatement();

                //String sql = "INSERT INTO Course VALUES (40477369, 'You', 'Are', 'Crazy@YOLO.gov')";
                //stmt.executeUpdate(sql);

                System.out.println("Insert Into Course Table 1  ");
                System.out.println("Insert Into Enrollment Table 2  ");
                System.out.println("Insert Into Student Table 3  ");
                System.out.println("Insert Into Teacher Table 4  ");
                System.out.println("View Course Table 5");
                System.out.println("View Enrollment Table 6");
                System.out.println("View Student Table 7");
                System.out.println("View Teacher Table 8");

                System.out.print('\n' + "Please select a database or view a table by entering a number above: ");

                Scanner kbd = new Scanner(System.in);
                int select = kbd.nextInt();

                switch (select) {
                    case 1 -> {
                        System.out.println('\n' + "Inserting records into the Course table...");

                        System.out.print("Enter a Course ID Number: ");
                        int CourseIDNum = kbd.nextInt();

                        System.out.print("Enter a subject: ");
                        String subject = kbd.nextLine();

                        if (kbd.hasNextLine()) {
                            subject = kbd.nextLine();

                        }

                        System.out.print("Enter meeting days for the class: ");
                        String meetingDays = kbd.nextLine();

                        System.out.print("Enter the start time for the class: ");
                        String startingTime = kbd.nextLine();

                        System.out.print("Enter the end time for the class: ");
                        String endingTIME = kbd.nextLine();

                        System.out.print("Enter the Teacher ID number: ");
                        int TeacherIDNum = kbd.nextInt();

                        String sql = "INSERT INTO Course VALUES (" + CourseIDNum + ", '" + subject + "', '" + meetingDays + "', '" + startingTime + "', '" + endingTIME + "', '" + TeacherIDNum + "')";

                        stmt.executeUpdate(sql);

                    }
                    case 2 -> {

                        System.out.println('\n' + "Inserting records into the Enrollment table...");

                        System.out.print("Enter a Course ID Number: ");
                        int CourseIDNum = kbd.nextInt();

                        System.out.print("Enter a Student ID number: ");
                        int StudentIDNum = kbd.nextInt();

                        String sql2 = "INSERT INTO Enrollment VALUES (" + CourseIDNum + ", '" + StudentIDNum + "' )";
                        stmt.executeUpdate(sql2);
                    }
                    case 3 -> {

                        System.out.println('\n' + "Inserting records into the Student table...");

                        System.out.print("Enter a Student ID Number: ");
                        int StudentIDNum = kbd.nextInt();

                        System.out.print("Enter a First Name: ");
                        String fName = kbd.next();

                        System.out.print("Enter a Last Name: ");
                        String lName = kbd.next();

                        System.out.print("Enter an email address: ");
                        String email = kbd.next();

                        System.out.print("Enter a major: ");
                        String major = kbd.nextLine();
                        if (kbd.hasNextLine()) {
                            major = kbd.nextLine();

                        }

                        String sql3 = "INSERT INTO Student VALUES (" + StudentIDNum + ", '" + fName + "' , '" + lName + "', '" + email + "', '" + major + "')";
                        stmt.executeUpdate(sql3);
                    }
                    case 4 -> {

                        System.out.println('\n' + "Inserting records into the Teacher table...");

                        System.out.print("Enter a Teacher ID Number: ");
                        int TeacherIDNum = kbd.nextInt();

                        System.out.print("Enter a First Name: ");
                        String fName = kbd.next();

                        System.out.print("Enter a Last Name: ");
                        String lName = kbd.next();

                        System.out.print("Enter an email address: ");
                        String email = kbd.next();

                        System.out.print("Enter a Phone Number: ");
                        String phoneNo = kbd.nextLine();
                        if (kbd.hasNextLine()) {
                            phoneNo = kbd.nextLine();

                            phoneNo = phoneNo.replace(' ', '-');
                        }

                        String sql4 = "INSERT INTO Teacher VALUES (" + TeacherIDNum + ", '" + fName + "' , '" + lName + "', '" + email + "', '" + phoneNo + "')";
                        stmt.executeUpdate(sql4);
                    }
                    default -> {
                        String wrongString = ('\n' + "Please select a valid number and run the program again");
                        System.out.println(wrongString);
                    }

                    case 5 -> {

                        System.out.println("\n" + "Displaying the records from the Course table...");

                        String sql1 = "Select * FROM Course"; //SQL Statement

                        ResultSet rs = stmt.executeQuery(sql1);

                        while(rs.next()) {

                            ResultSetMetaData rsmd = rs.getMetaData();
                            int numberOfColumns = rsmd.getColumnCount();
                            int rowCount = 1;
                            while (rs.next()) {
                                System.out.println("Row " + rowCount + ":  ");
                                for (int i = 1; i <= numberOfColumns; i++) {

                                    System.out.print("   Column " + i + ":  ");

                                    System.out.println(rs.getString(i));

                                }

                                System.out.println("");
                                rowCount++;

                            }

                            System.out.println("Restart program to view options again");
                        }

                        rs.close();

                    }

                    case 6 -> {

                        System.out.println("\n" + "Displaying the records from the Enrollment table...");

                        String sql2 = "Select * FROM Enrollment"; //SQL Statement

                        ResultSet rs2 = stmt.executeQuery(sql2);

                        while(rs2.next()) {

                            ResultSetMetaData rsmd = rs2.getMetaData();
                            int numberOfColumns = rsmd.getColumnCount();
                            int rowCount = 1;
                            while (rs2.next()) {
                                System.out.println("Row " + rowCount + ":  ");
                                for (int i = 1; i <= numberOfColumns; i++) {
                                    System.out.print("   Column " + i + ":  ");
                                    System.out.println(rs2.getString(i));

                                }

                                System.out.println("");
                                rowCount++;

                            }

                            System.out.println("Restart program to view options again");
                        }

                        rs2.close();

                    }

                    case 7 -> {

                        System.out.println("\n" + "Displaying the records from the Student table...");

                        String sql3 = "Select * FROM Student"; //SQL Statement

                        ResultSet rs3 = stmt.executeQuery(sql3);

                        while(rs3.next()) {

                            ResultSetMetaData rsmd = rs3.getMetaData();
                            int numberOfColumns = rsmd.getColumnCount();
                            int rowCount = 1;
                            while (rs3.next()) {
                                System.out.println("Row " + rowCount + ":  ");
                                for (int i = 1; i <= numberOfColumns; i++) {
                                    System.out.print("   Column " + i + ":  ");
                                    System.out.println(rs3.getString(i));

                                }

                                System.out.println("");
                                rowCount++;

                            }

                            System.out.println("Restart program to view options again");
                        }

                        rs3.close();

                    }

                    case 8 -> {

                        System.out.println("\n" + "Displaying the records from the Teacher table...");

                        String sql4 = "Select * FROM Teacher"; //SQL Statement

                        ResultSet rs4 = stmt.executeQuery(sql4);

                        while(rs4.next()) {

                            ResultSetMetaData rsmd = rs4.getMetaData();
                            int numberOfColumns = rsmd.getColumnCount();
                            int rowCount = 1;
                            while (rs4.next()) {
                                System.out.println("Row " + rowCount + ":  ");
                                for (int i = 1; i <= numberOfColumns; i++) {
                                    System.out.print("   Column " + i + ":  ");
                                    System.out.println(rs4.getString(i));

                                }

                                System.out.println("");
                                rowCount++;

                            }

                            System.out.println("Restart program to view options again");
                        }

                        rs4.close();

                    }
                }

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }
    }
