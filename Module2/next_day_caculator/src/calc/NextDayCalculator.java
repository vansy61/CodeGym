package calc;

public class NextDayCalculator {
    public int[] calculator(int day, int month, int year) {

        int daysInMonth;

        if(month == 2 && isLeapYear(year)) {
            daysInMonth = 29;
        }else {
            switch (month) {
                case 2:
                    daysInMonth = 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    daysInMonth = 30;
                    break;
                default:
                    daysInMonth = 31;
            }
        }

        if(day < daysInMonth) {
            day++;
        }else {
            day = 1;
            month++;
        }

        if(month > 12) {
            month = 1;
            year++;
        }

        return new int[]{day, month, year};
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }
}
