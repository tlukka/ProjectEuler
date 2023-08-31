import java.util.Hashtable;

public class Problem19 {


    public static void main(String[] args) {
        System.out.println("Number of Mondays between 1901 to 2000 is " + countOfMondayBetweenYears(1901, 2000, 1));
        System.out.println("Number of Mondays between 1901 to 2000 is " + countOfMondayBetweenYearsBF(1902, 2000, 0));
    }

    // Use Constants for Months
    public static final int JAN = 0;
    public static final int FEB = 1;
    public static final int MAR = 2;
    public static final int APR = 3;
    public static final int MAY = 4;
    public static final int JUN = 5;
    public static final int JUL = 6;
    public static final int AUG = 7;
    public static final int SEP = 8;
    public static final int OCT = 9;
    public static final int NOV = 10;
    public static final int DEC = 11;

    // Use Constants for Days
    public static final int SUN = 0;
    public static final int MON = 1;
    public static final int TUE = 2;
    public static final int WED = 3;
    public static final int THU = 4;
    public static final int FRI = 5;
    public static final int SAT = 6;


    static int countOfMondayBetweenYearsBF(int startYear, int endYear, int countDay) {
        if (endYear < 0 || startYear < 0 || startYear > endYear)
            throw new IllegalArgumentException("Invalid inputs");
        int countOfMonday = 0;
        Hashtable<Integer, Integer> dayTable = new Hashtable<Integer, Integer>();
        dayTable.put(JAN, 31);
        dayTable.put(FEB, 28);
        dayTable.put(MAR, 31);
        dayTable.put(APR, 30);
        dayTable.put(MAY, 31);
        dayTable.put(JUN, 30);
        dayTable.put(JUL, 31);
        dayTable.put(AUG, 31);
        dayTable.put(SEP, 30);
        dayTable.put(OCT, 31);
        dayTable.put(NOV, 30);
        dayTable.put(DEC, 31);

        // 1/1/00 is the first day
        int currMonth = JAN;
        int currDayOfMonth = 1;
        int currDay = MON;
        int currYear = startYear;
        while (currYear <= endYear) {
            if (currDay == countDay && currDayOfMonth == 1 && currYear != 1900) {
                countOfMonday++;
            }
            int monthDayTotal = dayTable.get(currMonth);
            if (currMonth == FEB && Utility.isLeapYear(currYear)) {
                monthDayTotal++;
            }

            currDay = (currDay + 1) % 7;
            currDayOfMonth++;
            if (currDayOfMonth > monthDayTotal) {
                if (currMonth == DEC) {
                    currYear++;
                }
                currDayOfMonth = 1;
                currMonth = (currMonth + 1) % 12;
            }
        }
        return countOfMonday;
    }


    static int countOfMondayBetweenYears(int startYear, int endYear, int countDay) {
        if (endYear < 0 || startYear < 0 || startYear > endYear)
            throw new IllegalArgumentException("Invalid inputs");
        int countOfMonday = 0;
        for (int y = startYear; y <= endYear; y++)
            for (int m = 1; m <= 12; m++) {
                if (dayOfWeekBySakamoto(y, m, countDay) == 0)
                    countOfMonday++;

            }
        return countOfMonday;
    }

    // Sakamoto's methods
    static int dayOfWeekBySakamoto(int y, int m, int d) {
        // The value of e is obtained from the following table:
        //m ->	1	2	3	4	5	6	7	8	9	10	11	12
        //e ->	0	3	2	5	0	3	5	1	4	6	2	4

        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4}; // https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
        if (m < 3)
            y -= 1;
        return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
    }
}
