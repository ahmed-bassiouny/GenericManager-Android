package bassiouny.ahmed.genericmanager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by bassiouny on 24/03/18.
 */

public class DateTimeManager {

    public static String changeDateFormatWithException(String dateStr, String originalFormat, String targetFormat) throws ParseException {
        DateFormat original = new SimpleDateFormat(originalFormat, Locale.ENGLISH);
        DateFormat target = new SimpleDateFormat(targetFormat, Locale.ENGLISH);
        Date date = original.parse(dateStr);
        return target.format(date);
    }

    public static String changeDateFormat(String dateStr, String originalFormat, String targetFormat) {
        DateFormat original = new SimpleDateFormat(originalFormat, Locale.ENGLISH);
        DateFormat target = new SimpleDateFormat(targetFormat, Locale.ENGLISH);
        try {
            Date date = original.parse(dateStr);
            return target.format(date);
        } catch (ParseException e) {
            return dateStr;
        }
    }

    public static long getTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static Date convertStringToDate(String date, String strFormat) {

        DateFormat format = new SimpleDateFormat(strFormat, Locale.ENGLISH);
        try {
            return format.parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }

    public static Date convertStringToDateWithException(String date, String strFormat) throws ParseException {
        DateFormat format = new SimpleDateFormat(strFormat, Locale.ENGLISH);
        return format.parse(date);
    }
}
