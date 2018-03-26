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
    private static final Locale LOCAL = Locale.ENGLISH;

    public static String changeDateFormatWithException(String dateStr, String originalFormat, String targetFormat) throws ParseException {
        DateFormat original = new SimpleDateFormat(originalFormat, LOCAL);
        DateFormat target = new SimpleDateFormat(targetFormat, LOCAL);
        Date date = original.parse(dateStr);
        return target.format(date);
    }

    public static String changeDateFormat(String dateStr, String originalFormat, String targetFormat) {
        DateFormat original = new SimpleDateFormat(originalFormat, LOCAL);
        DateFormat target = new SimpleDateFormat(targetFormat, LOCAL);
        try {
            Date date = original.parse(dateStr);
            return target.format(date);
        } catch (ParseException e) {
            return dateStr;
        }
    }

    public static long getCurrentTimeStamp() {
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
        DateFormat format = new SimpleDateFormat(strFormat, LOCAL);
        return format.parse(date);
    }

    public static long convertStringToUnixTimeStampWithException(String date ,String strFormat) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat,LOCAL);
        Date parsedDate = dateFormat.parse(date);
        return parsedDate.getTime();
    }
    public static long convertStringToUnixTimeStamp(String date ,String strFormat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat,LOCAL);
        try {
            Date parsedDate = dateFormat.parse(date);
            return parsedDate.getTime();
        } catch (ParseException e) {
            return 0;
        }

    }

    public static String convertUnixTimeStampToString(long unixTimeStamp,String strFormat) {
        Date date = new Date(unixTimeStamp);
        DateFormat format = new SimpleDateFormat(strFormat, Locale.ENGLISH);
        return format.format(date);
    }
}
