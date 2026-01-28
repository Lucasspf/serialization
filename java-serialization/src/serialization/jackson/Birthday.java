package serialization.jackson;

public class Birthday {
    private int day;
    private int month;
    private int year;

    public Birthday(){}

    public Birthday(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
