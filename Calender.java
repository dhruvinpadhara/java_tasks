import java.util.Scanner;

public class Calender {
    // Write a program that produces calendars as output.
    // Your program should have a method that outputs a single month's calendar like
    // the one below,
    // given parameters to specify how many days are in the month and
    // what the date of the first Sunday is in that month. In the month shown below,
    // these values are 31 and 6, respectively.

    // Author : Dhruvin Padhara
    // Get Month from user and print it with get first sunday of month date and total number of date in month

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter month like Jan,Feb,Mar");
        String month = scanner.nextLine();
        System.out.println("please enter start day of month like Sun,Mon,Tue");
        String startDay = scanner.nextLine();
        prepareMonth(month, startDay, scanner);

    }

    public static void prepareMonth(String month, String startDay, Scanner scanner) {
        int dateLength = getNumberOFDate(month);
        System.out.println("date number : " + dateLength);
        System.out.println("please enter date between space");
        int space = scanner.nextInt();
        String days[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        int startDayNumber = getStartDayNumber(days, startDay);
        prepareHeaderOfDays(space, days);
        System.out.println("------------------------------------------------------------------------------------");
        preapareCalenderOfMonth(startDayNumber, dateLength, space);
    }

    private static int getNumberOFDate(String month) {
        int numberOfDays = 0;
        if (month.equals("Jan") || month.equals("Mar") || month.equals("May") ||
                month.equals("Jul") || month.equals("Aug") || month.equals("Oct") || month.equals("Dec")) {
            numberOfDays = 31;
        } else if (month.equals("Jun") || month.equals("Sep") || month.equals("Nov") || month.equals("Apr")) {
            numberOfDays = 30;
        } else if (month.equals("Feb")) {
            numberOfDays = 28;
        }
        return numberOfDays;
    }

    private static int getStartDayNumber(String[] days, String startDay) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(startDay)) {
                return i + 1;
            }
        }
        return 0;
    }

    private static void prepareHeaderOfDays(int space, String[] days) {

        for (int day = 0; day < days.length; day++) {
            if (day == 0) {
                System.out.print("|");
            }
            setSpace(space);
            System.out.print(days[day]);
            setSpace(space);
            System.out.print("|");
        }
        System.out.println("");
    }

    private static void preapareCalenderOfMonth(int startDayNumber, int dateLength, int space) {
        boolean isStartDatePrinted = false;
        int printNewLineNumber = 0;
        int firstSundayInMonth = 0;  
        for (int date = 1; date <= dateLength; date++) {

            if (date == 1) {
                System.out.print("|");
            }
            if (!isStartDatePrinted) {
                int totalSpace = ((space * 2) + 3) * startDayNumber;
                setSpace(totalSpace);
                System.out.print(date);
                setSpace(space + 1);
                isStartDatePrinted = true;
            } else {
                setSpace(space);
                System.out.print(date);
                if (date < 10) {
                    setSpace(space + 1);
                } else {
                    setSpace(space);
                }
            }
            // }
            System.out.print("|");
            if (printNewLineNumber == 0) {
                printNewLineNumber = 7 - startDayNumber + 1;
                firstSundayInMonth = printNewLineNumber + 1;
                // System.out.println("printNewLineNumber :"+printNewLineNumber);
            }
            printNewLine(printNewLineNumber, date);
        }
        System.out.println("\nFirst sunday in month date is :"+ firstSundayInMonth);
        System.out.println("Number of Dates in Month :"+ dateLength);
    }

    private static void printNewLine(int printNewLineNumber, int date) {

        int dayDifference = date - printNewLineNumber;

        // System.out.print("dayDifference : "+ dayDifference);

        if (printNewLineNumber == date) {
            System.out.println();
            System.out.print("|");
        } else if ((dayDifference % 7 == 0)) {
            System.out.println();
            System.out.print("|");
        }
    }

    private static void setSpace(int space) {
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
    }
}
