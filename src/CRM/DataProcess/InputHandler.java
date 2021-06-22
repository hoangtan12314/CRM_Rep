package CRM.DataProcess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InputHandler {
    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Date DateConverter(String dateStr){
        try {
            Date date = sdf.parse(dateStr);
            return date;
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getDigit(String str){
        String[] strArr = str.split("_");
        int digitPart = Integer.parseInt(strArr[1]);
        return digitPart;
    }

    public String idGenerator(String prefix, int suffix){
        if (suffix < 10){
            return prefix + "00" + suffix;
        } else if(suffix >= 10 && suffix < 100){
            return prefix + "0" + suffix;
        } else
            return prefix + suffix;
    }

}
