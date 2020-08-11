package demo.factory.statics;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CanlenderDemo {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        Calendar instance1 = Calendar.getInstance(TimeZone.getDefault());
        Calendar instance2 = Calendar.getInstance(Locale.CHINA);
        Calendar instance3 = Calendar.getInstance(TimeZone.getDefault(), Locale.CHINA);
    }
}
