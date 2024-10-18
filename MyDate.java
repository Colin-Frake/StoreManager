package assignment1.items;

public class MyDate {
    private int day;
    private int month;
    private int year;
    public static int[] SUMMER_MONTHS = {6, 7, 8, 9};
    public static int[] WINTER_MONTHS = {12,1, 2, 3};
    public MyDate(int d, int m, int y) {
        this.year = y;
        if (0 < d && m > 0 && m < 13 && y >= 0) {
            if (d < 32 && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)) {
                this.day = d;
                this.month = m;
            }
            else if (d < 31 && (m == 4 || m == 6 || m == 9 || m == 11)) {
                this.day = d;
                this.month = m;
            }
            else if (d < 29 || m == 2) {
                this.day = d;
                this.month = m;
            }
            else {
                throw new IllegalArgumentException("Invalid Date");
            }
        }
        else {
            throw new IllegalArgumentException("Invalid Date");
        }
    }

    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    public boolean equals(Object input) {
        if (input instanceof MyDate) {
            MyDate input2 = (MyDate)input;
            if (this.day == input2.getDay()) {
                if (this.month == input2.getMonth()) {
                    if (this.year == input2.getYear()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static MyDate today() {
        String date = java.time.LocalDate.now().toString();
        int d = Integer.parseInt(date.substring(8));
        int m = Integer.parseInt(date.substring(5,7));
        int y = Integer.parseInt(date.substring(0,4));
        MyDate tdy = new MyDate(d, m, y);
        return tdy;

    }
}
