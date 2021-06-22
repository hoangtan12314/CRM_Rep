package CRM.DataProcess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
}
