package opstaman.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ee on 01/01/15.
 */
public abstract class DateConvertor {

    public static Date convertDate(String date,String pattern){
        Date parsedDate = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            parsedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }

    public static String convertToString(Date date,String pattern){
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String parsedDate = dateFormat.format(date);
        return parsedDate;
    }

}
